package guiGalam.Elements;


import java.io.IOException;

import guiGalam.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	private Main main;
	@FXML
	private Label Final;
	
	
	
	
	@FXML
	private void goHome()throws IOException{
		
		main.showMainItems();
		
	}
	@FXML
	private void goRecord()throws IOException{
		main.showRecordsScene();
	}
	
}