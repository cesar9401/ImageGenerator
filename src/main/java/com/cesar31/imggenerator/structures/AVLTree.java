package com.cesar31.imggenerator.structures;

import com.cesar31.imggenerator.control.ControlFile;
import com.cesar31.imggenerator.model.Image;
import java.io.IOException;

/**
 *
 * @author cesar31
 */
public class AVLTree {

    private AVLNode root;
    private int size;

    private String graph;
    private String imgGraph;

    private boolean exists;
    private boolean deleted;

    private final String AVL_D = "avl.dot";
    private final String AVL_P = "avl.png";
    private final String COMMAND = "dot -Tpng " + AVL_D + " -o " + AVL_P;

    public AVLTree() {
        this.size = 0;
        this.exists = false;
        this.deleted = false;
    }

    /**
     * Crear nodo nuevo e insertar
     *
     * @param id
     * @param object
     */
    public void insert(String id, Object object) {
        AVLNode node = new AVLNode(id, object);
        insert(node);
    }

    /**
     * Insertar nuevo nodo
     *
     * @param node
     */
    public void insert(AVLNode node) {
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
        exists = false;

        /*node.getId() < father.getId()*/
        if (node.getId().compareTo(father.getId()) < 0) {
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
        } else if (node.getId().compareTo(father.getId()) > 0) {
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
        } else if (node.getId().compareTo(father.getId()) == 0) {
            exists = true;
        }

        return dad;
    }

    /**
     * Buscar
     *
     * @param id
     * @return
     */
    public AVLNode search(String id) {
        if (this.root != null) {
            return search(this.root, id);
        }

        return null;
    }

    /**
     * Buscar por id
     *
     * @param father
     * @param id
     * @return
     */
    private AVLNode search(AVLNode father, String id) {
        if (father == null) {
            return null;

            /*id > father.getId()*/
        } else if (id.compareTo(father.getId()) > 0) {
            return search(father.getRight(), id);

            /*id < father.getId()*/
        } else if (id.compareTo(father.getId()) < 0) {
            return search(father.getLeft(), id);
        } else {
            return father;
        }
    }

    /**
     * Eliminar por id
     *
     * @param id
     */
    public void delete(String id) {
        this.deleted = false;

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
    private AVLNode delete(String id, AVLNode father) {
        AVLNode dad = father;
        /*id < father.getId()*/
        if (id.compareTo(father.getId()) < 0) {
            if (father.getLeft() != null) {

                /*father.getLeft().getId() == id*/
                if (father.getLeft().getId().compareTo(id) == 0) {
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

            /*id > father.getId()*/
        } else if (id.compareTo(father.getId()) > 0) {
            if (father.getRight() != null) {

                /*father.getRight().getId() == id*/
                if (father.getRight().getId().compareTo(id) == 0) {
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

            /*id == father.getId()*/
        } else if (id.compareTo(father.getId()) == 0) {
            dad = delete(father);
            if (dad != null) {

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
        this.deleted = true;
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

    private void getSize(AVLNode node) {
        if (node != null) {
            this.size++;
            getSize(node.getLeft());
            getSize(node.getRight());
        }
    }

    public int getSize() {
        this.size = 0;
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
        graph += "\tlabel = \"Arbol AVL\";\n";
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
        Object object = node.getObject();
        if (node.getRight() == null && node.getLeft() == null) {
            if (object instanceof SparseMatrix) {
                return "\tlayer" + node.getId() + "[ label = \"capa_" + node.getId() + "\" ];\n";
            }

            /* usuario */
            return "\tuser" + node.getId() + "[ label = \"" + node.getId() + "\" ];\n";
            //return "\tnode" + node.getId() + "[ label = \"" + node.getId() + "\" ];\n";
        }

        if (object instanceof SparseMatrix) {
            return "\tlayer" + node.getId() + "[ label = \"<C0> | capa_" + node.getId() + "| <C1>\" ];\n";
        }

        /* usuario */
        return "\tuser" + node.getId() + "[ label = \"<C0> | " + node.getId() + " | <C1>\" ];\n";
        //return "\tnode" + node.getId() + "[ label = \"<C0> | " + node.getId() + " | <C1>\" ];\n";
    }

    /**
     * Puntero de padre a hijo
     *
     * @param father
     * @param son
     * @return
     */
    private String getPointers(AVLNode father, AVLNode son, boolean right) {
        Object object = father.getObject();
        if (object instanceof SparseMatrix) {
            return right ? "\tlayer" + father.getId() + ":C1 -> layer" + son.getId() + ";\n" : "\tlayer" + father.getId() + ":C0 -> layer" + son.getId() + ";\n";
        }

        return right ? "\tuser" + father.getId() + ":C1 -> user" + son.getId() + ";\n" : "\tuser" + father.getId() + ":C0 -> user" + son.getId() + ";\n";
        //return "\tnode" + father.getId() + " -> node" + son.getId() + ";\n";
    }

    public boolean exists() {
        return exists;
    }

    public boolean deleted() {
        return deleted;
    }

    public AVLNode getRoot() {
        return root;
    }

    /* GENERAR LISTADO DE CAPAS DE IMAGEN CON PUNTEROS A AVL DE CAPAS  */
    public void generateDotWithImgFile(Image img) {
        ControlFile write = new ControlFile();
        String content = getImgDotString(img);

        write.writeDotFile("img_avl.dot", content);
        try {
            write.execComand("dot -Tpng img_avl.dot -o img_avl.png");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private String getImgDotString(Image img) {
        imgGraph = "digraph avl_tree{\n\n";
        imgGraph += "\tlabel = \"Arbol AVL\";\n";
        imgGraph += "\tnode[ shape = record ]\n\n";

        /* Arbol */
        getNodesForImg(this.root);
        imgGraph += "\n";

        getPointersForImg(this.root);
        imgGraph += "\n\n";

        /* Imagen */
        imgGraph += "\timagen" + img.getId() + "[ label = \"imagen" + img.getId() + "\" color = red ];\n";
        ObjectList list = img.getLayers();
        ListNode tmp = list.getRoot();
        while (tmp != null) {
            /* nodos listado img */
            imgGraph += "\tcapa" + tmp.getId() + "[ label = \"capa_" + tmp.getId() + "\" color = red ];\n";
            tmp = tmp.getNext();
        }
        imgGraph += "\n";
        /* nodo Imagen a nodo root lista de capas */
        tmp = list.getRoot();
        if (tmp != null) {
            imgGraph += "\timagen" + img.getId() + " -> capa" + tmp.getId() + "[ color = red ];\n";
        }
        while (tmp != null) {
            imgGraph += "\tcapa" + tmp.getId() + " -> layer" + tmp.getId() + "[ color = red ];\n";
            if (tmp.getNext() != null) {
                imgGraph += "\tcapa" + tmp.getId() + " -> capa" + tmp.getNext().getId() + "[ color = red ];\n";
            }
            tmp = tmp.getNext();
        }
        imgGraph += "\n";

        imgGraph += "}\n";
        return imgGraph;
    }

    private void getNodesForImg(AVLNode father) {
        if (father != null) {
            imgGraph += nodeName(father);

            getNodesForImg(father.getLeft());
            getNodesForImg(father.getRight());
        }
    }

    private void getPointersForImg(AVLNode father) {
        if (father != null) {
            if (father.getRight() != null) {
                imgGraph += getPointers(father, father.getRight(), true);
                getPointersForImg(father.getRight());
            }

            if (father.getLeft() != null) {
                imgGraph += getPointers(father, father.getLeft(), false);
                getPointersForImg(father.getLeft());
            }
        }
    }
}
