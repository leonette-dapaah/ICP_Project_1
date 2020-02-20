package guiGalam.Elements;

import java.io.IOException;


import guiGalam.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainItemsController {
	private Main main;
	
	@FXML
	private Label t1;
	
	@FXML
	private Label t2;
	
	@FXML
	private Label t3;
	
	@FXML
	private Label t4;
	
	@FXML
	private TextField in1;

	@FXML
	private TextField in2;
	
	@FXML
	private TextField in3;
	
	@FXML
	private TextField in4;
	
	@FXML
	private Button b1;
	
	public void saveGalam(ActionEvent event) {
		
		t1.setText(in1.getText());in1.setText("");
		t2.setText(in2.getText());in2.setText("");
		t3.setText(in3.getText());in3.setText("");
		t4.setText(in4.getText());in4.setText("");
		b1.setText("SAVED");

	}
	public void saveObs(ActionEvent event) {
		
		t1.setText(in1.getText());in1.setText("");
		t2.setText(in2.getText());in2.setText("");
		t3.setText(in3.getText());in3.setText("");
		t4.setText(in4.getText());in4.setText("");
		b1.setText("SAVED");

	}
	
	
	public void largestColorValue(ActionEvent event) {
		t1.setText("");
	}
	
	public void AvgEverRecorded(ActionEvent event) {
		t1.setText("");
	}
	
	public void threshold(ActionEvent event) {
		in1.getText();
		if(in1.getText().isEmpty())
			t1.setText("");
		else
			t1.setText(in1.getText());
	}
	@FXML
	private void goGalamsey()throws IOException{
		main.showGalamseyScene();
		
	}
	
	@FXML
	private void goObservatory()throws IOException{
		main.showObservatoryScene();
	}
	
	@FXML
	private void goStatistics()throws IOException{
		main.showStatisticsScene();
	}
//	@FXML
//	private void goRecord()throws IOException{
//		main.showStatisticsScene();
//	}
	
}
