package com.testdev.service.game.state;

import javafx.scene.control.Button;

/**
 * Player 1 sets "X".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserOneState extends GameState {
    @Override
    public void handle(Context context) {
        context.getClickedButton().setText("X");
        context.getLblResult().setText("Player 2's turn");
        context.getFieldService().populateField("X", getRow(context.getClickedButton()),
                getColumn(context.getClickedButton()));
        context.setState(new UserTwoState());
    }
}
