package me.maddin.game.Utility;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import me.maddin.game.main.MainClass;

public class FileManager {

	public static File jarfile;
	
	public static void load() {
		try {
			jarfile = new File(MainClass.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			// 
			e.printStackTrace();
		}
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
}
