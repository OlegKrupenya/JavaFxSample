package com.testdev.ui.game.state;

/**
 * Created by oleh.krupenia on 7/20/2015.
 */
public class SinglePlayerOneState extends GameState {
    @Override
    public void handle(StateContext stateContext) {
        stateContext.getClickedButton().setText("X");
        stateContext.getLblResult().setText("Computer player's turn");
        stateContext.getFieldService().populateField("X", getRow(stateContext.getClickedButton()),
                getColumn(stateContext.getClickedButton()));
        stateContext.setState(new ComputerPlayerState());
    }
}
