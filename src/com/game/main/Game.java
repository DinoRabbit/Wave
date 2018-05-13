package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

//Handle the game logic

public class Game extends Canvas implements Runnable 
{
	
	private static final long serialVersionUID = -473349850293143017L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	public int diff = 0;
	
	//0 = normal
	//1 = hard
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	//handle the state of the game
	public enum STATE 
	{
		Menu,
		Select,
		Help,
		Shop,
		Game,
		End
	};
	
	public static STATE gameState = STATE.Menu;
	
	public Game()
	{
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		new Window(WIDTH, HEIGHT, "Game", this);
		spawner = new Spawn(this, handler, hud);
		r = new Random();
		
		if(gameState == STATE.Game) //start the game
		{
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		}
		else //on the menu
			for(int i = 0; i < 20; i++)
				handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
				
	}
	
	public synchronized void start() //start thread
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() //stop thread
	{
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Basic game loop to keep the game running
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			
			if(running)
				render();
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//tick method, calls the tick method for other objects
	private void tick()
	{
		if(gameState == STATE.Game)
		{
			if(!paused)
			{
				hud.tick();
				spawner.tick();
				handler.tick();
				
				if(HUD.HEALTH <= 0)
				{
					HUD.HEALTH = 100;
					gameState = STATE.End;
					handler.clearEnemys();
					for(int i = 0; i < 20; i++)
						handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
				}	
			}
		}		
		else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select)
		{
			handler.tick();
			menu.tick();	
		}
	}
	
	//render method to display the games objects
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(paused)
		{
			g.setColor(Color.white);
			g.drawString("PAUSED", 100, 100);
		}
		if(gameState == STATE.Game)
		{
			hud.render(g);
			handler.render(g);
		}
		else if(gameState == STATE.Shop)
			shop.render(g);
		else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select)
		{
			menu.render(g);
			handler.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	//Function to keep objects from moving out of the window
	public static float clamp(float var, float min, float max)
	{
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String [] args)
	{
		new Game();
	}
}
