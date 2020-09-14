import java.util.Random;
import java.util.Scanner;

public class SortingMain {
	private static Timer timer;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean cont = true; 
		int arrayLength = 0;
		while (cont) {
			System.out.println("Enter an integer");
			String arrLength = reader.nextLine();
			try {
				arrayLength = Integer.parseInt(arrLength);
				cont = false;
			}catch (NumberFormatException e) {
				System.out.println("Not a number");
			}
		}
		timer = new Timer();
		System.out.println("Intialize a Random Array");
		int[] arr = randomArray(arrayLength);
		printArray(arr);
		SortingAlgorithms sorter = new SortingAlgorithms(); // initialize sorting class methods
		System.out.println("");
		
		timer.startTime();
		// Use Selection Sort
		System.out.println("Selection Sort");
		int[] selectionSorted = sorter.SelectionSort(arr);
		printArray(selectionSorted);
		System.out.println("Time Complexity: O(n ** 2)");
		timer.restart();
		
		// Use Bubble Sort
		System.out.println("Bubble Sort");
		int[] bubbleSorted = sorter.BubbleSort(arr);
		printArray(bubbleSorted);
		System.out.println("Time Complexity: \nWorst:  O(n ** 2) \nBest: O(n)");
		timer.restart();
		
		// Use Insertion Sort
		System.out.println("Insertion Sort");
		int[] insertionSorted = sorter.InsertionSort(arr);
		printArray(insertionSorted);
		System.out.println("Time Complexity: O(n ** 2)");
		timer.restart();
		
		// Use Merge Sort
		System.out.println("Merge Sort");
		int[] mergeSorted = sorter.MergeSort(arr);
		printArray(mergeSorted);
		System.out.println("Time Complexity: O(n log(n)");
		timer.restart();
		
		// Use Quick Sort
		System.out.println("Quick Sort");
		int[] quickSorted = sorter.QuickSort(arr, 0, arr.length -1);
		printArray(quickSorted);
		System.out.println("Time Complexity: O(n ** 2)");
		timer.restart();
		
		// Use Heap Sort
		System.out.println("Heap Sort");
		int[] heapSorted = sorter.HeapSort(arr);
		printArray(heapSorted);
		System.out.println("Time Complexity: O(n log(n))");
		timer.restart();
		
		// Use PigeonHole Sort
		System.out.println("Pigeon Hole Sort");
		int[] piegonHoleSorted = sorter.pigeonholeSort(arr);
		printArray(piegonHoleSorted);
		System.out.println("Time Complexity: O(n + 2 ** k )");
		timer.restart();
		
	}
	
	public static int[] randomArray(int length) {
		Random rand = new Random();
		int[] arr = new int[length];
		  	for (int i = 0; i < arr.length; i++) {
		  		arr[i] = rand.nextInt(10000); 
		  	}
	    return arr;
	}
	
	public static void printArray(int arr[]) {
		for (int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println(arr[arr.length - 1]);
		
	}
	
}


