package com.testdev.service.field;

import com.testdev.domain.Field;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service that modifies and validates the field.
 * Created by oleh.krupenia on 7/15/2015.
 */
public class FieldServiceImpl implements FieldService {
    public static final int KEY_VALUE_PAIR = 2;
    @Autowired
    private Field field;

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
    public FieldValidationResult validateField() {
        boolean hasEmptyCells = isHasEmptyCells();
        for (int i = 0; i < Field.SIZE; i++) {
            if (field.getData()[i][0].equals(field.getData()[i][1])
                    && field.getData()[i][1].equals(field.getData()[i][2]) && !field.getData()[i][1].isEmpty()) {
                return field.getData()[i][0].isCross() ? FieldValidationResult.PLAYER_ONE_WON : FieldValidationResult.PLAYER_TWO_WON;
            }
        }
        for (int j = 0; j < Field.SIZE; j++) {
            if (field.getData()[0][j].equals(field.getData()[1][j])
                    && field.getData()[1][j].equals(field.getData()[2][j]) && !field.getData()[1][j].isEmpty()) {
                return field.getData()[0][j].isCross() ? FieldValidationResult.PLAYER_ONE_WON : FieldValidationResult.PLAYER_TWO_WON;
            }
        }
        if ((!field.getData()[0][0].isEmpty() && field.getData()[0][0].equals(field.getData()[1][1])
                && field.getData()[1][1].equals(field.getData()[2][2])) || (!field.getData()[0][2].isEmpty()
                && field.getData()[0][2].equals(field.getData()[1][1])
                && field.getData()[1][1].equals(field.getData()[2][0]))) {
            return field.getData()[1][1].isCross() ? FieldValidationResult.PLAYER_ONE_WON : FieldValidationResult.PLAYER_TWO_WON;
        }
        if (hasEmptyCells) {
            return FieldValidationResult.EMPTY_CELLS_EXIST;
        }
        return FieldValidationResult.TIE_GAME;
    }

    /**
     * @return {@code true} if there is at least one empty cell.
     */
    private boolean isHasEmptyCells() {
        boolean hasEmptyCells = false;
        for (int i = 0; i < Field.SIZE; i++) {
            if (field.getData()[i][0].isEmpty() || field.getData()[i][1].isEmpty() || field.getData()[i][2].isEmpty()) {
                hasEmptyCells = true;
            }
        }
        return hasEmptyCells;
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

    @Override
    public int[] getFreeCell() {
        int[] result = new int[KEY_VALUE_PAIR];
        for (int i = 0; i < Field.SIZE; i++) {
            for (int j = 0; j < Field.SIZE; j++) {
                if (field.getData()[i][j].isEmpty()) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
