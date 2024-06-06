//import for Scanner and other utility classes
import java.util.*;

class Zoos {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        if (str.length() > 20 && str.charAt(0) != 'z') {
            System.out.println("No");
            return;
        }

        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'z') {
                count += 2;
            } else {
                count--;
            }
        }

        if (count == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}