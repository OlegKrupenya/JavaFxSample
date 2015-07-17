package com.testdev.service.game.state;

/**
 * Player 2 sets "0".
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserTwoState implements GameState {
    @Override
    public void handle(Context context) {
        context.setState(new UserOneState());
    }
}
