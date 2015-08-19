package com.testdev.service.field;

/**
 * Service that modifies and validates the field.
 * Created by oleh.krupenia on 7/15/2015.
 */
public interface FieldService {
    /**
     * Sets the data for the cell. If the data is "X", the cross will be set to {@code true}.
     * If the data is "0", the zero will be set to {@code true}.
     * @param data "X" or "0".
     * @param row Index of the row.
     * @param col Index of the column.
     */
    void populateField(String data, int row, int col);

    /**
     * Validates the field after each move.
     * @return 0 - if there is no winner yet and it is possible to continue the game. 1 - if the winner is player 1.
     * 2 - if the winner is player 2. 3 - if there is a tie game.
     */
    FieldValidationResult validateField();

    /**
     * Clears the field. All cells will be empty.
     */
    void clear();

    /**
     * @return Array that contains a row and a column of a free cell for computer player.
     */
    int[] getFreeCell();
}
