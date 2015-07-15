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
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
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
        return 0;
    }

    private int getRow(Button clickedButton) {
        return 0;
    }

}
