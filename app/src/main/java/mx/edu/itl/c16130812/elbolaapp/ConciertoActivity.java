/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                        Clase que muestra un video despues de pulsar un boton
:*
:*  Archivo     : ConciertoActivity.java
:*  Autor       : Jesus Gerardo Gonzalez Ramirez      18130561
:*  Fecha       : 07/mayo/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripci�n : clase que muestra un video despues de pulsarlo con la clase Video View, se configura
                   el objeto VideoView para la reproduccion del video
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c16130812.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

 //-------------------------------------------------------------------------------------------------

public class ConciertoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concierto);

        // Configuramos el objeto VideoView para la reproduccion del video
        videoView = findViewById( R.id.videoView );

        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.la_pachanga ;
        Uri uri = Uri.parse( uriPath );
        videoView.setVideoURI( uri );
        videoView.setMediaController( new MediaController( this ) );
        videoView.requestFocus();
        videoView.start();

    }
}
//-------------------------------------------------------------------------------------------------