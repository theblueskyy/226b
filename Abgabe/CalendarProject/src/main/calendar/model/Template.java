package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.ImageView;
/**
 * Creates ImageViews for Template
 * 
 * @author nana.schuetz
 * @version 1.0
 */
public class Template {

	Map<String,List<ImageView>> mImages = new HashMap<String,List<ImageView>>(); // Bereiche wo die bilder abgelegt werden
	
	/**
	 *Creates and sets layout of ImageView
	 */
	public Template(){
		//Template one
		ImageView lImageView = new ImageView();
		lImageView.setLayoutX(210);
		lImageView.setLayoutY(10);
		lImageView.setFitHeight(220);
		lImageView.setFitWidth(300);
		List<ImageView> lList = new ArrayList<ImageView>();
		lList.add(lImageView);
		mImages.put("single", lList);
		
		//Template two
		ImageView lImageView1 = new ImageView();
		lImageView1.setLayoutX(210);
		lImageView1.setLayoutY(10);
		lImageView1.setFitHeight(120);
		lImageView1.setFitWidth(280);
		List<ImageView> lList1 = new ArrayList<ImageView>();
		lList1.add(lImageView1);
		ImageView lImageView2 = new ImageView();
		lImageView2.setLayoutX(210);
		lImageView2.setLayoutY(130);
		lImageView2.setFitHeight(120);
		lImageView2.setFitWidth(280);
		lList1.add(lImageView2);
		mImages.put("double", lList1);
		
		//template three
		ImageView lImageView3 = new ImageView();
		lImageView3.setLayoutX(210);
		lImageView3.setLayoutY(10);
		lImageView3.setFitHeight(100);
		lImageView3.setFitWidth(140);
		List<ImageView> lList2 = new ArrayList<ImageView>();
		lList2.add(lImageView3);
		ImageView lImageView4 = new ImageView();
		lImageView4.setLayoutX(350);
		lImageView4.setLayoutY(10);
		lImageView4.setFitHeight(100);
		lImageView4.setFitWidth(140);
		lList2.add(lImageView4);
		ImageView lImageView5 = new ImageView();
		lImageView5.setLayoutX(210);
		lImageView5.setLayoutY(110);
		lImageView5.setFitHeight(100);
		lImageView5.setFitWidth(140);
		lList2.add(lImageView5);
		ImageView lImageView6 = new ImageView();
		lImageView6.setLayoutX(350);
		lImageView6.setLayoutY(110);
		lImageView6.setFitHeight(100);
		lImageView6.setFitWidth(140);
		lList2.add(lImageView6);
		mImages.put("quadruple", lList2);
		
	}
	
	/**
	 *Get image with key parameter
	 */
	public List<ImageView> getImages(String pKey){
		return mImages.get(pKey);
	}
	
	
}
