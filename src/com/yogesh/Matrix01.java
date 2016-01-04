package com.yogesh;

import java.util.ArrayList;

/*
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

	Do it in place.
	
	Example
	
	Given array A as
	
	1 0 1
	1 1 1 
	1 1 1
	On returning, the array A should be :
	
	0 0 0
	1 0 1
	1 0 1
	Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 */
public class Matrix01 {
	public static void  setZeroes(ArrayList<ArrayList<Integer>> a) {
		
		int [] position = new int[a.size() + a.get(0).size()];
		
		for(int i = 0; i < a.size(); i++){
			for(int j = 0 ; j < a.get(0).size(); j++){
				if(a.get(i).get(j) == 0){
					position[i] = 1;
				}
			}
		}
		
		for(int i = 0; i < a.get(0).size(); i++){
			for(int j = 0 ; j < a.size(); j++){
				if(a.get(j).get(i) == 0){
					position[a.size() + i] = 1;
				}
			}
		}
		
		for(int i = 0; i < a.size() ; i++){
			if(position[i] == 1){
				for(int j = 0 ; j < a.get(0).size() ;j++){
						a.get(i).set(j, 0);
				}
			}
		}
		
		int col = 0;
		for(int j = a.size(); j < position.length ; j++){
			
			if(position[j] == 1){
				for(int i = 0 ; i < a.size() ;i++){
						a.get(i).set(col, 0);
				}
			}
			col++;
		}
		
		for(int i = 0 ; i < a.size() ; i++){
			System.out.print("[");
			for(int j = 0; j < a.get(0).size(); j++){
				
				if(j != a.get(0).size() - 1){
					System.out.print(a.get(i).get(j) + ",");
				}else{
					System.out.print(a.get(i).get(j));
				}
			}
			System.out.print("]");
		}
	}

}
