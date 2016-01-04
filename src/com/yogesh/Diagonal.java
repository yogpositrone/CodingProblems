package com.yogesh;

import java.util.ArrayList;

/*
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 * Input: 	

		1 2 3
		4 5 6
		7 8 9
		
		Return the following :
		
		[ 
		  [1],
		  [2, 4],
		  [3, 5, 7],
		  [6, 8],
		  [9]
		]

 */
public class Diagonal {
	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i = 0 ;i < a.size()  ; i++){
			if(i == 0){
				ArrayList<Integer> first = new ArrayList<Integer>();
				
				for(int j = 0 ; j < a.size() ; j++){
					int p = i ;
					int q = j;
					first.add(a.get(p).get(q));
					while(p < a.size() && q-1 >= 0){
						p = p + 1;
						q = q - 1;
						first.add(a.get(p).get(q));
					}
						res.add(first);
						first = new ArrayList<Integer>();
					
				}
			}else{
				
				ArrayList<Integer> second = new ArrayList<Integer>();
					int p = i;
					int q = a.size() - 1;
					second.add(a.get(p).get(q));
					while(p < a.size() && q-1 >= i){
						p = p + 1;
						q = q - 1;
						second.add(a.get(p).get(q));
					}
						res.add(second);
						second = new ArrayList<Integer>();
					
			}
			
			
		}
		return res;
		
	}
}
