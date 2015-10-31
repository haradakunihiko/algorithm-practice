package test;

public class Exam {

	// O(n)
	public int reverse(int n) {
		int reversed = 0;

		while (n > 0) {
			reversed *= 10;
			reversed += n % 10;
			n /= 10;
		}
		return reversed;
	}

	// O(n)
	public int symmetory(int n) {
		return n == reverse(n) ? 1 : 0;
	}

	// O(nlog(n))
	public void sort(int[] base, int length) {
		quicksort(base, 0, length - 1);
	}

	private void quicksort(int[] base, int left, int right) {
		int index = partition(base, left, right);

		if (index-1 > left) {
			quicksort(base, left, index-1);
		}
		if (index < right) {
			quicksort(base, index, right);
		}
	}

	private int partition(int[] base, int left, int right) {
		int pivot = base[left];
		while (left <= right) {
			while (base[left] < pivot ) {
				left++;
			}
			while (pivot < base[right] ) {
				right--;
			}
			if (left <= right) {
				swap(base, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[] base, int one, int another) {
		int temp = base[one];
		base[one] = base[another];
		base[another] = temp;
	}
	
	
	//O(log(n))
	public int find(int n, int[] base, int length){
		return binarySearch(n, base, 0, length-1);
	}
	
	private int binarySearch(int n, int[]base,int left, int right){
		if(left == right && base[left] == n){
			return left;
		}else if(left >= right){
			return -1;
		}
		
		int midIndex = (left + right) / 2;
		
		if(base[midIndex]>=n){
			return binarySearch(n, base, left, midIndex);
		}else{
			return binarySearch(n, base, midIndex+1, right);
		}
		
	}
}
