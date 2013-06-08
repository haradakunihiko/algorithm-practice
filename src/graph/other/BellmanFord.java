package graph.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * pcc95
 * 
 * @author Harada
 * 
 */
public class BellmanFord {

	int max = 10;

	List<Edge> edgeList = new ArrayList<Edge>(max);
	int[] d = new int[max];

	void shortestPath(int s) {
		d[s] = 0;
		Arrays.fill(d, Integer.MAX_VALUE);
		while (true) {
			boolean update = false;
			for (Edge edge : edgeList) {
				if (d[edge.from] != Integer.MAX_VALUE) {
					d[edge.to] = Math.min(d[edge.to], d[edge.from] + edge.cost);
					update = true;
				}
			}
			if (!update) {
				break;
			}
		}
	}

	private class Edge {
		int from;
		int to;
		int cost;
	}
}
