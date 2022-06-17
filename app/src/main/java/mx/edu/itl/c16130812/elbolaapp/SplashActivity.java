/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                       Clase para cargar el splash y despues pasar el login
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Jesus Gerardo Gonzalez Ramirez      18130561
:*  Fecha       : 07/mayo/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripci�n : clase que hace una transicion al login despues de 3 segundos con el metodo Handler
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c16130812.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//---------------------------------------------------------------------------------------------------

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Hacer la transicion al login despues de 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent ( SplashActivity.this , LoguinActivity.class );
                startActivity ( intent );
                finish ( );
            }
        },3000);

    }
}