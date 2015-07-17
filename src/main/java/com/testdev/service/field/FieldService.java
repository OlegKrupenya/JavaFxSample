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
        boolean hasEmptyCells = false;
        for (int i = 0; i < Field.SIZE; i++) {
            if (field.getData()[i][0].isEmpty() || field.getData()[i][1].isEmpty() || field.getData()[i][2].isEmpty()) {
                hasEmptyCells = true;
            }
            if (field.getData()[i][0].equals(field.getData()[i][1])
                    && field.getData()[i][1].equals(field.getData()[i][2]) && !field.getData()[i][1].isEmpty()) {
                return field.getData()[i][0].isCross() ? 1 : 2;
            }
        }
        for (int j = 0; j < Field.SIZE; j++) {
            if (field.getData()[0][j].equals(field.getData()[1][j])
                    && field.getData()[1][j].equals(field.getData()[2][j]) && !field.getData()[1][j].isEmpty()) {
                return field.getData()[0][j].isCross() ? 1 : 2;
            }
        }
        if ((!field.getData()[0][0].isEmpty() && field.getData()[0][0].equals(field.getData()[1][1])
                && field.getData()[1][1].equals(field.getData()[2][2])) || (!field.getData()[0][2].isEmpty()
                && field.getData()[0][2].equals(field.getData()[1][1])
                && field.getData()[1][1].equals(field.getData()[2][0]))) {
            return field.getData()[1][1].isCross() ? 1 : 2;
        }
        if (hasEmptyCells) {
            return 0;
        }
        return 3;
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
