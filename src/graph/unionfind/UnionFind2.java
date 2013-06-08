package graph.unionfind;

public class UnionFind2 {
	int parent[];
	int rank[];

	UnionFind2() {
	}

	void init(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py) {
			return;
		}
		if (rank[px] < rank[py]) {
			parent[px] = py;
		} else {
			parent[py] = px;
			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}

	boolean same(int x, int y) {
		return find(x) == find(y);
	}
}
