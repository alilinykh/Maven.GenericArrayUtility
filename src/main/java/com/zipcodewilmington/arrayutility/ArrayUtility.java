package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
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
        Long rslt = Arrays.stream(originalArray).filter(v -> v.equals(valueToEvaluate)).count();
        return rslt.intValue();
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Stream<T> stream = Stream.concat(Arrays.stream(originalArray), Arrays.stream(arrayToMerge));
        Integer count = 0;
        T stuff = null;
        for (T t: (T[]) stream.toArray()
             ) {
            Integer rslt = getNumberOfOccurrences(t);
            if (rslt > count) {
                count = rslt;
                stuff = t;
            }
        }
        return stuff;
    }


    public T []removeValue(T valueToRemove) {
        return null;
    }
}
