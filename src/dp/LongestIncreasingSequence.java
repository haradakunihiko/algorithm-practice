package dp;

import java.util.Arrays;

public class LongestIncreasingSequence {
	int n = 5;
	int[] a = { 4, 2, 3, 1, 5 };

	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSequence().dynamic());
	}

	int dynamic() {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
