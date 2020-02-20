package guiGalam.Elements;

import java.io.IOException;

import guiGalam.Main;
import javafx.fxml.FXML;

public class ObControllerr {
private Main main;
	
	@FXML
	private void goObservatory()throws IOException{
		main.showObservatoryScene();
	}
}
