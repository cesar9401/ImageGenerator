package com.cesar31.imggenerator;

import com.cesar31.imggenerator.structures.SparseMatrix;

/**
 *
 * @author cesar31
 */
public class ImageGenerator {

    public static void main(String[] args) {
        SparseMatrix matrix = new SparseMatrix();

        matrix.viewColumns();
        matrix.insertColumn(20);
        matrix.insertColumn(15);

        matrix.insertColumn(3);
        matrix.viewColumns();

        matrix.insertColumn(1);
        matrix.insertColumn(5);
        matrix.insertColumn(2);

        matrix.viewColumns();
    }
}
