package com.yogesh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	/*public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(B >= A.size()) {
		    B = B % A.size();
		}
		for (int i = 0; i < A.size(); i++) {
			ret.add(A.get((i + B) % A.size()));
		}
		return ret;
	}*/
	
	
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
	// DO NOT MODIFY THE LIST
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
	
	public static ArrayList<Integer> flip(String A) {

		int maxDiff = 0;
		int flipStartIndex = 0;
		int flipEndIndex = 0;
		@SuppressWarnings("unused")
		int totalNumberOfOnes = 0;
		int totalNumberOfZeros = 0;

		int currentDiff = 0;
		int currentStart = 0;
		@SuppressWarnings("unused")
		int currentOnesToFlip = 0;

		for (int i = 0; i < A.length(); i++) {
			if ((int) A.charAt(i) - 48 == 0) {
				currentDiff -= 1;
				totalNumberOfZeros++;
			} else {
				currentDiff += 1;
				currentOnesToFlip++;
				totalNumberOfOnes++;
			}
			if (currentDiff < maxDiff) {
				maxDiff = currentDiff;
				flipStartIndex = currentStart;
				flipEndIndex = i;
			} else if (currentDiff > 0) {
				currentDiff = 0;
				currentStart = i + 1;
				currentOnesToFlip = 0;
			}
		}

		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(totalNumberOfZeros == 0){
			return ret;
		}
			ret.add(flipStartIndex+1);
			ret.add(flipEndIndex+1);

		return ret;
	}


		static public ArrayList<Integer> wave(ArrayList<Integer> a){
			
			if(a == null || a.size() == 0){
				return a;
			}
			
			qsort(a, 0, a.size()-1);
			for(int i = 0 ; i < a.size() - 1 ; i=i+2){
				int temp = a.get(i);
				a.set(i, a.get(i+1));
				a.set(i+1, temp);
		}
		return a;
		}
	
	
		
		static public void qsort(ArrayList<Integer> a, int low, int high){
				int i = low;
				int j = high;
				int pivot = a.get(low + (high - low) /2);
				while(i <=j){
					while( a.get(i) < pivot){
						i++;
					}
					
					while(a.get(j) > pivot ){
						j--;
					}
					
					if(i <=j){
						int t = a.get(i);
						a.set(i, a.get(j));
						a.set(j,  t);
						i++;
						j--;
					}
				}
				
				if(low < j){
					qsort(a, low, j);
				}
				if(i < high){
					qsort(a, i, high);
				}
		}
		
		static public class Interval {
			      int start;
			      int end;
			      Interval() { start = 0; end = 0; }
			      Interval(int s, int e) { start = s; end = e; }
			  }
		 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
			 
			 
			 if(intervals.isEmpty()){
				 intervals.add(newInterval);
				 return intervals;
			 }
			 //find out the intervals in which new interval lies
			 
			 int startIntervalIndex = -1;
			 int endIntervalIndex = -1;
			 
			 for(int i = 0 ; i < intervals.size() ; i++){
				 
				 if(intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start){
					 startIntervalIndex = i;
				 }
				 
				 if(intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end){
					 endIntervalIndex = i;
				 }
				 
				
			 }
			 
			 
			 if(startIntervalIndex == -1 && endIntervalIndex == -1){
				 if(intervals.get(0).start > newInterval.start){
					 for(int i = 0; i < intervals.size() ; i++){
						 Interval temp = intervals.get(i);
						 intervals.set(i, newInterval);
						 newInterval = temp;
					 }
					 intervals.add(newInterval);
				 }else{
					 intervals.add(newInterval);
				 }
				 return intervals;
			 }
			 if(startIntervalIndex > -1 && endIntervalIndex == -1){
				 intervals.get(startIntervalIndex).end = newInterval.end;
				 return intervals;
			 }
			 if(startIntervalIndex == -1 && endIntervalIndex > -1){
				 intervals.get(endIntervalIndex).start = newInterval.start;
				 return intervals;
			 }
			 
			 ArrayList<Integer> removeList = new ArrayList<Integer>();
			 if(startIntervalIndex != endIntervalIndex){
				 if(newInterval.end < intervals.get(endIntervalIndex).end){
					 intervals.get(startIntervalIndex).end = intervals.get(endIntervalIndex).end;
				 }else{
					 intervals.get(startIntervalIndex).end = newInterval.end;
				 }
				 for(int i = startIntervalIndex + 1; i <= endIntervalIndex  ; i++){
					 removeList.add(i);
				 }	
				 
				 for(int i = 0 ; i < removeList.size() ; i++){
					 int index = removeList.get(i) - i;
					 intervals.remove(index);
				 }
			 }
			 
			 
			 
			 
			 return intervals;
		    }
		 
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
	public static void main(String args[]){
		/*ArrayList<Integer> t = new ArrayList<Integer>();
		
		
		Integer[] A = {14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35 };
		ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(A));
		t = rotateArray(r, 56);*/
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(3,4));
		//ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(7,8,9));
		
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		r.add(one);
		r.add(two);
		//r.add(three);
		generateMatrix(3);
		//spiralOrder(r);
		//diagonal(r);
		//flip("010");
		/*for(int i = 0; i < t.size() ; i++){
			System.out.println(t.get(i)+ " ");
		}*/
		
//		Integer[] A = {5, 1, 3, 2, 4 };
//		ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(A));
//		ArrayList<Integer> res = wave(r);
//		System.out.println(res);
		
		/*Interval i1 = new Interval(31935139, 38366404);
		Interval i2 = new Interval(54099301, 76986474);
		Interval i3 = new Interval(87248431, 94675146);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		//intervals.add(i4);
		//intervals.add(i5);
		
		Interval newInterval = new Interval(43262807, 68844111);
		ArrayList<Interval> res = insert(intervals, newInterval);
		System.out.println();
		for(int i = 0 ; i < res.size() ; i++){
			System.out.print("["+ res.get(i).start + "," + res.get(i).end + "] ");
		}*/
		
		String[] arr = {"one", "two", "three", "four", "five", "six"};
		int i = 0;
		for(String str : arr){
			if(str.length() == 3){
				arr[i] = arr[i].toUpperCase();
			}
			i++;
		}
		
		for(String str : arr){
			System.out.println(str);
		}
		
	}
	}
