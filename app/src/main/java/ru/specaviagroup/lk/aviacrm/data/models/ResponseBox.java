package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseBox {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("article_name")
    private String articleName;

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

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
}

