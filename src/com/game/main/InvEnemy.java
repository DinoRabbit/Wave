package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//An enemy that is only visible when near the player
//None of these spawn in game as of yet, modify spawner to have some appear at whichever level you choose
//I mostly made this enemy for fun

public class InvEnemy extends GameObject 
{
	
	private Handler handler;
	private GameObject player;
	//boolean to determine when enemy is visible
	private boolean show;

	public InvEnemy(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		show = false;
		velX = 5;
		velY = 5;
		
		//We need to get the player from the handler
		for(int i = 0; i < handler.object.size(); i++)
		{
			if(handler.object.get(i).getId() == ID.Player)
				player = handler.object.get(i);
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
		
		float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
		if(distance <= 150)
			show = true;
		else
			show = false;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		if(show)
			handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		if(show)
		{
			g.setColor(Color.green);
			g.fillRect((int)x, (int)y, 16, 16);
		}
	}

}

