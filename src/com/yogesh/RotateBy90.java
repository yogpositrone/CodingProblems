package com.yogesh;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Matrix rotation by 90 degree.
 * Transpose and change cols
 */
public class RotateBy90 {
	
	
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		

		int n = a.size();
		if(n == 1){
			System.out.println("["+a.get(0).get(0)+"]");
			return;
		}
		for(int i = 0; i < n ; i++){
			for(int j = i ; j < n ; j++){
				int t = a.get(i).get(j);
				a.get(i).set(j, a.get(j).get(i));
				a.get(j).set(i, t);
			}
		}
		
		//change columns
		for(int i = 0 ; i < n/2 ; i++){
			for(int j = 0 ; j < n  ; j++){
				int t = a.get(j).get(i);
				a.get(j).set(i, a.get(j).get(n-1-i));
				a.get(j).set(n-1-i, t);
			}
		}
			
	
		for(int i = 0 ;i < n ; i++){
			System.out.print(" [" );
			for(int j = 0 ; j < n ; j++){
				System.out.print(a.get(i).get(j)+" ");
			}
			System.out.print("]");
		}
		
		 
		
		 
		
	}
	
	public static void main(String args[]){
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(3,4));
		//ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(9,10,11,12));
		//ArrayList<Integer> four = new ArrayList<Integer>(Arrays.asList(13,14,15,16));
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		r.add(one);
		r.add(two);
		//r.add(three);
		//r.add(four);
		
		rotate(r);
	}

}
