package com.testdev.service.field;

import com.testdev.domain.Field;

/**
 * Service that modifies and validates the field.
 * Created by oleh.krupenia on 7/15/2015.
 */
public class FieldService implements IFieldService {
    private final Field field = new Field();

    @Override
    public void populateField(String data, int row, int col) {
        if ("X".equals(data)) {
            field.getData()[row][col].setCross(true);
            field.getData()[row][col].setZero(false);
        } else {
            field.getData()[row][col].setCross(false);
            field.getData()[row][col].setZero(true);
        }
    }

    @Override
    public int validateField() {
        for (int i = 0; i < Field.SIZE; i++) {
        }
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < Field.SIZE; i++) {
            for (int j = 0; j < Field.SIZE; j++) {
                field.getData()[i][j].setCross(false);
                field.getData()[i][j].setZero(false);
            }
        }
    }
}
