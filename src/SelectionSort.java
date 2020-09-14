
public class SelectionSort {
	public int[] sort(int arr[]) {
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

}