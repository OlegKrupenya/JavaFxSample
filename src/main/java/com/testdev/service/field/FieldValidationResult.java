package com.testdev.service.field;

/**
 * Represents the result of the field validation after each move.
 * 0 - if there is no winner yet and it is possible to continue the game. 1 - if the winner is player 1.
 * 2 - if the winner is player 2. 3 - if there is a tie game.
 */
public enum FieldValidationResult {
    EMPTY_CELLS_EXIST(0), PLAYER_ONE_WON(1), PLAYER_TWO_WON(2), TIE_GAME(3);
    private int value;

    public int getValue() {
        return value;
    }

    public boolean isThereNoWinner() {
        return this.value == 0 || this.value == 3;
    }

    FieldValidationResult(int value) {
        this.value = value;
    }
}