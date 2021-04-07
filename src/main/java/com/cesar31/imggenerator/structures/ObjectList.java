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

    public ObjectList() {
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
        if (this.root == null) {
            this.root = node;
        } else {
            ListNode aux = root;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(node);
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
                tmp = null;
                return tmp;
            } else {
                ListNode aux = this.root;
                while (aux.getNext() != null) {
                    if (aux.getNext().getId() == id) {
                        tmp = aux.getNext();
                        return tmp;
                    }
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
}
