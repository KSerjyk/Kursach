package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

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
    void BackBtnClicked(MouseEvent event) {

    }

    @FXML
    void CachePathTextId(ActionEvent event) {

    }

    @FXML
    void SaveBtnClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert SaveBtnId != null : "fx:id=\"SaveBtnId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert BackBtnId != null : "fx:id=\"BackBtnId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert SaveCacheCheckBoxId != null : "fx:id=\"SaveCacheCheckBoxId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert TimeCheckBoxId != null : "fx:id=\"TimeCheckBoxId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";

    }
}