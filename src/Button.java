import java.awt.*;
import javax.swing.*;
public class Button extends JButton {
	private static final long serialVersionUID = 4630602608293459831L;
	public int x,y;
	Button(int i,int j)
	{
		super();
		x = i;
		y = j;
	}
}
class BackGround
{
	static Color[] simple = {Color.MAGENTA,Color.BLUE,Color.CYAN,Color.GREEN,Color.YELLOW,Color.ORANGE,Color.RED,Color.PINK};
	static Color setBackGround(int i)
	{
		return simple[i];
	}
}