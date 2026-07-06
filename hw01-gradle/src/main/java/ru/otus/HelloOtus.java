package ru.otus;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class HelloOtus {
    public List<String> copyToImmutableReverse(List<String> strings) {
        return ImmutableList.copyOf(strings).reverse();
    }
}
