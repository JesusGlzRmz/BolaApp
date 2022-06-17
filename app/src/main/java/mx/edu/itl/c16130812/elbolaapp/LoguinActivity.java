/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                       Clase Para ingregar el usuario y contraseña y editarlos
:*
:*  Archivo     : LoginActivity.java
:*  Autor       : Jesus Gerardo Gonzalez Ramirez      18130561
:*  Fecha       : 07/mayo/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripci�n : clase para ingresar el usuario y contrseña para luego pasar al mainActivity
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c16130812.elbolaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//------------------------------------------------------------------------------------------------

public class LoguinActivity extends AppCompatActivity {

    public static final int CODIGO_USUARIO = 10;
    public static final int CODIGO_CONTRASENA = 20;

    private EditText edtUsuario;
    private EditText edtContrasena;

    //--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);

        // asignamos las referencias a los EditText en la IU
        edtUsuario = findViewById ( R.id.edtUsuario);
        edtContrasena = findViewById ( R.id.edtContrasena );

    }

//--------------------------------------------------------------------------------------------------
    // Boton para pasar al MainActivity

    public void btnEntrarClick (View v) {
        String usuario = edtUsuario.getText().toString();
        String contrasena = edtContrasena.getText().toString();

        if ( usuario .equals ( "admin" ) && contrasena.equals ( "android" ) ) {
            Intent intent = new Intent(this,  MainActivity.class);
            startActivity ( intent );
            finish ( );

        }
        else
            {
            if ( ! usuario.equals( "admin" ) ) {
                edtUsuario.setError("Usuario incorrecto");
            }
            else
                {
                edtContrasena.setError( "Contraseña Incorrecta" );
            }
        }
    }

    //--------------------------------------------------------------------------------------------------
    public void btnUsuarioClick ( View v )
    {
        Intent intent = new Intent( this, LeerDatoActivity.class );
        // establecemos el dato que se traspasara al segundo activity
        intent.putExtra( "usuario", edtUsuario.getText().toString() );
        startActivityForResult( intent, CODIGO_USUARIO );
    }

    //--------------------------------------------------------------------------------------------------
    public void btnContrasenaClick ( View v )
    {
        Intent intent = new Intent( this, LeerDatoActivity.class );
        // establecemos el dato que se traspasara al segundo activity
        intent.putExtra( "contrasena", edtContrasena.getText().toString() );
        startActivityForResult( intent, CODIGO_CONTRASENA );
    }

    //--------------------------------------------------------------------------------------------------
    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data ) {
        super.onActivityResult( requestCode, resultCode, data );
        // Verificar el estado del resultado devuelto por LeerDatoActivity
        if ( resultCode == RESULT_OK )
        {
            if ( requestCode == CODIGO_USUARIO )
            {
                edtUsuario.setText( data.getStringExtra( "dato_nuevo" ) );
            }
            else if ( requestCode == CODIGO_CONTRASENA )
            {
                edtContrasena.setText( data.getStringExtra( "dato_nuevo" ) );
            }
        }
        else if ( resultCode == RESULT_CANCELED )
        {
            // Hacer algo si se cancela la captura del dato nuevo
        }
    }

    //--------------------------------------------------------------------------------------------------
}