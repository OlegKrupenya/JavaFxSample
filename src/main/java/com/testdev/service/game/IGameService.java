package com.testdev.service.game;

import com.testdev.service.game.state.Context;
import com.testdev.service.game.state.GameState;
import com.testdev.service.game.state.UserOneState;
import com.testdev.service.game.state.UserTwoState;

/**
 * Service that controls the state of the game.
 * Created by oleh.krupenia on 7/15/2015.
 */
public interface IGameService {
    /**
     * Changes the {@link GameState} and returns "X" or "0" depending of the state.
     * @return "X" if the current state {@link UserOneState} is or "0" for {@link UserTwoState}.
     */
    String getCellText();

    /**
     * Resets the current state to {@link UserTwoState} for a new game.
     */
    void resetGame();
}
