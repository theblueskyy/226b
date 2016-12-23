package presentation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.geometry.HPos;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
/**
 * Creates Calendar
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class Calendar extends BorderPane {

	private final ObjectProperty<YearMonth> mMonth = new SimpleObjectProperty<>();

	private final ObjectProperty<Locale> mLocale = new SimpleObjectProperty<>(Locale.getDefault());

	// private final BorderPane view;
	private final GridPane mCalendar;

	/**
	 *Add listener and create all the Panes and Labels
	 */
	public Calendar(YearMonth pMonth) {
		super();
		// view = new BorderPane();
		this.getStyleClass().add("calendar");
		mCalendar = new GridPane();
		mCalendar.getStyleClass().add("calendar-grid");

		Label lHeader = new Label();
		lHeader.setMaxWidth(Double.MAX_VALUE);
		lHeader.getStyleClass().add("calendar-header");

		this.mMonth.addListener((obs, oldMonth, newMonth) -> rebuildCalendar());

		this.mLocale.addListener((obs, oldLocale, newLocale) -> rebuildCalendar());

		this.setTop(lHeader);
		this.setCenter(mCalendar);

		this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		setMonth(pMonth);

		lHeader.textProperty()
				.bind(Bindings.createStringBinding(
						() -> this.mMonth.get().format(DateTimeFormatter.ofPattern("MMMM yyyy", mLocale.get())),
						this.mMonth, this.mLocale));
	}

	/**
	 *Builds Calendar
	 */
	private void rebuildCalendar() {

		mCalendar.getChildren().clear();

		WeekFields lWeekFields = WeekFields.of(mLocale.get());

		LocalDate lFirst = mMonth.get().atDay(1);

		int lDayOfWeekOfFirst = lFirst.get(lWeekFields.dayOfWeek());

		// column headers:
		for (int lDayOfWeek = 1; lDayOfWeek <= 7; lDayOfWeek++) {
			LocalDate lDate = lFirst.minusDays(lDayOfWeekOfFirst - lDayOfWeek);
			DayOfWeek lDay = lDate.getDayOfWeek();
			Label lLabel = new Label(lDay.getDisplayName(TextStyle.SHORT_STANDALONE, mLocale.get()));
			lLabel.getStyleClass().add("calendar-day-header");
			GridPane.setHalignment(lLabel, HPos.CENTER);
			mCalendar.add(lLabel, lDayOfWeek - 1, 0);
		}

		LocalDate lFirstDisplayedDate = lFirst.minusDays(lDayOfWeekOfFirst - 1);
		LocalDate lLast = mMonth.get().atEndOfMonth();
		int lDayOfWeekOfLast = lLast.get(lWeekFields.dayOfWeek());
		LocalDate lLastDisplayedDate = lLast.plusDays(7 - lDayOfWeekOfLast);

		PseudoClass lBeforeMonth = PseudoClass.getPseudoClass("before-display-month");
		PseudoClass lAfterMonth = PseudoClass.getPseudoClass("after-display-month");

		for (LocalDate lDate = lFirstDisplayedDate; !lDate.isAfter(lLastDisplayedDate); lDate = lDate.plusDays(1)) {
			Label lLabel = new Label(String.valueOf(lDate.getDayOfMonth()));
			lLabel.getStyleClass().add("calendar-cell");
			lLabel.pseudoClassStateChanged(lBeforeMonth, lDate.isBefore(lFirst));
			lLabel.pseudoClassStateChanged(lAfterMonth, lDate.isAfter(lLast));

			GridPane.setHalignment(lLabel, HPos.CENTER);

			int lDayOfWeek = lDate.get(lWeekFields.dayOfWeek());
			int lDaysSinceFirstDisplayed = (int) lFirstDisplayedDate.until(lDate, ChronoUnit.DAYS);
			int lWeeksSinceFirstDisplayed = lDaysSinceFirstDisplayed / 7;

			mCalendar.add(lLabel, lDayOfWeek - 1, lWeeksSinceFirstDisplayed + 1);
		}
	}

	/**
	 *Get property of month
	 */
	public final ObjectProperty<YearMonth> monthProperty() {
		return this.mMonth;
	}

	/**
	 *Get month return month property
	 **@return month property
	 */
	public final YearMonth getMonth() {
		return this.monthProperty().get();
	}

	/**
	 *Set month with YearMonth parameter
	 */
	public final void setMonth(final YearMonth pMonth) {
		this.monthProperty().set(pMonth);
	}

	/**
	 *Get month return locale property
	 *@return mLocale the actualy month
	 */
	public final ObjectProperty<Locale> localeProperty() {
		return this.mLocale;
	}

	/**
	 *Get locale return locale property
	 *@return Locale the locale 
	 */
	public final java.util.Locale getLocale() {
		return this.localeProperty().get();
	}

	/**
	 *Set local with Locale parameter
	 */
	public final void setLocale(final java.util.Locale pLocale) {
		this.localeProperty().set(pLocale);
	}

}
