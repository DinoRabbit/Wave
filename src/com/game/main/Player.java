package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//The player object

public class Player extends GameObject 
{
	Random r = new Random();
	private Handler handler;

	public Player(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision();
	}
	
	//Function for handling collisions with other game objects(enemies), player loses health
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.OneDEnemy)
				if(getBounds().intersects(tempObject.getBounds()))
					HUD.HEALTH -= 2;
			if(tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.HardEnemy)
				if(tempObject.getBounds().intersects(tempObject.getBounds()))
					HUD.HEALTH -= 4;
			if(tempObject.getId() == ID.EnemyBoss)
				if(tempObject.getBounds().intersects(tempObject.getBounds()))
					HUD.HEALTH -= 6;
		}
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
