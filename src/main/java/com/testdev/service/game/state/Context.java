package com.testdev.service.game.state;

import com.testdev.service.field.IFieldService;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Context that defines an interface to the client
 * Created by oleh.krupenia on 7/15/2015.
 */
public class Context {
    /**
     * The current state
     */
    private GameState state = new UserOneState();

    /**
     * Label to set the message.
     */
    private Label lblResult;

    /**
     * Button that has been clicked.
     */
    private Button clickedButton;

    /**
     * Service to populate data.
     */
    private IFieldService fieldService;

    public void setState(GameState state) {
        this.state = state;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public Button getClickedButton() {
        return clickedButton;
    }

    public IFieldService getFieldService() {
        return fieldService;
    }

    /**
     * Changes the state by user request.
     */
    public void request(Label lblResult, Button clickedButton, IFieldService fieldService) {
        this.lblResult = lblResult;
        this.clickedButton = clickedButton;
        this.fieldService = fieldService;
        this.state.handle(this);
    }
}
