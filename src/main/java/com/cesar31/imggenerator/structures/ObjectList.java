package com.cesar31.imggenerator.structures;

import com.cesar31.imggenerator.control.ControlFile;
import java.io.IOException;

/**
 *
 * @author cesar31
 */
public class ObjectList {

    private ListNode root;

    private final String LIST_D = "list.dot";
    private final String LIST_P = "list.png";
    private final String COMMAND = "dot -Tpng " + LIST_D + " -o " + LIST_P;
    private boolean inserted;

    public ObjectList() {
        this.inserted = false;
    }

    /**
     * Crear nuevo nodo e insertar
     *
     * @param id
     * @param object
     */
    public void insertar(int id, Object object) {
        ListNode node = new ListNode(id, object);
        insertar(node);
    }

    /**
     * Insertar nodo
     *
     * @param node
     */
    private void insertar(ListNode node) {
        this.inserted = false;

        if (this.root == null) {
            this.root = node;
            this.inserted = true;
        } else {
            ListNode aux = root;
            this.inserted = true;
            while (aux.getNext() != null) {
                if (aux.getId() == node.getId()) {
                    /* no insertar */
                    this.inserted = false;
                    break;
                }
                aux = aux.getNext();
            }
            if (this.inserted) {
                if (aux.getId() != node.getId()) {
                    aux.setNext(node);
                } else {
                    this.inserted = false;
                }
            }
        }
    }

    /**
     * Eliminar nodo
     *
     * @param id
     */
    public void delete(int id) {
        if (this.root != null) {
            if (this.root.getId() == id) {
                //ListNode del = root;
                root = root.getNext();
            } else {
                ListNode aux = this.root;
                while (aux.getNext() != null) {
                    if (aux.getNext().getId() == id) {
                        ListNode del = aux.getNext();
                        aux.setNext(del.getNext());
                        break;
                    }
                    aux = aux.getNext();
                }
            }
        } else {
            System.out.println("Listado vacio");
        }
    }

    /**
     * Obtener nodo
     *
     * @param id
     * @return
     */
    public ListNode getNode(int id) {
        ListNode tmp = null;
        if (this.root != null) {
            if (this.root.getId() == id) {
                return this.root;
            } else {
                ListNode aux = this.root;
                while (aux.getNext() != null) {
                    if (aux.getNext().getId() == id) {
                        tmp = aux.getNext();
                        return tmp;
                    }
                    aux = aux.getNext();
                }
            }
        }
        return tmp;
    }

    private String getDotString() {
        String graph = "digraph object_list{\n\n";
        graph += "\tnode[ shape = record ];\n\n";

        ListNode aux = this.root;
        while (aux != null) {
            graph += "\tnode" + aux.getId() + "[ label = \"" + aux.getId() + "\" ];\n";
            aux = aux.getNext();
        }
        graph += "\n";

        aux = this.root;
        while (aux != null) {
            if (aux.getNext() != null) {
                graph += "\tnode" + aux.getId() + " -> node" + aux.getNext().getId() + ";\n";
            }
            aux = aux.getNext();
        }
        graph += "\n";
        graph += "}\n";

        return graph;
    }

    public void generateDotFile() {
        ControlFile write = new ControlFile();
        String content = getDotString();

        write.writeDotFile(LIST_D, content);
        try {
            write.execComand(COMMAND);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public ListNode getRoot() {
        return root;
    }

    public boolean inserted() {
        return inserted;
    }
}
