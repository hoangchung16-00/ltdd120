package com.example.appcaronline1.home.tabacitivity.activityhistory;

public class Movement {
    String moveFrom,moveTo,start,end;
    OptionMoving optionMoving;
    Double cash;

    public Movement(String moveFrom, String moveTo, String start, String end, OptionMoving optionMoving, Double cash) {
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
        this.start = start;
        this.end = end;
        this.optionMoving = optionMoving;
        this.cash = cash;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public OptionMoving getOptionMoving() {
        return optionMoving;
    }

    public void setOptionMoving(OptionMoving optionMoving) {
        this.optionMoving = optionMoving;
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
