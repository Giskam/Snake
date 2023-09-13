package ua.com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuScene extends Scene {

	public KL keyListener;
	
	public MenuScene (KL keyListener) {
		this.keyListener = keyListener;
	}
	
	@Override
	public void update(double dt) {
		// TODO Auto-generated method stub
		if(keyListener.isKeyPressed(KeyEvent.VK_UP)) {
			System.out.println("Up arrow is pressed");
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

}
