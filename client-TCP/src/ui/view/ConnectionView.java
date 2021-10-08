package ui.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.ConnectionController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConnectionView extends Stage {

    // Elements
    private TextField ipTF;
    private TextField portTF;
    private Label warmingLabel;

    private Button closeBtn;
    private Button playBtn;

    private Scene scene;
    
    private ConnectionController controller;
    // Constructor

    public ConnectionView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../assets/connectionWindow.fxml"));
            Parent parent = loader.load();

            ipTF = (TextField) loader.getNamespace().get("ipTF");
            portTF = (TextField) loader.getNamespace().get("portTF");
            warmingLabel = (Label) loader.getNamespace().get("warmingLabel");

            closeBtn = (Button) loader.getNamespace().get("closeBtn");
            playBtn = (Button) loader.getNamespace().get("playBtn");
            
            scene = new Scene(parent);
            this.setScene(scene);
            controller = new ConnectionController(this);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public TextField getIpTF() {
        return ipTF;
    }

    public TextField getPortTF() {
        return portTF;
    }

    public Label getWarmingLabel() {
        return warmingLabel;
    }

    public Button getCloseBtn() {
        return closeBtn;
    }

    public Button getPlayBtn() {
        return playBtn;
    }
    
}
