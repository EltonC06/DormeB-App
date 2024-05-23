package com.dormeb.dormeb

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageButton
import android.widget.SeekBar
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues

class SecondActivity : AppCompatActivity() {

    private var firstMediaPlayer = MediaPlayer()
    private var secondMediaPlayer = MediaPlayer()
    private var thirdMediaPlayer = MediaPlayer()


    private lateinit var btnPause: ImageButton

    private lateinit var firstVolumeBar: SeekBar
    private lateinit var secondVolumeBar: SeekBar
    private lateinit var thirdVolumeBar: SeekBar

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
        initialAnimation()


        val transferList = intent.getParcelableExtra<AudiostoPass>("Sounds")?.audios // os sons transferidos

        if (transferList != null) {
            for (audios in transferList){
                if (audios == SoundsName.CHUVA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }

                else if (audios == SoundsName.TROVAO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }


                }
                else if (audios == SoundsName.VENTILADOR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.CIDADE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.CLIMATIZADOR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.FLORESTA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.FOGUEIRA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.PRAIA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
                else if (audios == SoundsName.GUARDA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                        mediaPlayerConfig(2)
                        secondMediaPlayer.start()
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                        mediaPlayerConfig(3)
                        thirdMediaPlayer.start()
                    }
                }
            }
        }

        verifySoundQuantity()

        firstVolumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // seekbar.progress return a percent value (so i just need to divide /2 to adptate to mediaplayer)
                val volume = progress.toFloat().div(100)
                firstMediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        secondVolumeBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress.toFloat().div(100)
                secondMediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        thirdVolumeBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress.toFloat().div(100)
                thirdMediaPlayer.setVolume(volume, volume)
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

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun initialAnimation() {
        firstVolumeBar.alpha = AlphaValues.TransparencyMax
        btnPause.animate().setDuration(1000).alpha(AlphaValues.TransparencyMin)

    }

    private fun verifySoundQuantity() {
        if (secondMediaPlayer.isPlaying) {
            secondVolumeBar.alpha = AlphaValues.TransparencyMax
        }
        if (thirdMediaPlayer.isPlaying) {
            thirdVolumeBar.alpha = AlphaValues.TransparencyMax
        }
    }

    private fun mediaPlayerConfig(number: Int) {
        when (number) {
            1-> {firstMediaPlayer.isLooping = true
            firstMediaPlayer.setVolume(0.5F, 0.5F)
            firstMediaPlayer.start()}

            2-> {secondMediaPlayer.isLooping = true
            secondMediaPlayer.setVolume(0.5F, 0.5F)
            secondMediaPlayer.start()}

            3-> {thirdMediaPlayer.isLooping = true
            thirdMediaPlayer.setVolume(0.5F, 0.5F)
            thirdMediaPlayer.start()}
        }
    }


    private fun initInterfaceComponents() {

        btnPause = findViewById(R.id.pauseButton)

        firstVolumeBar = findViewById(R.id.firstVolumeBar)
        firstVolumeBar.progress = 50

        secondVolumeBar = findViewById(R.id.secondVolumeBar)
        secondVolumeBar.progress = 50
        secondVolumeBar.alpha = AlphaValues.initialTransparency

        thirdVolumeBar = findViewById(R.id.thirdVolumeBar)
        thirdVolumeBar.progress = 50
        thirdVolumeBar.alpha = AlphaValues.initialTransparency

        firstMediaPlayer.setVolume(0.5F, 0.5F)
        secondMediaPlayer.setVolume(0.5F, 0.5F)
        thirdMediaPlayer.setVolume(0.5F, 0.5F)



    }

}