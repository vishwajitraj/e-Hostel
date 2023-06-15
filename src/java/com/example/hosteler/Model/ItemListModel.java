package com.example.hosteler.Model;

public class ItemListModel {

    private String imageView;
    private String itemName;
    private String itemLocation;
    private String itemCurrentPrice;
    private String itemTotalPrice;
    private String itemDiscount;
    private String rating;
    private String totalRating;

    public ItemListModel(String imageView, String itemName, String itemLocation, String itemCurrentPrice, String itemTotalPrice, String itemDiscount, String rating, String totalRating) {
        this.imageView = imageView;
        this.itemName = itemName;
        this.itemLocation = itemLocation;
        this.itemCurrentPrice = itemCurrentPrice;
        this.itemTotalPrice = itemTotalPrice;
        this.itemDiscount = itemDiscount;
        this.rating = rating;
        this.totalRating = totalRating;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemCurrentPrice() {
        return itemCurrentPrice;
    }

    public void setItemCurrentPrice(String itemCurrentPrice) {
        this.itemCurrentPrice = itemCurrentPrice;
    }

    public String getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(String itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public String getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(String totalRating) {
        this.totalRating = totalRating;
    }
}
