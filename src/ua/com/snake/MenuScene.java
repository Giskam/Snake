package ua.com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MenuScene extends Scene {

	public KL keyListener;
	public ML mouseListener;
	public BufferedImage title, play, playPressed, exit, exitPressed;
	public Rect playRect, exitRect, titleRect;
	
	public BufferedImage playCurrentImage, exitCurrentImage;
	
	public MenuScene (KL keyListener, ML mouseListener) {
		this.keyListener = keyListener;
		this.mouseListener = mouseListener;
		try {
			BufferedImage spriteSheet = ImageIO.read(new File("Assets/menuSprite.png"));
			title = spriteSheet.getSubimage(0, 242, 960, 240);
			play = spriteSheet.getSubimage(0, 121, 261, 121);
			playPressed = spriteSheet.getSubimage(264, 125, 261, 121);
			exit = spriteSheet.getSubimage(0, 0, 233, 92);
			exitPressed = spriteSheet.getSubimage(264, 0, 233, 93);
		} catch(Exception e) {
			e.printStackTrace();
		}
		titleRect = new Rect(150, 40, 300, 100);
		playRect = new Rect(310, 210, 600, 70);
		exitRect = new Rect(410, 270, 600, 70);
		
		playCurrentImage = play;
		exitCurrentImage = exit;
	}
	
	@Override
	public void update(double dt) {
		
		if (mouseListener.getX()>=playRect.x && mouseListener.getX()<=playRect.x + playRect.width && mouseListener.getY() >= playRect.y && mouseListener.getY()<= playRect.y + playRect.height) {
			playCurrentImage = playPressed;
			if(mouseListener.isPressed) {
				Window.changeState(1);
			}
		}else {
			playCurrentImage = play;
		}
		if (mouseListener.getX() >= exitRect.x && mouseListener.getX() <= exitRect.x + exitRect.width
				&& mouseListener.getY() >= exitRect.y && mouseListener.getY() <= exitRect.y + exitRect.height) {
			exitCurrentImage = exitPressed;
			if(mouseListener.isPressed) {
			
			}
		}else {
			exitCurrentImage = exit;
		}
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		g.drawImage(title, (int)150, (int)40, (int)300, (int)100, null);
		g.drawImage(playCurrentImage, (int)240, (int)210, (int)150, (int)70, null);
		g.drawImage(exitCurrentImage, (int)250, (int)300, (int)130, (int)55, null);
	}

}
