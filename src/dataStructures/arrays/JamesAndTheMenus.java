package dataStructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JamesAndTheMenus {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] menus = new int[n][m];
		
		HashMap<Integer, Integer> bestPrices = new HashMap<>();
		int k = 0;
		while (k < n) {
			s.nextLine();
			int[] menu = new int[m];
			for (int i=0; i<m; i++) {
				menu[i] = s.nextInt();
				if (bestPrices.containsKey(i) && bestPrices.get(i) < menu[i]) {
					bestPrices.put(i, menu[i]);
				}
				if (!bestPrices.containsKey(i)) {
					bestPrices.put(i, menu[i]);
				}
			}
			menus[k] = menu;
			k++;
		}
		List<Integer> bestMenu = new ArrayList<>();

		
		for (Map.Entry<Integer, Integer> entry: bestPrices.entrySet()) {
			int item = entry.getKey();
			int value = entry.getValue();
			System.out.println(item + " " + value);
			
			for (int i=0; i<n; i++) {
				if (menus[i][item] == value) {
					bestMenu.add(i);
				}
			}
			
		}
		
		for (int menu: bestMenu) {
			System.out.print(menu + " ");
		}
		
		
	}

}
