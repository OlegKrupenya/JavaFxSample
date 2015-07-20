package com.testdev.ui.game.state;

import javafx.scene.control.Button;

/**
 * Interface of the state of the game.
 * Created by oleh.krupenia on 7/15/2015.
 */
public abstract class GameState {
    /**
     * Changes the current state by user request.
     * @param context Context that defines an interface to the client
     */
    public abstract void handle(Context context);

    /**
     * Returns index of the column by id of the button.
     * @param clickedButton The button that has been clicked.
     * @return index of the column by id of the button.
     */
    protected int getColumn(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(4)));
    }

    /**
     * Returns index of the row by id of the button.
     * @param clickedButton The button that has been clicked.
     * @return index of the row by id of the button.
     */
    protected int getRow(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(3)));
    }
}
