package com.lucaryholt.mytodoapp.Model;

import java.util.UUID;

public class ToDoItem {

    private String id = UUID.randomUUID().toString();
    private String title;
    private String text;
    private String imageName = null;
    private boolean done;

    public ToDoItem(String title, String text) {
        this.title = title;
        this.text = text;
        this.done = false;
    }

    public ToDoItem(String title, String text, String imageName) {
        this.title = title;
        this.text = text;        this.imageName = imageName;
        this.done = false;
    }

    public ToDoItem(String id, String title, String text, boolean done) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.done = done;
    }

    public ToDoItem(String id, String title, String text, String imageName, boolean done) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.imageName = imageName;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageName() {
        return imageName;
    }

    public boolean isDone() {
        return done;
    }

    public void toggleDone() {
        this.done = !done;
    }

    public boolean equals(Object o){
        if (getClass() != o.getClass())
            return false;
        ToDoItem other = (ToDoItem) o;
        return other.getId() == this.id;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
