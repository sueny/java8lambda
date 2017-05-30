package java8lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java8lambda.Color.BLUE;
import static java8lambda.Color.GREEN;
import static java8lambda.Color.RED;
import static java8lambda.Color.YELLOW;

public class StreamOracleExample {

    public static void main(String[] args) throws Exception {

        List<Widget> widgets = Arrays.asList(
                new Widget(RED, 50),
                new Widget(BLUE, 2),
                new Widget(RED, 100),
                new Widget(YELLOW, 25),
                new Widget(GREEN, 3)
        );

        System.out.println("List of widgets");
        widgets.forEach(System.out::println);

        //Stream.of(Object[])
        //Arrays.stream(Object[])
        //IntStream.range(int, int)  
        //Stream.iterate(Object, UnaryOperator);
        //BufferedReader.lines();
        int sum = widgets.stream()
                .filter(b -> b.getColor() == RED)
                .mapToInt(b -> b.getWeight())
                .sum();

        System.out.println("\nSum of RED widgets");
        System.out.println(sum);

        System.out.println("\nInts automatic generated with IntStream");
        IntStream.range(1, 10).forEach(System.out::println);

        System.out.println("\nFile to stream -> Open file, read lines, string value of");
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        URL path = StreamOracleExample.class.getResource("file");
        File file = new File(path.getFile());
        BufferedReader in = new BufferedReader(new FileReader(file));
        in.lines().map(String::valueOf).forEach(System.out::println);

        System.out.println("\nPath to stream -> file to path, limit, print");
        Files.list(file.toPath().getParent()).limit(5).forEach(System.out::println);

        System.out.println("\nUsing parallel Stream");
        int sumOfWeights = widgets.parallelStream()
                .filter(b -> b.getColor().equals(Color.RED))
                .mapToInt(b -> b.getWeight())
                .sum();
        System.out.println(sumOfWeights);

        System.out.println("\nUsing stream to concat a list of string");
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));
        System.out.println(s);

        int[] array
                = IntStream.range(0, 50).parallel().map(x -> x * 2).toArray();

        System.out.println(Arrays.toString(array));

        /*
        ArrayList<String> results = new ArrayList<>();
        stream.filter(s -> pattern.matcher(s).matches())
                .forEach(s -> results.add(s));  // Unnecessary use of side-effects!

        List<String> results
                = stream.filter(s -> pattern.matcher(s).matches())
                        .collect(Collectors.toList());  // No side-effects!
        */
        System.out.println("\nstream.collect -> Use collect instead of forEach to save data in a list");
        
        
        System.out.println("\nUnordered() -> In cases where the stream has an encounter order, but the user does not particularly care about that encounter order, explicitly de-ordering the stream with unordered() may improve parallel performance for some stateful or terminal operations.");

        OptionalInt heaviest = widgets.parallelStream()
                                   .mapToInt(Widget::getWeight)
                                   .max();
        System.out.println(heaviest);
        
        System.out.println("\nMutable reduction");
        
        System.out.println("\nparallelizable collect form");
        /*ArrayList<String> strings = stream.collect(() -> new ArrayList<>(),
                                                (c, e) -> c.add(e.toString()),
                                                (c1, c2) -> c1.addAll(c2));*/
        
        List<String> strings = widgets.stream().map(Object::toString)
                                  .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("\n 2 version of parallelizable collect form, create List of String");
        System.out.println(strings);
        
        
        /**/
        Collector<Widget, ?, Integer> summingWeight
         = Collectors.summingInt(Widget::getWeight);
        
        Map<Color, Integer> weightByColor
         = widgets.stream().collect(Collectors.groupingBy(Widget::getColor,
                                                            summingWeight));
        
        System.out.println("\ncomposability, grouping weight by color");
        System.out.println(weightByColor);
        
        System.out.println("\nReduction, concurrency, and ordering");
        Map<Color, List<Widget>> widgetByColor
         = widgets.parallelStream()
               .collect(Collectors.groupingBy(Widget::getColor));
        widgetByColor.forEach((t, u) -> System.out.println(t + " " + u));
        
    }
}
