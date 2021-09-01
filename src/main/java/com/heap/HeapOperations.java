package com.heap;

class HeapImpl {

	int size;//current size of heap
	int[] arr = new int[20];//max heap size is 20

	/*
	Steps to insert new value
	1. add new value at last in array
	2. find new value's parent using (index-1)/2 formula
	3. if parent is lesser than its children then swap
	4. keep doing this until parent is greater
	*/
	public void insertNewValue(int val) {
		arr[size] = val;
		int index = size;
		int parent = (index - 1) / 2;

		while (parent >= 0 && arr[parent] < arr[index]) {
			int t = arr[parent];
			arr[parent] = arr[index];
			arr[index] = t;

			t = parent;
			index = parent;
			parent = (t - 1) / 2;
		}

		size++;
	}

	public int getMax() {
		return arr[0];
	}

	/*
	Steps to delete max value
	1. swap max value with last value of array
	2. decrease the size of array
	3. start heapify from index 0
	4. return deleted max value
	*/
	public int removeMax() {
		int max = arr[0];
		arr[0] = arr[size - 1];
		size = size - 1;
		maxHeapify(0);
		return max;
	}

	/*
	Steps to max heapify
	1. Calculate index's children
	2. find which child has largest value than index
	3. if any child has largest value then swap largest with index
	4. heapify largest
	*/
	public void maxHeapify(int index) {
		int l, r;
		l = 2 * index + 1;
		r = 2 * index + 2;

		int largest = index;
		if (l < this.size && arr[l] > arr[largest]) {
			largest = l;
		}

		if (r < this.size && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != index) {
			int t = arr[largest];
			arr[largest] = arr[index];
			arr[index] = t;

			maxHeapify(largest);
		}
	}

	/*
	Steps to build max heap
	1. Complete binary tree's leaf node start from (n/2)-1
	2. leaf node will be already heapified so we can exclude them
	*/
	public void buildMaxHeap(int[] arr) {
		this.arr = arr;
		this.size = arr.length;

		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(i);
		}
	}
}


public class HeapOperations {

	public static void main(String[] args) {

		HeapImpl a = new HeapImpl();
		int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

		a.insertNewValue(arr[0]);
		a.insertNewValue(arr[1]);
		a.insertNewValue(arr[2]);

		System.out.println(a.getMax());

		a.insertNewValue(arr[3]);
		a.insertNewValue(arr[4]);
		System.out.println(a.getMax());

		a.insertNewValue(arr[5]);
		System.out.println(a.getMax());

		a.insertNewValue(arr[6]);
		a.insertNewValue(arr[7]);
		System.out.println(a.getMax());

		a.removeMax();
		System.out.println(a.getMax());

		a.buildMaxHeap(arr);

	}

}