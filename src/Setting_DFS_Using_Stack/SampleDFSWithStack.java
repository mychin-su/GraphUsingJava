package Setting_DFS_Using_Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SampleDFSWithStack {
	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0 } };
		// Khai báo
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> daDuyet = new HashSet<>();
		daDuyet.add(0); // đỉnh 0
		// Khởi tạo
		stack.add(0); // thêm đỉnh 0 vào trong stack

		// Duyệt theo Stack
		while (stack.isEmpty() == false) { // Nếu có phần tử trong stack thì vòng while sẽ duyệt qua
			int u = stack.pop();
			// process u
			System.out.print(u + " ");

			// Add tất cả các đỉnh kề v vơi u mà chưa được duyệt vào stack
			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] == 1 && daDuyet.contains(v) == false) {
					stack.add(v);
					// Đánh dấu đã duyệt qua
					daDuyet.add(v);
				}
			}
		}

	}
}
