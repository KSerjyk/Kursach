package Controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton AnalyticsBtnId;

    @FXML
    private JFXButton SettingsBtnId;

    @FXML
    void AnalyticsBtnClicked(MouseEvent event) {

    }

    @FXML
    void SettingsBtnClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert AnalyticsBtnId != null : "fx:id=\"AnalyticsBtnId\" was not injected: check your FXML file 'MainMenuFXML.fxml'.";
        assert SettingsBtnId != null : "fx:id=\"SettingsBtnId\" was not injected: check your FXML file 'MainMenuFXML.fxml'.";

    }
}