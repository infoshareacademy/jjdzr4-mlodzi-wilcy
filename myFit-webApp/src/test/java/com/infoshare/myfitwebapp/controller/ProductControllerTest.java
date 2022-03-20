package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.repository.ProductRepository;
import com.infoshare.myfitwebapp.repository.util.InitData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private InitData initData;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        initData.cleanUp();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        //given
        String body = "name=3&kcalPer100g=30&fatPer100g=30&carbohydratesPer100g=30&proteinPer100g=30&add=";
        Product expected = initData.createProduct();
        //when
        this.mockMvc.perform(post("/products/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .content(body))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        //then
        Product actual = productRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Product wasn't created"));
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getKcalPer100g()).isEqualTo(expected.getKcalPer100g());
        assertThat(actual.getFatPer100g()).isEqualTo(expected.getFatPer100g());
        assertThat(actual.getCarbohydratesPer100g()).isEqualTo(expected.getCarbohydratesPer100g());
        assertThat(actual.getProteinPer100g()).isEqualTo(expected.getProteinPer100g());
    }

    @Test
    public void shouldEditProduct() throws Exception {
        //given
        Product initialized = initData.initProductData();
        String body = "id=" + initialized.getId() + "&name=31&kcalPer100g=31&fatPer100g=31&carbohydratesPer100g=31&proteinPer100g=31&update=";
        //when
        this.mockMvc.perform(post("/products/update")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(body))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        //then
        Product actual = productRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Product wasn't created"));
        assertThat(actual.getName()).isEqualTo("31");
        assertThat(actual.getKcalPer100g()).isEqualTo(31);
        assertThat(actual.getFatPer100g()).isEqualTo(31);
        assertThat(actual.getCarbohydratesPer100g()).isEqualTo(31);
        assertThat(actual.getProteinPer100g()).isEqualTo(31);
    }
}