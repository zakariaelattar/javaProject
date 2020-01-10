package Class;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Controller.LoginController;
import View.*;
/*
 * MAIN APP
 * */
public class App extends Application
{
	 public  void start(Stage primaryStage) 
	   {
		   
		   try {
				primaryStage.initStyle(StageStyle.UNDECORATED);
		        primaryStage.setMaximized(false);
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
				Loader.setController(new LoginController());
				AnchorPane root = Loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("../View/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	   public static void main(String[] args)
	   {
		   launch(args);
	   }

     


}
