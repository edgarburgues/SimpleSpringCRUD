package com.example.ConexionBaseDatos.DAO;

import com.example.ConexionBaseDatos.Model.ModeloAlumnos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class NotasDAOimp implements NotasDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ModeloAlumnos> getAlumnos() {
        String query = "FROM ModeloAlumnos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public String insertarAlumno(String nombre, String apellido, String nota) {
        ModeloAlumnos nuevoAlumno = new ModeloAlumnos();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setNota(String.valueOf(nota));
        entityManager.persist(nuevoAlumno);
        return "Alumno insertado";
    }

    @Override
    public String eliminarAlumno(String id) {

        ModeloAlumnos alumno = entityManager.find(ModeloAlumnos.class, Integer.parseInt(id));
        entityManager.remove(alumno);

        return null;
    }

    @Override
    public String actualizarAlumno(String id, String nombre, String apellido, String nota) {
        ModeloAlumnos alumno = entityManager.find(ModeloAlumnos.class, Integer.parseInt(id));
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setNota(nota);
        entityManager.merge(alumno);
        return null;
    }

}
