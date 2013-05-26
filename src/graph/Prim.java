package graph;

import java.util.Arrays;

public class Prim {
	int[][] edge;
	int[][] dist;

	int prim(int v) {
		int MAX = Integer.MAX_VALUE;
		int[] distance = new int[v];// �X�^�[�g����̋����łȂ��A���ݑI������Ă��钸�_����̍ŒZ
		boolean[] checked = new boolean[v];
		Arrays.fill(distance, MAX);
		distance[0] = 0;
		int now = 0;
		int total = 0;
		for (int i = 0; i < v; i++) {
			checked[now] = true;
			for (int j = 0; j < edge[now].length; j++) {
				int next = edge[now][j];
				distance[next] = Math.min(distance[next], dist[now][next]);
			}

			int nowd = MAX;
			for (int j = 0; j < v; j++) {
				if (nowd > distance[j] && !checked[j]) {
					nowd = distance[j];
					now = j;
				}
			}
			if (nowd == MAX) {
				return -1;
			} else {
				total += nowd;
			}
		}
		return total;
	}
}
