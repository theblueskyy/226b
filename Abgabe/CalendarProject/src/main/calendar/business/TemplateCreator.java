package business;

import java.net.URISyntaxException;

import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Template;
import presentation.CalendarApp;
/**
 * Creates Templates with ImageViews
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class TemplateCreator extends Tab {

	Template mTemplate;

	/**
	 *Constructor
	 */
	public TemplateCreator() throws URISyntaxException {
		super();

	}

	/**
	 *Set chosen Template
	 */
	public void setTemplate(Template pTemplate, String pType) throws URISyntaxException {
		this.mTemplate = pTemplate;
		AnchorPane lTabContent = new AnchorPane();
		for (ImageView lImageView : this.mTemplate.getImages(pType)) {

			lImageView.setImage(new Image(CalendarApp.class.getResourceAsStream("preview.png")));
			lImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent t) {
					FileSelector.chooseFile(lImageView);
				}
			});
			lTabContent.getChildren().add(lImageView);
		}
		((Pane) this.getContent()).getChildren().add(lTabContent);
	}
}
