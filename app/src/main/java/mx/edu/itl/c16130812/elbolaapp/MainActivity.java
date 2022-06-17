/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                       Clase donde muestra los botones donde se van interactuar
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jesus Gerardo Gonzalez Ramirez      18130561
:*  Fecha       : 07/mayo/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripci�n : clase donde muestra los botones donde se van interactuar y se mandaran a otras pantallas
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c16130812.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

//--------------------------------------------------------------------------------------------------

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button btnFiesta;
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar la referecnia del boton de la party en la IU
        btnFiesta = findViewById ( R.id.btnFiesta );

        // Registrar este activity como listener de los eventos touch del boton party
        btnFiesta.setOnTouchListener( this );

        // Establecer el canal de audio para reproduccion de musica
        setVolumeControlStream(AudioManager.STREAM_MUSIC );

    }

    //--------------------------------------------------------------------------------------------------

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ( view.getId() == R.id.btnFiesta )
        {
            switch ( motionEvent.getAction() )
            {
                case MotionEvent.ACTION_DOWN: reproducir_audio ();
                break;
                case MotionEvent.ACTION_UP: detener_audio ();
                break;
            }
            return true;
        }
        return false;
    }

    private void reproducir_audio () {
        if ( mediaPlayer == null )
        {
            mediaPlayer = MediaPlayer.create( this, R.raw.tequila );
        }
        mediaPlayer.start();
    }

    //--------------------------------------------------------------------------------------------------

    private void detener_audio () {
        if ( mediaPlayer != null )
        {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    //--------------------------------------------------------------------------------------------------

    public void btnSpotifyClick ( View v ) {
        Intent intent = new Intent ( this, ConciertoActivity.class );
        startActivity( intent );
    }

}