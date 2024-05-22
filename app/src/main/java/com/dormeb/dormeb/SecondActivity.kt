package com.dormeb.dormeb

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.enums.SoundsName

class SecondActivity : AppCompatActivity() {

    private var firstMediaPlayer = MediaPlayer()
    private var secondMediaPlayer = MediaPlayer()
    private var thirdMediaPlayer = MediaPlayer()


    private lateinit var btnPause: ImageButton

    private lateinit var volumeBar: SeekBar
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
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }

                else if (audios == SoundsName.TROVAO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }


                }
                else if (audios == SoundsName.VENTILADOR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.CIDADE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.CLIMATIZADOR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.FLORESTA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.FOGUEIRA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.PRAIA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.GUARDA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                        firstMediaPlayer.isLooping = true
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                        secondMediaPlayer.isLooping = true
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                        thirdMediaPlayer.isLooping = true
                        thirdMediaPlayer.start()
                    }
                }

            }
        }

        volumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // seekbar.progress return a percent value (so i just need to divide /2 to adptate to mediaplayer)
                var volume = seekBar!!.progress.toFloat() / 2

                println("onProgressChanged: " + seekBar.progress.toFloat())
                // firstMediaPlayer.setVolume(volume, volume)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }


        })

        btnPause.setOnClickListener{

            firstMediaPlayer.stop()
            secondMediaPlayer.stop()
            thirdMediaPlayer.stop()

            finish()
        }


    }




    private fun initInterfaceComponents() {
        btnPause = findViewById(R.id.pauseButton)
        volumeBar = findViewById(R.id.volumeSeekBar)
    }

}