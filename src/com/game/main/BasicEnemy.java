package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Basic enemy object, simple enough to understand

public class BasicEnemy extends GameObject 
{
	
	private Handler handler;

	public BasicEnemy(int x, int y, int mode, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		
		switch(mode)
		{
			case 1:
				velX = 5;
				velY = 5;
				break;
			case 2:
				velX = -5;
				velY = 5;
				break;
			case 3:
				velX = 5;
				velY = -5;
				break;
			case 4:
				velX = -5;
				velY = -5;
				break;
			default:
				velX = 5;
				velY = 5;
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}


	public void tick() 
	{
		x += velX;
		y += velY;
		
		//When we hit the edge, reverse direction
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
