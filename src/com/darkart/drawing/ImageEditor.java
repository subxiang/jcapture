package com.darkart.drawing;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ImageEditor extends JFrame {
	private final BufferedImage screenImg;

	public ImageEditor(BufferedImage screenImg) {
		this.screenImg = screenImg;
		setJMenuBar(createMenuBar());
		add(new JButton(new ImageIcon(screenImg)));
	}

	private JMenuBar createMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('f');
		JMenuItem save = new JMenuItem(new SaveAction(screenImg));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		fileMenu.add(save);
		bar.add(fileMenu);
		
		return bar;
	}
}
