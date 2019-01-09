package hackerrank.algorithms;

import java.util.Scanner;

public class J_SimpleArraySum {

    private static final Scanner scanner = new Scanner(System.in);

    static int simpleArraySum(int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        // Prompt the user for the size of the array
        System.out.println("Enter the size of the array: ");
        int arraySize = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Array size is " + arraySize);

        // declare an int array
        int[] array = new int[arraySize];

        // Prompt the user to fill the array
        System.out.println("Enter the integers to fill the array with spaces: ");
        String[] arrayItems = scanner.nextLine().split(" ");

        // Fill the array
        for (int i = 0; i < arraySize; i++) {
            int arrayItem = Integer.parseInt(arrayItems[i].trim());
            array[i] = arrayItem;
        }

        // print the array contents
        System.out.print("The array is [");

        for (int elem : array) {
            System.out.print(elem);
        }

        System.out.print("]\n");

        System.out.println("The sum of the array is " + simpleArraySum(array));
    }
}
