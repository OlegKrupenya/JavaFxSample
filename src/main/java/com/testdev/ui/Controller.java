package com.testdev.ui;

import com.testdev.service.field.IFieldService;
import com.testdev.ui.game.state.ComputerPlayerState;
import com.testdev.ui.game.state.Context;
import com.testdev.ui.game.state.SinglePlayerOneState;
import com.testdev.ui.game.state.UserOneState;
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
    private IFieldService fieldService;

    /**
     * Context that defines an interface to the client.
     */
    @Autowired
    private Context context;

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
        context.request(lblResult, clickedButton, fieldService);
        clickedButton.setFont(Font.font(25));
        checkValidationResult();
        if (context.getState() instanceof ComputerPlayerState) {
            int[] indexes = fieldService.getFreeCell();
            String btnId = "btn" + indexes[0] + indexes[1];
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
            clickedButton.setFont(Font.font(25));
            context.request(lblResult, clickedButton, fieldService);
            checkValidationResult();
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
        if (target.getId().equals("single")) {
            context.setState(new SinglePlayerOneState());
        } else {
            context.setState(new UserOneState());
        }
        for (Node node : btnContainer.getChildren()) {
            HBox hBox = (HBox) node;
            for (Object child : hBox.getChildren()) {
                if (child instanceof Button) {
                    Button btn = (Button) child;
                    btn.setText("");
                    lblResult.setText("Player 1's turn");
                }
            }
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
     */
    private void checkValidationResult() {
        int result;
        result = fieldService.validateField();
        if (result == 1) {
            lblResult.setText("Player 1 won");
            btnContainer.setDisable(true);
        } else if (result == 2) {
            lblResult.setText("Computer player won");
            btnContainer.setDisable(true);
        } else if (result == 3) {
            lblResult.setText("Tie game");
            btnContainer.setDisable(true);
        }
    }
}
