package Controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        if (youtubeChannelId.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "ID каналу має бути більше ніж 0 символів");
            alert.show();
        } else {
            listViewId.getItems().add(youtubeChannelId.getText());
            youtubeChannelId.setText("");
        }
        if(maxChannels > 1)
            listViewId.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void finishEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (youtubeChannelId.getText().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "ID каналу має бути більше ніж 0 символів");
                alert.show();
            } else {
                listViewId.getItems().add(youtubeChannelId.getText());
                youtubeChannelId.setText("");
            }
        }
        if(maxChannels > 1)
            listViewId.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void proceedToTask(MouseEvent event) {
        if (listViewId.getItems().size() >= minChannels) {
            if (listViewId.getSelectionModel().getSelectedItems().size() >= minChannels && listViewId.getSelectionModel().getSelectedItems().size() <= maxChannels) {
                List<String> channelsId = new ArrayList<>();
                for (String id :
                        listViewId.getSelectionModel().getSelectedItems()) {
                    channelsId.add(id);
                }
                TaskViewer taskViewer = new TaskViewer();
                taskViewer.ShowForm((Stage) plusBtnId.getScene().getWindow(), channelsId, false);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "You must select at least " + minChannels + " ID but don't more than " + maxChannels);
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You must enter at least " + minChannels + " ID");
            alert.show();
        }
    }

    @FXML
    void initialize() {
    }
}
