package two_sums;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 6, 7, 8};

        System.out.print("Enter target sum: ");
        int targetSum = sc.nextInt();
        int firstNum = 0;
        int secondNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == targetSum) {
                    firstNum = numbers[i];
                    secondNum = numbers[j];
                }
            }
        }

        System.out.println(firstNum + " + " + secondNum + " = " + targetSum);

    }
}
