package com.game.main;

import com.game.main.Game.STATE;

import java.util.Random;

//Class to handle enemy spawning for each level

public class Spawn 
{
	private Handler handler;
	private HUD hud;
	private Game game;
	private int scoreKeep = 0;
	private Random r = new Random();
	
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
					handler.addObject(new BasicEnemy(50, Game.HEIGHT/2 - 32, 3,  ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 4,  ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 4)
				{
					handler.addObject(new BasicEnemy(50, 50, 3, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 70, 50, 4,  ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 6)
				{
					handler.addObject(new BasicEnemy(50, Game.HEIGHT - 100, 1, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 8)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 3, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 4, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 10)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
				}
				else if(hud.getLevel() == 12)
				{
					handler.clearEnemys();
					handler.addObject(new BasicEnemy(50, Game.HEIGHT - 100, 1, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(50, 50, 3, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 70, 50, 4, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 14)
				{
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 20)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 1, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 2, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 22)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new FastEnemy(Game.WIDTH/2 - 48, Game.HEIGHT/2 - 32, 1, ID.FastEnemy, true, handler));
				}
				else if(hud.getLevel() == 26)
				{
					handler.clearEnemys();
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 1, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 2, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 30)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 3, ID.FastEnemy, true, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 4, ID.FastEnemy, true, handler));
				}
				else if(hud.getLevel() == 32)
				{
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 34)
				{
					handler.addObject(new SmartEnemy(Game.WIDTH/2 - 48, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 36)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 40)
				{
					handler.clearEnemys();
					handler.addObject(new HardEnemy(50, 50, 3, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, 50, 4, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(50, Game.HEIGHT - 100, 1, ID.BasicEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 42)
				{
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 46)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 1, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 2, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 50)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new SmartEnemy(50, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 55)
				{
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
				}
				else if(hud.getLevel() == 57)
				{
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 61) //Game is won
				{
					Game.gameState = STATE.Win;
					handler.clearEnemys();
					for(int i = 0; i < 20; i++)
						handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
				}
			}
			
			else if(game.diff == 1) //Hard Difficulty
			{
				if(hud.getLevel() == 2)
				{
					handler.addObject(new HardEnemy(50, Game.HEIGHT/2 - 32, 1, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 2, ID.HardEnemy, handler));
				}
				else if(hud.getLevel() == 4)
				{
					handler.addObject(new HardEnemy(50, 50, 3, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, 50, 4, ID.HardEnemy, handler));
					handler.addObject(new BasicEnemy(50, Game.HEIGHT - 100, 1, ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 6)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 3, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 4, ID.FastEnemy, false, handler));
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
				else if(hud.getLevel() == 12)
				{
					handler.clearEnemys();
					handler.addObject(new HardEnemy(50, 50, 3, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, 100, 4, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(50, Game.HEIGHT - 100, 1, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.HardEnemy, handler));
				}
				else if(hud.getLevel() == 14)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 1, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 2, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 16)
				{
					handler.addObject(new FastEnemy(50, Game.HEIGHT/2 - 32, 3, ID.FastEnemy, true, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 4, ID.FastEnemy, true, handler));
				}
				else if(hud.getLevel() == 20)
				{
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 22)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new SmartEnemy(50, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 26)
				{
					handler.clearEnemys();
					handler.addObject(new SmartEnemy(50, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 30)
				{
					handler.addObject(new FastEnemy(50, 50, 3, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, 100, 4, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(50, Game.HEIGHT - 100, 1, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 34)
				{
					handler.addObject(new HardEnemy(50, Game.HEIGHT/2 - 32, 1, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, 2, ID.HardEnemy, handler));
				}
				else if(hud.getLevel() == 36)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new HardEnemy(50, 50, 3, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, 100, 4, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(50, Game.HEIGHT - 100, 1, ID.BasicEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 40)
				{
					handler.clearEnemys();
					handler.addObject(new FastEnemy(50, 50, 3, ID.FastEnemy, true, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, 50, 4, ID.FastEnemy, true, handler));
					handler.addObject(new FastEnemy(50, Game.HEIGHT - 100, 1, ID.FastEnemy, true, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.FastEnemy, true, handler));
				}
				else if(hud.getLevel() == 42)
				{
					handler.addObject(new FastEnemy(50, 50, 3, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, 100, 4, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(50, Game.HEIGHT - 100, 1, ID.FastEnemy, false, handler));
					handler.addObject(new FastEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.FastEnemy, false, handler));
				}
				else if(hud.getLevel() == 48)
				{
					handler.addObject(new SmartEnemy(50, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 50)
				{
					handler.clearEnemys();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new SmartEnemy(50, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(Game.WIDTH - 70, Game.HEIGHT/2 - 32, ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 53)
				{
					handler.addObject(new HardEnemy(50, 50, 3, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, 100, 4, ID.HardEnemy, handler));
					handler.addObject(new HardEnemy(50, Game.HEIGHT - 100, 1, ID.BasicEnemy, handler));
					handler.addObject(new HardEnemy(Game.WIDTH - 70, Game.HEIGHT - 100, 2, ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 55)
				{
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, true, handler));
					handler.addObject(new OneDimensionalEnemy(ID.OneDEnemy, false, handler));
				}
				else if(hud.getLevel() == 61) //Game is won
				{
					Game.gameState = STATE.Win;
					handler.clearEnemys();
					for(int i = 0; i < 20; i++)
						handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
				}
			}
		}
	}
}

