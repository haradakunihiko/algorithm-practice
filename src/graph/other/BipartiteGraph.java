package graph.other;

/**
 * pcc93
 * 
 * @author Harada
 * 
 */
public class BipartiteGraph {
	int[][] graph;
	int[] color;

	boolean solve() {
		boolean ret = false;
		for (int i = 0; i < graph.length; i++) {
			if (color[i] == 0) {
				ret = ret && dfs(i, 1);
			}
		}
		return ret;
	}

	boolean dfs(int v, int c) {
		color[v] = c;
		int[] next = graph[v];
		for (int i = 0; i < next.length; i++) {
			if (next[i] > 0) {
				if (color[next[i]] == c) {
					return false;
				} else {
					if(color[next[i]] == 0){
						return dfs(next[i], -c);
					}
				}
			}
		}
		return true;
	}
}
