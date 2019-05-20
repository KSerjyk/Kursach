package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ActionMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton plusBtnId;

    @FXML
    private JFXListView<?> listViewId;

    @FXML
    void PlusBtnClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert plusBtnId != null : "fx:id=\"plusBtnId\" was not injected: check your FXML file 'ActionMenuFXML.fxml'.";
        assert listViewId != null : "fx:id=\"listViewId\" was not injected: check your FXML file 'ActionMenuFXML.fxml'.";

    }
}
