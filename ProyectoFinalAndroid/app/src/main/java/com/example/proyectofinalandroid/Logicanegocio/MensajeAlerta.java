package com.example.proyectofinalandroid.Logicanegocio;

import com.example.proyectofinalandroid.BaseDatos.BaseDatosUsuario;
import com.example.proyectofinalandroid.Usuario.Usuario;

import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MensajeAlerta {
    private Context context; // se utiliza para poder usar make.toast se llama en un activity o servicio

    public MensajeAlerta(Context context) {this.context = context;}

    // Este método envía un SMS a todos los números de teléfono almacenados en la base de datos
    //Al momento de de enlazar esta clase con un boton en un activity cuando se instancie cambiar mensaje
    //por  "ayuda estoy en peligro" o cualquier otro qu estime conveniente
    public void enviarSMSATodos(BaseDatosUsuario baseDatosUsuario, String mensaje) {
        for (Usuario usuario : baseDatosUsuario.getBDusuario()) {
            enviarSMS(usuario.getNumeroPersonal(), mensaje);

        }

    }


    // Método para enviar un SMS a un número específico con el mensaje proporcionado
    private void enviarSMS(String numero, String mensaje) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numero, null, mensaje, null, null);
            Toast.makeText(context, "SMS enviado a " + numero, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Error al enviar SMS a " + numero, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}