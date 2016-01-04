package com.yogesh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * REPEATARR :
 * 
	 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less then O(n) space and traversing the stream sequentially O(1) times.
	
	Sample Input:
	
	[3 4 1 4 1]
	Sample Output:
	
	1
	If there are multiple possible answers ( like in the sample case above ), output any one.
 */

public class NumberRepeat {
	
	public static int firstMissingPositive(ArrayList<Integer> a) {
		//Note that ( N being the size of the array ), A[i]<=0 and A[i]>N are not the numbers you are looking for because the missing positive integer will be in the range [1, N+1].

//The answer will be N+1 only if all of the elements of the array are exact one occurrence of [1, N].
		
		 /* int n = A.size() + 1;
		    int count;
		    int idx = 0;
		    int size = A.size();
		    count = size - 1;
		    
		    for (idx = size - 1; idx >= 0; idx--) {
		        
		        int num = A.get(idx);
		        
		        if (num < 0) {
		            int val = A.get(count);
		            A.set(idx, val);
		            A.set(count, num);
		            count--;
		        }
		        
		    }
		    
		    for (idx = 0; idx <= count; idx++) {
		        
		        int num = A.get(idx);
		        
	            num = Math.abs(num);
		        
		        if (num > 0 && num < n) {
		            
		            int index = num - 1;
		            int val = A.get(index);
		            A.set(index, -val);
		            
		        }
		        
		    }
		    
		    for (idx = 0; idx <= count; idx++) {
		        
		        int num = A.get(idx);
		        
		        if (num > 0) {
		            return idx + 1;
		        }
		        
		    }
		    
		    return idx + 1;*/
		return -1;
	}
	
	public int repeatedNumber(final List<Integer> a) {
		HashSet<Integer> nos = new HashSet<Integer>(a.size() - 1);
		
		for(int i = 0 ;i < a.size() ; i++){
			if(nos.contains(a.get(i))){
				return a.get(i);
			}else{
				nos.add(a.get(i));
			}
		}
		
		
		return -1;
	}
	
public static ArrayList<Integer> repeatedNumber1(final List<Integer> a) {
		
		java.math.BigInteger sum = (java.math.BigInteger.valueOf((long) (a.size()) * ((long) a.size() + 1)/2));
		java.math.BigInteger  sumSquare = java.math.BigInteger.valueOf((long)(a.size()) * (long) (a.size()+ 1) * (long)(2* a.size() + 1)/6);
		java.math.BigInteger actualSum = java.math.BigInteger.valueOf(0);
		java.math.BigInteger actualSumSquare = java.math.BigInteger.valueOf(0);
		for(int i = 0 ;i < a.size() ; i++){
			actualSum = actualSum.add(java.math.BigInteger.valueOf(a.get(i)));
			actualSumSquare = actualSumSquare.add(java.math.BigInteger.valueOf((long)(a.get(i) * (long)a.get(i))));
		}
		java.math.BigInteger t = (sumSquare.subtract(actualSumSquare)).divide((sum.subtract(actualSum)));
		java.math.BigInteger missing = (t.add(sum).subtract(actualSum)).divide(java.math.BigInteger.valueOf(2));
		java.math.BigInteger duplicate = missing.subtract(sum).add(actualSum);
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		result.add(duplicate.intValue());
		result.add((int)missing.intValue());
		System.out.println(missing);
		System.out.println(duplicate);
		return null;
	}
}
