package ua.com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {


	public static Window window = null;
	public boolean isRunning;
	public int currentState;
	public Scene currentScene;

	public KL keyListener = new KL();
	public ML mouseListener = new ML();

	public Window(int width, int height, String title) {
		setSize(width, height);
		setTitle(title);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		isRunning = true;
		changeState(0);
		addKeyListener(keyListener);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	public void changeState(int newState) {
		currentState = newState;

		switch (currentState) {

		case 0:
			currentScene = new MenuScene(keyListener, mouseListener);
			break;
		case 1:
			currentScene = new GameScene(keyListener);
			break;
		default:
			System.out.println("Unknown scene");
			currentScene = null;
			break;
		}
	}

	public static Window getWindow() {
		if (Window.window == null) {
			Window.window = new Window(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.TITLE);
		}
		return Window.window;
	}
 
	public void close() {
		isRunning = false;
	}

	public void update(double dt) {
		Image dbImage = createImage(getWidth(), getHeight());// off screen
		Graphics dbg = dbImage.getGraphics(); // graphics context
		this.draw(dbg); // draw onto graphics(downCust to 2d) pane
		getGraphics().drawImage(dbImage, 0, 0, this);// get context; draw privios off screen on new off screen

		currentScene.update(dt);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		currentScene.draw(g);
	}

	@Override
	public void run() {
		double lastFrameTime = 0.0;
		try {
			while (isRunning) {
				double time = Time.getTime();
				double deltaTime = time - lastFrameTime;
				lastFrameTime = time;

				update(deltaTime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dispose();
	}
}
