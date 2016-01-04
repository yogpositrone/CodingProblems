package com.yogesh;

import java.util.ArrayList;


/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

	Example:
	
	Given n = 3,
	
	You should return the following matrix:
	 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 
 */
public class MatrixgenerationSpiralWay {
	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i = 0 ; i < a ; i++){
			ArrayList<Integer> t = new ArrayList<Integer>();
			for(int j = 0 ; j < a ; j++){
				t.add(j, 0);
			}
			res.add(i, t);
		}
		
		
		int top = 0;
		 int bottom = a - 1;
		 int left = 0;
		 int right = a - 1;
		 int no = 1;
		 while(top <= bottom && left <= right){
			 
			 for(int i =  left ; i <= right ; i++){
				if(top <= bottom){
					 //System.out.print(a.get(top).get(i) + " ");
					res.get(top).set(i, no++);
				}
				
			 }
			 top++;
			 for(int j = top ; j <= bottom; j++ ){
				 if(left <= right){
					 //System.out.print(a.get(j).get(right) + " ");
					 res.get(j).set(right, no++);
				 }
				
			 }
			 right--;
			 for(int k = right ; k >= left; k--){
				 if(top <= bottom){
					// System.out.print(a.get(bottom).get(k) + " ");	
					 res.get(bottom).set(k, no++);
				 }
				 
			 }
			 bottom--;
			 for(int l = bottom ; l >= top; l--){
				 if(left <= right){
					 //System.out.print(a.get(l).get(left) + " ");
					 res.get(l).set(left, no++);
				 }
				 
			 }
			 left++;
		 }
		 
		 return res;
			 
	}
}
