package ua.com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene {

	Rect background, foreground;
	Snake snake;
	KL keyListener;
	
	public Food food;
	
	
	public GameScene (KL keyListener) {
		background = new Rect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		foreground = new Rect(25, 48, Constants.TILE_WIDTH*23, Constants.TILE_WIDTH*22);
		snake = new Snake(10, 48, 48+24, 24, 24); 
		this.keyListener = keyListener;
		food = new Food(foreground, snake, 13, 13, Color.GREEN);
		food.spawn();
	}
	@Override
	public void update(double dt) {
		// TODO Auto-generated method stub
		snake.update(dt);
		if(keyListener.isKeyPressed(KeyEvent.VK_UP)) {
			snake.changeDirection(Direction.UP);
		}else if(keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
			snake.changeDirection(Direction.DOWN);
		}else if(keyListener.isKeyPressed(KeyEvent.VK_RIGHT)) {
			snake.changeDirection(Direction.RIGHT);
		}else if(keyListener.isKeyPressed(KeyEvent.VK_LEFT)) {
			snake.changeDirection(Direction.LEFT);
		}
		 
		if (!food.isSpawned) {
			food.spawn();
		}
		food.update(dt);
		snake.update(dt);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		// TODO Auto-generated method stub
		g2.setColor(Color.BLACK);
		g2.fill(new Rectangle2D.Double(background.x, background.y, background.width, background.height));
		
		g2.setColor(Color.WHITE);
		g2.fill(new Rectangle2D.Double(foreground.x, foreground.y, foreground.width, foreground.height));
		snake.draw(g2);
		food.draw(g2);
	}

}
