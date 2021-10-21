package com.example.video1_mediaplayer

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView

class MainActivity : Activity(), View.OnClickListener {
    private var btnPlay: Button? = null
    private var btnPause: Button? = null
    private var btnStop: Button? = null
    private var video: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializamos la clase asociandole el fichero de Video
        video = findViewById<View>(R.id.videoView) as VideoView
        val path = "android.resource://" + packageName + "/" + R.raw.video
        video!!.setVideoURI(Uri.parse(path))

        //Obtenemos los tres botones de la interfaz
        btnPlay = findViewById<View>(R.id.buttonPlay) as Button
        btnStop = findViewById<View>(R.id.buttonStop) as Button
        btnPause = findViewById<View>(R.id.buttonPause) as Button

        //Y les asignamos el controlador de eventos
        btnPlay!!.setOnClickListener(this)
        btnStop!!.setOnClickListener(this)
        btnPause!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        when (v.id) {
            R.id.buttonPlay -> //Iniciamos el video
                video!!.start()
            R.id.buttonPause -> //Pausamos el video
                video!!.pause()
            R.id.buttonStop -> {
                //Paramos el video y volvemos a inicializar
                video!!.stopPlayback()
                video!!.seekTo(0)
                video!!.resume()
            }
        }
    }
}

