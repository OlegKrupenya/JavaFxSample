package com.testdev.domain;

/**
 * Cell of the matrix that contains information whether the cell is empty.
 * Created by oleh.krupenia on 7/14/2015.
 */
public class Cell {
    private boolean cross;
    private boolean zero;

    public boolean isCross() {
        return cross;
    }

    public void setCross(boolean cross) {
        this.cross = cross;
    }

    public boolean isZero() {
        return zero;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }
}
