package net.ivanvega.sqliteenandroid.db;

public class Usuario {
     int id;
    String nombre;
    String telefono;
    String email;
    String FechaNacimiento;
    String red_social;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setDechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Usuario(int id, String nombre, String telefono, String email, String FechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.FechaNacimiento=FechaNacimiento;
    }
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public Usuario(int id, String nombre, String telefono, String email, String red_social,String FechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.red_social = red_social;
        this.FechaNacimiento=FechaNacimiento;
    }

    public String getRed_social() {
        return red_social;
    }

    public void setRed_social(String red_social) {
        this.red_social = red_social;
    }


}
