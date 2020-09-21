package com.example.score;

public class Memento {
    private String name;
    private Integer score;

    public Memento(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
