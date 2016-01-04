package com.yogesh;

import java.util.ArrayList;
import java.util.List;

/*
 * Spiral order matrix rotation 
 */
public class SpiralOrder {
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 int top = 0;
		 int bottom = a.size() - 1;
		 int left = 0;
		 int right = a.get(0).size() - 1;
		 
		 while(top <= bottom && left <= right){
			 
			 for(int i =  left ; i <= right ; i++){
				if(top <= bottom){
					 System.out.print(a.get(top).get(i) + " ");
				}
				
			 }
			 top++;
			 for(int j = top ; j <= bottom; j++ ){
				 if(left <= right){
					 System.out.print(a.get(j).get(right) + " ");
				 }
				
			 }
			 right--;
			 for(int k = right ; k >= left; k--){
				 if(top <= bottom){
					 System.out.print(a.get(bottom).get(k) + " ");	 
				 }
				 
			 }
			 bottom--;
			 for(int l = bottom ; l >= top; l--){
				 if(left <= right){
					 System.out.print(a.get(l).get(left) + " ");
				 }
				 
			 }
			 left++;
			 
			 
			 
			 
			 
			 
		 }
		 // Populate result;
		 return result;
	}
	
}
