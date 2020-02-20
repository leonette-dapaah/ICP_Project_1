package guiGalam;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	private static BorderPane mainLayout;
//	private  Monitoring ;
	
	@FXML
	private Label Final;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Galamsey Monitoring");
		showView();
		showMainItems();
		
	}
	
	public void showView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Elements/Main.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		
		primaryStage.setScene(scene);
		primaryStage.show();
//		
	}
	public static void showMainItems()throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Elements/MainLayout.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	public static void showGalamseyScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Elements/GalamseyLay.fxml"));
		BorderPane Galamsey = loader.load();
		mainLayout.setCenter(Galamsey);
	}
	public static void showObservatoryScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Elements/Observatory.fxml"));
		BorderPane Galamsey = loader.load();
		mainLayout.setCenter(Galamsey);
	}
	public static void showStatisticsScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Elements/Monitoring statistics.fxml"));
		BorderPane Galamsey = loader.load();
		mainLayout.setCenter(Galamsey);
	}
	public static void showRecordsScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Elements/Information.fxml"));
		BorderPane Galamsey = loader.load();
		mainLayout.setCenter(Galamsey);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
