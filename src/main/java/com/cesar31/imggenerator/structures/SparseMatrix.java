package com.cesar31.imggenerator.structures;

import com.cesar31.imggenerator.control.WriteFile;
import java.io.IOException;

/**
 *
 * @author cesar31
 */
public class SparseMatrix {
    
    /* Propiedades de SparseMatrix - Capas para las Imagenes */
    private int id;
    private SparseMatrix next;

    private final String MATRIX_D = "matrix.dot";
    private final String MATRIX_P = "matrix.png";
    private final String COMMAND = "dot -Tpng " + MATRIX_D + " -o " + MATRIX_P;

    private MatrixNode root;
    private int rows;
    private int columns;

    public SparseMatrix() {
        // Nodo root
        this.root = new MatrixNode(0, 0, "matriz");

        this.rows = 0;
        this.columns = 0;
    }
    
    public SparseMatrix(int id) {
        this();
        this.id = id;
    }

    /**
     * Crear nodo y luego enviar para insertar
     *
     * @param x
     * @param y
     * @param color
     */
    public void insert(int x, int y, String color) {
        MatrixNode node = new MatrixNode(x, y, color);
        insert(node);
    }

    /**
     * Insertar nodo en matriz
     *
     * @param node
     */
    private void insert(MatrixNode node) {
        int x = node.getX();
        int y = node.getY();

        MatrixNode rowHead = getRow(y, true);
        MatrixNode columnHead = getColumn(x, true);

        /* Insertar en columna */
        MatrixNode col = rowHead.getRight();
        if (col == null) {
            rowHead.setRight(node);
            node.setLetf(rowHead);
        } else {
            if (col.getX() > x) {
                /* Punteros para node */
                node.setRight(col);
                node.setLetf(rowHead);

                rowHead.setRight(node);
                col.setLetf(node);
            } else {
                MatrixNode aux = col;
                boolean inserted = false;
                while (aux.getRight() != null) {
                    if (aux.getRight().getX() > x) {
                        /* Punteros para node */
                        node.setRight(aux.getRight());
                        node.setLetf(aux);

                        aux.getRight().setLetf(node);
                        aux.setRight(node);
                        inserted = true;
                        break;
                    }
                    aux = aux.getRight();
                    System.out.println(aux.toString());
                }

                if (!inserted) {
                    aux.setRight(node);
                    node.setLetf(aux);
                }
            }
        }

        /* Insertar en fila */
        MatrixNode row = columnHead.getDown();
        if (row == null) {
            columnHead.setDown(node);
            node.setUp(columnHead);
        } else {
            if (row.getY() > y) {
                /* Punteros para node */
                node.setDown(row);
                node.setUp(columnHead);

                columnHead.setDown(node);
                row.setUp(node);
            } else {
                MatrixNode aux = row;
                boolean inserted = false;
                while (aux.getDown() != null) {
                    if (aux.getDown().getY() > y) {
                        /* Punteros para node */
                        node.setDown(aux.getDown());
                        node.setUp(aux);

                        aux.getDown().setUp(node);
                        aux.setDown(node);
                        inserted = true;
                        break;
                    }
                    aux = aux.getDown();
                }

                if (!inserted) {
                    aux.setDown(node);
                    node.setUp(aux);
                }
            }
        }
    }

    /**
     * Buscar nodo por fila y columna
     *
     * @param row
     * @param column
     * @return
     */
    public MatrixNode searchNode(int row, int column) {
        MatrixNode rowHead = getRow(row, false);
        if (rowHead != null) {
            MatrixNode aux = rowHead.getRight();
            while (aux != null) {
                if (aux.getX() == column) {
                    System.out.println("aux");
                    return aux;
                }
                aux = aux.getRight();
            }
        }

        return null;
    }

    /**
     * Obtener fila, si no existe se interta y retorna
     *
     * @param rowNumber
     * @return
     */
    private MatrixNode getRow(int rowNumber, boolean create) {
        MatrixNode aux = root.getDown();
        while (aux != null) {
            if (aux.getY() == rowNumber) {
                return aux;
            }
            aux = aux.getDown();
        }

        return create ? insertRow(rowNumber) : null;
    }

    /**
     * Obtener columna, si no existe se inserta y retorna
     *
     * @param columnNumber
     * @return
     */
    private MatrixNode getColumn(int columnNumber, boolean create) {
        MatrixNode aux = root.getRight();
        while (aux != null) {
            if (aux.getX() == columnNumber) {
                return aux;
            }
            aux = aux.getRight();
        }

        return create ? insertColumn(columnNumber) : null;
    }

    /**
     * Insertar nueva fila
     *
     * @param rowNumber
     * @return
     */
    public MatrixNode insertRow(int rowNumber) {
        MatrixNode header = root.getDown();
        MatrixNode row = new MatrixNode(0, rowNumber, String.valueOf(rowNumber));

        if (header == null) {
            root.setDown(row);
            row.setUp(root);

            this.rows++;
            return row;
        } else {
            if (header.getY() > rowNumber) {
                /* Punteros para rowHead */
                row.setDown(header);
                row.setUp(root);

                /* Punteros para root */
                root.setDown(row);

                /* Punteros para header */
                header.setUp(row);

                this.rows++;
                return row;
            } else {
                MatrixNode aux = header;
                while (aux.getDown() != null) {
                    if (aux.getDown().getY() > rowNumber) {
                        /* Punteros para rowHead */
                        row.setDown(aux.getDown());
                        row.setUp(aux);

                        aux.getDown().setUp(row);
                        aux.setDown(row);

                        this.rows++;
                        return aux;
                    }
                    aux = aux.getDown();
                }

                aux.setDown(row);
                row.setUp(aux);

                this.rows++;
                return row;
            }
        }
    }

    /**
     * Insertar nueva columna
     *
     * @param columnNumber
     * @return
     */
    public MatrixNode insertColumn(int columnNumber) {
        MatrixNode header = root.getRight();
        MatrixNode column = new MatrixNode(columnNumber, 0, String.valueOf(columnNumber));

        if (header == null) {
            root.setRight(column);
            column.setLetf(root);

            this.columns++;
            return column;
        } else {
            if (header.getX() > columnNumber) {
                /* Punteros para columnHead */
                column.setRight(header);
                column.setLetf(root);

                /* Punteros para root */
                root.setRight(column);

                /* Punteros para header */
                header.setLetf(column);

                this.columns++;
                return column;
            } else {
                MatrixNode aux = header;
                while (aux.getRight() != null) {
                    if (aux.getRight().getX() > columnNumber) {
                        /* Punteros para columnHead */
                        column.setRight(aux.getRight());
                        column.setLetf(aux);

                        /* Punteros para aux */
                        aux.getRight().setLetf(column);
                        aux.setRight(column);

                        this.columns++;
                        return column;
                    }
                    aux = aux.getRight();
                }

                aux.setRight(column);
                column.setLetf(aux);

                this.columns++;
                return column;
            }
        }
    }

    public void generateDotFile() {
        WriteFile write = new WriteFile();

        String content = getDotString();
        write.writeDotFile(MATRIX_D, content);
        try {
            write.execComand(COMMAND);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public String getDotString() {
        String graph = "digraph graph_name {\n\n";
        graph += "\tnode [shape = box]\n\n";

        graph += getName(root) + "[ label = \"Matriz\", width = 1.5, group = 1];\n\n";
        graph += "\te0[ shape = point, width = 0 ];\n";
        graph += "\te1[ shape = point, width = 0 ];\n\n";

        MatrixNode aux = root.getDown();
        if (aux != null) {
            graph += getName(aux) + "[ label = \"" + aux.getY() + "\" pos = \"5.3,3.5!\" width = 1.5 group = 1 ];\n";
            aux = aux.getDown();
        }
        while (aux != null) {
            graph += getName(aux) + "[ label = \"" + aux.getY() + "\" width = 1.5 group = 1 ];\n";
            aux = aux.getDown();
        }
        graph += "\n";

        aux = root.getDown();
        while (aux != null) {
            if (aux.getDown() != null) {
                graph += nodeToNode(aux, aux.getDown());
            }

            if (aux.getUp() != null && aux.getUp() != root) {
                graph += nodeToNode(aux, aux.getUp());
            }
            aux = aux.getDown();
        }
        graph += "\n";

        aux = root.getRight();
        while (aux != null) {
            graph += getName(aux) + "[ label = \"" + aux.getX() + "\" width = 1.5 group = " + (aux.getX() + 1) + " ];\n";
            aux = aux.getRight();
        }
        graph += "\n";

        aux = root.getRight();
        while (aux != null) {
            if (aux.getRight() != null) {
                graph += nodeToNode(aux, aux.getRight());
            }

            if (aux.getLetf() != null && aux.getLetf() != root) {
                graph += nodeToNode(aux, aux.getLetf());
            }

            if (aux.getDown() != null) {
                graph += nodeToNode(aux, aux.getDown());
            }
            aux = aux.getRight();
        }
        graph += "\n";

        if (root.getRight() != null) {
            graph += nodeToNode(root, root.getRight());
        }

        if (root.getDown() != null) {
            graph += nodeToNode(root, root.getDown());
        }
        graph += "\n";

        graph += "\t{ rank = same; ";
        aux = root;
        while (aux != null) {
            graph += "node" + aux.getX() + "_" + aux.getY() + "; ";
            aux = aux.getRight();
        }
        graph += "}\n\n";

        aux = root.getDown();
        while (aux != null) {
            MatrixNode aux1 = aux.getRight();
            while (aux1 != null) {
                graph += getName(aux1) + "[ label = \"" + aux1.getColor() + "\" width = 1.5 group = " + (aux1.getX() + 1) + "]\n";
                aux1 = aux1.getRight();
            }
            graph += "\n";
            aux = aux.getDown();
        }

        aux = root.getDown();
        while (aux != null) {
            MatrixNode aux1 = aux.getRight();
            if (aux1 != null) {
                graph += nodeToNode(aux, aux1);
            }

            while (aux1 != null) {
                if (aux1.getRight() != null) {
                    graph += nodeToNode(aux1, aux1.getRight());
                }

                if (aux1.getDown() != null) {
                    graph += nodeToNode(aux1, aux1.getDown());
                }

                if (aux1.getLetf() != null) {
                    graph += nodeToNode(aux1, aux1.getLetf());
                }

                if (aux1.getUp() != null) {
                    graph += nodeToNode(aux1, aux1.getUp());
                }
                aux1 = aux1.getRight();
            }

            aux1 = aux;
            graph += "\t{ rank = same; ";
            while (aux1 != null) {
                graph += "node" + aux1.getX() + "_" + aux1.getY() + "; ";
                aux1 = aux1.getRight();
            }
            graph += "}\n\n";
            aux = aux.getDown();
        }

        graph += "}\n";

        return graph;
    }

    private String getName(MatrixNode n) {
        return "\tnode" + n.getX() + "_" + n.getY();
    }

    private String nodeToNode(MatrixNode n, MatrixNode p) {
        return "\tnode" + n.getX() + "_" + n.getY() + " -> node" + p.getX() + "_" + p.getY() + ";\n";
    }

    public void viewRows() {
        MatrixNode aux = root.getDown();
        System.out.println("Rows");
        System.out.println("0");
        if (aux != null) {
            System.out.println(aux.getY());
            while (aux.getDown() != null) {
                aux = aux.getDown();
                System.out.println(aux.getY());
            }
        }
    }

    public void viewColumns() {
        MatrixNode aux = root.getRight();
        System.out.println("Columns");
        System.out.print("0 ");
        if (aux != null) {
            System.out.print(aux.getX() + " ");
            while (aux.getRight() != null) {
                aux = aux.getRight();
                System.out.print(aux.getX() + " ");
            }
        }
        System.out.println("");
    }

    public MatrixNode getRoot() {
        return root;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SparseMatrix getNext() {
        return next;
    }

    public void setNext(SparseMatrix next) {
        this.next = next;
    }
}
