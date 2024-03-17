package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsMain {


    public static void startStreams() {

        List<Integer> nums = Arrays.asList(10, 4, 5, 6, 7, 8);
        nums.forEach(System.out::println);
        System.out.println();

               /* WHY STREAMS:
               dont change existing list because that will make it mutable
                 When you work with a lot of data and use multiple threads it is always better to have immutable data.
                  So whenever you change data, do it in a new stream.
         */

        // if you want to do in multiple threads, use parrallelStream() instead of stream()

        /* separate */
        System.out.println("\nSeparate stream objects");

        Stream<Integer> data = nums.stream();
        Stream<Integer> peek = data.peek(System.out::println).sorted();
        Stream<Integer> sorted = peek.map(n -> n * 2).sorted();
        sorted.forEach(System.out::println);


        /* combined: */
        System.out.println("\nCombined");
        nums.stream().map(n -> n * 10).sorted().forEach(System.out::println);

        /* collect to create new List */
        System.out.println("\nCreate new list");
        List<String> users = Arrays.asList("Hans", "Kees", "Peter", "Ans");
        List<String> sortedUsers = users.stream()
                .filter(n -> !Objects.equals(n, "Peter"))
                .sorted()
                .map(n -> n + "!")
                .toList();
        // creates 3 streams, but every time a stream is consumed that memory is cleared up again, so memory issues aren't a big problem with
        // copying the list everytime.
        sortedUsers.forEach(System.out::println);


        /* custom filter predicate: */
        System.out.println("\nWith custom filter predicate");

        Predicate<Integer> isEvenPredicate = (Integer i) -> {
             return i % 2 == 0;
        };

        Integer i = nums.stream().filter(isEvenPredicate).findFirst().orElseThrow();
        System.out.println(i);  // no such element exception when predicate returns false with findFirst


        /* reduce: filter data, map data and create reduced part of it
        * Reduce performs operation and then uses that same result again for the next operation
         */
        System.out.println("\n MapReduce: ");
        // Reduce(value n, apply with 2 values
        // identity = startValue
        // c = carry (so previous result)
        // e = element (new element)
        int sum = nums.stream().reduce(0, (c,e) -> c + e);
        System.out.println(sum);


        int result = Stream.of(1,2,3).reduce(0, (c, e) -> c  * e + 1);
        // first one: 0 * 1 + 1 = 1
        // second one: 1 * 2 + 1 = 3
        // last one: 3*3 + 1 = 10
        System.out.println(result);
    }

}
