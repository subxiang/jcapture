package com.darkart.drawing;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveAction extends AbstractAction {
	private final BufferedImage screenImg;

	public SaveAction(BufferedImage screenImg) {
		this.screenImg = screenImg;
		putValue(Action.NAME, "Save");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("JPG files", "jpg"));
		int ret = fileChooser.showSaveDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write(screenImg, "JPG", fileChooser.getSelectedFile());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
