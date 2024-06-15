package inputOutput;
//import for Scanner and other utility classes
import java.util.*;

class SplitHouses {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        String str = s.nextLine();
        String result = "";

        for (int i=0; i<str.length(); i++) {
            result += (str.charAt(i) == 'H')? "H" : "B";
            if (result.contains("HH")) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        System.out.println(result);
    }
}