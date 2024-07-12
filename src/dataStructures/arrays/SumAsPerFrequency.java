package dataStructures.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SumAsPerFrequency {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		scanner.nextLine();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			int num = scanner.nextInt();
			
			if (map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		
		scanner.nextLine();
		int testCases = scanner.nextInt();
		
		map = sortByValue(map);
		
		while (testCases > 0) {
			scanner.nextLine();
			
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int sum = 0;
			
			if (l > N || r < l) {
				continue;
			}
			
			if (l == r && l < N && !map.containsValue(map)) {
				System.out.println(sum);
				continue;
			}
			
			for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
				int value = entry.getValue();
				
				if (value > r) {
					break;
				}
				
				if (value >= l && value <= r) {
					sum += (entry.getKey() * value);
				}
			}
			
			System.out.println(sum);
			
			testCases--;
		}
	}
	
	// function to sort hashmap by values
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, 
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap 
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
