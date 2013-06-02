package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * pcc73
 * 
 * @author Harada
 * 
 */
public class Expedition {

	int N = 4;
	int L = 25;
	int P = 10;
	int[] A = { 10, 14, 20, 21 };
	int[] B = { 10, 5, 2, 4 };

	public static void main(String[] args) {
		System.out.println(new Expedition().solve());
	}

	int solve() {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(N,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});
		int before = 0;
		int present = P;
		int cnt = 0;
		while (present < L) {
			for (int i = 0; i < B.length; i++) {
				if (A[i] <= present && A[i] > before) {
					queue.add(B[i]);
				}
			}

			if (queue.isEmpty()) {
				cnt = -1;
				break;
			}
			Integer gas = queue.poll();
			before = present;
			present += gas.intValue();
			cnt++;
		}
		return cnt;
	}
}
