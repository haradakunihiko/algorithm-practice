package memo;

public class Fib {
	int fib_(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib_(n - 1) + fib_(n - 2);
		}
	}

	int memo[];

	int fib(int n) {
		if (n <= 1) {
			return n;
		} else if (memo[n] > 0) {
			return memo[n];
		} else {
			return memo[n] = fib(n - 1) + fib(n - 2);
		}
	}
}
