package com.testdev.ui.game.state;

/**
 * Created by oleh.krupenia on 7/20/2015.
 */
public class SinglePlayerOneState extends GameState {
    @Override
    public void handle(Context context) {
        context.getClickedButton().setText("X");
        context.getLblResult().setText("Computer player's turn");
        context.getFieldService().populateField("X", getRow(context.getClickedButton()),
                getColumn(context.getClickedButton()));
        context.setState(new ComputerPlayerState());
    }
}
