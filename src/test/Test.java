package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		System.out.println("Test App");
		//int[] array = new int[] {1,2,3,0,4,3,0};
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(0);
		list.add(3);
		list.add(0);
		
		int zcount = (int) list.stream().filter(item -> item == 0).count();
		List<Integer> nlist = list.stream().filter((item) -> item != 0).collect(Collectors.toList());
		List<Integer> zlist = list.stream().filter(item -> item == 0).collect(Collectors.toList());
		System.out.println(nlist);
		System.out.println(zlist);
		zlist.addAll(nlist);
		System.out.println(zlist);
		for (int i=0; i<zcount; i++) {
			nlist.add(0, 0);
		}
		System.out.println(nlist);
		
	}

}
