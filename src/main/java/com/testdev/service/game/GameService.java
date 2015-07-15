package com.testdev.service.game;

import com.testdev.service.game.state.Context;
import com.testdev.service.game.state.UserOneState;

/**
 * Created by oleh.krupenia on 7/15/2015.
 */
public class GameService implements IGameService {

    private Context context = new Context();

    @Override
    public String getCellText() {
        context.request();
        return context.getState() instanceof UserOneState ? "X" : "0";
    }
}
