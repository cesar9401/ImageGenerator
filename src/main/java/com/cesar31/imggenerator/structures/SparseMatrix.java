package com.cesar31.imggenerator.structures;

/**
 *
 * @author cesar31
 */
public class SparseMatrix {

    private MatrixNode root;
    private int rows;
    private int columns;

    public SparseMatrix() {
        // Nodo root
        this.root = new MatrixNode(0, 0, null);

        this.rows = 0;
        this.columns = 0;
    }

    /**
     * Insertar nueva fila
     *
     * @param rowNumber
     * @return
     */
    public MatrixNode insertRow(int rowNumber) {
        MatrixNode header = root.getDown();
        MatrixNode row = new MatrixNode(0, rowNumber, null);

        if (header == null) {
            root.setDown(row);
            row.setUp(root);

            this.rows++;
            return row;
        } else {
            if (header.getY() > rowNumber) {
                /* Punteros para row */
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
                        /* Punteros para row */
                        row.setDown(aux.getDown());
                        row.setUp(aux);

                        aux.setDown(row);
                        aux.getDown().setUp(row);

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
        MatrixNode column = new MatrixNode(columnNumber, 0, null);

        if (header == null) {
            root.setRight(column);
            column.setLetf(root);

            this.columns++;
            return column;
        } else {
            if (header.getX() > columnNumber) {
                /* Punteros para column */
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
                        /* Punteros para column */
                        column.setRight(aux.getRight());
                        column.setLetf(aux);

                        /* Punteros para aux */
                        aux.setRight(column);
                        aux.getRight().setLetf(column);

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
        System.out.println("0");
        if (aux != null) {
            System.out.println(aux.getX());
            while (aux.getRight() != null) {
                aux = aux.getRight();
                System.out.println(aux.getX());
            }
        }
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
}
