package com.yogesh;

import java.util.ArrayList;
import java.util.Arrays;

public class StockPurchaser {

	
	public static void main(String args[]){
			
		
		ArrayList<Integer> nos = new ArrayList<Integer>(Arrays.asList(4,5,1,2,3,6,7,3));
		
		int min = 0;
		int max = 0;
		int buy = 0;
		int sell = 0;
		int maxProfit = 0;
		
		for(int i = 0 ;i < nos.size() ; i++)
		{
			if(nos.get(min) > nos.get(i)){
				min = i;
			}
			if(nos.get(max) < nos.get(i)){
				max = i;
				if(nos.get(max) - nos.get(min) > maxProfit){
					maxProfit = nos.get(max) - nos.get(min);
					buy = min;
					sell = max;
				}
			}
			
		}
		System.out.println("Buy Day : "+ buy +"\nSell Day : "+ sell + "\nProfit : "+ maxProfit);
		
	}
}
