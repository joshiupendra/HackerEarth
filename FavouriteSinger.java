import java.util.*;


class FavouriteSinger {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        long N = s.nextLong();
        HashMap<Long, Integer> smap = new HashMap<>();
        int max = 0;

        //Insert all Key=Singer value=Instances in Map
        for(int i=0; i<N; i++) {
            long a = s.nextLong();
            if(smap.containsKey(a)) {
                smap.put(a, smap.get(a)+1);
                max = (max < smap.get(a))? smap.get(a) : max;
            } else {
                smap.put(a, 1);
            }
        }

        //Count Number of Favourite Singer
        int favouriteSinger = 0;
        for (Map.Entry<Long, Integer> set: smap.entrySet()) {
            if(set.getValue() >= max) {
                favouriteSinger++;
            }
        }
        System.out.println(favouriteSinger);
    }
}