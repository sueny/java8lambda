package java8lambda;

import java.util.function.BiConsumer;

public class WrapperLambda {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int key = 1;

        process(numbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

    }

    public static void process(int [] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int number : numbers) {
            consumer.accept(number, key);
        }
    }
    
    public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            System.out.println("Executing from wrapper");
            consumer.accept(v, k);
        };
    }
}
