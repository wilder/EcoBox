package com.wilderpereira.ecobox;

/**
 * Created by Wilder on 06/11/16.
 */

public class Friend {
    private String name;
    private String level;
    private boolean ranking;

    public boolean isRanking() {
        return ranking;
    }

    public void setRanking(boolean ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
