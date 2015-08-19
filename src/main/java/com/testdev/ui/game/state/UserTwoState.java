package com.testdev.ui.game.state;

/**
 * Player 2 sets "0".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserTwoState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("0");
        stateContext.getLblResult().setText("Player 1's turn");
        stateContext.getFieldService().populateField("0", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new UserOneState());
    }

}
