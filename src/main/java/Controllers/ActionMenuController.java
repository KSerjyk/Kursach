package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ActionMenuController {
    public int minChannels, maxChannels;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton plusBtnId;

    @FXML
    private JFXListView<String> listViewId;

    @FXML
    private JFXTextField youtubeChannelId;

    @FXML
    void PlusBtnClicked(MouseEvent event) {
        if(youtubeChannelId.getText().length() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR, "ID каналу має бути більше ніж 0 символів");
            alert.show();
        }
        else
            if(listViewId.getItems().size() < maxChannels) {
                listViewId.getItems().add(youtubeChannelId.getText());
                youtubeChannelId.setText("");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Для даної задачі потрібно не більше " + maxChannels + " ID");
                alert.show();
                youtubeChannelId.setText("");
            }
    }

    @FXML
    void finishEnter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER) {
            if(youtubeChannelId.getText().length() == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR, "ID каналу має бути більше ніж 0 символів");
                alert.show();
            }
            else
            if(listViewId.getItems().size() < maxChannels) {
                listViewId.getItems().add(youtubeChannelId.getText());
                youtubeChannelId.setText("");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Для даної задачі потрібно не більше " + maxChannels + " ID");
                alert.show();
                youtubeChannelId.setText("");
            }
        }
    }

    @FXML
    void initialize() {
    }
}
