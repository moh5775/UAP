
import java.util.Scanner;

public class PrintNext {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        int n = input.nextInt();
        int count = 0;
        if (n % 5 == 0) {
            if (n % 2 == 0) {
                for (int i = n + 2; i <= n + 40; i = i + 2) {
                    System.out.print(i + " ");
                    count++;
                }
            } else {
                for (int i = n + 1; i <= n + 40; i = i + 2) {
                    System.out.print(i + " ");
                    count++;
                }
            }
        }
        else if (n % 7 == 0) {
            count = 0;
            for (int i = n + 1; count < 5; i++) {
                int flag = 0;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    System.out.print(i + " ");
                    count++;
                }
            }
        }
        if(count>=1)
        System.out.println("Total: " + count);
        else
        System.out.println("Neither divisile by 5 nor 7.");
    }
}
