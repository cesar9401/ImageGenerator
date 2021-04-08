package com.cesar31.imggenerator.model;

import com.cesar31.imggenerator.structures.ObjectList;

/**
 *
 * @author cesar31
 */
public class Image {

    private int id;
    private ObjectList layers;

    public Image() {
        this.layers = new ObjectList();
    }

    public Image(int id) {
        this();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ObjectList getLayers() {
        return layers;
    }

    public void setLayers(ObjectList layers) {
        this.layers = layers;
    }
}
