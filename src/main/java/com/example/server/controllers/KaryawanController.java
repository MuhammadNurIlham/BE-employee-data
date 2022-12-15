package com.example.server.controllers;

import java.util.List;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.dto.ResponseData;
import com.example.server.dto.SearchKaryawan;
import com.example.server.models.entities.Karyawan;
import com.example.server.services.KaryawanService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/karyawan")
public class KaryawanController {
    

    @Autowired
    private KaryawanService karyawanService;

    @PostMapping
    public ResponseEntity<ResponseData<Karyawan>> create(@Valid @RequestBody Karyawan karyawan, Errors errors) {

        ResponseData<Karyawan> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(karyawanService.save(karyawan));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Karyawan> findAll(){
        return karyawanService.findAll();
    }

    @GetMapping("/{id}")
    public Karyawan findOne(@PathVariable("id") Long id){
        return karyawanService.findOne(id);
    }

    // @PutMapping
    @PatchMapping
    public ResponseEntity<ResponseData<Karyawan>> update(@Valid @RequestBody Karyawan karyawan, Errors errors ){

        ResponseData<Karyawan> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(karyawanService.save(karyawan));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        karyawanService.removeOne(id);
    }

    // @PostMapping("/search")
    // public List<Karyawan> search(@RequestBody Karyawan karyawan){
    //     return karyawanService.searchKaryawan(karyawan.getNik(), karyawan.getName());
    // }

    // @PostMapping("/search/name")
    // public Karyawan getKaryawanByName(@RequestBody com.example.server.dto.SearchKaryawan SearchKaryawan){
    //     return karyawanService.findByName(SearchKaryawan.getSearchKey());
    // }

    // search by nik
    @PostMapping("/search/nik")
    public Karyawan getKaryawanByNik(@RequestBody SearchKaryawan searchKaryawan){
return karyawanService.findByNik(searchKaryawan.getSearchKey());
    }

    // search by name
    @PostMapping("/search/name")
    public Karyawan getKaryawanByName(@RequestBody SearchKaryawan searchKaryawan) {
        return karyawanService.findByName(searchKaryawan.getSearchKey());
    }

    // search by full name
    @PostMapping("/search/fullname")
    public List<Karyawan> getKaryawanByNameLike(@RequestBody SearchKaryawan searchKaryawan) {
        return karyawanService.findByNameLike(searchKaryawan.getSearchKey());
    }


}
