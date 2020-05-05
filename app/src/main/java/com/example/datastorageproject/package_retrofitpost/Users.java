package com.example.datastorageproject.package_retrofitpost;

public class Users{

    private String name;
    private String job;
    private String id;
    private String createdAt;

    public Users(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
