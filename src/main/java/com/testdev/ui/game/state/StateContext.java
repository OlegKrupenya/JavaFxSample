package com.testdev.ui.game.state;

import com.testdev.service.field.FieldService;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Context that defines an interface to the client.
 * @see Design pattern State.
 * Created by oleh.krupenia on 7/15/2015.
 */
public class StateContext {
    /**
     * The current state
     */
    private GameState state = new UserOneClickedState();

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
    private FieldService fieldService;

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return this.state;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public Button getClickedButton() {
        return clickedButton;
    }

    public FieldService getFieldService() {
        return fieldService;
    }

    /**
     * Changes the state by user request.
     */
    public void request(Label lblResult, Button clickedButton, FieldService fieldService) {
        this.lblResult = lblResult;
        this.clickedButton = clickedButton;
        this.fieldService = fieldService;
        this.state.handle(this);
    }
}
