package java8lambda;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Jason", "Mraz", 20),
                new Person("Bruno", "Mars", 50),
                new Person("Kate", "Perry", 5),
                new Person("Ze", "Silva", 18)
        );

        System.out.println("Full list of persons");
        people.forEach(System.out::println);

        System.out.println("\nQuantity of persons who last Name starts with 'M'");
        long count = people.stream().filter(p -> p.getLastName().startsWith("M")).count();
        System.out.println(count);

    }
}
