package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        T rslt = null;
        for (T t: (T[]) stream.toArray()
             ) {
            Integer numberOfOccurrences = getNumberOfOccurrences(t);
            if (numberOfOccurrences > count) {
                count = numberOfOccurrences;
                rslt = t;
            }
        }
        return rslt;
    }


    public T []removeValue(T valueToRemove) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t: originalArray
             ) {
            if (!t.equals(valueToRemove)) {
                arrayList.add(t);
            }
        }
        for (int i = 0; i < arrayList.size() ; i++) {
            originalArray[i] = arrayList.get(i);
        }
        originalArray = Arrays.copyOf(originalArray,arrayList.size());
        return originalArray;
    }
}
