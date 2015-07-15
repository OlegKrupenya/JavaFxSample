package com.testdev.domain;

/**
 * Represents the 3x3 field of the game
 * Created by oleh.krupenia on 7/15/2015.
 */
public class Field {
    /**
     * The field has width and height = 3
     */
    public static final int SIZE = 3;

    /**
     * Data that contains current information about the game
     */
    private Cell[][] data;

    public Field() {
        this.data = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.data[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getData() {
        return data;
    }
}
