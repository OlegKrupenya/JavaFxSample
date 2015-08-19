package com.testdev.ui.game.state;

/**
 * Created by oleh.krupenia on 7/20/2015.
 */
public class ComputerPlayerState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("0");
        stateContext.getLblResult().setText("Player 1's turn");
        stateContext.getFieldService().populateField("0", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new SinglePlayerOneState());
    }
}
