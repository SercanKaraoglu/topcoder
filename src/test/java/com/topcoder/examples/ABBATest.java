package com.topcoder.examples;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ABBATest {
    private static ABBA abba;

    @BeforeAll
    public static void setUp() throws Exception {
        abba = new ABBA();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of(new Scenerio("B", "ABBA", "Possible"),
                         new Scenerio("AB", "ABB", "Impossible"),
                         new Scenerio("BBAB", "ABABABABB", "Impossible"),
                         new Scenerio("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA", "Possible"),
                         new Scenerio("A", "BB", "Impossible")
                        )
                     .map(scenerio ->
                                  dynamicTest(scenerio.toString(),
                                              () -> {
                                                  assertEquals(scenerio.expected, abba.canObtain(scenerio.initial, scenerio.target));
                                              }
                                             )
                         );
    }

    class Scenerio {
        private final String initial;
        private final String target;
        private final String expected;

        public Scenerio(String initial, String target, String expected) {
            this.initial = initial;
            this.target = target;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return String.format("initial = %s, target = %s, returns = %s", initial, target, expected);
        }
    }

}
