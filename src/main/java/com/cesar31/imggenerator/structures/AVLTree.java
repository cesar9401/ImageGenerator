package com.cesar31.imggenerator.structures;

import com.cesar31.imggenerator.control.ControlFile;
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

    /**
     * Crear nodo nuevo e insertar
     *
     * @param id
     * @param object
     */
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

    /**
     * Eliminar por id
     *
     * @param id
     */
    public void delete(int id) {
        if (this.root != null) {
            this.root = delete(id, root);
        } else {
            System.out.println("Arbol vacio");
        }
    }

    /**
     * Eliminar recursivo
     *
     * @param id
     * @param father
     * @return
     */
    private AVLNode delete(int id, AVLNode father) {
        AVLNode dad = father;

        if (id < father.getId()) {
            if (father.getLeft() != null) {
                if (father.getLeft().getId() == id) {
                    father.setLeft(delete(father.getLeft()));
                } else {
                    /* Padre -> hijo izquierda */
                    father.setLeft(delete(id, father.getLeft()));
                }

                /* verificar factor de equilibrio */
                if (father.getFactor() == 2) {
                    if (father.getRight().getFactor() < 0) {
                        /* Rotacion doble der */
                        dad = doubleRightRotation(father);
                    } else {
                        dad = rightRotation(father);
                    }
                }
            } else {
                System.out.println("Nodo no encontrado");
            }
        } else if (id > father.getId()) {
            if (father.getRight() != null) {
                if (father.getRight().getId() == id) {
                    father.setRight(delete(father.getRight()));
                } else {
                    /* Padre -> hijo derecha */
                    father.setRight(delete(id, father.getRight()));
                }

                /* verificar factor de equilibrio */
                if (father.getFactor() == -2) {
                    if (father.getLeft().getFactor() > 0) {
                        /* Rotacion doble izq */
                        dad = doubleLeftRotation(father);
                    } else {
                        dad = leftRotation(father);
                    }
                }
            } else {
                System.out.println("Nodo no encontrado");
            }
        } else if (id == father.getId()) {
            dad = delete(father);
            if (dad != null) {
                System.out.println("before: " + dad.getFactor());

                /* Factor de equilibrio */
                if (dad.getFactor() == 2) {
                    if (dad.getRight().getFactor() < 0) {
                        /* Rotacion doble der */
                        dad = doubleRightRotation(dad);
                    } else {
                        dad = rightRotation(dad);
                    }
                }

                if (dad.getFactor() == -2) {
                    if (dad.getLeft().getFactor() > 0) {
                        /* Rotacion doble izq */
                        dad = doubleLeftRotation(dad);
                    } else {
                        dad = leftRotation(dad);
                    }
                }
                System.out.println("after: " + dad.getFactor());
            }
        }

        return dad;
    }

    /**
     * Eliminar casos
     *
     * @param node
     * @return
     */
    private AVLNode delete(AVLNode node) {
        /* Eliminar */

        boolean right = node.getRight() != null;
        boolean left = node.getLeft() != null;

        if (!right && !left) {
            /* Nodo hoja */
            node = null;

        } else if (right && left) {
            /* Nodo con dos hijos */
            AVLNode dad = lowerRight(node.getRight());
            node.setRight(delete(dad.getId(), node.getRight()));

            /* Hijo izquierda */
            dad.setLeft(node.getLeft());
            dad.setRight(node.getRight());

            node = dad;

        } else if (right || left) {
            /*Tiene un hijo hijos */
            node = right ? node.getRight() : node.getLeft();
        }
        return node;
    }

    /**
     * Nodo con Id mas pequeno
     *
     * @param node
     * @return
     */
    private AVLNode lowerRight(AVLNode node) {
        if (node.getLeft() != null) {
            node = lowerRight(node.getLeft());
        }
        return node;
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
        ControlFile write = new ControlFile();
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
