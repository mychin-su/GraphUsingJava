package Setting__Graph;

import java.util.HashSet;
import java.util.Set;

public class Find_the_shortest_path_Using_Distra {

	public static void main(String[] args) {
		int n = 5;
		int a[][] = { { 0, 6, 0, 1, 0 }, { 6, 0, 5, 2, 2 }, { 0, 5, 0, 0, 5 }, { 1, 2, 0, 0, 1 }, { 0, 2, 5, 1, 0 } };
		Set<Integer> visited = new HashSet<Integer>();
		int[] distance = new int[n]; // distance[i] = khoang cach tu dinh dau cho den i
		int[] prev = new int[n]; // previouse[i]: la dinh ngay phia truoc cua i

		int start = 0;
		int finish = 2;
		int oo = Integer.MAX_VALUE;

		// Bước 1: Khời tạo khoảng cách
		for (int i = 0; i < n; i++) {
			distance[i] = oo;
		}
		
		distance[start] = 0;
		while (visited.size() < n) {
			// Buoc 2: chon dinh chua duyet
			// va dang co khoang cach nho nhat(tu dinh xuat phat) lam dinh dang xet.
			int dangXet = 0;
			int minDist = oo;
			for (int i = 0; i < n; i++) {
				if (visited.contains(i) == false && distance[i] < minDist) {
					minDist = distance[i];
					dangXet = i;
				}
			}

			// Buoc3: Tu dinh dang xet, duyet cac Dinh Ke chua duyet:
			// update khoang cach va dinh truoc cua dinh do.

			for (int i = 0; i < n; i++) {
				if (visited.contains(i) == false && a[dangXet][i] != 0) {
					int newDistance = distance[dangXet] + a[dangXet][i];
					if (newDistance < distance[i]) {
						distance[i] = newDistance;
						prev[i] = dangXet;
					}
				}
			}
			// Buoc4: Danh dau dinh dang xet thanh dinh da duyet
			visited.add(dangXet);
		}
		System.out.println("Khoang cach nho nhat tu  " + start + " den " + finish + ": " + distance[finish]);
		System.out.println("Duong di la: ");
		int chay = finish;
		while (chay != start) {
			System.out.print(chay + "<- ");
			chay = prev[chay];
		}
		System.out.println(chay);

	}
}
