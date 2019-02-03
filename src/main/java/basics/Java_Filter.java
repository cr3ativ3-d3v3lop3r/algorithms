package basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java_Filter {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("List of numbers: " + listOfNumbers);
        System.out.println("Less than 5: " + filterEveryThingLessThan(listOfNumbers, 5));
        System.out.println("Greater than 5: " + filterEveryThingGreaterThan(listOfNumbers, 5));
        System.out.println("Range between (3-8): " + filterBetweenRange(listOfNumbers, 3, 8));
    }

    public static List<Integer> filterEveryThingLessThan(List<Integer> collection, Integer lessThan) {
        return collection.stream().filter( (n) -> n < lessThan).collect(Collectors.toList());
    }

    public static List<Integer> filterEveryThingGreaterThan(List<Integer> collection, Integer greaterThan) {
        return collection.stream().filter( (n) -> n > greaterThan).collect(Collectors.toList());
    }

    public static List<Integer> filterBetweenRange(List<Integer> collection, Integer first, Integer last) {
        return collection.stream().filter( (n) -> n >= first && n <= last).collect(Collectors.toList());
    }
}
