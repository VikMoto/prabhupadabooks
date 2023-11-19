package com.prabhupadabooks;


import com.prabhupadabooks.entity.Product;
import com.prabhupadabooks.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void testFindByAlias() {
        String alias = "samsung";

        Product product = productRepository.findByAlias(alias);

        assertThat(product).isNotNull();
    }
}
