package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

//Object to handle game objects

public class Handler 
{	
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public int spd = 5;
	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}		
	}
	
	//Function to clear out enemy objects, but keep non-enemy objects like the player
	public void clearEnemys()
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			if(tempObject.getId() == ID.Player) 
			{ 
				object.clear();
				if(Game.gameState != Game.STATE.End && Game.gameState != Game.STATE.Win) //re-add the player if the game isn't over yet.
					addObject(new Player((int)tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
			}
			if(Game.gameState == Game.STATE.End && tempObject.getId() == ID.Player) object.remove(tempObject);
		}	
		
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
}

