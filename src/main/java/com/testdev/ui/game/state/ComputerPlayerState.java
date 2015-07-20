package com.testdev.ui.game.state;

/**
 * Created by oleh.krupenia on 7/20/2015.
 */
public class ComputerPlayerState extends GameState {
    @Override
    public void handle(Context context) {
        context.getClickedButton().setText("0");
        context.getLblResult().setText("Player 1's turn");
        context.getFieldService().populateField("0", getRow(context.getClickedButton()),
                getColumn(context.getClickedButton()));
        context.setState(new SinglePlayerOneState());
    }
}
