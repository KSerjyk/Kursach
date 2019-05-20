package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SettingsMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton SaveBtnId;

    @FXML
    private JFXButton BackBtnId;

    @FXML
    private JFXCheckBox SaveCacheCheckBoxId;

    @FXML
    private CheckBox TimeCheckBoxId;

    @FXML
    void BackBtnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenuFXML.fxml"));
        Stage mainStage = (Stage) BackBtnId.getScene().getWindow();
        mainStage.setTitle("Youtube Analytics");
        mainStage.setScene(new Scene(root, 500, 300));
        mainStage.setResizable(false);
        mainStage.show();
    }

    @FXML
    void CachePathTextId(ActionEvent event) {

    }

    @FXML
    void SaveBtnClicked(MouseEvent event) {
        System.out.println("Saved Button Pressed");
    }

    @FXML
    void initialize() {
        assert SaveBtnId != null : "fx:id=\"SaveBtnId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert BackBtnId != null : "fx:id=\"BackBtnId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert SaveCacheCheckBoxId != null : "fx:id=\"SaveCacheCheckBoxId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert TimeCheckBoxId != null : "fx:id=\"TimeCheckBoxId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        SaveBtnId.setDisableVisualFocus(true);
    }
}