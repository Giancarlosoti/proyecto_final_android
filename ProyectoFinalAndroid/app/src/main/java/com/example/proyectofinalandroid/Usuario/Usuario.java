package com.example.proyectofinalandroid.Usuario;

import com.example.proyectofinalandroid.BaseDatos.BaseDatosUsuario;

//Atributos de la clase usuario
public class Usuario implements Cliente {
    private String NombreUsuario;
    private String Email;
    private String Contrasena;
    private String NumeroPersonal;
    private String NumeroFamiliar;
    private String Edad;
    private String GrupoDeApoyo;
    private String EnfermedadBase;
    private String Estatura;
    private String Peso;

    //Se instancia la base de datos(lista) en esta clase para generar un guardado automatico
    BaseDatosUsuario baseDatosUsuario = new BaseDatosUsuario();

    //se realizan los setter de la clase para poder ingresar datos
    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        NumeroPersonal = numeroPersonal;
    }
    public void setNumeroFamiliar(String numeroFamiliar){
        NumeroFamiliar = numeroFamiliar;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public void setGrupoDeApoyo(String grupoDeApoyo) {
        GrupoDeApoyo = grupoDeApoyo;
    }

    public void setEnfermedadBase(String enfermedadBase) {EnfermedadBase = enfermedadBase; }
    public void setEstatura(String estatura) {Estatura = estatura; }
    public void setPeso(String peso) {Peso = peso; }

    //se realizan los getter de la clase para poder mostrar los datos del usuario

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getNumeroPersonal() {
        return NumeroPersonal;
    }
    public String getNumeroFamiliar() {
        return NumeroFamiliar;
    }

    public String getEdad() {
        return Edad;
    }

    public String getGrupoDeApoyo() {
        return GrupoDeApoyo;
    }

    public String getEnfermedadBase() {
        return EnfermedadBase;
    }

    public String getEstatura() {
        return Estatura;
    }

    public String getPeso() {
        return Peso;
    }

    @Override
    public void GenerarAlerta() {

    }
  //este metodo es para guardar los datos se puede llamar a la clase y al metodo a traves de un boton guardar
  //el metodo llama a la base de datos y guarda los datos
    @Override
    public void IngresarDatos() {
        baseDatosUsuario.AgregarDatos(this);
    }

//este metodo es para mostrar los datos del usuario se puede llamar al metodo con un boton de mostrar datos
//el metodo llama a la base de datos para mostrar los datos
    @Override
    public void MostrarDatos() {
     baseDatosUsuario.MostrarUsuarios();
    }

}

