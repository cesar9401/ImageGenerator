package com.cesar31.imggenerator;

import com.cesar31.imggenerator.structures.*;

/**
 *
 * @author cesar31
 */
public class ImageGenerator {

    public static void main(String[] args) {
        //matrixTest();
        AVLTest();
    }

    public static void AVLTest() {
        AVLTree tree = new AVLTree();

        tree.insert(30, "objecto");
        tree.insert(10, "objecto");
        tree.insert(35, "objecto");
        tree.insert(5, "objecto");
        tree.insert(20, "objecto");
        tree.insert(15, "objecto");
        tree.insert(25, "objecto");
        tree.insert(40, "objecto");
        tree.insert(45, "objecto");
        tree.insert(50, "objecto");
        tree.insert(55, "objecto");
        tree.insert(60, "objecto");

        tree.insert(300, "objecto");
        tree.insert(400, "objecto");
        tree.insert(600, "objecto");
        tree.insert(800, "objecto");

        tree.insert(210, "objecto");
        tree.insert(220, "objecto");
        tree.insert(230, "objecto");
        tree.insert(240, "objecto");
        tree.insert(250, "objecto");
        tree.insert(260, "objecto");
        tree.insert(299, "objecto");
        tree.insert(350, "objecto");
        tree.insert(360, "objecto");

        System.out.println("Size: " + tree.getSize());

        tree.generateDotFile();
    }

    public static void matrixTest() {
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
        matrix.generateDotFile();
    }
}
