package ua.havrysh;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetUtil {

    public static <T> Set<T> merge(Set<T> s1, Set<T> s2) {
        return Stream
                .concat(s1.stream(), s2.stream())
                .collect(Collectors.toSet());
    }
}
