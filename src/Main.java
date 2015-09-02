import java.awt.*;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				Frame a = new Frame();
				a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				a.setVisible(true);
			}
		});

	}

}
