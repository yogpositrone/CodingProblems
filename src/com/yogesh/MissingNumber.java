package com.yogesh;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
 * 
 * Find missing number in array
 */

public class MissingNumber {
	
	public static void main(String[] args) {
		int[] numbers = {0,1,2,3,1};
		int length = numbers.length;
	    int sum1 = 0;
	    for(int i = 0; i < length; ++i) {
	        if(numbers[i] < 0 || numbers[i] > length - 2)
	            throw new IllegalArgumentException("Invalid numbers.");
	        sum1 += numbers[i];
	        
	    }
	    int sum2 = ((length - 1) * (length - 2)) >> 1;
	    System.out.println( sum1 - sum2);
	    
	    
	    AccessController.doPrivileged(new PrivilegedAction<Object>() {
	    	public Object run(){
	    		final String lib = "awt";
	    		System.loadLibrary(lib);
	    		return null;
	    	}
		});
	    
	    System.out.println(System.getProperty("java.home"));
	    Integer a = 82944;
	    
	    ArrayList<Integer> factors = new ArrayList<Integer>();
	    for(int i = 1 ; i <= (int) Math.sqrt(a) ; i++){
	        if( a % i == 0){
	            factors.add(i);
	        }
	    }

	    Collections.reverse(factors);

	    Iterator<Integer> nos = factors.iterator();
	    
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    while(nos.hasNext()){
	    	Integer fact = nos.next();
	    	Integer x = a/fact;
	    	if(x.intValue() != fact.intValue()){
	    		temp.add(x);
	    	}
	    	
	    }
	    
	    Collections.reverse(factors);
	    factors.addAll(temp);
	    System.out.println(factors);
	    
	    
	 
	}
	
	
	
	

}
