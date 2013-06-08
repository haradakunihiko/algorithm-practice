package graph.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * pcc102
 * 
 * @author Harada
 * 
 */
public class Roadblocks {

	int N = 4;
	int R = 4;
	List<List<Edge>> list = new ArrayList<List<Edge>>();

	public static void main(String[] args) {
		System.out.println(new Roadblocks().solve());
	}

	int solve() {
		// “ñ”Ô–Ú‚Í‚Ç‚¤‚·‚éH
		 list.add(new ArrayList<Edge>());
		 list.get(0).add(new Edge(100, 1));
		 list.add(new ArrayList<Roadblocks.Edge>());
		 list.get(1).add(new Edge(200, 3));
		 list.get(1).add(new Edge(250, 2));
		 list.add(new ArrayList<Roadblocks.Edge>());
		 list.get(2).add(new Edge(100, 3));
		 list.get(2).add(new Edge(250, 1));
		 list.add(new ArrayList<Roadblocks.Edge>());
		 list.get(3).add(new Edge(200, 1));
		 list.get(3).add(new Edge(100, 2));
//		list.add(new ArrayList<Edge>());
//		list.get(0).add(new Edge(2, 1));
//		list.get(0).add(new Edge(5, 2));
//		list.add(new ArrayList<Roadblocks.Edge>());
//		list.get(1).add(new Edge(4, 2));
//		list.get(1).add(new Edge(6, 3));
//		list.get(1).add(new Edge(10, 4));
//		list.add(new ArrayList<Roadblocks.Edge>());
//		list.get(2).add(new Edge(5, 0));
//		list.get(2).add(new Edge(4, 1));
//		list.get(2).add(new Edge(2, 3));
//		list.add(new ArrayList<Roadblocks.Edge>());
//		list.get(3).add(new Edge(6, 1));
//		list.get(3).add(new Edge(2, 2));
//		list.get(3).add(new Edge(1, 5));
//		list.add(new ArrayList<Roadblocks.Edge>());
//		list.get(4).add(new Edge(10, 1));
//		list.get(4).add(new Edge(3, 5));
//		list.get(4).add(new Edge(5, 6));
//		list.add(new ArrayList<Roadblocks.Edge>());
//		list.get(5).add(new Edge(1, 3));
//		list.get(5).add(new Edge(3, 4));
//		list.get(5).add(new Edge(9, 5));
//		list.add(new ArrayList<Roadblocks.Edge>());
//		list.get(6).add(new Edge(5, 4));
//		list.get(6).add(new Edge(9, 5));

		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(0, 0));

		int[] dp = new int[list.size()];
		int[] dp2 = new int[list.size()];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		Arrays.fill(dp2, Integer.MAX_VALUE / 2);

		dp[0] = 0;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			List<Edge> nextRoutes = list.get(edge.to);
			for (Edge nextRoute : nextRoutes) {
				int estimateCost = dp[edge.to] + nextRoute.cost;
				int secondCost = 0;
				if (estimateCost < dp[nextRoute.to]) {
					dp[nextRoute.to] = estimateCost;
					queue.add(new Edge(estimateCost, nextRoute.to));
					secondCost = dp[nextRoute.to];
				} else {
					secondCost = estimateCost;
				}

				if (dp2[nextRoute.to] > secondCost && dp[nextRoute.to] < secondCost) {
					dp2[nextRoute.to] = secondCost;
					queue.add(new Edge(secondCost, nextRoute.to));
				}
			}
		}
		return dp2[3];
	}

	private class Edge implements Comparable<Edge> {
		Edge(int cost, int to) {
			this.cost = cost;
			this.to = to;
		}

		int cost;
		int to;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "cost:" + cost + ",to:" + to;
		}

		@Override
		public int compareTo(Edge o) {
			if (cost < o.cost) {
				return -1;
			} else if (cost == o.cost) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
