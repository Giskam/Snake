package ua.com.snake;

import java.awt.Color;
import java.awt.Graphics;

public class MenuScene extends Scene {

	int i = 0;
	
	@Override
	public void update(double dt) {
		// TODO Auto-generated method stub
		if(i==1000) {
			Window.changeState(1);
		}
		i++;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

}
