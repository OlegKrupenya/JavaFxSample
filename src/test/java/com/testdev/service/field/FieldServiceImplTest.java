package com.testdev.service.field;

import com.testdev.domain.Field;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Tests for FieldService
 * Created by oleh.krupenia on 7/15/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class FieldServiceImplTest {

    @Autowired
    private FieldService fieldService;

    @Test
    public void shouldPlayerOneWinIfFirstRowContainsCross() {
        this.fieldService.populateField("X", 0, 0);
        this.fieldService.populateField("X", 0, 1);
        this.fieldService.populateField("X", 0, 2);

        FieldValidationResult res = this.fieldService.validateField();
        Assert.assertTrue(res.getValue() == 1);

        this.fieldService.clear();
        this.fieldService.populateField("X", 0, 0);
        this.fieldService.populateField("0", 1, 0);
        this.fieldService.populateField("X", 0, 1);
        this.fieldService.populateField("0", 1, 1);
        this.fieldService.populateField("X", 0, 2);

        res = this.fieldService.validateField();
        Assert.assertTrue(res.getValue() == 1);
    }

    @Test
    public void shouldPlayerTwoWinIfFirstRowContainsZero() {
        this.fieldService.populateField("0", 0, 0);
        this.fieldService.populateField("0", 0, 1);
        this.fieldService.populateField("0", 0, 2);

        FieldValidationResult res = this.fieldService.validateField();
        Assert.assertTrue(res.getValue() == 2);

        this.fieldService.clear();
        this.fieldService.populateField("X", 1, 1);
        this.fieldService.populateField("0", 0, 0);
        this.fieldService.populateField("X", 2, 1);
        this.fieldService.populateField("0", 0, 1);
        this.fieldService.populateField("X", 2, 2);
        this.fieldService.populateField("0", 0, 2);

        res = this.fieldService.validateField();
        Assert.assertTrue(res.getValue() == 2);
    }

    @Configuration
    static class ContextConfiguration {

        @Bean
        public FieldService orderService() {
            return new FieldServiceImpl();
        }

        @Bean
        public Field field() {
            return new Field();
        }
    }
}
