package dp;

public class Knapsack {
	int[] w = { 2, 1, 3, 2 };
	int[] v = { 3, 2, 4, 2 };
	int limit = 5;
	int n = 4;
	int result = 7;

	public static void main(String[] args) {
		System.out.println(new Knapsack().rec(0, 0));
		System.out.println(new Knapsack().recMemo(0, 0));
		System.out.println(new Knapsack().binary());
		System.out.println(new Knapsack().dynamic());
		System.out.println(new Knapsack().dynamic2());
	}

	int rec(int i, int weight) {
		int result;
		if (i == n) {
			result = 0;
		} else if (limit - weight < w[i]) {
			result = rec(i + 1, weight);
		} else {
			result = Math.max(rec(i + 1, weight), rec(i + 1, weight + w[i])
					+ v[i]);
		}
		return result;
	}

	int[][] memo = new int[n][limit];

	int recMemo(int i, int weight) {
		if (memo[i][weight] > 0) {
			return memo[i][weight];
		}
		int result;
		if (i == n) {
			result = 0;
		} else if (limit - weight < w[i]) {
			result = rec(i + 1, weight);
		} else {
			result = Math.max(rec(i + 1, weight), rec(i + 1, weight + w[i])
					+ v[i]);
		}
		return memo[i][weight] = result;
	}

	int binary() {
		// 入れるケースをbinaryで保持。2番目と4番目を入れている場合は、1001となる。
		// intの場合32、longで64このおもりまで計測可能
		int[] dpw = new int[1 << w.length];
		int[] dpv = new int[1 << v.length];

		for (int i = 0; i < w.length; i++) {// O(n)
			// おもりの数だけ実行
			for (int j = 0; j < 1 << i; j++) {// O(2^n)
				// 前回までに検討したおもりの組み合わせと、今回入れる場合を検討
				if (dpw[j] + w[i] <= limit) {
					// 入れる事ができる場合のみ更新
					dpv[j + (1 << i)] = dpv[j] + v[i];
					dpw[j + (1 << i)] = dpw[j] + w[i];
				}
				// 入れない場合は、前回と同じbinaryとなるので更新の必要は無い。
			}
		}
		int res = 0;
		for (int i = 0; i < dpv.length; i++) {
			// 一番大きいものを取得
			res = Math.max(res, dpv[i]);
		}
		return res;
	}

	// intの場合32、longの場合64このおもりまで計測かのう。
	// また、おもりの重さはそれぞれ2^32、2^64まで。
	int[][] dp = new int[n + 1][limit + 1];
	int dynamic() {
		for (int i = 0; i < n; i++) {//O(n)
			for (int weight = 0; weight <= limit; weight++) {// O(limit)
				// i番目でweightの重さのときの最大価値をdp[i+1][weight]に
				if (weight < w[i]) {
					// weightではi番目を入れる事が不可能
					dp[i + 1][weight] = dp[i][weight];
				} else {
					// w[i]を入れていないケースと入れるケースの大きい方を指定。
					// 1.入れていない場合は、一つ前の同じ重さのときと同価値。
					// 2.入れている場合は、一つ前の、w[i]を引いたときに、v[i]を足したもの
					dp[i + 1][weight] = Math.max(dp[i][weight], dp[i][weight
							- w[i]]
							+ v[i]);
				}
			}
		}
		return dp[n][limit];
	}

	int dynamic2() {
		for (int i = 0; i < n; i++) {
			for (int weight = 0; weight <= limit; weight++) {
				// i番目を検討するとき、knapsackの重さがweightである。、
				// i番目でxの重さのときの価値をdp[i+1][x]に
				if (limit - weight >= w[i]) {
					// i番目のおもりを入れる事が出来る場合。入れる前の価値に、v[i]を加える
					dp[i + 1][weight + w[i]] = Math.max(
							dp[i + 1][weight + w[i]], dp[i][weight] + v[i]);
				}
				// i番目のおもりを入れない場合は、入れる前と同じになる。
				dp[i + 1][weight] = Math.max(dp[i + 1][weight], dp[i][weight]);
			}
		}
		return dp[n][limit];
	}
}
