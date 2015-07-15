package com.testdev.service.field;

/**
 * Service that modifies and validates the field.
 * Created by oleh.krupenia on 7/15/2015.
 */
public interface IFieldService {
    void populateField(String data, int row, int col);
    int validateField();
    void clear();
}
