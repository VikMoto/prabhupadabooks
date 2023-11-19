package com.prabhupadabooks;


import com.prabhupadabooks.entity.Category;
import com.prabhupadabooks.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepoTest {

    private final CategoryRepository categoryRep;

    public CategoryRepoTest(CategoryRepository categoryRep) {
        this.categoryRep = categoryRep;
    }

    @Test
    void testListEnabledCategories() {
        List<Category> categories = categoryRep.findAllEnabled();

        categories.forEach(category -> {
            System.out.println(category.getTitle() + " (" + category.getEnabled() + ")");
        });
    }

    @Test
    void categoryFindByAlias() {
        String alias = "protectors";

        Category category = categoryRep.findByAliasEnabled(alias);

        assertThat(category).isNotNull();

    }

    @Test
    void testListRootCategories(){
        List<Category> categories = categoryRep.findRootCategories();
        categories.forEach(category -> System.out.println(category.getTitle()));
    }
}
