package com.testdev.ui.game.state;

/**
 * State of the game when the computer player made its move.
 * @see Design pattern State
 * Created by oleh.krupenia on 7/20/2015.
 */
public class ComputerPlayerMadeMoveState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("0");
        stateContext.getLblResult().setText("Player 1's turn");
        stateContext.getFieldService().populateField("0", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new SinglePlayerOneClickedState());
    }
}
