//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static boolean isSimple (int number) {
        boolean isSimple = true;
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] SumMulDigits(int number) {
        int sum = number % 10;
        int mul = number / 10;
        number /= 10;
        while (number > 0) {
            sum += number % 10;
            mul *= number % 10;
            number /= 10;
        }
        return new int[]{mul, sum};
    }

    public static int evklidGcd (int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return Math.abs(num1);
    }

    public static int lcm (int a, int b) {
        return Math.abs(a * b) / evklidGcd(a, b);
    }

    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());
        number = Math.abs(number);
        if (isSimple(number)) {
            System.out.printf("%d - is a simple number\n", number);
        }
        else {
            System.out.printf("%d - is not a simple number\n", number);
        }

        System.out.print("Enter number: ");
        number = Integer.parseInt(input.nextLine());
        int[] result = SumMulDigits(number);
        System.out.printf("Multiply of digits in %d = %d\n", number, result[0]);
        System.out.printf("Sum of digits in %d = %d\n", number, result[1]);

        System.out.println("Enter two numbers: ");
        int a =  Integer.parseInt(input.nextLine());
        int b = Integer.parseInt(input.nextLine());
        int nod =  evklidGcd(a, b);
        System.out.printf("GCD  of %d and %d = %d\n", a, b, nod);
        int nok =  lcm(a, b);
        System.out.printf("LCM of %d and %d = %d\n", a, b, nok);
    }
}