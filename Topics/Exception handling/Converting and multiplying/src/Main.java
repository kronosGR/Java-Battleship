import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String inp = "";
        while (true) {
            try {
                inp = sc.nextLine();
                int num = Integer.parseInt(inp);
                if (num == 0) {
                    break;
                }
                System.out.println(num * 10);
            } catch (NumberFormatException e) {
                System.out.println(String.format("Invalid user input: %s", inp));
                continue;
            }
        }

    }
}