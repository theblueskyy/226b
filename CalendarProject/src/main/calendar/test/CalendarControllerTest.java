/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javafx.scene.control.ComboBox;

import static org.mockito.Mockito.*;

import presentation.CalendarController;

/**
 * @author Nana
 *
 */
public class CalendarControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	CalendarController cc = new CalendarController();
	
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Test method for {@link presentation.CalendarController#chooseTemplate()}.
	 */
	@Test
	public void testChooseTemplate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link presentation.CalendarController#chooseYear()}.
	 */
	@Test(expected = NumberFormatException.class)
	public void testChooseYear() {
		CalendarController test = Mockito.mock(CalendarController.class);
		int year = 2017;
		test.combo_year = new ComboBox<String>();
		when(test.combo_year.getValue()).thenReturn("muster");
		test.chooseYear();
		//String d = "blah" + year;
	}

	/**
	 * Test method for {@link presentation.CalendarController#backToMenu(javafx.event.ActionEvent)}.
	 */
	@Test
	public void testBackToMenu() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link presentation.CalendarController#createCalendar(javafx.event.ActionEvent)}.
	 */
	@Test
	public void testCreateCalendar() {
		cc.createCalendar(2017);
	}

}
