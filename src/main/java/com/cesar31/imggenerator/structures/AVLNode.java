package com.cesar31.imggenerator.structures;

/**
 *
 * @author cesar31
 */
public class AVLNode {

    private int id;
    private AVLNode right;
    private AVLNode left;

    private Object object;

    public AVLNode() {
    }

    public AVLNode(int id, Object object) {
        this.id = id;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Factor de equilibrio
     *
     * @return
     */
    public int getFactor() {
        int hRight = (this.right == null) ? 0 : 1 + this.right.getHeight();
        int hLeft = (this.left == null) ? 0 : 1 + this.left.getHeight();
        return hRight - hLeft;
    }

    /**
     * Altura
     *
     * @return
     */
    public int getHeight() {
        int hRight = (this.right == null) ? 0 : 1 + this.right.getHeight();
        int hLeft = (this.left == null) ? 0 : 1 + this.left.getHeight();

        return Math.max(hRight, hLeft);
    }

}
