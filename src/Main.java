import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.darkart.drawing.ImageEditor;


public class Main {

	/**
	 * @param args
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		final BufferedImage screenImg = robot.createScreenCapture(getArea());
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame editor = new ImageEditor(screenImg);
				editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				editor.pack();
				editor.setVisible(true);
			}
			
		});
	}

	private static Rectangle getArea() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Rectangle(screenSize);
	}

}
