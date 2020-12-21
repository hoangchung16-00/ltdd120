package com.example.appcaronline1.activityhistory;

import com.example.appcaronline1.home.tabacitivity.activityhistory.OptionMoving;

public class Move {
    String moveFrom,moveTo,start,end;
    OptionMoving optionMoving;
    Double cash;

    public Move(String moveFrom, String moveTo, String start, String end, OptionMoving optionMoving, Double cash) {
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
        this.start = start;
        this.end = end;
        this.optionMoving = optionMoving;
        this.cash = cash;
    }

    public String getMoveFrom() {
        return moveFrom;
    }

    public void setMoveFrom(String moveFrom) {
        this.moveFrom = moveFrom;
    }

    public String getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(String moveTo) {
        this.moveTo = moveTo;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public OptionMoving getOptionMoving() {
        return optionMoving;
    }

    public void setOptionMoving(OptionMoving optionMoving) {
        this.optionMoving = optionMoving;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Move{" +
                "moveFrom='" + moveFrom + '\'' +
                ", moveTo='" + moveTo + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
