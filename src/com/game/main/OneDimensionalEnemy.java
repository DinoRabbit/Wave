package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//An enemy that moves very fast, but only in the X direction or the Y direction

public class OneDimensionalEnemy extends GameObject
{
	
	private Handler handler;

	public OneDimensionalEnemy(ID id, boolean horiz, Handler handler) 
	{
		super(Game.WIDTH/2 - 16, Game.HEIGHT/2 - 32, id);
		this.handler = handler;
		
		//Set the velocity
		if(horiz)
		{
			velX = 10;
			velY = 0;
		}
		else
		{
			velX = 0;
			velY = 10;
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
		
		//reverse direction when we hit the window edge
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.magenta, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.magenta);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}


