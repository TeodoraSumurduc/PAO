package org.example.Bonus;

import org.example.Task1.MyUtilityClass;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

public class MyUtilityClassTest {

    @Test
    public void testPrintCollection() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        assertDoesNotThrow(() -> MyUtilityClass.printCollection(integers));

        Collection<String> strings = List.of("ana", "are", "mere");
        assertDoesNotThrow(() -> MyUtilityClass.printCollection(strings));
    }

    @Test
    public void testPrintCollectionNull() {
        assertThrows(IllegalArgumentException.class, () -> MyUtilityClass.printCollection(null));
    }

    @Test
    public void testDuplicateCollection() {
        List<Integer> integers = List.of(1, 2, 3);
        List<Integer> expected = List.of(1, 1, 2, 2, 3, 3);
        assertEquals(expected, MyUtilityClass.duplicateCollection(integers));

        List<String> strings = List.of("a", "b", "c");
        List<String> expectedStrings = List.of("a", "a", "b", "b", "c", "c");
        assertEquals(expectedStrings, MyUtilityClass.duplicateCollection(strings));
    }

    @Test
    public void testDuplicateCollectionNull() {
        assertThrows(IllegalArgumentException.class, () -> MyUtilityClass.duplicateCollection(null));
    }

    @Test
    public void testAggregate() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        int sum = MyUtilityClass.aggregate(integers, 0, Integer::sum);
        assertEquals(15, sum);

        List<Boolean> booleans = List.of(true, false, true);
        boolean allTrue = MyUtilityClass.aggregate(booleans, true, (acc, val) -> acc && val);
        assertFalse(allTrue);

        int trueCount = MyUtilityClass.aggregate(booleans, 0, (acc, val) -> val ? acc + 1 : acc);
        assertEquals(2, trueCount);
    }

    @Test
    public void testAggregateNullCollection() {
        assertThrows(IllegalArgumentException.class, () -> MyUtilityClass.aggregate(null, 0, Integer::sum));
    }

    @Test
    public void testAggregateNullAccumulator() {
        List<Integer> integers = List.of(1, 2, 3);
        assertThrows(NullPointerException.class, () -> MyUtilityClass.aggregate(integers, 0, null));
    }
}
