package com.testdev.ui;

import com.testdev.service.field.FieldService;
import com.testdev.service.field.IFieldService;
import com.testdev.service.game.GameService;
import com.testdev.service.game.IGameService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
     * Service that controls the state of the game.
     */
    @Autowired
    private IGameService gameService;

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
        String data = gameService.getCellText();
        fieldService.populateField(data, getRow(clickedButton), getColumn(clickedButton));
        if (data.equals("X")) {
            lblResult.setText("Player 2's turn");
        } else {
            lblResult.setText("Player 1's turn");
        }
        clickedButton.setText(data);
        clickedButton.setFont(Font.font(25));
        int result = fieldService.validateField();
        if (result == 1) {
            lblResult.setText("Player 1 won");
            btnContainer.setDisable(true);
        } else if (result == 2) {
            lblResult.setText("Player 2 won");
            btnContainer.setDisable(true);
        } else if (result == 3) {
            lblResult.setText("Tie game");
            btnContainer.setDisable(true);
        }
    }

    /**
     * Handles actionEvent when the user selects option of the menu.
     * @param actionEvent ActionEvent when the user when the user selects option of the menu.
     */
    @FXML
    public void onMenuSelected(ActionEvent actionEvent) {
        btnContainer.setDisable(false);
        fieldService.clear();
        gameService.resetGame();
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
     * Returns index of the column by id of the button.
     * @param clickedButton The button that has been clicked.
     * @return index of the column by id of the button.
     */
    private int getColumn(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(4)));
    }

    /**
     * Returns index of the row by id of the button.
     * @param clickedButton The button that has been clicked.
     * @return index of the row by id of the button.
     */
    private int getRow(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(3)));
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
}
