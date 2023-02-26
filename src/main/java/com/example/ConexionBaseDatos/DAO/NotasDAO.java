package com.example.ConexionBaseDatos.DAO;

import com.example.ConexionBaseDatos.Model.ModeloAlumnos;

import java.util.List;

public interface NotasDAO {
    List<ModeloAlumnos> getAlumnos();


    String insertarAlumno(String nombre, String apellido, String nota);

    String eliminarAlumno(String id);

    String actualizarAlumno(String id, String nombre, String apellido, String nota);
}
