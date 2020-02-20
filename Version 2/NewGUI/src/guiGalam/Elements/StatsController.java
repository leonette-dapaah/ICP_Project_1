package guiGalam.Elements;

import java.io.IOException;

import guiGalam.Main;
import javafx.fxml.FXML;

public class StatsController {
private Main main;
	
	@FXML
	private void goStatistics()throws IOException{
		main.showStatisticsScene();
	}
}

