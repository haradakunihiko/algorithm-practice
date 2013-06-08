package programingcontestchallengebook.binarysearch;

import java.util.Arrays;

public class Pcc129_cable_master {

	int k = 11;
	double[] l = { 8.02, 7, 43, 4, 57, 5, 39 };

	void solve() {
		Arrays.sort(l);
		double lb = l[l.length - 1] / k;
		double ub = 0;
		for (double d : l) {
			ub += d;
		}
		ub /= k;

		int limit = 0;
		while (ub - lb >= 0.001 && limit <= 100) {
			double mid = (ub + lb) / 2;
			if (canCut(mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
			limit++;
		}
	}

	boolean canCut(double size) {
		int res = 0;
		for (int i = 0; i < l.length; i++) {
			res += l[i] / size;
		}
		return res >= k;
	}
}
