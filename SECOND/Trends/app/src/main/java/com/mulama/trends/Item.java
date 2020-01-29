package com.mulama.trends;

public class Item {

    private String name;
    private String design;
    private String origin;
    private String price;
    private int image;

    public Item( int image,String name, String design, String origin, String price) {
        this.name = name;
        this.design = design;
        this.origin = origin;
        this.price = price;
        this.image = image;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}



