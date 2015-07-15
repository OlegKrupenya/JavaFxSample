package com.testdev.service.game;

import com.testdev.service.game.state.Context;
import com.testdev.service.game.state.UserOneState;

/**
 * Created by oleh.krupenia on 7/15/2015.
 */
public class GameService implements IGameService {

    @Override
    public String getCellText(Context context) {
        return context.getState() instanceof UserOneState ? "X" : "0";
    }
}
