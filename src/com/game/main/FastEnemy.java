package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//A faster version of the basic enemy

public class FastEnemy extends GameObject
{
	
	private Handler handler;

	public FastEnemy(int x, int y, int mode, ID id, boolean horiz, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		
		//Much faster vertical or horizontal movement
		if(horiz)
		{
			switch(mode)
			{
				case 1:
					velX = 9;
					velY = 2;
					break;
				case 2:
					velX = -9;
					velY = 2;
					break;
				case 3:
					velX = 9;
					velY = -2;
					break;
				case 4:
					velX = -9;
					velY = -2;
					break;
				default:
					velX = 9;
					velY = 2;
			}
		}
		else
		{
			switch(mode)
			{
				case 1:
					velX = 2;
					velY = 9;
					break;
				case 2:
					velX = -2;
					velY = 9;
					break;
				case 3:
					velX = 2;
					velY = -9;
					break;
				case 4:
					velX = -2;
					velY = -9;
					break;
				default:
					velX = 2;
					velY = 9;
			}
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
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
