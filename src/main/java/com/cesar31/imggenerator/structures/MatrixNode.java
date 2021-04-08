package com.cesar31.imggenerator.structures;

/**
 *
 * @author cesar31
 */
public class MatrixNode {

    private int x;
    private int y;
    private String color;

    private MatrixNode right, letf, up, down;

    public MatrixNode() {
    }

    public MatrixNode(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MatrixNode getRight() {
        return right;
    }

    public void setRight(MatrixNode right) {
        this.right = right;
    }

    public MatrixNode getLetf() {
        return letf;
    }

    public void setLetf(MatrixNode letf) {
        this.letf = letf;
    }

    public MatrixNode getUp() {
        return up;
    }

    public void setUp(MatrixNode up) {
        this.up = up;
    }

    public MatrixNode getDown() {
        return down;
    }

    public void setDown(MatrixNode down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "MatrixNode{" + "x=" + x + ", y=" + y + ", color=" + color + '}';
    }
}
