package com.example.hosteler.Model;

public class ProductFacilityModel {

    private String featureNumber;
    private String featureName;

    public ProductFacilityModel(String featureNumber, String featureName) {
        this.featureNumber = featureNumber;
        this.featureName = featureName;
    }

    public String getFeatureNumber() {
        return featureNumber;
    }

    public void setFeatureNumber(String featureNumber) {
        this.featureNumber = featureNumber;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
