package org.sort;

public class Main {

	public static void main(String[] args) {
		int[] nums = {1, 13, 43, 4, 54, 86, 15, 24};
		Sort.bubbleSort(nums);
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
