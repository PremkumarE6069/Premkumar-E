// inc
import java.util.*;

public class inc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial value : ");
        int n = sc.nextInt();
        System.out.println("Enter the number of loops");
        int m = sc.nextInt();
        int out = quantityChange(n, m);
        System.out.println("QUANTITY VAL : " + out);
        sc.close();
    }

    public static int quantityChange(int init, int loop) {
        Scanner sc = new Scanner(System.in);
        int total = init;
        for (int i = 0; i < loop; i++) {
            System.out.println("Enter the condition : ");
            String str = sc.nextLine();
            if (str.equals("inc"))
                total++;
            else {
                if (total != 0)
                    total--;
            }
        }
        sc.close();
        return total;
    }
}
