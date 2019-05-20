package Controllers;

import com.jfoenix.controls.JFXComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YouTubeAnalyticsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox BackBtnId;

    @FXML
    private JFXComboBox<?> ComboBoxId;

    @FXML
    void BackBtnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenuFXML.fxml"));
        Stage secondStage = new Stage();
        Stage mainStage = (Stage) BackBtnId.getScene().getWindow();
        mainStage.setTitle("Youtube Analytics");
        mainStage.setScene(new Scene(root, 500, 300));
        mainStage.setResizable(false);
        mainStage.show();
    }

    @FXML
    void ComboBoxAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BackBtnId != null : "fx:id=\"BackBtnId\" was not injected: check your FXML file 'YouTubeAnalyticsMenuFXML.fxml'.";
        assert ComboBoxId != null : "fx:id=\"ComboBoxId\" was not injected: check your FXML file 'YouTubeAnalyticsMenuFXML.fxml'.";

    }
}
