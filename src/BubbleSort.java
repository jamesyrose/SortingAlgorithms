
public class BubbleSort {

	public int[] sort(int arr[]) {
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

}
