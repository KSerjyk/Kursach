package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;

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
    private JFXCheckBox TimeCheckBoxId;

    @FXML
    private JFXTextField cachePathTF;

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
    void selectDirectory(MouseEvent event) {
        /*JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(fc.showDialog(null, "Вибрати папку") == JFileChooser.APPROVE_OPTION)
            cachePathTF.setText(fc.getSelectedFile().getPath());*/
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File dir = directoryChooser.showDialog(BackBtnId.getScene().getWindow());
        if(dir != null)
            cachePathTF.setText(dir.getAbsolutePath());
    }

    @FXML
    void SaveBtnClicked(MouseEvent event) {
        SettingsConfig obj = SettingsConfig.getInstance();
        obj.setPath(cachePathTF.getText());
        obj.setSaveCache(SaveCacheCheckBoxId.isSelected());
        obj.setShowTime(TimeCheckBoxId.isSelected());
    }

    @FXML
    void initialize() {
        assert SaveBtnId != null : "fx:id=\"SaveBtnId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert BackBtnId != null : "fx:id=\"BackBtnId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert SaveCacheCheckBoxId != null : "fx:id=\"SaveCacheCheckBoxId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        assert TimeCheckBoxId != null : "fx:id=\"TimeCheckBoxId\" was not injected: check your FXML file 'SettingsMenuFXML.fxml'.";
        SaveBtnId.setDisableVisualFocus(true);
        SaveCacheCheckBoxId.setSelected(SettingsConfig.getInstance().isSaveCache());
        TimeCheckBoxId.setSelected(SettingsConfig.getInstance().isShowTime());
        cachePathTF.setText(SettingsConfig.getInstance().getPath());
    }
}