/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                       Clase para editar la contraseña y usuario
:*
:*  Archivo     : LeerDatoActivity.java
:*  Autor       : Jesus Gerardo Gonzalez Ramirez      18130561
:*  Fecha       : 07/mayo/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripci�n : clase para editar la contrseña y usuario, se obtiene la referencia del edtiText
                    en la IU para el dato, Se recupera el valor del argumento que viene desde LoginAcivity
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c16130812.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//--------------------------------------------------------------------------------------------------

public class LeerDatoActivity extends AppCompatActivity {

    private EditText edtDato;
    private String llave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_dato);

        // Obtener la referecnia del editText en la IU para el dato
        edtDato = findViewById( R.id.edtDato );

        // Recuperamos el valor del argumento que viene desde LoginActivity
        Intent i = getIntent();
        String dato = i.getStringExtra( "usuario" );
        if ( dato != null )
        {
            edtDato.setText( dato );
            llave = "usuario";
        }
        else
        {
            dato = i.getStringExtra( "contrasena" );
            edtDato.setText( dato );
            llave = "contrasena";
        }

    }

    //--------------------------------------------------------------------------------------------------

    public void btnAceptarClick ( View v ) {
        // Establecemos el valor del resultado que se devolvera a LoginActivity
        Intent intent = getIntent();
        intent.putExtra( "dato_nuevo", edtDato.getText().toString() );
        setResult( RESULT_OK, intent );
        finish();
    }

    //--------------------------------------------------------------------------------------------------

    public void btnCancelarClick ( View v ) {
        setResult( RESULT_CANCELED );
        finish();
    }

}