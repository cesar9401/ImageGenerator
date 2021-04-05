package com.cesar31.imggenerator.structures;

import com.cesar31.imggenerator.control.WriteFile;
import java.io.IOException;

/**
 *
 * @author cesar31
 */
public class AVLTree {

    private AVLNode root;
    private int size;
    private String graph;

    private final String AVL_D = "avl.dot";
    private final String AVL_P = "avl.png";
    private final String COMMAND = "dot -Tpng " + AVL_D + " -o " + AVL_P;

    public AVLTree() {
        this.size = 0;
    }

    public void insert(int id, Object object) {
        AVLNode node = new AVLNode(id, object);
        if (this.root == null) {
            this.root = node;
        } else {
            this.root = insert(node, root);
        }

    }

    /**
     * Insertar nodo
     *
     * @param node
     * @param father
     * @return
     */
    private AVLNode insert(AVLNode node, AVLNode father) {
        AVLNode dad = father;

        if (node.getId() < father.getId()) {
            if (father.getLeft() == null) {
                father.setLeft(node);
            } else {
                father.setLeft(insert(node, father.getLeft()));
                if (father.getFactor() == -2) {
                    if (father.getLeft().getFactor() > 0) {
                        /* Rotacion doble izq */
                        dad = doubleLeftRotation(father);
                    } else {
                        dad = leftRotation(father);
                    }
                }
            }
        } else {
            if (father.getRight() == null) {
                father.setRight(node);
            } else {
                father.setRight(insert(node, father.getRight()));
                if (father.getFactor() == 2) {
                    if (father.getRight().getFactor() < 0) {
                        /* Rotacion doble der */
                        dad = doubleRightRotation(father);
                    } else {
                        dad = rightRotation(father);
                    }
                }
            }
        }

        return dad;
    }

    private AVLNode doubleRightRotation(AVLNode node) {
        //System.out.println("Doble derecha");
        node.setRight(leftRotation(node.getRight()));
        return rightRotation(node);
    }

    /**
     * Rotacion doble a la izquierda
     *
     * @param node
     * @return
     */
    private AVLNode doubleLeftRotation(AVLNode node) {
        //System.out.println("Doble Izquierda");
        node.setLeft(rightRotation(node.getLeft()));
        return leftRotation(node);
    }

    /**
     * Rotacion simple izquierda
     *
     * @param node
     * @return
     */
    private AVLNode leftRotation(AVLNode node) {
        //System.out.println("Izquierda");
        AVLNode aux = node.getLeft();
        node.setLeft(aux.getRight());
        aux.setRight(node);

        return aux;
    }

    /**
     * Rotacion simple derecha
     *
     * @param node
     * @return
     */
    private AVLNode rightRotation(AVLNode node) {
        //System.out.println("Derecha");
        AVLNode aux = node.getRight();
        node.setRight(aux.getLeft());
        aux.setLeft(node);

        return aux;
    }

    private void preOrden(AVLNode node) {
        if (node != null) {
            System.out.print(node.getId() + " ");
            preOrden(node.getLeft());
            preOrden(node.getRight());
        }
    }

    public void preOrden() {
        preOrden(this.root);
    }

    private void getSize(AVLNode node) {
        if (node != null) {
            this.size++;
            getSize(node.getLeft());
            getSize(node.getRight());
        }
    }

    public int getSize() {
        getSize(root);
        return size;
    }

    /**
     * Generar archivo .dot y .png
     */
    public void generateDotFile() {
        WriteFile write = new WriteFile();
        String content = getDotString();

        write.writeDotFile(AVL_D, content);
        try {
            write.execComand(COMMAND);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Generar contenido para archivo .dot
     *
     * @return
     */
    private String getDotString() {
        graph = "digraph avl_tree{\n\n";
        graph += "\tnode[ shape = record ]\n\n";

        getNodes(root);
        graph += "\n";

        getPointers(root);
        graph += "\n";

        graph += "}\n";
        return graph;
    }

    /**
     * Obtener apuntadores entre padres e hijos
     *
     * @param father
     */
    private void getPointers(AVLNode father) {
        if (father != null) {
            if (father.getRight() != null) {
                graph += getPointers(father, father.getRight(), true);
                getPointers(father.getRight());
            }

            if (father.getLeft() != null) {
                graph += getPointers(father, father.getLeft(), false);
                getPointers(father.getLeft());
            }
        }
    }

    /**
     * Nombre de nodos recursivo
     *
     * @param father
     */
    private void getNodes(AVLNode father) {
        if (father != null) {
            graph += nodeName(father);

            getNodes(father.getLeft());
            getNodes(father.getRight());
        }
    }

    /**
     * nombre y label del nodo
     *
     * @param node
     * @return
     */
    private String nodeName(AVLNode node) {
        if (node.getRight() == null && node.getLeft() == null) {
            return "\tnode" + node.getId() + "[ label = \"" + node.getId() + "\" ];\n";
        }
        return "\tnode" + node.getId() + "[ label = \"<C0> | " + node.getId() + " | <C1>\" ];\n";
    }

    /**
     * Puntero de padre a hijo
     *
     * @param father
     * @param son
     * @return
     */
    private String getPointers(AVLNode father, AVLNode son, boolean right) {
        return right ? "\tnode" + father.getId() + ":C1 -> node" + son.getId() + ";\n" : "\tnode" + father.getId() + ":C0 -> node" + son.getId() + ";\n";
        //return "\tnode" + father.getId() + " -> node" + son.getId() + ";\n";
    }
}
