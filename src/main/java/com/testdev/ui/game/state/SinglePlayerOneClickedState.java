package com.testdev.ui.game.state;

/**
 * State of the game when the player 1 clicked the field.
 * @see Design pattern State
 * Created by oleh.krupenia on 7/20/2015.
 */
public class SinglePlayerOneClickedState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("X");
        stateContext.getLblResult().setText("Computer player's turn");
        stateContext.getFieldService().populateField("X", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new ComputerPlayerMadeMoveState());
    }
}
