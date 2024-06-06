//import for Scanner and other utility classes
import java.util.*;

class MaximumBorders {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        //Number of TestCases
        int testCases = s.nextInt();

        //Iterate for Each Test Case
        for (int i=0; i<testCases; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int blackCells = 0;
            s.nextLine();

            // Iterate for Each Row
            for (int j=0; j<n; j++) {
                int rowBlackCells = 0;
                String row = s.nextLine();

                //Iterate each Char at a Row
                for(int k=0; k<row.length(); k++) {
                    char c = row.charAt(k);
                    if (c == '#') {
                        rowBlackCells++;
                    }
                }

                blackCells = (blackCells < rowBlackCells)? rowBlackCells: blackCells;
            }
            
            System.out.println(blackCells);
        }        
    }
}