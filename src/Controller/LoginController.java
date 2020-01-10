package Controller;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import Model.User;
public class LoginController implements Initializable {
	
	 @FXML
	 TextField email;
	 @FXML
	 PasswordField password;
	 @FXML
	 Button connexion;
	 @FXML
	 Button close;
	 @FXML
	 Label lbTest;
	 @FXML
	 AnchorPane root;
	 double xOffset;
	 double yOffset;
	 User user;
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stuff
		user = null;
		close.setOnAction(this::closeButtonAction);
		connexion.setOnAction(this::connexionButton);
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	Node node=(Node)event.getSource();
                Scene scene = (Scene) node.getScene();
                Stage stage = (Stage)scene.getWindow();
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
           }
        });
    }
	public void closeButtonAction(ActionEvent event) {

        if (event.getSource() == close) {
               Node node=(Node)event.getSource();
               Scene scene = (Scene) node.getScene();
               Stage stage = (Stage)scene.getWindow();
               stage.close();
        }
	}
   public void connexionButton(ActionEvent event)
   {
	 try {
		   user = UserController.findByMail(email.getText());
		   if(user!=null && isValid(email.getText()))
		   {
			   if(user.getPassword().equals(password.getText()))
			   {
				   try {
					    Stage primaryStage = new Stage(); 
						primaryStage.initStyle(StageStyle.UNDECORATED);
				        primaryStage.setMaximized(false);
						FXMLLoader Loader = new FXMLLoader(getClass().getResource("../View/Dash.fxml"));
						Loader.setController(new DashController());
						DashController dash = Loader.getController();
						dash.setUser(user);
						AnchorPane root = Loader.load();
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("../View/style.css").toExternalForm());
						primaryStage.setScene(scene);
						primaryStage.show();
						Node node=(Node)event.getSource();
			            Scene parent = (Scene) node.getScene();
			            Stage stage = (Stage)parent.getWindow();
			            stage.close();
						
						
					} catch(Exception e) {
						e.printStackTrace();
					}
			   }
			   else
			   {
				   Alert alert = new Alert(AlertType.WARNING, "identifiants incorrect ! ", ButtonType.CANCEL);
				   alert.showAndWait(); 
			   }
		   }
		   else
		   {
			   Alert alert = new Alert(AlertType.INFORMATION, "aucun email de ce type ou format d'email incorrect ! ", ButtonType.CANCEL);
			   alert.showAndWait(); 
		   }
		   
		 
	 }
	 catch(Exception e)
	 {
		 Alert alert = new Alert(AlertType.INFORMATION, "erreur de type"+e.toString(), ButtonType.CANCEL);
		 alert.showAndWait();
	 }
   }
   public static boolean isValid(String email) 
   { 
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                           "[a-zA-Z0-9_+&*-]+)*@" + 
                           "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                           "A-Z]{2,7}$"; 
                             
       Pattern pat = Pattern.compile(emailRegex); 
       if (email == null) 
           return false; 
       return pat.matcher(email).matches(); 
   }

	
}
