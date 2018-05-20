package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//A harder version of basic enemies to be used with the hard difficulty

public class HardEnemy extends GameObject 
{
	
	private Handler handler;
	private Random r = new Random();

	public HardEnemy(int x, int y, int mode, ID id, Handler handler) 
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
		
		//When direction reverses, change velocity to random values
		if((y <= 5 && velY < 0) || (y >= Game.HEIGHT - 37 && velY > 0)) 
		{ 
			if(velY < 0) velY = -(r.nextInt(7) + 1) * -1;
			else velY = (r.nextInt(7) + 1) * -1;
		}
		if((x <= 5 && velX < 0) || (x >= Game.WIDTH - 21 && velX > 0))
		{ 
			if(velX < 0) velX = -(r.nextInt(15) + 5) * -1;
			else velX = (r.nextInt(15) + 5) * -1;
		}
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.yellow, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}

