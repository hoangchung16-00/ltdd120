package com.example.appcaronline1.home.tabacitivity.activityhistory;

public class Move {
    String moveFrom,moveTo,start,end;

    public Move(String moveFrom, String moveTo,  String start, String end) {
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;

        this.start = start;
        this.end = end;
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
