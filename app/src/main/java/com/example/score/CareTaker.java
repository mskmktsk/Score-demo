package com.example.score;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> list = new ArrayList<>();;

    public void add(Memento memento) {
        list.add(memento);
    }

    public Memento get() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public void reset() {
        list.clear();
    }
}
