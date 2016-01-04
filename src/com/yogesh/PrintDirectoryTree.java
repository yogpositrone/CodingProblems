package com.yogesh;

import java.io.File;
import java.util.ArrayList;

/*
 * Whole directory structure
 */
public class PrintDirectoryTree {

	
	static void printTree(File f){
		
		String[] node = f.list();
		ArrayList<File>  dirs = new ArrayList<File>();
		for(String filename : node){
			System.out.println(filename);
			File dir = new File(f, filename);
			if(dir.isDirectory()){
				dirs.add(dir);
			}
		}
		
		for(File dir : dirs){
			System.out.println();
			printTree(dir);
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		printTree(new File("/Users/yogeshbagul/Documents/Eular"));
	}
}
