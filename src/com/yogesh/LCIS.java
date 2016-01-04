package com.yogesh;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Longest continuous subsequence
 */
public class LCIS {
	
	public static void main(String args[]){
		//ArrayList<Integer> nos = new ArrayList<Integer> (Arrays.asList(9,12,14,1,3,4,3,4,5,6,7,8,9,1));
		ArrayList<Integer> nos = new ArrayList<Integer> (Arrays.asList(0,1,3,4,-1,-2,4,5,6,7,8,9,0,1,2,3,7,8,9,10,11));
		int maxLCIS = 0;
		int start = 0;
		int end = 0;
		int currentLCIS = 0;
		int currentStart = 0;
		for(int i = 1 ; i < nos.size() ; i++){
			
			if(nos.get(i-1) < nos.get(i)){
				currentLCIS++;
			}else{
				currentLCIS = 0;
				currentStart = i;
			}
			
			if(maxLCIS < currentLCIS){
				start = currentStart;
				maxLCIS = currentLCIS;
				end = i;
			}
			
		}
		
		System.out.println("Start Index : "+ start + "\nEnd Index : "+ end + "\nLength : "+ maxLCIS);
	}

}
