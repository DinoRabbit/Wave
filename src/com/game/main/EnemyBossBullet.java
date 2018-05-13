package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//Bullet for enemy boss object, basically the same as basic enemy object

public class EnemyBossBullet extends GameObject 
{
	
	private Handler handler;
	private Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5); //bullets should go down, in a random direction
		velY = 5;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}


	public void tick() 
	{
		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		//bullets can leave the screen, when they do, remove them
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
