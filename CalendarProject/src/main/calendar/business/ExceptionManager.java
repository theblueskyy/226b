package business;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Creates alert warning, if there is an exception
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class ExceptionManager {

	/**
	 *Creates alert if input = null
	 */
	public static void inputNull() {
		Alert lAlert = new Alert(AlertType.ERROR);
		lAlert.setTitle("Error");
		lAlert.setHeaderText("No file selected!");
		lAlert.setContentText("Please select a file for each placeholder!");
		lAlert.showAndWait();
	}
	
	/**
	 *Creates alert if input is wrong
	 */
	public static void inputWrong() {
		Alert lAlert = new Alert(AlertType.ERROR);
		lAlert.setTitle("Error");
		lAlert.setHeaderText("Wrong input format!");
		lAlert.setContentText("Please enter a valid year!");
		lAlert.showAndWait();
	}
}
