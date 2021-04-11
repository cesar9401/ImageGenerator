package com.cesar31.imggenerator.structures;

import com.cesar31.imggenerator.control.ControlFile;
import com.cesar31.imggenerator.model.Image;
import java.io.IOException;

/**
 *
 * @author cesar31
 */
public class CircularList {

    private ListNode top;
    private ListNode bottom;
    private boolean inserted;

    private final String LIST_D = "circular.dot";
    private final String LIST_P = "circular.png";
    private final String COMMAND = "dot -Tpng " + LIST_D + " -o " + LIST_P;

    public CircularList() {
        this.inserted = false;
    }

    public void insertar(int id, Object object) {
        ListNode node = new ListNode(id, object);
        insertar(node);
    }

    /**
     * Insertar
     *
     * @param node
     */
    public void insertar(ListNode node) {
        this.inserted = false;

        if (this.top == null) {
            this.top = node;
            node.setNext(node);
            node.setPrevious(node);
            this.bottom = node;
            this.inserted = true;
        } else {
            ListNode aux = this.top;
            inserted = true;
            do {
                if (aux.getId() == node.getId()) {
                    /* No insertar */
                    inserted = false;
                    break;
                }
                aux = aux.getNext();
            } while (aux.getNext() != this.bottom);

            if (inserted) {
                this.bottom.setNext(node);
                node.setPrevious(this.bottom);
                node.setNext(this.top);
                this.top.setPrevious(node);
                this.bottom = node;
            }
        }
    }

    /**
     * Buscar nodo
     *
     * @param id
     * @return
     */
    public ListNode search(int id) {
        if (this.top == null) {
            return null;
        } else {
            ListNode aux = this.top;
            do {
                if (aux.getId() == id) {
                    return aux;
                }
                aux = aux.getNext();
            } while (aux != this.top);
        }

        return null;
    }

    /**
     * Eliminar
     *
     * @param id
     */
    public void delete(int id) {
        if (this.top != null) {
            if (this.top.getId() == id) {
                if (this.top == this.bottom) {
                    this.top = null;
                    this.bottom = null;
                } else {
                    this.top = this.top.getNext();
                    this.top.setPrevious(this.bottom);
                    this.bottom.setNext(this.top);
                }
            } else {
                ListNode aux = this.top;
                while (aux.getNext() != this.top) {
                    if (aux.getNext().getId() == id) {
                        if (aux.getNext() == this.bottom) {
                            this.bottom = aux;
                        }
                        ListNode del = aux.getNext();

                        del.getNext().setPrevious(aux);
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
     * Generar dot y png lista circular con lista de capas
     */
    public void generateDotFileWithLayers() {
        ControlFile write = new ControlFile();
        String content = getDotWithLayersString();

        write.writeDotFile(LIST_D, content);
        try {
            write.execComand(COMMAND);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * String para dot lista circular de img con lista de capas
     *
     * @return
     */
    private String getDotWithLayersString() {
        String graph = "digraph circular_layers{\n\n";
        graph += "\tnode[ shape = box ];\n";
        graph += "\trankdir = TB;\n\n";

        if (this.top != null) {
            ListNode aux = this.top;
            do {
                /* nodo lista circular */
                graph += "\timagen" + aux.getId() + "[ label = \"imagen" + aux.getId() + "\" group = " + aux.getId() + " ];\n";

                /* Imagen */
                Image img = (Image) aux.getObject();

                /* ObjectList */
                ObjectList list = img.getLayers();

                ListNode tmp = list.getRoot();
                while (tmp != null) {
                    //AVLNode avl = (AVLNode) tmp.getObject();
                    //SparseMatrix matrix = (SparseMatrix) avl.getObject();
                    //graph += "\tcapa" + matrix.getId() + "[ label = \"capa_" + matrix.getId() + "\" ];\n";

                    /* nodos lista de capas */
                    graph += "\tcapa" + tmp.getId() + "_" + aux.getId() + "[ label = \"capa_" + tmp.getId() + "\" group = " + aux.getId() + "];\n";
                    tmp = tmp.getNext();
                }
                graph += "\n";

                tmp = list.getRoot();
                if (tmp != null) {
                    /* nodo img a nodo capa */
                    graph += "\timagen" + aux.getId() + " -> capa" + tmp.getId() + "_" + aux.getId() + ";\n";
                }
                while (tmp != null) {
                    if (tmp.getNext() != null) {
                        /* punteros entre capas */
                        graph += "\tcapa" + tmp.getId() + "_" + aux.getId() + " -> capa" + tmp.getNext().getId() + "_" + aux.getId() + ";\n";
                    }
                    tmp = tmp.getNext();
                }
                graph += "\n";

                aux = aux.getNext();
            } while (aux != this.top);
            graph += "\n";

            aux = this.top;
            do {
                /* Punteros entre lista circular  */
                graph += "\timagen" + aux.getId() + " -> imagen" + aux.getNext().getId() + ";\n";
                graph += "\timagen" + aux.getId() + " -> imagen" + aux.getPrevious().getId() + ";\n";
                aux = aux.getNext();
            } while (aux != this.top);

            aux = this.top;
            graph += "{ rank = same; ";
            do {
                graph += "imagen" + aux.getId() + "; ";
                aux = aux.getNext();
            } while (aux != this.top);
            graph += "}\n";
            graph += "\n";
        }

        graph += "}\n";
        return graph;
    }

    /**
     * Generar png y dot lista circular
     */
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

    /**
     * String para archivo dot lista circular
     *
     * @return
     */
    private String getDotString() {
        String graph = "digraph circular_list{\n\n";
        graph += "\tnode[ shape = record ];\n";
        graph += "\trandir = LR;\n\n";

        if (this.top != null) {
            ListNode aux = this.top;
            do {
                graph += "\tnode" + aux.getId() + "[ label = \"" + aux.getId() + "\" ];\n";
                aux = aux.getNext();
            } while (aux != this.top);
            graph += "\n";

            aux = this.top;
            do {
                graph += "\tnode" + aux.getId() + " -> node" + aux.getNext().getId() + ";\n";
                graph += "\tnode" + aux.getId() + " -> node" + aux.getPrevious().getId() + ";\n";
                aux = aux.getNext();
            } while (aux != this.top);
            graph += "\n";
        }

        graph += "}\n";
        return graph;
    }

    public ListNode getTop() {
        return top;
    }

    public ListNode getBottom() {
        return bottom;
    }

    public boolean isInserted() {
        return inserted;
    }
}
