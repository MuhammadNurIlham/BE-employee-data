package com.example.server.models.entities;

import java.io.Serializable;
// import java.time.LocalDate;

// import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="tbl_karyawan")
public class Karyawan implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "nik tidak boleh kosong")
    @Column(nullable = false, unique = true)
    private String nik;

    @NotEmpty(message = "nama tidak boleh kosong")
    private String name;

    @NotEmpty(message = "address tidak boleh kosong")
    @Column(length = 500)
    private String address;

    @NotEmpty(message = "gender tidak boleh kosong")
    private String gender;

    // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @NotEmpty(message = "tanggal lahir tidak boleh kosong")
    private String birth;

    @NotEmpty(message = "negara tidak boleh kosong")
    private String country;

    public Karyawan(){
    };

    public Karyawan(
        Long id, 
        @NotEmpty(message = "nik tidak boleh kosong") String nik, 
        @NotEmpty(message = "nama tidak boleh kosong") String name, 
        @NotEmpty(message = "address tidak boleh kosong") String address, 
        @NotEmpty(message = "gender tidak boleh kosong") String gender,
        @NotEmpty(message = "tanggal lahir tidak boleh kosong") String birth,
        @NotEmpty(message = "negara tidak boleh kosong") String country
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

    public String getBirth(){
        return birth;
    }

    public void setBirth(String birth){
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
