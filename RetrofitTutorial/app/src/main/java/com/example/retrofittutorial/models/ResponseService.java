package com.example.retrofittutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseService {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("nickName")
    @Expose
    private String nickName;

    /**
     * No args constructor for use in serialization
     */
    public ResponseService() {
    }

    /**
     * @param lastName
     * @param nickName
     * @param name
     * @param id
     */
    public ResponseService(int id, String name, String lastName, String nickName) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}