package basics;

import java.util.Arrays;
import java.util.List;

public class Java_Reduce {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("List of nummbers: " + listOfNumbers);
        System.out.println("Sum of the numbers is: " + sum(listOfNumbers));
    }

    public static Integer sum(List<Integer> collection) {
        return collection.stream().reduce(0, (left, right) -> left + right);
    }
}
