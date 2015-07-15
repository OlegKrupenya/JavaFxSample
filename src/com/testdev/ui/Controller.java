package com.testdev.ui;

import com.testdev.service.field.FieldService;
import com.testdev.service.field.IFieldService;
import com.testdev.service.game.GameService;
import com.testdev.service.game.IGameService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    private IFieldService fieldService = new FieldService();
    private IGameService gameService = new GameService();

    @FXML
    public void onBtnMouseClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getTarget();
        clickedButton.setText("X");
        clickedButton.setFont(Font.font(25));
    }

}
