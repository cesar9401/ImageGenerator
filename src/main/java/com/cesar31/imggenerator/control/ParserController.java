package com.cesar31.imggenerator.control;

import com.cesar31.imggenerator.model.Image;
import com.cesar31.imggenerator.parser.ImageLex;
import com.cesar31.imggenerator.parser.ImageParser;
import com.cesar31.imggenerator.structures.AVLNode;
import com.cesar31.imggenerator.structures.AVLTree;
import com.cesar31.imggenerator.structures.CircularList;
import com.cesar31.imggenerator.structures.ListNode;
import com.cesar31.imggenerator.structures.MatrixNode;
import java.io.StringReader;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class ParserController {

    private AVLTree layersTree;
    private CircularList imgList;
    private AVLTree usersTree;

    public ParserController() {
    }

    /**
     * Parsear entrada
     *
     * @param input
     * @return
     */
    private Object parserFile(String input) {
        Object object = null;
        ImageLex lex = new ImageLex(new StringReader(input));
        ImageParser parser = new ImageParser(lex, this);
        try {
            object = parser.parse().value;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        return object;
    }

    /**
     * Arbol avl de capas
     *
     * @param input
     * @return
     */
    public AVLTree readLayers(String input) {
        Object layers = parserFile(input);
        if (layers != null) {
            this.layersTree = (AVLTree) layers;
            return this.layersTree;
        }

        return null;
    }

    /**
     * Lista circulas de imagenes
     *
     * @param input
     * @return
     */
    public CircularList readImages(String input) {
        Object images = parserFile(input);
        if (images != null) {
            this.imgList = (CircularList) images;
            return this.imgList;
        }

        return null;
    }

    /**
     * Arbol avl de usuarios
     *
     * @param input
     * @return
     */
    public AVLTree readUsers(String input) {
        Object users = parserFile(input);
        if (users != null) {
            this.usersTree = (AVLTree) users;
            return this.usersTree;
        }

        return null;
    }

    /**
     * Crear nodos para la matriz
     *
     * @param cells
     * @param color
     * @return
     */
    public MatrixNode getMatrixNode(List<Integer> cells, String color) {
        MatrixNode node = null;
        if (cells.size() == 2) {
            node = new MatrixNode(cells.get(0), cells.get(1), color);
            //System.out.println(node.toString());
        }

        return node;
    }

    /**
     * Crear Imagenes
     *
     * @param id
     * @param layers
     * @return
     */
    public ListNode getImage(int id, List<Integer> layers) {
        Image img = new Image(id);
        if (this.layersTree != null) {
            /* Agregar capas de la imagen */
            layers.forEach(i -> {
                AVLNode node = layersTree.search(i);
                if (node != null) {
                    /* Insertar nodo en lista */
                    img.getLayers().insertar(node.getId(), node);
                } else {
                    System.out.println("La capa: " + i + "que se ha intentado cargar a la imagen: " + id + ", no existe");
                }
            });
        } else {
            System.out.println("No se han cargado capas");
            return null;
        }
        System.out.println("Image: " + img.getId());
        return new ListNode(id, img);
    }
}
