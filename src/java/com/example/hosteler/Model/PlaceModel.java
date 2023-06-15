package com.example.hosteler.Model;

public class PlaceModel {

    private String placeImageLink;
    private String placeName;

    public PlaceModel(String placeImageLink, String placeName) {
        this.placeImageLink = placeImageLink;
        this.placeName = placeName;
    }

    public String getPlaceImageLink() {
        return placeImageLink;
    }

    public void setPlaceImageLink(String placeImageLink) {
        this.placeImageLink = placeImageLink;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
