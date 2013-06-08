package graph.other;

/**
 * pcc98
 * 
 * @author Harada
 * 
 */
public class WarshallFloyd {

	int d[][];

	void solve() {
		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
	}
}
