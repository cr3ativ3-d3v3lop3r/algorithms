package basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java_Map {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> times2 = listOfNumbers.stream().map( (n) -> n * 2 ).collect(Collectors.toList());

        System.out.println("List of numbers: " + listOfNumbers);
        System.out.println("List of numbers: " + multiplyBy(listOfNumbers, 2));
    }

    public static List<Integer> multiplyBy(List<Integer> collection, Integer multiplicationFactor) {
        return collection.stream().map((n) -> n * multiplicationFactor).collect(Collectors.toList());
    }
}
