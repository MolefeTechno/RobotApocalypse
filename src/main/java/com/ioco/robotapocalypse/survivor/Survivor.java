package com.ioco.robotapocalypse.survivor;

import jakarta.persistence.*;


@Entity
@Table(name = "Survivors")
public class Survivor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(nullable = false, length = 255)
    private String name;
   
    private Integer age;
   
    @Column(length = 255)
    private String gender;
   
    private Double latitude;
    private Double longitude;
   
    @Column(nullable = false)
    private Integer contaminationReports;
    
    @Column(nullable = false)
    private Boolean isInfected = false;
  
    
    public Survivor(){

    }
   
    public Survivor(String name, Integer age, String gender, double latitude, double longitude,Integer contaminationReports,Boolean isInfected)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contaminationReports = contaminationReports;
        this.isInfected = isInfected;
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public Integer getContaminationReports() {
        return contaminationReports;
    }
    public void setContaminationReports(Integer contaminationReports) {
        this.contaminationReports = contaminationReports;
    }

    public Boolean getIsInfected() {
        return isInfected;
    }

    public void setIsInfected(Boolean isInfected) {
        this.isInfected = isInfected;
    }

    
    @Override
    public String toString() {
        return "Survivor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", latitude="
                + latitude + ", longitude=" + longitude + ", contaminationReports=" + contaminationReports
                + ", isInfected=" + isInfected + "]";
    }
    
}
