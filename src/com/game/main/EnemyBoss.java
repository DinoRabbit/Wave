package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//A massive enemy that shoots small bullets at the player

public class EnemyBoss extends GameObject 
{
	
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	private Random r = new Random();

	public EnemyBoss(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 96, 96);
	}


	/* This enemy is unique in that it floats down from the top of the screen, stops, and begins
		moveing from side to side, the first timer tells us when to stop the vertical movement,
		the second timer tells us how long we should wait until the enemy begins horizontal movement*/
	public void tick() 
	{
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer --;
		
		if(timer <= 0) timer2--;
		
		//Horizontal movement logic, enemy speeds up as it moves
		if(timer2 <= 0)
		{
			if(velX == 0) velX = 2;
			if(velX > 0) velX += 0.05f;
			else if(velX < 0) velX -= 0.05f;
			
			//prevent velocity from exceeding 10/-10
			velX = Game.clamp(velX, -10, 10);
			
			//Logic to spawn in bullets
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler)); //spawn a bullet
		}
		
		//When we hit the edge, reverse direction
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1;
	
		//handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 96, 96, 0.02f, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
	}

}
