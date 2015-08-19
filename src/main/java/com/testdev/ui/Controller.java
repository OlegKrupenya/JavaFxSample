package com.testdev.ui;

import com.testdev.service.field.FieldValidationResult;
import com.testdev.service.field.FieldService;
import com.testdev.ui.game.state.ComputerPlayerMadeMoveState;
import com.testdev.ui.game.state.StateContext;
import com.testdev.ui.game.state.SinglePlayerOneClickedState;
import com.testdev.ui.game.state.UserOneClickedState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * Controller of the application.
 */
public class Controller {
    public static final String PLAYER_1_WON = "Player 1 won";
    public static final String TIE_GAME = "Tie game";
    public static final String PLAYER_1_S_TURN = "Player 1's turn";
    public static final String SINGLE_MODE = "single";
    public static final String COMPUTER_PLAYER_WON = "Computer player won";
    public static final String PLAYER_2_WON = "Player 2 won";
    public static final String BTN_ID_PREFIX = "btn";
    public static final String EMPTY_TEXT = "";
    /**
     * Container of the buttons.
     */
    @FXML
    private VBox btnContainer;
    /**
     * Label that displays information to the user.
     */
    @FXML
    private Label lblResult;

    /**
     * Service that modifies and validates the field.
     */
    @Autowired
    private FieldService fieldService;

    /**
     * Context that defines an interface to the client.
     */
    @Autowired
    private StateContext stateContext;

    /**
     * A loaded object hierarchy from a FXML document.
     */
    private Node view;

    /**
     * Handles actionEvent when the user clicks the buttons.
     * @param actionEvent ActionEvent when the user clicks the buttons.
     */
    @FXML
    public void onBtnMouseClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getTarget();
        if (!StringUtils.isEmpty(clickedButton.getText())) {
            return;
        }
        stateContext.request(lblResult, clickedButton, fieldService);
        checkValidationResult(PLAYER_2_WON);
        if (stateContext.getState() instanceof ComputerPlayerMadeMoveState && !PLAYER_1_WON.equals(lblResult.getText())) {
            int[] indexes = fieldService.getCoordinatesOfFirstFreeCell();
            String btnId = BTN_ID_PREFIX + indexes[0] + indexes[1];
            for (Node node : btnContainer.getChildren()) {
                HBox hBox = (HBox) node;
                for (Object child : hBox.getChildren()) {
                    if (child instanceof Button) {
                        Button btn = (Button) child;
                        if (btnId.equals(btn.getId())) {
                            clickedButton = btn;
                            break;
                        }
                    }
                }
            }
            stateContext.request(lblResult, clickedButton, fieldService);
            checkValidationResult(COMPUTER_PLAYER_WON);
        }
    }

    /**
     * Handles actionEvent when the user selects option of the menu.
     * @param actionEvent ActionEvent when the user when the user selects option of the menu.
     */
    @FXML
    public void onMenuSelected(ActionEvent actionEvent) {
        MenuItem target = (MenuItem) actionEvent.getTarget();
        btnContainer.setDisable(false);
        fieldService.clear();
        if (target.getId().equals(SINGLE_MODE)) {
            stateContext.setState(new SinglePlayerOneClickedState());
        } else {
            stateContext.setState(new UserOneClickedState());
        }
        for (Node node : btnContainer.getChildren()) {
            HBox hBox = (HBox) node;
            hBox.getChildren().stream().filter(child -> child instanceof Button).forEach(child -> {
                Button btn = (Button) child;
                btn.setText(EMPTY_TEXT);
                lblResult.setText(PLAYER_1_S_TURN);
            });
        }
    }

    /**
     * Sets the view.
     * @param view The loaded object hierarchy.
     */
    public void setView(Node view) {
        this.view = view;
    }

    /**
     * @return The loaded object hierarchy.
     */
    public Node getView() {
        return view;
    }

    /**
     * Verifies current state of the game.
     * @param player2Message Message that will be shown when player 2 wins
     */
    private void checkValidationResult(String player2Message) {
        FieldValidationResult result;
        result = fieldService.validateField();
        if (result == FieldValidationResult.PLAYER_ONE_WON) {
            lblResult.setText(PLAYER_1_WON);
            btnContainer.setDisable(true);
        } else if (result == FieldValidationResult.PLAYER_TWO_WON) {
            lblResult.setText(player2Message);
            btnContainer.setDisable(true);
        } else if (result == FieldValidationResult.TIE_GAME) {
            lblResult.setText(TIE_GAME);
            btnContainer.setDisable(true);
        }
    }
}
