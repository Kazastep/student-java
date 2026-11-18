package edu.course.lab06;

import java.util.Collection;

public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T> void copyAll(
            Collection<? extends T> sources,
            Collection<? super T> destination) {
        for (T value: sources){
            destination.add(value);
        }
    }
}