package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainScreenController implements Initializable {

  Stage stage;
  @FXML
  Button button_signup;

  @FXML
  Button button_login;

  @FXML
  private Button button_create;
  @FXML
  private TextArea idSpace;


  @Override
  public void initialize(URL url, ResourceBundle resources) {
    button_signup.setOnMousePressed(new EventHandler<MouseEvent>() {

      public void handle(MouseEvent e) {
        System.out.println("(Sign-Up Pressed)");
        loadScene(button_signup,"SignUpSample.fxml","Sign Up");
      }
    });


    button_login.setOnMousePressed(new EventHandler<MouseEvent>() {
      Main msc = new Main();
      public void handle(MouseEvent e) {

        loadScene(button_login,"SignInSample.fxml","Log In Window");
      }
    });
  }
  //Method use for calling a scene (Andre use it for every scene calling)******************
  public void loadScene(Button pressedButton, String nameOfFxml,String titleOftheScene){

    try {
      Stage stage;
// retrieves and closes current stage
      stage = (Stage) pressedButton.getScene().getWindow();
      stage.close();
// loads main screen stage
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(nameOfFxml));
      Parent profile = fxmlLoader.load();

// creates a new stage
      Stage newStage = new Stage();
      newStage.setTitle(titleOftheScene);
      newStage.setScene(new Scene(profile));

// set new stage to current stage and display stage
      stage = newStage;
      stage.show();

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

}
