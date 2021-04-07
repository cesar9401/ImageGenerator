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
        
        tree.insert(18, "objecto");
        tree.insert(9, "objecto");
        tree.insert(25, "objecto");
        tree.insert(7, "objecto");
        tree.insert(23, "objecto");
        tree.insert(29, "objecto");
        tree.insert(2, "objecto");
        tree.insert(11, "objecto");
        tree.insert(10, "objecto");
        tree.insert(21, "objecto");
        tree.insert(24, "objecto");
        tree.insert(8, "objecto");
        tree.insert(27, "objeto");
        tree.insert(1, "objeto");
        
        tree.delete(21);
        tree.delete(24);
        tree.delete(18);

        //System.out.println("Size: " + tree.getSize());
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
