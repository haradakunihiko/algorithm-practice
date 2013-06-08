package graph.other;

import java.util.Arrays;

public class Dijkstra {

	int[][] edge;
	int[][] dist;

	int dijkstra(int from, int to, int v) {
		int MAX = (int) 1e9;
		int[] distance = new int[v];
		boolean[] check = new boolean[v];

		Arrays.fill(distance, MAX);
		distance[from] = 0;

		for (int i = 0; i < v; i++) {
			int now = 0;
			int nowd = MAX;
			for (int j = 0; j < v; j++) {
				if (nowd > distance[j] && !check[j]) {
					nowd = distance[j];
					now = j;
				}
			}
			if (nowd == MAX) {
				break;
			}
			check[now] = true;
			for (int j = 0; j < edge[now].length; j++) {
				int next = edge[now][j];
				distance[next] = Math.min(distance[next], distance[now]
						+ dist[now][next]);
				// �ύX����ۂɁAnext��previous��now�Ƃ������������Ă����΁A�ǂ̌o�H��ʂ��������肷�鎖���\�B
			}

		}
		return distance[to];
	}
}
