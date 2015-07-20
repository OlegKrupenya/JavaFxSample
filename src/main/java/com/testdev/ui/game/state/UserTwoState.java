package com.testdev.ui.game.state;

/**
 * Player 2 sets "0".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserTwoState extends GameState {
    @Override
    public void handle(Context context) {
        context.getClickedButton().setText("0");
        context.getLblResult().setText("Player 1's turn");
        context.getFieldService().populateField("0", getRow(context.getClickedButton()),
                getColumn(context.getClickedButton()));
        context.setState(new UserOneState());
    }

}
