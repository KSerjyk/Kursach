package Controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ActionMenuController {
    public int minChannels, maxChannels;
    public boolean comments;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXProgressBar progress;

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
        if (maxChannels > 1)
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
        if (maxChannels > 1)
            listViewId.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void proceedToTask(MouseEvent event) {
        if (listViewId.getItems().size() >= minChannels) {
            if (listViewId.getSelectionModel().getSelectedItems().size() >= minChannels && listViewId.getSelectionModel().getSelectedItems().size() <= maxChannels) {
                progress.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
                final List<String> channelsId = new ArrayList<>();
                channelsId.addAll(listViewId.getSelectionModel().getSelectedItems());
                final TaskViewer taskViewer = new TaskViewer(channelsId, comments);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        taskViewer.ShowForm();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                StackPane root = new StackPane();
                                root.getChildren().add(taskViewer.tableView);
                                Stage secondaryStage = new Stage();
                                secondaryStage.setTitle("Information");
                                Scene scene = new Scene(root, 800, 300);
                                secondaryStage.setScene(scene);
                                secondaryStage.show();
                                progress.setProgress(0);
                            }
                        });
                    }
                };
                thread.start();
            } else {
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
