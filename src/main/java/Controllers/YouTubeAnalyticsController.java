package Controllers;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
    void BackBtnClicked(MouseEvent event) {

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
