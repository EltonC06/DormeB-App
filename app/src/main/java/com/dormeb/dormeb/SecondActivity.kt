package com.dormeb.dormeb

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.R
import com.dormeb.dormeb.enums.SoundsName

class SecondActivity : AppCompatActivity() {

    private var mediaPlayer = MediaPlayer()
    private lateinit var btnPause: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initInterfaceComponents()

        val transferList = intent.getParcelableExtra<AudiostoPass>("Sounds")?.audios // os sons transferidos

        if (transferList != null) {
            for (audios in transferList){
                if (audios == SoundsName.CHUVA.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.TROVAO.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.VENTILADOR.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.CIDADE.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.CLIMATIZADOR.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.arcondicionado)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.FLORESTA.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.FOGUEIRA.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.PRAIA.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.praia)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }
                else if (audios == SoundsName.GUARDA.toString()) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                    mediaPlayer.isLooping = true
                    mediaPlayer.start()
                }

            }
        }

        btnPause.setOnClickListener{
            mediaPlayer.stop()
            finish()
        }


    }




    private fun initInterfaceComponents() {
        btnPause = findViewById(R.id.pauseButton)
    }

}