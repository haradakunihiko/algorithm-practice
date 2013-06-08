package math;

import java.util.HashMap;
import java.util.Map;

public class Basic {

	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return n != 1;
	}

	public Map<Integer, Integer> primeFactor(int n) {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		for (int i = 2; i * i <= n; i++) {
			int cnt = 0;
			while (n % i == 0) {
				cnt++;
				n /= i;
			}
			if (cnt > 0) {
				res.put(Integer.valueOf(i), Integer.valueOf(cnt));
			}
		}
		return res;
	}

	/**
	 * O(n)
	 */
	public int pow(int a, int n) {
		int res = 1;
		for (int i = 0; i < n; i++) {
			res *= n;
		}
		return res;
	}

	/**
	 * O(logn)
	 */
	public int pow2(int a, int n) {
		int res = 1;
		while (n > 0) {
			if ((n & 1) == 1) {
				res *= a;
			}
			a *= a;
		}
		return res;
	}
}
