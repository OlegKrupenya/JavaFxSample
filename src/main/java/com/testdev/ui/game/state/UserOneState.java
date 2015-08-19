package com.testdev.ui.game.state;

/**
 * Player 1 sets "X".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserOneState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("X");
        stateContext.getLblResult().setText("Player 2's turn");
        stateContext.getFieldService().populateField("X", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new UserTwoState());
    }
}
