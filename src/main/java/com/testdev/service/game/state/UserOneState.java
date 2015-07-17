package com.testdev.service.game.state;

/**
 * Player 1 sets "X".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserOneState implements GameState {
    @Override
    public void handle(Context context) {
        context.setState(new UserTwoState());
    }
}
