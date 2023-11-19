package com.prabhupadabooks;


import com.prabhupadabooks.entity.Category;
import com.prabhupadabooks.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CategoryTest {

    private final CategoryRepository categoryRep;

    public CategoryTest(CategoryRepository categoryRep) {
        this.categoryRep = categoryRep;
    }

    @Test
    void testCreateCategory() {

        Category testCategory = new Category();
        Category parent = categoryRep.getReferenceById(1);
        testCategory.setTitle("Sensor phones");
        testCategory.setAlias("sensor_phones");
        testCategory.setImageURL("text.png");
        testCategory.setEnabled(true);
        testCategory.setParent(parent);

        Category saveCategory = categoryRep.save(testCategory);
        assertThat(saveCategory).isNotNull();
        assertThat(saveCategory.getId()).isPositive();
    }

    @Test
    void testGetCategory() {
        Category category = categoryRep.getReferenceById(1);
        System.out.println(category.getTitle());

        Set<Category> children = category.getChildren();

        children.stream().map(Category::getTitle).forEach(System.out::println);
        assertThat(children.size()).isGreaterThan(0);
    }

    @Test
    void testShowHierarchicalCategories() {
        Iterable<Category> categories = categoryRep.findAll();
        for (Category category : categories) {
            if (category.getParent() == null) {
                System.out.println(category.getTitle());
                Set<Category> children = category.getChildren();
                for (Category subCat : children) {
                    System.out.println("--" + subCat.getTitle());
                }
            }
        }
    }


}
