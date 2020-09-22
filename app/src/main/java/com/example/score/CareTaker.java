package com.example.score;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> list = new ArrayList<>();;

    public void push(Memento memento) {
        list.add(memento);
    }

    public Memento pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public String peek() {
        return list.get(list.size() - 1).getName();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
