package com.digvijayb.aglorithms.sample;

import java.util.stream.Stream;

public class StreamSample {

    public static void main(String[] args) {
        final Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        final Stream<Integer> modifedStream = integerStream.parallel().map(e -> e * 2);
        modifedStream.forEachOrdered(System.out::println);
        // modifedStream.forEach(System.out::println);

    }
}
