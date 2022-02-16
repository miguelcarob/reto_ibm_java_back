package com.group09.movies.controller;


import com.group09.movies.dto.Message;
import com.group09.movies.entity.Administrator;
import com.group09.movies.service.impl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AdministratorRestController {


    @Autowired
    AdminService adminService;


    @RequestMapping(value = "/administrator/", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateInformationSubscriber(@RequestBody Administrator administrator) {
        Optional<Administrator> administratorOriginal=adminService.findAdminById(administrator.getId());
        if(administratorOriginal.isPresent()){
            administratorOriginal.get().getIdUserCinema().setSurnameUserCinema(administrator.getIdUserCinema().getSurnameUserCinema());
            administratorOriginal.get().getIdUserCinema().setNameUserCinema(administrator.getIdUserCinema().getNameUserCinema());
            Message m = new Message(adminService.updateCinema(administratorOriginal.get()), "200");
            return new ResponseEntity(m, HttpStatus.OK);
        }
        return new ResponseEntity(new Message("No se puede actualizar la información del Administrador","403"), HttpStatus.FORBIDDEN);
    }


    @RequestMapping(value = "/administrator/", method = RequestMethod.GET)
    public ResponseEntity<?> findAllsubscribers() {
        return new ResponseEntity(new Message(adminService.getAllAdministrators(),"200"), HttpStatus.OK);
    }


    @RequestMapping(value = "/administrator/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getsubscriber(@PathVariable("id") int id) {

        try{

            Message m=new Message(adminService.findAdminById(id), "200");
            return new ResponseEntity(m,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new Message("No se encuentra el subscriptor con la información suministrada","403"), HttpStatus.FORBIDDEN);
        }
    }
}
