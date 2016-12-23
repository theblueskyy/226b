package presentation;

import java.net.URL;
import java.time.YearMonth;
import java.util.ResourceBundle;

import business.CalendarCreator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class CalendarController implements Initializable {
	@FXML
	private AnchorPane pane;

	TabPane tabPane = new TabPane();

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		String[] array = { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		
		for (int i = 0; i < 12; i++) 
		{
			Tab tab = new Tab();
			Pane pane = new Pane();
			YearMonth ym = YearMonth.of(2017, i%12+1);
			pane.getChildren().add(new CalendarCreator(ym));
			tab.setText(array[i]);
			tab.setContent(pane);
			tabPane.getTabs().add(tab);
		}
		pane.getChildren().add(tabPane);
	}

}
