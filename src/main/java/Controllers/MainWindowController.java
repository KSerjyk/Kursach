package Controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    void AnalyticsBtnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/YouTubeAnalyticsMenuFXML.fxml"));
        Stage secondStage = new Stage();
        Stage mainStage = (Stage) AnalyticsBtnId.getScene().getWindow();
        mainStage.close();
        secondStage.setScene(new Scene(root,500, 300));
        secondStage.setTitle("Analytics window");
        secondStage.show();
    }

    @FXML
    void SettingsBtnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/SettingsMenuFXML.fxml"));
        Stage secondStage = new Stage();
        Stage mainStage = (Stage) AnalyticsBtnId.getScene().getWindow();
        mainStage.close();
        secondStage.setScene(new Scene(root,500, 300));
        secondStage.setTitle("Settings");
        secondStage.show();
    }

    @FXML
    void initialize() {
        assert AnalyticsBtnId != null : "fx:id=\"AnalyticsBtnId\" was not injected: check your FXML file 'MainMenuFXML.fxml'.";
        assert SettingsBtnId != null : "fx:id=\"SettingsBtnId\" was not injected: check your FXML file 'MainMenuFXML.fxml'.";

    }
}