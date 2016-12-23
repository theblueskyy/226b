package business;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
/**
 * Open FileChooser 
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class FileSelector {

	/**
	 *Open FileChooser if PlaceHolder image is clicked on
	 */
	public static void chooseFile(ImageView pImageView) {
		FileChooser lFileChooser = new FileChooser();

		FileChooser.ExtensionFilter lImageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		lFileChooser.getExtensionFilters().addAll(lImageFilter);
		
		try {
			File lFile = lFileChooser.showOpenDialog(null);
			BufferedImage lBufferedImage = ImageIO.read(lFile);
			Image lImage = SwingFXUtils.toFXImage(lBufferedImage, null);
			pImageView.setImage(lImage);
		} catch (Exception e) {
			ExceptionManager.inputNull();

		}
	}
}
