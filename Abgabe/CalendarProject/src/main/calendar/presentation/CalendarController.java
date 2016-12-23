package presentation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import business.ExceptionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.print.PrinterJob;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import model.Template;
/**
 * Controller class of calendar.fxml
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class CalendarController implements Initializable {

	ArrayList<String> month = new ArrayList<String>();

	@FXML
	private TabPane tabpane;
	@FXML
	ComboBox<String> selectionTemplate;
	@FXML
	ImageView test;
	@FXML
	public ComboBox<String> combo_year;

	/**
	 *Allows you to choose template
	 */
	@FXML
	public void chooseTemplate() throws URISyntaxException, IOException {
		business.TemplateCreator lMonth = ((business.TemplateCreator) tabpane.getSelectionModel().getSelectedItem());
		for (int i = 1; i < ((Pane) lMonth.getContent()).getChildren().size(); i++) {
			((Pane) lMonth.getContent()).getChildren().remove(i);
		}
		((business.TemplateCreator) tabpane.getSelectionModel().getSelectedItem()).setTemplate(new Template(),
				selectionTemplate.getSelectionModel().getSelectedItem());
	}

	/**
	 *Allows you to choose year
	 */
	@FXML
	public void chooseYear() {
		try {
			tabpane.getTabs().clear();
			int lYear = Integer.parseInt(combo_year.getValue());
			createCalendar(lYear);
		} catch (NumberFormatException e) {
			ExceptionManager.inputWrong();
		}
	}

	/**
	 *Init method
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectionTemplate.getItems().addAll("single", "double", "quadruple");
		selectionTemplate.setPromptText("Choose Template");
		combo_year.getItems().addAll("2017", "2018", "2019", "2020");
		combo_year.setPromptText("Choose Year");
		combo_year.setEditable(true);
	}

	/**
	 *Creates Calendar for every month in a year
	 */
	public void createCalendar(int pYear) {
		try {

			for (int i = 0; i < 12; i++) {
				Pane lPane = new Pane();
				business.TemplateCreator lTab = new business.TemplateCreator();
				YearMonth lYearMonth = YearMonth.of(pYear, i % 12 + 1);
				String lName = lYearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN);
				lTab.setText(lName);
				lPane.getChildren().add(new Calendar(lYearMonth));
				lTab.setContent(lPane);
				tabpane.getTabs().add(lTab);

			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 *Export Calendar as PDF
	 */
	@FXML
	public void print(ActionEvent event) {

		PrinterJob lPrinterJob = PrinterJob.createPrinterJob();
		{
			if (lPrinterJob != null) {
				lPrinterJob.showPrintDialog(CalendarApp.getMainStage());
				for (int i = 0; i < 12; i++) {
					lPrinterJob.printPage(tabpane.getTabs().get(i).getContent());
				}

				lPrinterJob.endJob();
			}
		}

	}

	/**
	 *Goes back to menu.fxml
	 */
	@FXML
	public void backToMenu(ActionEvent event) {

		CalendarApp.loadScene("menu");
	}
}
