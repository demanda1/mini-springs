package org.example.async;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
    private String name;
    private String blog;

    public User() {
        // Default constructor needed by Jackson
    }

    public String getName() {
        return name;
    }

    public User(String name, String blog) {
        this.name = name;
        this.blog = blog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }
}
