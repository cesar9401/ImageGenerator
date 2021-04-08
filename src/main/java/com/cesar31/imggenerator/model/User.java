package com.cesar31.imggenerator.model;

import com.cesar31.imggenerator.structures.ObjectList;

/**
 *
 * @author cesar31
 */
public class User {

    private String id;
    private ObjectList images;

    public User() {
        this.images = new ObjectList();
    }

    public User(String id) {
        this();
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectList getImages() {
        return images;
    }

    public void setImages(ObjectList images) {
        this.images = images;
    }
}
