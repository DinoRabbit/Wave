package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.main.Game.STATE;

//A class to deal with Key input
/*	We handle when a key is down with a set of booleans because a strange thing used to happen
	where if the player were to hold down the W key, to move up, and then pressed the S key,
	to move down, and then released W, the player would begin to move down, and then stop once
	the W key was released.  The boolean values prevent this from happening. */

public class KeyInput extends KeyAdapter
{
	private Handler handler;
	private boolean [] keyDown = new boolean[4];
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
		//A set of booleans to tell us when a key is being pressed
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			//Handle the player's movement WASD
			if(tempObject.getId() == ID.Player)
			{
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.spd); keyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.spd); keyDown[1] = true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.spd); keyDown[2] = true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.spd); keyDown[3] = true; }
			}
		}
		
		//Pause the game
		if(key == KeyEvent.VK_P)
		{
			if(Game.gameState == STATE.Game)
				Game.paused = !Game.paused;
		}
		
		//exit on Escape key
		if(key == KeyEvent.VK_ESCAPE) System.exit(0);
		
		//Open up the game's shop when the space key is pressed
		if(key == KeyEvent.VK_SPACE)
		{
			if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
			else if(Game.gameState == STATE.Shop) Game.gameState = STATE.Game;
		}
	}
	
	//Handle a Key being released
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player)
			{
				if(key == KeyEvent.VK_W) keyDown[0] = false; 
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				if(key == KeyEvent.VK_D) keyDown[2] = false;
				if(key == KeyEvent.VK_A) keyDown[3] = false;
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
	}
}
