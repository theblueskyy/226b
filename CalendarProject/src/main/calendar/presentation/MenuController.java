package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
/**
 * Controller class of menu.fxml
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class MenuController {

	@FXML
	protected Label label_menuTitle;
	@FXML
	protected Button button_createCalendar;
	@FXML
	protected Button button_editCalendar;
	@FXML
	protected ImageView imageView_pic;

	/**
	 *Loads calendar.fxml
	 */
	public void createCalendar(ActionEvent event) {

		CalendarApp.loadScene("calendar");
	}

	/**
	 *Exit programm
	 */
	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}
}
