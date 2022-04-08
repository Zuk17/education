package com.zuk17.battleship;

public class Coordinates {
    private final Coordinate begin;
    private final Coordinate end;

    final int minX;
    final int minY;
    final int maxX;
    final int maxY;

    public Coordinates(Coordinate[] coordinates) {
        begin = coordinates[0];
        end = coordinates[1];

        minX = Math.min(begin.getX(),end.getX());
        maxX = Math.max(begin.getX(),end.getX());
        minY = Math.min(begin.getY(),end.getY());
        maxY = Math.max(begin.getY(),end.getY());
    }

    public boolean isNotStraight() {
        return getXLength() * getYLength() != 0;
    }

    public Coordinate getBegin() {
        return begin;
    }

    public Coordinate getEnd() {
        return end;
    }

    public int getXLength() {
        return Math.abs(begin.getX() - end.getX());
    }

    public int getYLength() {
        return Math.abs(begin.getY() - end.getY());
    }
}
