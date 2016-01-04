package com.yogesh;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Rotate array by k positions
 */
public class RotateArrayByK {
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (B >= A.size()) {
			B = B % A.size();
		}
		for (int i = 0; i < A.size(); i++) {
			ret.add(A.get((i + B) % A.size()));
		}
		return ret;
	}

	// DO NOT MODIFY THE LIST

	public static void main(String args[]) {
		ArrayList<Integer> t = new ArrayList<Integer>();
		Integer[] A = { 14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35 };
		ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(A));
		t = rotateArray(r, 56);
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.print(t.get(i)+ " " );
		}

	}
}
