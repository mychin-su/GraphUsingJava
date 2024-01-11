package Setting_DFS_Using_Stack;

import java.util.HashSet;
import java.util.Set;

public class Setting_DFS_Using_Recursion {
	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0 } };

		Set<Integer> daDuyet = new HashSet<>();
		daDuyet.add(0); // đỉnh 0

		DFS(0, graph, daDuyet);
	}

	public static void DFS(int u, int[][] graph, Set<Integer> daDuyet) {
		// process u
		System.out.print(u + " ");

		for (int v = 0; v < graph.length; v++) {
			if (graph[u][v] == 1 && daDuyet.contains(v) == false) {
				daDuyet.add(v);
				DFS(v, graph, daDuyet);
			}
		}
	}
}
