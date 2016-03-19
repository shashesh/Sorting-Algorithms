package org.sort;

public class Sort {
		
	public static void bubbleSort(int[] a) {
		boolean swapped = true;
		int temp, j = 0;
		while(swapped) {
			j++;
			swapped = false;
			for(int i=0; i<a.length - j; i++) {
				if(a[i] > a[i+1]) {
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	public static void insertionSort(int[] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=i; j>0; j--) {
				if(a[j] < a[j-1]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}
	
	public static void mergeSort(int[] a) {
		int n = a.length;
		
		if(n<2) {
			return;
		}
		
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		
		for(int i=0; i<mid; i++) {
			left[i] = a[i];
		}
		for(int j=mid; j<n; j++) {
			right[j-mid] = a[j];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
		
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int i=0;
		int j=0;
		int k=0;
		
		while(i<left.length && j < right.length) {
			if(left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<left.length) {
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] a) {	
		if(a == null || a.length == 0) {
			return;
		}
		quickSort(a, 0, a.length-1 );		
	}

	private static void quickSort(int[] a, int lowerIndex, int higherIndex) {
		int i= lowerIndex;
		int j = higherIndex;
		
		int pivot = a[lowerIndex + (higherIndex-lowerIndex) / 2];
		
		while(i<=j) {
			while(a[i] < pivot) {
				i++;
			}
			
			while(a[j] > pivot) {
				j--;
			}
			
			if(i<=j) {
				swap(a, i,j);
				i++; 
				j--;
			}
		}
		if(lowerIndex < j) {
			quickSort(a, lowerIndex, j);
		}
		
		if(i< higherIndex) {
			quickSort(a, i, higherIndex);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
	}
}
