package com.example.ConexionBaseDatos.Controller;

import com.example.ConexionBaseDatos.DAO.NotasDAO;
import com.example.ConexionBaseDatos.Model.ModeloAlumnos;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnosController {
    @Autowired
    private NotasDAO notasDAO ;

    @GetMapping("/listar")
    public List<ModeloAlumnos> getAlumnos(){
        return notasDAO.getAlumnos();
    }

    @GetMapping("/insertar/{nombre}/{apellido}/{nota}")
    public void insertarAlumno(@PathVariable String nombre, @PathVariable String apellido, @PathVariable String nota){
        notasDAO.insertarAlumno(nombre, apellido, nota);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarAlumno(@PathVariable String id) {
        notasDAO.eliminarAlumno(id);
    }

    @PutMapping("/actualizar/{id}/{nombre}/{apellido}/{nota}")
    public void actualizarAlumno(@PathVariable String id, @PathVariable String nombre, @PathVariable String apellido, @PathVariable String nota){
        notasDAO.actualizarAlumno(id, nombre, apellido, nota);
    }
}
