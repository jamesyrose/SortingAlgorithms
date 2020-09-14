import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortingAlgorithms {

	public int[] SelectionSort(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			int minIdx = i; 
			for (int j=(i+1); j<arr.length; j++) {
				if (arr[minIdx] > arr[j]){
					minIdx = j;
				}				
			}
			int buff = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = buff;
		}
		return arr;	
	}

	public int[] BubbleSort(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<(arr.length-i-1); i++) {
				if (arr[j] > arr[j+1]) {
					int buff = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = buff;
				}
			}
		}
		return arr;
	}

	public int[] InsertionSort(int arr[]) {
		for (int i=1; i< arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j -= 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
	
	public int[] MergeSort(int arr[]) {
		int size = arr.length;
		if (size > 1) {
			int midPoint = Math.floorDiv(size, 2);
			int[] lowerHalf = new int[midPoint];
			int[] upperHalf = new int[size - lowerHalf.length];
			
			System.arraycopy(arr, 0, lowerHalf, 0, lowerHalf.length);
			System.arraycopy(arr, lowerHalf.length, upperHalf, 0, upperHalf.length);

			MergeSort(upperHalf);
			MergeSort(lowerHalf);
			
			int i = 0; 
			int j = 0; 
			int k = 0;
			
			while(i < lowerHalf.length  && j < upperHalf.length) {
				if (lowerHalf[i] < upperHalf[j]) {
					arr[k] = lowerHalf[i];
					i++;
				}else {
					arr[k] = upperHalf[j];
					j++;
				}
				k++;
			}
			
			while (i < lowerHalf.length) {
				arr[k] = lowerHalf[i];
				i++;
				k++;
			}
			
			while (j < upperHalf.length) {
				arr[k] = upperHalf[j];
				j++;
				k++;
			}
		}
		return arr;
	}

	public int[] QuickSort(int arr[], int lowIdx, int highIdx) {
		if (highIdx > lowIdx) {
			int pIdx = this.partition(arr, lowIdx, highIdx);
			this.QuickSort(arr, lowIdx, pIdx-1);
			this.QuickSort(arr, pIdx+1, highIdx);
		}
		return arr;
	}
	
	// used for Quick Sort
	private int partition(int arr[], int lowIdx, int highIdx) {
		int i = lowIdx - 1;
		int pivot = arr[highIdx];
		
		for (int j=lowIdx; j<highIdx; j++) {
			if (arr[j] < pivot) {
				i++;
				int buff = arr[i];
				arr[i] = arr[j];
				arr[j] = buff;
			}
		}
		return i + 1;
	}

	public int[] HeapSort(int arr[]) {
		int n = arr.length;
		
		for (int i=(Math.floorDiv(n, 2) - 1); i>0; i--) {
			heap(arr, n, i);
		}
		for (int i=(n-1); i>0; i--) {
			int buff = arr[i];
			arr[i] = arr[0];
			arr[0] = buff; 
			heap(arr, i, 0);
		}
		int temp = arr[arr.length-1];
		for (int i=arr.length - 1 ; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return arr;
	}
	
	// Used for Heap Sort
	private static void heap(int arr[], int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 1;
		
		if (left < n && arr[largest] < arr[left]) {
			largest = left;
		}
		
		if (right < n && arr[largest] < arr[right]) {
			largest = right;
		}
		
		if (largest != i) {
			int buff = arr[i];
			arr[i] = arr[largest];
			arr[largest] = buff;
			heap(arr, n, largest);
		}
	}

	public int[] pigeonholeSort(int arr[]) {
		int minVal = arr[0]; 
		int maxVal = arr[0];
		for (int val: arr) {
			if (val > maxVal) {
				maxVal = val;
			}
			if (val < minVal) {
				minVal = val;
 			}
		}

		
		int size = maxVal - minVal + 1; 
		int holes[] = new int[size];
		
		for (int val: arr) {
			holes[val - minVal]++; 
		}
		int i = 0; 
		for (int j=0; j<size; j++) {
			while (holes[j] > 0) {
				holes[j]--;
				arr[i] = j + minVal;
				i++;
			}
		}
		return arr;
	}

}
