package com.example.ConexionBaseDatos.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "alumnos")
@Entity
@ToString
@EqualsAndHashCode
public class ModeloAlumnos {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellido;

    @Column(name = "Nota")
    private String nota;

    public ModeloAlumnos(int parseInt, String nombre, String apellido, String nota) {
    }

    public ModeloAlumnos(String nombre, String apellido, String nota) {
    }

    public ModeloAlumnos() {

    }
}
