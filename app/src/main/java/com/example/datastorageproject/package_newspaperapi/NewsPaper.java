package com.example.datastorageproject.package_newspaperapi;

public class NewsPaper {
private int id;
private String name;
private String author;
private String title;
private String description;

    public NewsPaper(int id, String name, String author, String title, String description, String urlToImage) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
    }

    private String urlToImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
