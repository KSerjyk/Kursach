package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
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
    private JFXComboBox<ComboboxItem> ComboBoxId;

    @FXML
    void BackBtnClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenuFXML.fxml"));
        Stage mainStage = (Stage) BackBtnId.getScene().getWindow();
        mainStage.setTitle("Youtube Analytics");
        mainStage.setScene(new Scene(root, 400, 400));
        mainStage.setResizable(false);
        mainStage.show();
    }

    @FXML
    void applyAction(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ActionMenuFXML.fxml"));
        loader.load();
        ActionMenuController actionMenuController = loader.getController();
        ComboboxItem item = ComboBoxId.getValue();
        actionMenuController.maxChannels = item.getMax();
        actionMenuController.minChannels = item.getMin();
        Parent root = loader.getRoot();
        Stage mainStage = (Stage) applyActionBtn.getScene().getWindow();
        Stage secondStage = new Stage();
        secondStage.initOwner(mainStage);
        secondStage.setTitle("Youtube Analytics");
        secondStage.setScene(new Scene(root, 300, 400));
        secondStage.setResizable(false);
        secondStage.show();
    }

    @FXML
    void initialize() {
        ComboBoxId.getItems().addAll(new ComboboxItem("Загальна інформація", 1, 1), new ComboboxItem("Порівняти канали", 2, 2), new ComboboxItem("Сортувати канали за даними", 1, 999999), new ComboboxItem("Медіа резонанс", 1, 1), new ComboboxItem("Порівняти медіа резонанс", 2, 2), new ComboboxItem("Сортувати по медіа резонансу", 1, 999999));
        ComboBoxId.getSelectionModel().selectFirst();
        BackBtnId.setDisableVisualFocus(true);

    }
}
