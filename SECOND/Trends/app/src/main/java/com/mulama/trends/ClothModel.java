package com.mulama.trends;

public class ClothModel {
    private String name;
    private String design;
    private String origin;
    private String price;
    private String image;
    String pushId;



    public ClothModel( String name, String design, String origin, String price) {
        this.name = name;
        this.design = design;
        this.origin = origin;
        this.price = price;

    }
    public ClothModel() {
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
