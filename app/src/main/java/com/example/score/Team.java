package com.example.score;

public class Team {
    private String name;
    private Integer score;

    public Memento saveInfoToMemento() {
        return new Memento(name, score);
    }

    public void getInfoFromMemento(Memento memento) {
        if (memento != null) {
            name = memento.getName();
            score = memento.getScore();
        }
    }

    public Team(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", socre=" + score +
                '}';
    }
}
