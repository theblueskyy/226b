package presentation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class CalendarController implements Initializable 
{
	private final ObjectProperty<YearMonth> month = new SimpleObjectProperty<>();

	private final ObjectProperty<Locale> locale = new SimpleObjectProperty<>(Locale.getDefault());

	@FXML
	private Pane pane;
	
	@FXML
	private Pane panetem1;
	
	@FXML
	private Pane panetem2;
	
	@FXML
	private GridPane grid;
	
	@FXML
	private GridPane grid1;
	
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private Label label;
	
	@FXML
	private Button button;
	
	@FXML
	private Label label1;
	
	@FXML
	private Button button1;
	
	@FXML
	private Label label2;
	
	@FXML
	private Button button3;
	
	@FXML
	private ImageView image;
	
	@FXML
	private ImageView image2;
	
	@FXML
	private ImageView image3;

	private final BorderPane view;

	private final GridPane calendar;
	

	public CalendarController(YearMonth month) 
	{
		view = new BorderPane();
		view.getStyleClass().add("calendar");
		calendar = new GridPane();
		calendar.getStyleClass().add("calendar-grid");

		Label header = new Label();
		header.setMaxWidth(Double.MAX_VALUE);
		header.getStyleClass().add("calendar-header");

		this.month.addListener((obs, oldMonth, newMonth) -> rebuildCalendar());

		this.locale.addListener((obs, oldLocale, newLocale) -> rebuildCalendar());

		view.setTop(header);
		view.setCenter(calendar);

		view.getStylesheets().add(getClass().getResource("calendar.css").toExternalForm());

		setMonth(month);

		header.textProperty().bind(Bindings.createStringBinding(() -> this.month.get().format(DateTimeFormatter.ofPattern("MMMM yyyy", locale.get())),this.month, this.locale));
	}

	public CalendarController() {
		this(YearMonth.of(2017, 1));
	}

	@FXML
	public void nextMonth() {
		month.set(month.get().plusMonths(1));
	}

	@FXML
	public void previousMonth() {
		month.set(month.get().minusMonths(1));
	}
	
	@FXML
	public void browse() 
	{
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image1 = SwingFXUtils.toFXImage(bufferedImage, null);
			image.setImage(image1);
		} catch (IOException ex) {
			Logger.getLogger(CalendarController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@FXML
	public void browse2() 
	{
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image1 = SwingFXUtils.toFXImage(bufferedImage, null);
			image2.setImage(image1);
		} catch (IOException ex) {
			Logger.getLogger(CalendarController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@FXML
	public void browse3() 
	{
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			int x = bufferedImage.getWidth();
			int y = bufferedImage.getHeight();
			
			//image3.setFitWidth(x / (((x-200)/200)+1));
			//image3.setFitHeight(y / (((x-200)/200)+1));
			//image3.setFitWidth(300);
			//image3.setFitHeight(300);
			Image image1 = SwingFXUtils.toFXImage(bufferedImage, null);
			image3.setImage(image1);
		} catch (IOException ex) {
			Logger.getLogger(CalendarController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@FXML
	public void choose() {
		if(combo.getValue().equals("Template 1"))
		{
			grid1.setVisible(false);
			panetem2.setVisible(false);
			grid.setVisible(true);
			panetem1.setVisible(true);
		}
		else if(combo.getValue().equals("Template 2"))
		{
			grid.setVisible(false);
			panetem1.setVisible(false);
			grid1.setVisible(true);
			panetem2.setVisible(true);
		}
	}

	private void rebuildCalendar() {

		calendar.getChildren().clear();

		WeekFields weekFields = WeekFields.of(locale.get());

		LocalDate first = month.get().atDay(1);

		int dayOfWeekOfFirst = first.get(weekFields.dayOfWeek());

		// column headers:
		for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
			LocalDate date = first.minusDays(dayOfWeekOfFirst - dayOfWeek);
			DayOfWeek day = date.getDayOfWeek();
			Label label = new Label(day.getDisplayName(TextStyle.SHORT_STANDALONE, locale.get()));
			label.getStyleClass().add("calendar-day-header");
			GridPane.setHalignment(label, HPos.CENTER);
			calendar.add(label, dayOfWeek - 1, 0);
		}

		LocalDate firstDisplayedDate = first.minusDays(dayOfWeekOfFirst - 1);
		LocalDate last = month.get().atEndOfMonth();
		int dayOfWeekOfLast = last.get(weekFields.dayOfWeek());
		LocalDate lastDisplayedDate = last.plusDays(7 - dayOfWeekOfLast);

		PseudoClass beforeMonth = PseudoClass.getPseudoClass("before-display-month");
		PseudoClass afterMonth = PseudoClass.getPseudoClass("after-display-month");

		for (LocalDate date = firstDisplayedDate; !date.isAfter(lastDisplayedDate); date = date.plusDays(1)) {
			Label label = new Label(String.valueOf(date.getDayOfMonth()));
			label.getStyleClass().add("calendar-cell");
			label.pseudoClassStateChanged(beforeMonth, date.isBefore(first));
			label.pseudoClassStateChanged(afterMonth, date.isAfter(last));

			GridPane.setHalignment(label, HPos.CENTER);

			int dayOfWeek = date.get(weekFields.dayOfWeek());
			int daysSinceFirstDisplayed = (int) firstDisplayedDate.until(date, ChronoUnit.DAYS);
			int weeksSinceFirstDisplayed = daysSinceFirstDisplayed / 7;

			calendar.add(label, dayOfWeek - 1, weeksSinceFirstDisplayed + 1);
		}
	}

	public Node getView() {
		return view;
	}

	public final ObjectProperty<YearMonth> monthProperty() {
		return this.month;
	}

	public final YearMonth getMonth() {
		return this.monthProperty().get();
	}

	public final void setMonth(final YearMonth month) {
		this.monthProperty().set(month);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		pane.getChildren().add(view);
	}
}