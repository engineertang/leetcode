package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.IntConsumer;

import static org.junit.Assert.*;

public class RelativeSortArray1122Test {

    @Test
    public void relativeSortArray() {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};

        RelativeSortArray1122 clas = new RelativeSortArray1122();
        clas.relativeSortArray(arr1, arr2);
        Arrays.stream(arr1).forEach(value -> System.out.printf(value + ", "));
    }
}