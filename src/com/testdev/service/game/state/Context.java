package com.testdev.service.game.state;

/**
 * Created by oleh.krupenia on 7/15/2015.
 */
public class Context {
    private GameState state;

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void request() {
        this.state.handle(this);
    }
}
