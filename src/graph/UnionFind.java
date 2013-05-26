package graph;

public class UnionFind {
	int[] parent;// 根の場合、そのグループの要素数（負）が入る。子の場合、親の番号が入る。

	public UnionFind(int size) {
		parent = new int[size];
	}

	int root(int x) {
		if (parent[x] < 0) {
			return x;
		} else {
			return parent[x] = root(parent[x]);
		}
	}

	boolean union(int x, int y) {
		int rootX = root(x);
		int rootY = root(y);
		if (rootX == rootY) {
			return false;
		}
		if (parent[rootX] > parent[rootY]) {
			rootX ^= rootY;
			rootY ^= rootX;
			rootX ^= rootY;
		}
		parent[rootX] += parent[rootY];
		parent[rootY] = rootX;

		return true;
	}

	boolean find(int x, int y) {
		return root(x) == root(y);
	}

	int size(int x) {
		return parent[root(x)];
	}
}
