package com.testdev.domain;

/**
 * Cell of the matrix that contains information whether the cell is empty.
 *
 * Actually this class and {@link Field} class are redundant.
 * The field and be represented by just a matrix of strings.
 * I don't know why I created it :)
 *
 * Created by oleh.krupenia on 7/14/2015.
 */
public class Cell {
    private boolean cross;
    private boolean zero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (cross != cell.cross) return false;
        return zero == cell.zero;

    }

    @Override
    public int hashCode() {
        int result = (cross ? 1 : 0);
        result = 31 * result + (zero ? 1 : 0);
        return result;
    }

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

    public boolean isEmpty() {
        return !isCross() && !isZero();
    }
}
