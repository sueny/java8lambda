package java8lambda;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Jason", "Mraz", 20),
                new Person("Bruno", "Mars", 50),
                new Person("Kate", "Perry", 5),
                new Person("Ze", "Silva", 18)
        );
        
        people.forEach(System.out::println); 

    }
}
