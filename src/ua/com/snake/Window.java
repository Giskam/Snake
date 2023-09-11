package ua.com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable{

	public boolean isRunning;
	public Window (int width, int height, String title) {
		setSize(width, height);
		setTitle(title);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		isRunning = true;
	}
	
	public void update(double dt) {
		Image dbImage = createImage(getWidth(), getHeight());//off screen
		Graphics dbg = dbImage.getGraphics(); // graphics context
		this.draw(dbg); // draw onto graphics(downCust to 2d) pane   
		getGraphics().drawImage(dbImage, 0, 0, this);//get context; draw privios off screen on new off screen
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	
	@Override
	public void run() {
		double lastFrameTime = 0.0;
		try {
			while(isRunning) {
				double time = Time.getTime();
				double deltaTime = time - lastFrameTime; 
				lastFrameTime = time;
				
				update(deltaTime);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
