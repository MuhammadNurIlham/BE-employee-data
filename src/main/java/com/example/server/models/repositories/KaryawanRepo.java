package com.example.server.models.repositories;

import java.util.List;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.server.models.entities.Karyawan;

// import jakarta.websocket.server.PathParam;

public interface KaryawanRepo extends CrudRepository<Karyawan, Long> {

    List<Karyawan> findByNameContains(String name);

    // // search by nik
    // @Query("SELECT k FROM Karyawan k WHERE k.nik = :nik")
    // public Karyawan searchKaryawanByNIK(@PathParam("nik") String nik);
    // // List<Karyawan> searchKaryawanByNIK(String nik);

    // @Query("SELECT k FROM Karyawan k WHERE k.name = :name")
    // public Karyawan searchKaryawanByName(@PathParam("name") String name);
    // // List<Karyawan> searchKaryawanByName(String name);

    // @Query("SELECT nik, name FROM Karyawan WHERE nik LIKE %?1% AND name %?2%")
    // List<Karyawan> searchKaryawanByNIKandName(String nik, String name);
    
}
