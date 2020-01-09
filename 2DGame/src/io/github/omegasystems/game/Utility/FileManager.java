package me.maddin.game.Utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

public class FileManager {

	public static File jarfile;
	public static File ressourceFile;
	public static File entityRessourceFile;
	public static File tileRessourceFile;
	
	public static void init() {
		try {
			jarfile = new File(URLDecoder.decode(FileManager.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ressourceFile = new File(jarfile, "ressources");
		entityRessourceFile = new File(ressourceFile, "entities");
		tileRessourceFile = new File(ressourceFile, "tiles");
	}
	
	public static File getFile(String filename) {
		File file = new File(jarfile, filename);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public static File getFile(File parentFile, String filename) {
		File file = new File(parentFile, filename);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// +
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public static File createDirectory(String path) {
		File file = new File(jarfile, path);
		if(!file.isDirectory()) {
			file.mkdirs();
		}
		return file;
	}

	public static File createDirectory(File ressourceFile, String path) {
		File file = new File(ressourceFile, path);
		if(!file.isDirectory()) {
			file.mkdirs();
		}
		return file;
	}
	
	public static BufferedImage getImage(String path) {
		try {
			return ImageIO.read(new File(ressourceFile, path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	public static BufferedImage getImage(File parent, String path) {
		try {
			return ImageIO.read(new File(parent, path));
		} catch (IOException e) {
			System.out.println("Couldn't read file: "+path);
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
