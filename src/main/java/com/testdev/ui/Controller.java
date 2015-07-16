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

public class Controller {
    @FXML
    private VBox btnContainer;
    @FXML
    private Label lblResult;

    private IFieldService fieldService = new FieldService();
    private IGameService gameService = new GameService();

    @FXML
    public void onBtnMouseClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getTarget();
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
            lblResult.setText("Player 1's wins");
            btnContainer.setDisable(true);
        } else if (result == 2) {
            lblResult.setText("Player 2's wins");
            btnContainer.setDisable(true);
        }
    }

    @FXML
    public void onMenuSelected(ActionEvent actionEvent) {
        btnContainer.setDisable(false);
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

    private int getColumn(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(4)));
    }

    private int getRow(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(3)));
    }

}
