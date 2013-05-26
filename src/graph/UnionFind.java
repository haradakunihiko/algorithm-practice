package graph;

public class UnionFind {
	int[] parent;// ���̏ꍇ�A���̃O���[�v�̗v�f���i���j������B�q�̏ꍇ�A�e�̔ԍ�������B

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
