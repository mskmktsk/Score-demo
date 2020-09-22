package com.example.score;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    private CareTaker careTaker = new CareTaker();
    private MutableLiveData<Team> teamA;
    private MutableLiveData<Team> teamB;
    private String previous;

    public MutableLiveData<Team> getTeamA() {
        if (teamA == null) {
            teamA = new MutableLiveData<>();
            teamA.setValue(new Team("a"));
        }
        return teamA;
    }

    public MutableLiveData<Team> getTeamB() {
        if (teamB == null) {
            teamB = new MutableLiveData<>();
            teamB.setValue(new Team("b"));
        }
        return teamB;
    }

    public void add(String name, Integer score) {
        if (teamA.getValue().getName().equalsIgnoreCase(name)) {
            add(teamA, score);
        } else {
            add(teamB, score);
        }
    }

    public void undo() {
        if (!undo(teamA)) {
            undo(teamB);
        }
    }

    public void reset() {
        if (!careTaker.isEmpty()) {
            reset(teamA);
            reset(teamB);
            careTaker.clear();
            previous = null;
        }
    }

    private void add(MutableLiveData<Team> liveData, Integer score) {
        Team team = liveData.getValue();
        careTaker.push(team.saveInfoToMemento());
        team.setScore(team.getScore() + score);
        liveData.setValue(team);
        previous = team.getName();
    }

    private boolean undo(MutableLiveData<Team> liveData) {
        Team team = liveData.getValue();
        boolean bool = team.getName().equalsIgnoreCase(previous);
        if (bool && !careTaker.isEmpty()) {
            team.getInfoFromMemento(careTaker.pop());
            liveData.setValue(team);
            previous = careTaker.isEmpty() ? null : careTaker.peek();
        }
        return bool;
    }

    private void reset(MutableLiveData<Team> liveData) {
        Team team = liveData.getValue();
        team.setScore(0);
        liveData.setValue(team);
    }
}
