package com.example.server.models.entities;

import java.io.Serializable;
// import java.time.LocalDate;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tbl_karyawan")
public class Karyawan implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "NIK not empty")
    @Column(nullable = false, unique = true)
    private String nik;

    @NotEmpty(message = "Name not empty")
    private String name;

    @NotEmpty(message = "Address not empty")
    @Column(length = 500)
    private String address;

    @NotEmpty(message = "Gender not empty")
    private String gender;

    // @NotEmpty(message = "tanggal lahir tidak boleh kosong")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birth;

    @NotEmpty(message = "Country not empty")
    private String country;

    public Karyawan(){
    };

    public Karyawan(
        Long id, 
        @NotEmpty(message = "NIK not empty") String nik, 
        @NotEmpty(message = "Name not empty") String name, 
        @NotEmpty(message = "Address not empty") String address, 
        @NotEmpty(message = "Gender not empty") String gender,
        @NotNull LocalDate birth,
        @NotEmpty(message = "Country not empty") String country
        ){
        this.id = id;
        this.nik = nik;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
        this.country = country;
    }


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNik(){
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public LocalDate getBirth(){
        return birth;
    }

    public void setBirth(LocalDate birth){
        this.birth = birth;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public static Iterable<Karyawan> findAll() {
        return null;
    }
}
