package com.yogesh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Given a collection of intervals, merge all overlapping intervals.

	For example:
	
	Given [1,3],[2,6],[8,10],[15,18],
	
	return [1,6],[8,10],[15,18].
	
	Make sure the returned intervals are sorted.
 */
public class IntervalMerge {
	static public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }


private static boolean inBetween(int start, int end, int value){
	if(value >= start && value <= end){
		return true;
	}
	return false;
}

public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	 Collections.sort(intervals, new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start > o2.start){
				return 1;
			}else if(o1.start < o2.start){
				return -1;
			}
			return 0;
		}
		 
	});
	 for(int i = 0 ; i < intervals.size() - 1; i++){
			 if(inBetween(intervals.get(i).start, intervals.get(i).end, intervals.get(i+1).start)  && inBetween(intervals.get(i).start, intervals.get(i).end, intervals.get(i+1).end) ){
				 intervals.remove(i+1);
				 i--;
			 }else if(inBetween(intervals.get(i).start, intervals.get(i).end, intervals.get(i+1).start)){
				 if(intervals.get(i+1).end >= intervals.get(i).end ){
					 intervals.get(i).end = intervals.get(i+1).end;
					 intervals.remove(i+1);
					 i--;
				 }else{
					 intervals.remove(i+1);
					 i--;
			 }
		 }
		 
	 }
	 
	 return intervals;
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

}
