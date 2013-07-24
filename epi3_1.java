public class epi3_1 {
	public static int[] arr = {1,3,2};//{4,9,0,1,4,5,3,1,0,4};
	public static void swap(int idx1, int idx2) {
		int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;	
	}
	public static void main(String[] args) {
		final int pivotIdx = 2;
		final int pivot = arr[pivotIdx];
		int smallerIdx = -1;
		int equalIdx = -1;
		int biggerIdx = -1;
		int unreadIdx = 0;
		for (int x : arr) {
			if (arr[unreadIdx] < pivot) {
				// add a smaller
				if (smallerIdx < 0)
					smallerIdx = 0;
				if (equalIdx >= 0) {
					swap(equalIdx, unreadIdx);
					++equalIdx;
				}
				++unreadIdx;
					
			} else if (arr[unreadIdx] > pivot) {
				// add a bigger
				if (biggerIdx < 0) {
					biggerIdx = arr.length-1;
					swap(unreadIdx, biggerIdx);
				} else {
					swap(unreadIdx, biggerIdx-1);
					--biggerIdx;
				}
			} else { // arr[unreadIdx] == pivot
				// add an equal
				if (equalIdx < 0)
					equalIdx = unreadIdx;
				++unreadIdx;		
			}
		}
		for (int x : arr)
			System.out.println(x);
	}
}
