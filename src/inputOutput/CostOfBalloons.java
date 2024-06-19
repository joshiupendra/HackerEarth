package inputOutput;
//import for Scanner and other utility classes
import java.util.*;

class CostOfBalloons {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();
        s.nextLine();
        while (testCases > 0) {
            int gBalloonCost = s.nextInt();
            int pBalloonCost = s.nextInt();
            s.nextLine();
            int participants = s.nextInt();
            
            int firstCost = 0;
            int secondCost = 0;
            for (int i=0; i<participants; i++) {
                s.nextLine();
                int fProblem = s.nextInt();
                int sProblem = s.nextInt();
                
                // First Problem = Green Balloon, Second Problem = Purple Balloon
                if (fProblem > 0) {
                    firstCost += gBalloonCost;
                }
                if (sProblem > 0) {
                    firstCost += pBalloonCost;
                }

                // First Problem = Purple Balloon, Second Problem = Green Balloon
                if (fProblem > 0) {
                    secondCost += pBalloonCost;
                }
                if (sProblem > 0) {
                    secondCost += gBalloonCost;
                }
            }
            int finalCost = (firstCost > secondCost)? secondCost : firstCost;

            System.out.println(finalCost);
            testCases--;
        }
    }
}