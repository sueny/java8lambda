package java8lambda;

import java.util.Arrays;
import java.util.List;

public class StreamNumberExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result = 0;

        result = numbers.stream().reduce(0, Integer::sum);
                //.reduce(0, (total, e) -> Integer.sum(total, e));
        System.out.println("List of numbers");
        numbers.forEach(System.out::println);
        
        System.out.println("Sum total: " + result);

    }
}
