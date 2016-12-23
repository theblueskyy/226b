package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 * Launch FXML file
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class CalendarApp extends Application {

	/**
	 *Main Method
	 */
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage mMainStage;

	/**
	 *Start method/ load FXML
	 */
	@Override
	public void start(Stage pPrimaryStage) throws Exception {

		Parent lRoot = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Scene lScene = new Scene(lRoot);
		pPrimaryStage.setTitle("Calendar");
		pPrimaryStage.getIcons().add(new Image(CalendarApp.class.getResourceAsStream("icon.png")));
		pPrimaryStage.centerOnScreen();
		pPrimaryStage.setScene(lScene);
		mMainStage = pPrimaryStage;
		pPrimaryStage.show();

	}

	/**
	 * Loads varity of Scenes
	 */
	public static void loadScene(String lName) {
		Parent lParentToLoad = null;

		try {
			java.net.URL lResourcePath = CalendarApp.class.getResource(lName + ".fxml");
			lParentToLoad = FXMLLoader.load(lResourcePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene lSceneToLoad = new Scene(lParentToLoad);
		mMainStage.setScene(lSceneToLoad);
	}

	/**
	 *Get main Stage
	 */
	public static Stage getMainStage() {
		return mMainStage;
	}

	/**
	 *Set main Stage with Stage parameter
	 */
	public static void setMainStage(Stage mainStage) {
		CalendarApp.mMainStage = mainStage;
	}

}
