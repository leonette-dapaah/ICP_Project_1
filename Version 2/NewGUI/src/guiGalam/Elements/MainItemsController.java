package guiGalam.Elements;

import java.io.IOException;
import java.sql.*;


import galamsey.IMS.Galamsey;
import galamsey.IMS.Monitoring;
import galamsey.IMS.Observatory;
import guiGalam.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainItemsController {
	private Main main;
	private Monitoring mainSys = main.mainSys;
	/**
	 * Description of some variables here.
	 */
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	
	final String USER = main.Username;
	final String PASS = main.password;
	 
	//Creating instance of the Scanner class to accept input
	
	
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
	
	public static String check(String w) {
		if(w.isEmpty())
			return "1";
		return w;
	}
	
	public void saveGalam(ActionEvent event) {
		
		if(mainSys.getObservatories().isEmpty())
			mainSys.addObservatory(new Observatory("Ghana Obs Ltd", "Ghana", "2015", 56.3));
		
		mainSys.getObservatories().get(mainSys.getObservatories().size()-1).
		addGalamsey(new Galamsey(check(in1.getText()), check(in3.getText()),
				Integer.parseInt(check(in2.getText())),check(in4.getText())));
		// Creating connection with database and inputing the records
        Connection myConn = null;
		Statement myStmt = null; //We can also used PreparedStatement
		 
		/**
		 * Writing the data collected into a database.
		 */
		try {
			Class.forName(JDBC_DRIVER);
			
			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			myStmt = myConn.createStatement();
			
			String sql = "insert into Galamsey "
						+ " (veg_color, position, col_value, year)"
						+ " values ('"+check(in1.getText())+"', '"+check(in3.getText())+"', '"+
						Integer.parseInt(check(in2.getText()))+"', '"+check(in4.getText())+"')";
			
			
			myStmt.executeUpdate(sql);
			}catch(Exception se){
				se.printStackTrace();
			}
        
		
		t1.setText(in1.getText());in1.setText("");
		t2.setText(in2.getText());in2.setText("");
		t3.setText(in3.getText());in3.setText("");
		t4.setText(in4.getText());in4.setText("");
		b1.setText("SAVED");

	}
	public void saveObs(ActionEvent event) {
		mainSys.addObservatory(new Observatory(check(in1.getText()), check(in2.getText()), 
				check(in3.getText()), Double.parseDouble(check(in4.getText()))));
		/**
		 * Description of some variables here.
		 */
        
        // Creating connection with the database and putting the inputs into the Monitoring database table
        Connection myConn = null;
		Statement myStmt = null; //We can also used PreparedStatement
		 
		try {
			
			/**
			 * Writing the inputs into the tables of the databasee.
			 */
			
			Class.forName(JDBC_DRIVER);
			
			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			myStmt = myConn.createStatement();
			
			String sql = "insert into Observatory "
						+ " (obs_name, country, year_started, area_covered)"
						+ " values ('"+check(in1.getText())+"', '"+check(in2.getText())+"', '"+
						check(in3.getText())+"', '"+Double.parseDouble(check(in4.getText()))+"')";
			
			
			myStmt.executeUpdate(sql);
			}catch(Exception se){
				se.printStackTrace();
			}
		t1.setText(in1.getText());in1.setText("");
		t2.setText(in2.getText());in2.setText("");
		t3.setText(in3.getText());in3.setText("");
		t4.setText(in4.getText());in4.setText("");
		b1.setText("SAVED");

	}
	
	
	public void largestColorValue(ActionEvent event) {
		t1.setText(Double.toString(mainSys.largestGalamseyValueEverRecord()));
	}
	
	public void AvgEverRecorded(ActionEvent event) {
		t1.setText(Double.toString(mainSys.getLargestAverageGalamseyValue()));
	}
	
	public void threshold(ActionEvent event) {
		in1.getText();
		if(in1.getText().isEmpty())
			t1.setText("");
		else {
			try {

				t1.setText(mainSys.getAllGalamseyActAboveValueof(Integer.parseInt(in1.getText())));
			}catch(Exception e) {
				t2.setText("Wrong Input");
				t1.setText("Enter An Integer!");
			}
		}
			
	}

	
	public void showRecords(ActionEvent event) {
		if(mainSys.getAllObservatory().isEmpty())
			t1.setText("No Records");
		t1.setText(mainSys.getAllObservatory());
		
		if(mainSys.getAllGalam().isEmpty())
			t2.setText("No Records");
		t2.setText(mainSys.getAllGalam());
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
