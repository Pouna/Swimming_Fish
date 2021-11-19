package gameobject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import userinterface.GameWindow;
import util.Resource;

public class Background {
    private List<ImageBackground> listBackground;
	private BufferedImage background;
	
	private MainCharacter mainCharacter;
	
	public Background(int width, MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
		background = Resource.getResouceImage("data/background.png");
		listBackground = new ArrayList<ImageBackground>();
		
		ImageBackground imageBackground = new ImageBackground();
		imageBackground.posX = 0;
		imageBackground.posY = 30;
		listBackground.add(imageBackground);
		
		imageBackground = new ImageBackground();
		imageBackground.posX = 150;
		imageBackground.posY = 40;
		listBackground.add(imageBackground);
		
		imageBackground = new ImageBackground();
		imageBackground.posX = 300;
		imageBackground.posY = 50;
		listBackground.add(imageBackground);
		
		imageBackground = new ImageBackground();
		imageBackground.posX = 450;
		imageBackground.posY = 20;
		listBackground.add(imageBackground);
		
		imageBackground = new ImageBackground();
		imageBackground.posX = 600;
		imageBackground.posY = 60;
		listBackground.add(imageBackground);
	}
	
	public void update(){
		Iterator<ImageBackground> itr = listBackground.iterator();
		ImageBackground firstElement = itr.next();
		firstElement.posX -= mainCharacter.getSpeedX()/8;
		while(itr.hasNext()) {
			ImageBackground element = itr.next();
			element.posX -= mainCharacter.getSpeedX()/8;
		}
		if(firstElement.posX < -background.getWidth()) {
			listBackground.remove(firstElement);
			firstElement.posX = GameWindow.SCREEN_WIDTH;
			listBackground.add(firstElement);
		}
	}
	
	public void draw(Graphics g) {
		for(ImageBackground imgLand : listBackground) {
			g.drawImage(background, (int) imgLand.posX, imgLand.posY, null);
		}
	}
	
	private class ImageBackground {
		float posX;
		int posY;
	}
}
