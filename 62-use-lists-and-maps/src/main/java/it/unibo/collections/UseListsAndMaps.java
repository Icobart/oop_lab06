package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int DELTA = 1000;
    private static final int ELEMS = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i<DELTA; i++) {
            numbers.add(DELTA+i+1);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> lnumbers = new LinkedList<>();
        lnumbers.addAll(numbers);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer app = numbers.get(numbers.size()-1);
        numbers.set(numbers.size()-1, numbers.get(0));
        numbers.set(0, app);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final Integer arr : numbers) {
            System.out.println(arr);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeA = System.nanoTime();
        for(int i = 0; i<ELEMS; i++) {
            numbers.add(0, i);
        }
        timeA = System.nanoTime() - timeA;
        var millis = TimeUnit.NANOSECONDS.toMillis(timeA);
        System.out.println("Number of elements: "
                + ELEMS
                + " inserted in the first position of an ArrayList took "
                + timeA
                + "ns ("
                + millis
                + "ms)"
        );

        long timeL = System.nanoTime();
        for(int i = 0; i<ELEMS; i++) {
            lnumbers.add(0, i);
        }
        timeL = System.nanoTime() - timeL;
        var millisL = TimeUnit.NANOSECONDS.toMillis(timeL);
        System.out.println("Number of elements: "
                + ELEMS
                + " inserted in the first position of a LinkedList took "
                + timeL
                + "ns ("
                + millisL
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        timeA = System.nanoTime();
        for(int i = 0; i<DELTA; i++) {
            numbers.get(numbers.size()/2);
        }
        timeA = System.nanoTime() - timeA;
        millis = TimeUnit.NANOSECONDS.toMillis(timeA);
        System.out.println(DELTA
                + " times that the middle element was read in an ArrayList took "
                + timeA
                + "ns ("
                + millis
                + "ms)"
        );

        timeL = System.nanoTime();
        for(int i = 1; i<DELTA; i++) {
            lnumbers.get(lnumbers.size()/2);
        }
        timeL = System.nanoTime() - timeL;
        millisL = TimeUnit.NANOSECONDS.toMillis(timeL);
        System.out.println(DELTA
                + " times that the middle element was read in a LinkedList took "
                + timeL
                + "ns ("
                + millisL
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map <String, Long> continents = new HashMap<>();
        continents.put("Africa", 1_110_635_000L);
        continents.put("Americas", 972_005_000L);
        continents.put("Antartica", 0L);
        continents.put("Asia", 4_298_723_000L);
        continents.put("Europe", 742_452_000L);
        continents.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long population = 0L;
        for(final long comp : continents.values()) {
            population = population + comp;
        }
        System.out.print("Population of the world: " + population);
    }
}
