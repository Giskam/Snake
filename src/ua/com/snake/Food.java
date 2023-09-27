package ua.com.snake;

import java.awt.Color;

import java.awt.Graphics2D;

public class Food{

	public Rect background;
	public Snake snake;
	public int width, hight;
	public Color color;
	public Rect rect;
	public int xPading;
	public boolean isSpawned = false;
	public Food(Rect background, Snake snake, int width, int hight, Color color) {
		this.background = background;
		this.snake = snake;
		this.width = width;
		this.hight = hight;
		this.color = color;
		this.rect = new Rect(0, 0, width, hight);
		
		xPading = (int)((Constants.TILE_WIDTH - this.width) / 2);
		
		
	}

	public void spawn() {
		do{
			double randX = (int)(Math.random()*(int)(background.width / Constants.TILE_WIDTH) * Constants.TILE_WIDTH + background.x);
			double randY = (int)(Math.random()*(int)(background.height / Constants.TILE_WIDTH) * Constants.TILE_WIDTH + background.y);
			this.rect.x = randX;
			this.rect.y = randY;
		}while(snake.intersectingWithRect(this.rect));
		this.isSpawned = true;
			
	}
	
	public void update(double dt) {
		if(snake.intersectingWithRect(this.rect));
		snake.grow();
		this.rect.x = -100;
		this.rect.y = -100;
		
		isSpawned = false;
	}

	public void draw(Graphics2D g2) {
		g2.setColor(color);

		g2.fillRect((int)this.rect.x + xPading, (int)this.rect.y + xPading, width, hight);
	}
}
