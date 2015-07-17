package com.testdev.service.game.state;

/**
 * Context that defines an interface to the client
 * Created by oleh.krupenia on 7/15/2015.
 */
public class Context {
    /**
     * The current state
     */
    private GameState state = new UserTwoState();

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * Changes the state by user request.
     */
    public void request() {
        this.state.handle(this);
    }
}
