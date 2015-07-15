package com.testdev.service.game.state;

/**
 * Created by oleh.krupenia on 7/15/2015.
 */
public class UserOneState implements GameState {
    @Override
    public void handle(Context context) {
        context.setState(new UserTwoState());
    }
}
