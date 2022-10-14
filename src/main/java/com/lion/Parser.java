package com.lion;

public interface Parser<T> {
    T parse(String str);
}