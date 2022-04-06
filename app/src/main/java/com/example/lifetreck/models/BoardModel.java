package com.example.lifetreck.models;

public class BoardModel {
    private int image;
    private String description;
    private String buttonText;

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public BoardModel(int image, String description, String buttonText) {
        this.image = image;
        this.description = description;
        this.buttonText = buttonText;

    }
}
