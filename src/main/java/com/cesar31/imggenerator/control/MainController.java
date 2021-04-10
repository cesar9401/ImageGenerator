package com.cesar31.imggenerator.control;

import com.cesar31.imggenerator.model.Image;
import com.cesar31.imggenerator.model.User;
import com.cesar31.imggenerator.structures.AVLNode;
import com.cesar31.imggenerator.structures.AVLTree;
import com.cesar31.imggenerator.structures.CircularList;
import com.cesar31.imggenerator.structures.ListNode;
import com.cesar31.imggenerator.structures.MatrixNode;
import com.cesar31.imggenerator.structures.ObjectList;
import com.cesar31.imggenerator.structures.SparseMatrix;
import com.cesar31.imggenerator.ui.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar31
 */
public class MainController {

    private ParserController parser;
    private ControlFile control;

    private AVLTree layersTree;
    private CircularList imgList;
    private AVLTree usersTree;

    private MainFrame frame;

    private int limit;
    private int count;

    public MainController(MainFrame frame) {
        this.frame = frame;
        this.parser = new ParserController();
        this.control = new ControlFile();

        this.limit = 0;
        this.count = 0;
        /* Borrar */
        loadDatos();
        //generateImg();
    }

    public void generateImg() {
        System.out.println("Generando");
        AVLNode node1 = layersTree.search("3");
        System.out.println("node1 = " + node1.getId());
        SparseMatrix m1 = (SparseMatrix) node1.getObject();

        AVLNode node2 = layersTree.search("4");
        System.out.println("node2 = " + node2.getId());
        SparseMatrix m2 = (SparseMatrix) node2.getObject();
        System.out.println("m2 = " + m2.getId());
        SparseMatrix matrix = new SparseMatrix();

        MatrixNode aux = m1.getRoot().getDown();
        System.out.println("matriz1");
        while (aux != null) {
            MatrixNode aux1 = aux.getRight();
            while (aux1 != null) {
                MatrixNode node = matrix.searchNode(aux1.getY(), aux1.getX());
                if (node != null) {
                    node.setColor(aux1.getColor());
                    System.out.println(node.toString());
                } else {
                    System.out.println(aux1.toString());
                    matrix.insert(aux1.getX(), aux1.getY(), aux1.getColor());
                }

                aux1 = aux1.getRight();
            }
            aux = aux.getDown();
        }

        aux = m2.getRoot().getDown();
        System.out.println("\nmatriz2\n");
        while (aux != null) {
            MatrixNode aux1 = aux.getRight();
            while (aux1 != null) {
                MatrixNode node = matrix.searchNode(aux1.getY(), aux1.getX());
                if (node != null) {
                    node.setColor(aux1.getColor());
                    System.out.println(node.toString());
                } else {
                    System.out.println(aux1.toString());
                    matrix.insert(aux1.getX(), aux1.getY(), aux1.getColor());
                }
                aux1 = aux1.getRight();
            }
            aux = aux.getDown();
        }

        matrix.generateDotFile();
        System.out.println("listo!");
    }

    /* Borrar */
    private void loadDatos() {
        readLayers("/home/cesar31/Java/ImageGenerator/datos/capas.cap");
        readImages("/home/cesar31/Java/ImageGenerator/datos/imagenes.im");
        readUsers("/home/cesar31/Java/ImageGenerator/datos/usuarios.usr");
        System.out.println("Datos cargados");
    }

    /**
     * Leer capas
     *
     * @param path
     * @return
     */
    public boolean readLayers(String path) {
        /* Demas estructuras en null */
        this.imgList = null;
        this.usersTree = null;

        String input = this.control.readData(path);
        if (input != null) {
            this.layersTree = this.parser.readLayers(input);
        }

        return this.layersTree != null;
    }

    /**
     * Leer imagenes
     *
     * @param path
     * @return
     */
    public boolean readImages(String path) {
        String input = this.control.readData(path);
        if (input != null) {
            this.imgList = this.parser.readImages(input);
        }

        return this.imgList != null;
    }

    /**
     * Leer usuarios
     *
     * @param path
     * @return
     */
    public boolean readUsers(String path) {
        String input = this.control.readData(path);
        if (input != null) {
            this.usersTree = this.parser.readUsers(input);
        }

        return this.usersTree != null;
    }

    /**
     * Agregar usuarios
     *
     * @param id
     * @return
     */
    public void addUser(String id) {
        if (this.usersTree != null) {
            if (!id.strip().isEmpty()) {
                if (!id.contains(" ")) {
                    User u = new User(id);
                    usersTree.insert(id, u);
                    if (!usersTree.exists()) {
                        this.frame.showMessage("Se agrego correctamente al usuario: " + id, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        this.usersTree.generateDotFile();
                    } else {
                        this.frame.showMessage("El usuario: " + id + ", ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    this.frame.addText.setText("");
                }
            }
        }
    }

    /**
     * Obtener usuario
     *
     * @param id
     * @return
     */
    public User getUser(String id) {
        if (this.usersTree != null) {
            if (!id.strip().isEmpty()) {
                if (!id.contains(" ")) {
                    AVLNode node = usersTree.search(id);
                    if (node != null) {
                        return (User) node.getObject();
                    }
                }
            }
        }

        return null;
    }

    /**
     * Eliminar usuario
     *
     * @param id
     */
    public void delUser(String id) {
        if (this.usersTree != null) {
            if (!id.strip().isEmpty()) {
                if (!id.contains(" ")) {
                    this.usersTree.delete(id);
                    if (this.usersTree.deleted()) {
                        this.frame.showMessage("El usuario: " + id + ", ha sido eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        this.usersTree.generateDotFile();
                    } else {
                        this.frame.showMessage("El usuario: " + id + ", no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            this.frame.showMessage("No existen datos de usarios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Editar usuario
     *
     * @param id
     * @param u
     */
    public void editUser(String id, User u) {
        if (this.usersTree != null) {
            if (!id.strip().isEmpty()) {
                if (!id.contains(" ")) {
                    if (!id.equals(u.getId())) {
                        AVLNode node = this.usersTree.search(id);
                        if (node == null) {
                            this.usersTree.delete(u.getId());
                            u.setId(id);
                            this.usersTree.insert(id, u);
                            this.usersTree.generateDotFile();
                            this.frame.showMessage("El usuario: " + id + ", ha sido editado", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                            this.frame.disableButtons();
                        } else {
                            this.frame.showMessage("El usuario: " + id + ", ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
            }
        }
    }

    public void generateImgById(String str) {
        if (this.layersTree != null) {
            int id = getNumber(str);
            if (id > 0) {
                ListNode node = imgList.search(id);
                if (node != null) {
                    SparseMatrix matrix = new SparseMatrix();

                    Image im = (Image) node.getObject();
                    ObjectList layers = im.getLayers();
                    ListNode aux = layers.getRoot();
                    while (aux != null) {
                        AVLNode avl = (AVLNode) aux.getObject();
                        SparseMatrix m = (SparseMatrix) avl.getObject();
                        System.out.println("m: " + m.getId());
                        createMatrix(m, matrix);
                        aux = aux.getNext();
                    }

                    matrix.generateImgDotFile();
                } else {
                    this.frame.showMessage("El id ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                this.frame.showMessage("El valor ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Generar imagen por recorrido
     *
     * @param number
     * @param type
     */
    public void generateImgByTour(String number, String type) {
        if (this.layersTree != null) {
            //layersTree.generateDotFile();
            int size = getNumber(number);
            if (size > 0 && size <= layersTree.getSize()) {

                /* establecer limite y contador */
                this.limit = size;
                this.count = 0;

                switch (type) {
                    case "InOrden":
                        generateImgInOrden();
                        break;
                    case "PreOrden":
                        generateImgPreOrden();
                        break;
                    case "PostOrden":
                        generateImgPostOrden();
                        break;
                }
            } else {
                this.frame.showMessage("El valor ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void generateImgInOrden() {
        SparseMatrix matrix = new SparseMatrix();
        inOrden(layersTree.getRoot(), matrix);
        matrix.generateImgDotFile();
    }

    private void generateImgPreOrden() {
        SparseMatrix matrix = new SparseMatrix();
        preOrden(layersTree.getRoot(), matrix);
        matrix.generateImgDotFile();
    }

    private void generateImgPostOrden() {
        SparseMatrix matrix = new SparseMatrix();
        postOrden(layersTree.getRoot(), matrix);
        matrix.generateImgDotFile();
    }

    private void inOrden(AVLNode node, SparseMatrix matrix) {
        if (node != null) {
            inOrden(node.getLeft(), matrix);

            createMatrix(node, matrix);

            inOrden(node.getRight(), matrix);
        }
    }

    private void preOrden(AVLNode node, SparseMatrix matrix) {
        if (node != null) {
            createMatrix(node, matrix);

            preOrden(node.getLeft(), matrix);

            preOrden(node.getRight(), matrix);
        }
    }

    private void postOrden(AVLNode node, SparseMatrix matrix) {
        if (node != null) {
            postOrden(node.getLeft(), matrix);

            postOrden(node.getRight(), matrix);

            createMatrix(node, matrix);
        }
    }

    /**
     * crear matriz para generar imagen
     *
     * @param node
     * @param matrix
     */
    private void createMatrix(AVLNode node, SparseMatrix matrix) {
        if (this.count < this.limit) {
            SparseMatrix m = (SparseMatrix) node.getObject();
            System.out.println("matriz: " + m.getId());
            createMatrix(m, matrix);
            count++;
        }
    }

    /**
     * Crear matriz a partir de otras matrices
     *
     * @param m
     * @param matrix
     */
    private void createMatrix(SparseMatrix m, SparseMatrix matrix) {
        MatrixNode aux = m.getRoot().getDown();
        while (aux != null) {
            MatrixNode aux1 = aux.getRight();
            while (aux1 != null) {
                MatrixNode tmp = matrix.searchNode(aux1.getY(), aux1.getX());
                if (tmp != null) {
                    tmp.setColor(aux1.getColor());
                    //System.out.println(tmp.toString());
                } else {
                    //System.out.println(aux1.toString());
                    matrix.insert(aux1.getX(), aux1.getY(), aux1.getColor());
                }

                aux1 = aux1.getRight();
            }
            aux = aux.getDown();
        }
    }

    public void tour(SparseMatrix matrix) {
        MatrixNode aux = matrix.getRoot().getDown();
        while (aux != null) {
            MatrixNode aux1 = aux.getRight();
            while (aux1 != null) {
                System.out.println(aux1.toString());
                aux1 = aux1.getRight();
            }
            aux = aux.getDown();
        }
    }

    /**
     * Parsear entero
     *
     * @param number
     * @return
     */
    private int getNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public AVLTree getLayersTree() {
        return layersTree;
    }

    public CircularList getImgList() {
        return imgList;
    }

    public AVLTree getUsersTree() {
        return usersTree;
    }
}
