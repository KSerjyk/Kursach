import Controllers.SaveLoadCache;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        SaveLoadCache.LoadSaveSettingsConfig(false);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                SaveLoadCache.LoadSaveSettingsConfig(true);
            }
        });
       launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenuFXML.fxml"));
        primaryStage.setTitle("Youtube Analitics");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
