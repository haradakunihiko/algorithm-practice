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
		// �����P�[�X��binary�ŕێ��B2�Ԗڂ�4�Ԗڂ����Ă���ꍇ�́A1001�ƂȂ�B
		// int�̏ꍇ32�Along��64���̂�����܂Ōv���\
		int[] dpw = new int[1 << w.length];
		int[] dpv = new int[1 << v.length];

		for (int i = 0; i < w.length; i++) {// O(n)
			// ������̐��������s
			for (int j = 0; j < 1 << i; j++) {// O(2^n)
				// �O��܂łɌ�������������̑g�ݍ��킹�ƁA��������ꍇ������
				if (dpw[j] + w[i] <= limit) {
					// ����鎖���ł���ꍇ�̂ݍX�V
					dpv[j + (1 << i)] = dpv[j] + v[i];
					dpw[j + (1 << i)] = dpw[j] + w[i];
				}
				// ����Ȃ��ꍇ�́A�O��Ɠ���binary�ƂȂ�̂ōX�V�̕K�v�͖����B
			}
		}
		int res = 0;
		for (int i = 0; i < dpv.length; i++) {
			// ��ԑ傫�����̂��擾
			res = Math.max(res, dpv[i]);
		}
		return res;
	}

	// int�̏ꍇ32�Along�̏ꍇ64���̂�����܂Ōv�����̂��B
	// �܂��A������̏d���͂��ꂼ��2^32�A2^64�܂ŁB
	int[][] dp = new int[n + 1][limit + 1];
	int dynamic() {
		for (int i = 0; i < n; i++) {//O(n)
			for (int weight = 0; weight <= limit; weight++) {// O(limit)
				// i�Ԗڂ�weight�̏d���̂Ƃ��̍ő剿�l��dp[i+1][weight]��
				if (weight < w[i]) {
					// weight�ł�i�Ԗڂ����鎖���s�\
					dp[i + 1][weight] = dp[i][weight];
				} else {
					// w[i]�����Ă��Ȃ��P�[�X�Ɠ����P�[�X�̑傫�������w��B
					// 1.����Ă��Ȃ��ꍇ�́A��O�̓����d���̂Ƃ��Ɠ����l�B
					// 2.����Ă���ꍇ�́A��O�́Aw[i]���������Ƃ��ɁAv[i]�𑫂�������
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
				// i�Ԗڂ���������Ƃ��Aknapsack�̏d����weight�ł���B�A
				// i�Ԗڂ�x�̏d���̂Ƃ��̉��l��dp[i+1][x]��
				if (limit - weight >= w[i]) {
					// i�Ԗڂ̂���������鎖���o����ꍇ�B�����O�̉��l�ɁAv[i]��������
					dp[i + 1][weight + w[i]] = Math.max(
							dp[i + 1][weight + w[i]], dp[i][weight] + v[i]);
				}
				// i�Ԗڂ̂���������Ȃ��ꍇ�́A�����O�Ɠ����ɂȂ�B
				dp[i + 1][weight] = Math.max(dp[i + 1][weight], dp[i][weight]);
			}
		}
		return dp[n][limit];
	}
}
