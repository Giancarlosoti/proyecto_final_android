import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.proyectofinalandroid.MainActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class AccesoMapa {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private Context appContext; // Referencia al contexto de la aplicación

    public AccesoMapa(Context context) {
        appContext = context.getApplicationContext(); // Obtener el contexto de la aplicación
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(appContext);
        setupLocationCallback();
    }

    private void setupLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    double latitud = location.getLatitude();
                    double longitud = location.getLongitude();
                    // Aquí puedes trabajar con la latitud y longitud obtenidas
                }
            }
        };
    }

    public void iniciarActualizacionesUbicacion() {
        if (ContextCompat.checkSelfPermission(appContext, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Si no se tienen permisos, solicitarlos al usuario
            ActivityCompat.requestPermissions((MainActivity) appContext, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            // Si los permisos están otorgados, iniciar actualizaciones de ubicación
            LocationRequest locationRequest = LocationRequest.create();
            locationRequest.setInterval(10000);
            locationRequest.setFastestInterval(5000);
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
        }
    }

    public void detenerActualizacionesUbicacion() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    // Método para manejar la respuesta de solicitud de permisos
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                iniciarActualizacionesUbicacion();
            } else {
                // Manejar el caso cuando el usuario no otorga permisos
            }
        }
    }
}