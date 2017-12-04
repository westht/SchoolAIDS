package control;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;	
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class OneController {
	
	//not using yet
	@FXML
	private ImageView refugees;
	
	private Ellipse ceiling;
	
//	private Stage sendStage;

    
    private void initializeCeiling(AnchorPane root) {
        ceiling = new Ellipse();
        ceiling.centerXProperty().bind(root.widthProperty().multiply(0.5));
        ceiling.centerYProperty().setValue(0);
        ceiling.radiusXProperty().bind(root.widthProperty().multiply(0.8));
        ceiling.radiusYProperty().bind(root.heightProperty().multiply(0.6));
    }

    public void showSendProfile() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/Superheader.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage sendStage = new Stage();
            sendStage.setTitle("Superheader");
            
            //clips
           
            refugees = new ImageView();

            refugees.setEffect(new GaussianBlur(5));
            
            Scene scene = new Scene(page);
             sendStage.setScene(scene);

            
            sendStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSend() {
    	showSendProfile();
//        sendStage.close();
    }


    @FXML
    private void handleClose() {

   	        System.exit(0);
    }
    }