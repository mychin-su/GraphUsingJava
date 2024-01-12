package Setting__Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SettingBFSUsingQueue {
	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0 } };
		// Khai báo
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> daDuyet = new HashSet<>();
		daDuyet.add(0); // đỉnh 0
		// Khởi tạo
		queue.add(0); // thêm đỉnh 0 vào trong stack

		// Duyệt theo Stack
		while (queue.isEmpty() == false) { // Nếu có phần tử trong stack thì vòng while sẽ duyệt qua
			int u = queue.remove();

			// process u
			System.out.print(u + " ");

			// Add tất cả các đỉnh kề v vơi u mà chưa được duyệt vào stack
			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] == 1 && daDuyet.contains(v) == false) {
					queue.add(v);
					// Đánh dấu đã duyệt qua
					daDuyet.add(v);
				}
			}
		}

	}

}
