package com.example.server.services;


import java.util.List;
// import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.models.entities.Karyawan;
import com.example.server.models.repositories.KaryawanRepo;

import jakarta.validation.Valid;

@Service
@Transactional
public class KaryawanService {
    

    @Autowired
    private KaryawanRepo karyawanRepo;

    /**
     * @param karyawan
     * @return
     */
    public Karyawan save(Karyawan karyawan) {
        return karyawanRepo.save(karyawan);
    }

    public Karyawan findOne(Long id) {
        Optional<Karyawan> karyawan = karyawanRepo.findById(id);
        if(!karyawan.isPresent()){
            return null;
        }
        return karyawan.get();
    }

    public Iterable<Karyawan> findAll(){
        return karyawanRepo.findAll();
    }

    public void removeOne(Long id){
        karyawanRepo.deleteById(id);
    }

    public List<Karyawan> findEmployeeByName(String name){
        return karyawanRepo.findByNameContains(name);
    }

    public List<Karyawan> findDataEmployees(String nik, String name){
        List<Karyawan> karyawanData = null;

        if(nik != "" && name == ""){
            karyawanData = karyawanRepo.findByNik(nik);
        } else if (nik == "" && name != "") {
            karyawanData = karyawanRepo.findByName(name);
        } else {
            karyawanData = karyawanRepo.findByNikAndName(nik, name);
        }
        return karyawanData;
        }

        public Karyawan create(@Valid Karyawan karyawan){
            return null;
        }

    // search by nik
    // public Karyawan findByNik(String nik){
    //     return karyawanRepo.findByNik(nik);
    // }

    // search by name
    // public Karyawan findByName(String name) {
    //     return karyawanRepo.findByName(name);
    // }

    // search by full name
    // public List<Karyawan> findByNameLike(String name){
    //     return karyawanRepo.findByNameLike("%"+name+"%");
    // }

   
}

