import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements  Runnable,MouseListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int HEIGHT= 480;

	static final int WIDTH = 640;
	
	public static int contador = 100;
	
	public static int pontuacao = 0;
	
	public static int mx, my;
	
	public static boolean clicado = false;
	
	public Spawner spawner;
	
	public boolean GameOver = false;



	public Game () {
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
		
		spawner = new Spawner();
	}
	
	
		
	public void update () {
		if (GameOver == false) {
		
			
			spawner.update();
			if (contador <= 0) {
				//Game Over
			contador = 100;
			GameOver = true;
			}
		}
		
	}
	
	public void render () {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(GameOver == false) {
		
		/*
		 * 
		 
		g.setColor(Color.white);
		
		g.setFont(new Font("Arial",Font.BOLD,23));
		
		g.drawString("Pontos:" + contador, WIDTH/2 -60, 30);
		*/
		
		g.setColor(Color.green);
		g.fillRect(Game.WIDTH/2 - 100 - 70,20, contador*3, 20);
		g.setColor(Color.white);
		g.drawRect(Game.WIDTH/2 - 100 - 70,20, 300, 20);
		
		spawner.render(g);
			
	}else {
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("Game Over!", WIDTH/2 - 100, HEIGHT/2 - 100);
		g.drawString("Seus Pontos finais foram:" + this.pontuacao, WIDTH/2 - 200, HEIGHT/2 + 80 - 100);
		}	
		
		bs.show();
	}
	
	
	public static void main(String[] args ) {
		Game Game = new Game ();
		JFrame jframe = new JFrame ("Meu Jogo");
		jframe.add(Game);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.setVisible(true);
		
		new Thread(Game).start();
		
	}
	
	
	
	
	@Override
	public void run() {
		
		
		while (true) {
			update();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				
			e.printStackTrace();
	 	}
		}	
	 			
      }



	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		clicado = true;
		mx = e.getX();
		my = e.getY();
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
   	