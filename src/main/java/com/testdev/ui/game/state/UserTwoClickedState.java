package com.testdev.ui.game.state;

/**
 * State of the game when the player 2 clicked the field.
 * @see Design pattern State
 * Player 2 sets "0".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserTwoClickedState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("0");
        stateContext.getLblResult().setText("Player 1's turn");
        stateContext.getFieldService().populateField("0", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new UserOneClickedState());
    }

}
