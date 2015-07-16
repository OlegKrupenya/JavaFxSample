package com.testdev.ui;

import com.testdev.service.field.FieldService;
import com.testdev.service.field.IFieldService;
import com.testdev.service.game.GameService;
import com.testdev.service.game.IGameService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Controller {
    @FXML
    private Button btn00;
    @FXML
    private Button btn01;
    @FXML
    private Button btn02;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn20;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
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
        } else if (result == 2) {
            lblResult.setText("Player 2's wins");
        }
    }

    private int getColumn(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(4)));
    }

    private int getRow(Button clickedButton) {
        return Integer.parseInt(String.valueOf(clickedButton.getId().charAt(3)));
    }

}
