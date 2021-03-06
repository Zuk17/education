package com.zuk17.tictactoe;

import java.util.ArrayList;
import java.util.List;

/*
    Размеры поля указать вручную в коде :)
    Возможно не очень интересно играть в крестики-нолики на поле другого размера.
 */


public class Field implements Cloneable {
    public static final int X = 3;

    private int turn = 0;
    private Mark[][] field = new Mark[X][X];

    // Переменная для хранения возможных ходов
    private List<Coord> listCoord = new ArrayList<>();

    public Field(String inputString) {
        for (int i = 0; i < X; i++)
            for (int j = 0; j < X; j++) {
                field[i][j] = Mark.markFromAbbreviation(inputString.charAt(i * X + j));
                if (field[i][j] == Mark.FIRST) turn++;
                if (field[i][j] == Mark.SECOND) turn--;
                if (field[i][j] == Mark.FOG) listCoord.add(new Coord(new int[]{i + 1, j + 1}));
            }
    }

    public Field(Mark[][] field) {
        for (int i = 0; i < X; i++)
            for (int j = 0; j < X; j++) {
                this.field[i][j] = field[i][j];
                if (this.field[i][j] == Mark.FIRST) turn++;
                if (this.field[i][j] == Mark.SECOND) turn--;
                if (this.field[i][j] == Mark.FOG) listCoord.add(new Coord(new int[]{i + 1, j + 1}));
            }
    }

    public int coordsGetSize() {
        return listCoord.size();
    }

    public Mark getTurn() {
        if (turn == 0) return Mark.FIRST;
        if (turn == 1) return Mark.SECOND;
        throw new RuntimeException("Wrong turn! Check code");
    }

    public Mark get(int i, int j) {
        return field[i][j];
    }

    public List<Coord> getList() {
        return listCoord;
    }

    public String printField() {
        StringBuilder output = new StringBuilder();
        output.append("---------\n");

        for (int i = 0; i < X; i++) {
            output.append("| ");
            for (int j = 0; j < X; j++)
                output.append(field[i][j].valueOf()).append(" ");
            output.append("|\n");
        }

        output.append("---------\n");
        return output.toString();
    }

    public boolean setCoordinate(Coord coord, Mark mark) {
        if (field[coord.getX()][coord.getY()] == Mark.FOG) {
            field[coord.getX()][coord.getY()] = mark;

            if (!listCoord.remove(coord))
                throw new RuntimeException("В листе с доступными ходами отсутствует эта координата\n" +
                        "X=" + coord.getX() + "\t\tY=" + coord.getY() + "\t\t Size of " + listCoord.size() + "\n" +
                        listCoord);

            if (mark == Mark.FIRST) turn++;
            else turn--;

            return true;
        } else return false;
    }

    @Override
    public Field clone() {
        return new Field(field);
    }
}
