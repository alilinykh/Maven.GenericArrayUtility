package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    T[] arrayToMerge;
    T[] originalArray;

    public ArrayUtility(T[] t) {
        this.originalArray = t;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Long rslt = Stream.concat(Arrays.stream(originalArray), Arrays.stream(arrayToMerge)).filter(v -> v.equals(valueToEvaluate)).count();
        return rslt.intValue();
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return null;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }


    public T []removeValue(T valueToRemove) {
        return null;
    }
}
