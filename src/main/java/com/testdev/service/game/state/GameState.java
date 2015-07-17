package com.testdev.service.game.state;

/**
 * Interface of the state of the game.
 * Created by oleh.krupenia on 7/15/2015.
 */
public interface GameState {
    /**
     * Changes the current state by user request.
     * @param context Context that defines an interface to the client
     */
    void handle(Context context);
}
