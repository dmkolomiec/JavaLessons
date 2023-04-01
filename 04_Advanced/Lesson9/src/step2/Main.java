package step2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static final long ARRAY_SIZE = 10;
    public static final long MIN_ELEMENT_VALUE = 1;
    public static final long MAX_ELEMENT_VALUE = 20;  // >= MIN_ELEMENT_VALUE

    public static void main(String[] args) {
        Random random = new Random();
        Long totalSum;

        List<Long> list = Stream
                .generate(() -> random.nextLong(MIN_ELEMENT_VALUE, MAX_ELEMENT_VALUE + 1))
                .limit(ARRAY_SIZE)
                .sorted()
                .toList();
        System.out.println("Початковий список: " + list);

        try {
            System.out.print("Добуток квадратів ел-тів списку(Stream.reduce)  = ");
            totalSum = list.stream()
                    .map(number -> number * number)
                    .reduce(Long::sum).get();    // (left, right) -> left + right
            System.out.printf("%,d\n", totalSum);
        } catch (NoSuchElementException e) {
            System.out.println("0 (список пустий)");
        }

        totalSum = list.stream()
                .map(number -> number * number)
                .mapToLong(Long::longValue)
                .sum();
        System.out.printf("Добуток квадратів ел-тів списку(LongStream.sum) = %,d\n", totalSum);
    }
}
