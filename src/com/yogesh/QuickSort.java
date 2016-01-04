package com.yogesh;

import java.util.ArrayList;

/*
 * Quick Sort
 */
public class QuickSort {
	static public void qsort(ArrayList<Integer> a, int low, int high) {
		int i = low;
		int j = high;
		int pivot = a.get(low + (high - low) / 2);
		while (i <= j) {
			while (a.get(i) < pivot) {
				i++;
			}

			while (a.get(j) > pivot) {
				j--;
			}

			if (i <= j) {
				int t = a.get(i);
				a.set(i, a.get(j));
				a.set(j, t);
				i++;
				j--;
			}
		}

		if (low < j) {
			qsort(a, low, j);
		}
		if (i < high) {
			qsort(a, i, high);
		}
	}

	static public ArrayList<Integer> wave(ArrayList<Integer> a) {

		if (a == null || a.size() == 0) {
			return a;
		}

		qsort(a, 0, a.size() - 1);
	/*	for (int i = 0; i < a.size() - 1; i = i + 2) {
			int temp = a.get(i);
			a.set(i, a.get(i + 1));
			a.set(i + 1, temp);
		}*/
		return a;
	}
}
