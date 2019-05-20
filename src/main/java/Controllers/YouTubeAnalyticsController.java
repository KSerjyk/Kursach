package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private JFXButton BackBtnId;

    @FXML
    private JFXButton applyActionBtn;

    @FXML
    private JFXComboBox<String> ComboBoxId;

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
    void applyAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenuFXML.fxml"));
        Stage mainStage = (Stage) BackBtnId.getScene().getWindow();
        mainStage.setTitle("Youtube Analytics");
        mainStage.setScene(new Scene(root, 500, 300));
        mainStage.setResizable(false);
        mainStage.show();
    }
    @FXML
    void ComboBoxAction(ActionEvent event) {
        System.out.println(ComboBoxId.getValue());
    }

    @FXML
    void initialize() {
        assert BackBtnId != null : "fx:id=\"BackBtnId\" was not injected: check your FXML file 'YouTubeAnalyticsMenuFXML.fxml'.";
        assert ComboBoxId != null : "fx:id=\"ComboBoxId\" was not injected: check your FXML file 'YouTubeAnalyticsMenuFXML.fxml'.";
        ComboBoxId.getItems().addAll("Загальна інформація", "Порівняти канали", "Сортувати канали за даними", "Медіа резонанс", "Порівняти медіа резонанс", "Сортувати по медіа резонансу");
        /*ComboBoxId.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(observable);
                System.out.println(oldValue);
                System.out.println(newValue);
            }
        });*/
    }
}
