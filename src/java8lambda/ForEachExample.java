package java8lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ForEachExample {
    
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Jason", "Mraz", 20),
                new Person("Bruno", "Mars", 50),
                new Person("Kate", "Perry", 5),
                new Person("Ze", "Silva", 18)
        );
        System.out.println("Original list");
        printConditionally(people, p -> true);
        
        //Sort list by first Name
        
        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        
        System.out.println("Sort list by first name");
        printConditionally(people, p -> true);
        
        System.out.println("All persons with last name beginning with M");
        printConditionally(people, p -> p.getLastName().startsWith("M"));
        
    }
    
    private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
        for (Person p : people) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }
}
