package com.game.main;

//import java.util.Random;

//Class to handle enemy spawning for each level

public class Spawn 
{
	private Handler handler;
	private HUD hud;
	private Game game;
	private int scoreKeep = 0;
	//private Random r = new Random();
	
	public Spawn(Game game, Handler handler, HUD hud)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick()
	{
		scoreKeep++;
		//Level design: needs work
		if(scoreKeep >= 250)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(game.diff == 0) //Normal difficulty
			{
				if(hud.getLevel() == 2)
				{
					handler.addObject(new BasicEnemy(50, Game.HEIGHT/2 - 32, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 100, Game.HEIGHT/2 - 32, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 4)
				{
					handler.addObject(new BasicEnemy(100, 100, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 100, 100, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 6)
				{
					handler.addObject(new BasicEnemy(100, Game.HEIGHT - 100, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 100, Game.HEIGHT - 100, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 8)
				{
					handler.addObject(new FastEnemy(100, Game.HEIGHT/2 - 32, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 100, Game.HEIGHT/2 - 32, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 10)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
				}
				else if(hud.getLevel() == 12)
				{
					handler.clearEnemys();
					handler.addObject(new BasicEnemy(50, Game.HEIGHT - 100, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 100, Game.HEIGHT - 100, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(50, 100, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 100, 100, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 14)
				{
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 20)
				{
					handler.addObject(new FastEnemy(100, Game.HEIGHT/2 - 32, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 100, Game.HEIGHT/2 - 32, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 22)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new FastEnemy(Game.WIDTH/2 - 48, Game.HEIGHT/2 - 32, ID.FastEnemy, true, handler));
				}
			}
			
			else if(game.diff == 1) //Hard Difficulty
			{
				if(hud.getLevel() == 2)
				{
					handler.addObject(new HardEnemy(100, Game.HEIGHT/2 - 32, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 100, Game.HEIGHT/2 - 32, ID.HardEnemy, handler));
				}
				else if(hud.getLevel() == 4)
				{
					handler.addObject(new HardEnemy(50, 100, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 100, 100, ID.HardEnemy, handler));
					handler.addObject(new BasicEnemy(50, Game.HEIGHT - 100, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 100, Game.HEIGHT - 100, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 6)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 100, Game.HEIGHT/2 - 32, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 8)
				{
					handler.addObject(new SmartEnemy(Game.WIDTH/2, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 10)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
				}
				else if(hud.getLevel() == 14)
				{
					
				}
				else if(hud.getLevel() == 16)
				{
					
				}
				else if(hud.getLevel() == 18)
				{
					
				}
				else if(hud.getLevel() == 20)
				{
					
				}
				else if(hud.getLevel() == 22)
				{
					
				}
				else if(hud.getLevel() == 24)
				{
					
				}
			}
		}
	}
}
