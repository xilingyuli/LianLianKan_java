import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 5989701762764552461L;
	private int n=8,m=8;
	public int[][] key;
	private JButton[] level;
	public Button[][] buttons;
	private JPanel panel,choose,game;
	public Frame()
	{
		choose = new JPanel(new FlowLayout());
		setLevel();
		game = new JPanel();
		panel = new JPanel(new BorderLayout());
		panel.add(choose,BorderLayout.NORTH);
		panel.add(game,BorderLayout.CENTER);
		add(panel);
		pack();
		setTitle("Á¬Á¬¿´");
		setResizable(false);
	}
	private void setLevel()
	{
		level = new JButton[3];
		level[0] = new JButton("Easy");
		level[1] = new JButton("Simple");
		level[2] = new JButton("Hard");

		choose.add(level[0]);
		choose.add(level[1]);
		choose.add(level[2]);
		
		level[0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				n = 8;
				m = 8;
				setGame();
			}
		});
		level[1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				n = 12;
				m = 12;
				setGame();
			}
		});
		level[2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				n = 16;
				m = 16;
				setGame();
			}
		});
	}
	private void setGame()
	{
		key = new int[n][m];
		setKey();
		Select select = new Select();
		game.removeAll();
		game.setLayout(new GridLayout(n,m));
		buttons = new Button[n][m];
		for(int i=0;i<n;i++)
	    {
	    	for(int j=0;j<m;j++)
	    	{
	           buttons[i][j] = new Button(i,j);
	           buttons[i][j].setBackground(BackGround.setBackGround(key[i][j]-1));
	           game.add(buttons[i][j]);
	           buttons[i][j].addActionListener(select);
	       }
	    }
		setSize(32*n,32*m+choose.getHeight());
		game.updateUI();
	}
	void setKey()
	{
		for(int i=0;i<n;i++)
	        for(int j=0;j<m;j++)
	            key[i][j] = 0;
		Random rand = new Random();
		for(int l=0;l<n*m/8;l++)
	    {
	        for(int k=1;k<=8;)
	        {
	            int i = rand.nextInt(n);
	            int j = rand.nextInt(m);
	            if(key[i][j]==0)
	            {
	                key[i][j] = k;
	                k++;
	            }
	        }
	    }
	}
	class Select implements ActionListener
	{
		int x1,y1,x2,y2,f;
		Select()
		{
			f = 0;
		}
		public synchronized void actionPerformed(ActionEvent e)
		{
			Button b = (Button)e.getSource();
			if(f==0)
			{
				x1 = b.x;
				y1 = b.y;
				f = 1;
				buttons[x1][y1].setEnabled(false);
			}
			else
			{
				x2 = b.x;
				y2 = b.y;
				f = 0;
				if(isMatch())
				{
					buttons[x1][y1].setVisible(false);
					buttons[x2][y2].setEnabled(false);
					buttons[x2][y2].setVisible(false);
					key[x1][y1] = 0;
					key[x2][y2] = 0;
				}
				else
				{
					buttons[x1][y1].setEnabled(true);
				}
			}
		}
		boolean isMatch()
		{
			judge j = new judge(x1,y1,x2,y2,n,m,key);
			return j.Judge();
		}
	}

}

