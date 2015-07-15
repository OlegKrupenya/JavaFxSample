package com.testdev.service.field;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for FieldService
 * Created by oleh.krupenia on 7/15/2015.
 */
public class FieldServiceTest {
    private IFieldService fieldService;

    @Before
    public void before() {
        this.fieldService = new FieldService();
    }

    @After
    public void after() {
        this.fieldService = null;
    }

    @Test
    public void shouldPlayerOneWinIfFirstRowContainsCross() {
        this.fieldService.populateField("X", 0, 0);
        this.fieldService.populateField("X", 0, 1);
        this.fieldService.populateField("X", 0, 2);

        int res = this.fieldService.validateField();
        Assert.assertTrue(res == 1);

        this.fieldService.clear();
        this.fieldService.populateField("X", 0, 0);
        this.fieldService.populateField("0", 1, 0);
        this.fieldService.populateField("X", 0, 1);
        this.fieldService.populateField("0", 1, 1);
        this.fieldService.populateField("X", 0, 2);

        res = this.fieldService.validateField();
        Assert.assertTrue(res == 1);
    }

    @Test
    public void shouldPlayerTwoWinIfFirstRowContainsZero() {
        this.fieldService.populateField("0", 0, 0);
        this.fieldService.populateField("0", 0, 1);
        this.fieldService.populateField("0", 0, 2);

        int res = this.fieldService.validateField();
        Assert.assertTrue(res == 1);

        this.fieldService.clear();
        this.fieldService.populateField("X", 1, 1);
        this.fieldService.populateField("0", 0, 0);
        this.fieldService.populateField("X", 2, 1);
        this.fieldService.populateField("0", 0, 1);
        this.fieldService.populateField("X", 2, 2);
        this.fieldService.populateField("0", 0, 2);

        res = this.fieldService.validateField();
        Assert.assertTrue(res == 1);
    }
}
