package com.example.petwear.bean;

//TODO 宠物数据
public class PetBean {
    private Integer petId;
    private String petType;
    private String petName;
    private Integer petSex;

    public PetBean() {
    }

    public PetBean(Integer petId, String petType, String petName, Integer petSex) {
        this.petId = petId;
        this.petType = petType;
        this.petName = petName;
        this.petSex = petSex;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetSex() {
        return petSex;
    }

    public void setPetSex(Integer petSex) {
        this.petSex = petSex;
    }
}
