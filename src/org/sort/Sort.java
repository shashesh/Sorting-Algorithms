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
		int start = 0;
		int end = a.length-1;
		
		quicksort(a, start, end);
		
	}

	private static void quicksort(int[] a, int start, int end) {
		
		if(start<end) {	
			int pIndex = Partition(a, start, end);
			System.out.println();
			System.out.println("Pindex: " + pIndex);
			quicksort(a, start, pIndex-1);
			System.out.println();
			System.out.println("Pindex2: " + pIndex);
			quicksort(a, pIndex+1, end);
			System.out.println();
			System.out.println("Pindex3: " + pIndex + " End: " + end);
		}
	}

	private static int Partition(int[] a, int start, int end) {
		int pivot = a[end];
		System.out.println();
		System.out.println(pivot);
		int pIndex = start;
		
		for(int i=0; i<end; i++){
			if(a[i] <= pivot) {
				int temp = a[pIndex];
				a[pIndex] = a[i];
				a[i] = temp;
				pIndex++;
			}
		}
		int temp = a[end];
		a[end] = a[pIndex];
		a[pIndex] = temp;
		for(int i=0; i<a.length; i++) {
		System.out.print(a[i]+ " "); 
		}
		return pIndex;
	}
}
