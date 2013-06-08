package programingcontestchallengebook.binarysearch;

public class Pcc128_lower_bound {

	int n = 5;
	int[] a = { 2, 3, 3, 5, 6 };
	int k = 3;

	public void solve() {
		int lb = -1;
		int ub = a.length;
		while (ub - lb > 1) {
			int mid = (lb + ub) / 2;
			if (a[mid] <= k) {
				ub = mid;
			} else {
				lb = mid;
			}
		}
		System.out.println(ub);
	}
}
