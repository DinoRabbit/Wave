package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Random;

import com.game.main.Game.STATE;

//Class for handling menus within the game

public class Menu extends MouseAdapter
{
	Game game;
	Handler handler;
	private HUD hud;
	//private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	//Handle different buttons when the mouse is pressed
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu) //Initial menu
		{
			//Play Button
			if(mouseOver(mx, my, 210, 150, 200, 64))
			{
				Game.gameState = STATE.Select;
				return;
			}
			//Menu Button
			if(mouseOver(mx, my, 210, 250, 200, 64))
				Game.gameState = STATE.Help;
			//Quit Button
			if(mouseOver(mx, my, 210, 350, 200, 64))
				System.exit(0);
		}
		
		if(Game.gameState == STATE.Select) //Difficulty selection
		{
			//Normal Button
			if(mouseOver(mx, my, 210, 150, 200, 64))
			{
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				game.diff = 0;
			}
			//Hard Button
			if(mouseOver(mx, my, 210, 250, 200, 64))
			{
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				//handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				game.diff = 1;
			}
			//Back Button in Select
			if(mouseOver(mx, my, 210, 350, 200, 64))
			{
				Game.gameState = STATE.Menu;
				return;
			}
		}
		
		if(Game.gameState == STATE.Help) //Help screen
			//Back Button in Help
			if(mouseOver(mx, my, 210, 350, 200, 64))
			{
				Game.gameState = STATE.Menu;
				return;
			}
		if(Game.gameState == STATE.End || Game.gameState == STATE.Win) //End screen Win/Lose
			//Try Again
			if(mouseOver(mx, my, 210, 350, 200, 64))
			{
				Game.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.setScore(0);
				return;
			}
	}
	
	//mouse released is not used, but is required by mouse adapter.
	public void mouseReleased(MouseEvent e)
	{
		
	}
	 //Function to determine where the mouse is pointing
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	 //There is nothing that needs to be done in the menu tick() method
	public void tick()
	{
		
	}
	
	//Draw the various buttons depending on what game state we are in
	public void render(Graphics g)
	{
		if(Game.gameState == STATE.Menu)
		{
			Font fnt = new Font("aerial", 1, 50);
			Font fnt2 = new Font("aerial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Particle Game Thing", 73, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 282, 193);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 282, 293);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 282, 393);	
		}
		else if(Game.gameState == STATE.Help)
		{
			Font fnt = new Font("aerial", 1, 50);
			Font fnt2 = new Font("aerial", 1, 30);
			Font fnt3 = new Font("aerial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 243, 70);
			
			g.setFont(fnt3);
			g.drawString("Use WASD to move player and dodge enemies", 105, 210);
			g.drawRect(210, 350, 200, 64);
			g.setFont(fnt2);
			g.drawString("Back", 282, 393);
		}
		else if(Game.gameState == STATE.End)
		{
			Font fnt = new Font("aerial", 1, 50);
			Font fnt2 = new Font("aerial", 1, 30);
			Font fnt3 = new Font("aerial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 177, 70);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getScore(), 173, 210);
			g.drawRect(210, 350, 200, 64);
			g.setFont(fnt2);
			g.drawString("Try Again", 243, 393);
		}
		else if(Game.gameState == STATE.Win)
		{
			Font fnt = new Font("aerial", 1, 50);
			Font fnt2 = new Font("aerial", 1, 30);
			Font fnt3 = new Font("aerial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Congratulations", 120, 70);
			
			g.setFont(fnt3);
			g.drawString("You Won with a score of: " + hud.getScore(), 173, 210);
			g.drawRect(210, 350, 200, 64);
			g.setFont(fnt2);
			g.drawString("Main Menu", 243, 393);
		}
		if(Game.gameState == STATE.Select)
		{
			Font fnt = new Font("aerial", 1, 50);
			Font fnt2 = new Font("aerial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select Difficulty", 127, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 263, 193);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 282, 293);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 279, 393);	
		}
	}
	
}

