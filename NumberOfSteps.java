//import for Scanner and other utility classes
import java.util.*;

class NumberOfSteps {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n]; 
        s.nextLine();

        for (int i=0; i<n; i++) {
            a[i] = s.nextInt();
        }
        s.nextLine();

        for (int i=0; i<n; i++) {
            b[i] = s.nextInt();
        }

        //Find minimum in a[i]
        int min = a[0];
        for (int i=0; i<n; i++) {
            if(min > a[i]) {
                min = a[i] - b[i];
            }
        }

        //Calculate Number of Steps required to match all a[i]
        int result = 0;
        for (int i=0; i<n; i++) {
            while (a[i] > min && b[i] != 0) {
                a[i] -= b[i];
                result++;
            }
            if (a[i] != min) {
                result = -1;
                break;
            }
        }

        System.out.println(result);
    }
}