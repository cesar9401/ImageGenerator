package com.cesar31.imggenerator;

import com.cesar31.imggenerator.structures.MatrixNode;
import com.cesar31.imggenerator.structures.SparseMatrix;

/**
 *
 * @author cesar31
 */
public class ImageGenerator {

    public static void main(String[] args) {
        SparseMatrix matrix = new SparseMatrix();

//        matrix.viewRows();
//        matrix.viewColumns();
        matrix.insert(1, 1, "verde");

        matrix.insert(5, 1, "rojo");
        matrix.insert(4, 2, "negro");
        matrix.insert(1, 2, "azul");
        matrix.insert(6, 7, "azul");

//        matrix.viewRows();
//        matrix.viewColumns();
//        MatrixNode node = matrix.searchNode(1, 1);
//
//        if (node != null) {
//            System.out.println(node.toString());
//            System.out.println("Righ: " + node.getRight().toString());
//            System.out.println("Left: " + node.getLetf().toString());
//            System.out.println("Up: " + node.getUp().toString());
//            System.out.println("Down: " + node.getDown().toString());
//        }
        System.out.println(matrix.createDotFile());

    }
}
