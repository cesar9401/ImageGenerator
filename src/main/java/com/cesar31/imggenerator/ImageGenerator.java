package com.cesar31.imggenerator;

import com.cesar31.imggenerator.control.ControlFile;
import com.cesar31.imggenerator.control.ParserController;
import com.cesar31.imggenerator.model.Image;
import com.cesar31.imggenerator.model.User;
import com.cesar31.imggenerator.structures.*;
import com.cesar31.imggenerator.ui.MainFrame;

/**
 *
 * @author cesar31
 */
public class ImageGenerator {

    public static void main(String[] args) {
        //matrixTest();
        //AVLTest();
        //objectListTest();
        //circularListTest();
        //parserTest();

        java.awt.EventQueue.invokeLater(() -> {
            MainFrame view = new MainFrame();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        });
    }

    public static void parserTest() {
        ControlFile control = new ControlFile();
        ParserController controller = new ParserController();

        String data = control.readData("/home/cesar31/Java/ImageGenerator/datos/capas.cap");
        //System.out.println(data);
        AVLTree layers = controller.readLayers(data);
//        if (layers != null) {
//            //layers.generateDotFile();
//            AVLNode node = layers.search("5");
//            if (node != null) {
//                SparseMatrix matrix = (SparseMatrix) node.getObject();
//                matrix.generateDotFile();
//            } else {
//                System.out.println("null");
//            }
//        }

        String images = control.readData("/home/cesar31/Java/ImageGenerator/datos/imagenes.im");
        //System.out.println(images);
        CircularList list = controller.readImages(images);
        if (list != null) {
//            list.generateDotFile();
//            ListNode node = list.search(2);
//            if (node != null) {
//                if (node.getObject() != null) {
//                    Image img = (Image) node.getObject();
//                    //System.out.println("Image: " + img.getId());
//                    img.getLayers().generateDotFile();
//                    System.out.println("Image: " + img.getId());
//                    ObjectList img_list = img.getLayers();
//                    AVLNode n = (AVLNode) img_list.getNode(3).getObject();
//                    System.out.println("AVL: " + n.getId());
//                    SparseMatrix m = (SparseMatrix) n.getObject();
//                    m.generateDotFile();
//                }
//            } else {
//                System.out.println("Node null");
//            }
        }

        String usrs = control.readData("/home/cesar31/Java/ImageGenerator/datos/usuarios.usr");
        System.out.println(usrs);
        AVLTree users = controller.readUsers(usrs);
        if (users != null) {
            System.out.println("Usuarios: " + users.getSize());
            //users.generateDotFile();

            /* Obtener usuario */
            AVLNode node = users.search("cesar2");
            System.out.println("Usuario: " + node.getId());
            User u = (User) node.getObject();
            ObjectList img_u = u.getImages();
            //img_u.generateDotFile();

            ListNode n = img_u.getNode(1);
            System.out.println("n: " + n.getId());
            ListNode m = (ListNode) n.getObject();
            System.out.println("m: " + m.getId());
            Image i = (Image) m.getObject();
            i.getLayers().generateDotFile();
        }
    }

    public static void circularListTest() {
        CircularList list = new CircularList();
        list.insertar(1, "objeto");
        list.insertar(2, "objeto");
        list.insertar(3, "objeto");
        list.insertar(4, "objeto");
        list.insertar(5, "objeto");
        list.insertar(6, "objeto");

        list.delete(6);
        list.delete(1);

        list.delete(4);
        list.delete(2);

        list.delete(3);

        list.insertar(3, "objeto");
        list.insertar(4, "objeto");

        list.generateDotFile();
    }

    public static void objectListTest() {
        ObjectList list = new ObjectList();

        list.insertar(1, "objeto");
        list.insertar(2, "objeto");
        list.insertar(3, "objeto");
        list.insertar(4, "objeto");
        list.insertar(5, "objeto");
        list.insertar(6, "objeto");
        list.insertar(7, "objeto");

        list.getNode(2);

        list.delete(3);

        list.generateDotFile();
    }

    public static void AVLTest() {
        AVLTree tree = new AVLTree();

//        tree.insert(18, "objecto");
//        tree.insert(9, "objecto");
//        tree.insert(25, "objecto");
//        tree.insert(7, "objecto");
//        tree.insert(23, "objecto");
//        tree.insert(29, "objecto");
//        tree.insert(2, "objecto");
//        tree.insert(11, "objecto");
//        tree.insert(10, "objecto");
//        tree.insert(21, "objecto");
//        tree.insert(24, "objecto");
//        tree.insert(8, "objecto");
//        tree.insert(27, "objeto");
//        tree.insert(1, "objeto");
//        tree.delete(21);
//        tree.delete(24);
//        tree.delete(18);
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
