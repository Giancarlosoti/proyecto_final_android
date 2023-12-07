package com.example.proyectofinalandroid.BaseDatos;

import com.example.proyectofinalandroid.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosUsuario {
    private List<Usuario>BDusuario = new ArrayList<>();

    public void  AgregarDatos (Usuario usuario){
        BDusuario.add(usuario);

    }
    public void MostrarUsuarios() {
        for (Usuario usuario : BDusuario) {
            System.out.println("Nombre: " + usuario.getNombreUsuario());
            System.out.println("Email" + usuario.getEmail());
            System.out.println("Contraseña" + usuario.getContrasena());
            System.out.println("Teléfono Personal: " + usuario.getNumeroPersonal());
            System.out.println("Teléfono Familiar" + usuario.getNumeroFamiliar());
            System.out.println("Edad: " + usuario.getEdad());
            System.out.println("Grupo de apoyo: " + usuario.getGrupoDeApoyo());
            System.out.println("Enfermedad Base" + usuario.getEnfermedadBase());
            System.out.println("Estatura" + usuario.getEstatura());
            System.out.println("Peso" + usuario.getPeso());

            System.out.println("---------------------------");
        }
    }

    public List<Usuario> getBDusuario() {
        return BDusuario;
    }
}


