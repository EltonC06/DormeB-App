package com.dormeb.dormeb

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues
import kotlin.concurrent.timer

class SecondActivity : AppCompatActivity() {

    private var firstMediaPlayer = MediaPlayer()
    private var secondMediaPlayer = MediaPlayer()
    private var thirdMediaPlayer = MediaPlayer()

    private lateinit var desligarText: TextView

    private lateinit var quiCheck: CheckBox
    private lateinit var triCheck: CheckBox
    private lateinit var umaCheck: CheckBox


    private lateinit var btnPause: ImageButton
    private lateinit var btnSleep: ImageButton

    private lateinit var firstVolumeBar: SeekBar
    private lateinit var firstVolumeImg: ImageView

    private lateinit var secondVolumeBar: SeekBar
    private lateinit var secondVolumeImg: ImageView

    private lateinit var thirdVolumeBar: SeekBar
    private lateinit var thirdVolumeImg: ImageView

    private lateinit var sleepBackground: ImageView

    private lateinit var thisActivity: View

    override fun onDestroy() {
        firstMediaPlayer.stop()
        firstMediaPlayer.release()

        secondMediaPlayer.stop()
        secondMediaPlayer.release()

        thirdMediaPlayer.stop()
        thirdMediaPlayer.release()

        count?.cancel()

        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        initInterfaceComponents()
        initialAnimation()

        val transferList = intent.getParcelableExtra<AudiostoPass>("Sounds")?.audios // os sons transferidos
        verifySoundQuantity(transferList?.size)

        if (transferList != null) {
            for (audios in transferList){
                if (audios == SoundsName.CHUVA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        changeImgIcon(1, SoundsName.CHUVA)
                        mediaPlayerConfig(1)

                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        changeImgIcon(2, SoundsName.CHUVA)
                        mediaPlayerConfig(2)

                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                        changeImgIcon(3, SoundsName.CHUVA)
                        mediaPlayerConfig(3)

                    }
                }

                else if (audios == SoundsName.TROVAO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        changeImgIcon(1, SoundsName.TROVAO)
                        mediaPlayerConfig(1)

                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        changeImgIcon(2, SoundsName.TROVAO)
                        mediaPlayerConfig(2)

                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                        changeImgIcon(3, SoundsName.TROVAO)
                        mediaPlayerConfig(3)

                    }


                }
                else if (audios == SoundsName.VENTILADOR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        changeImgIcon(1, SoundsName.VENTILADOR)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        changeImgIcon(2, SoundsName.VENTILADOR)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ventilador)
                        changeImgIcon(3, SoundsName.VENTILADOR)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.CIDADE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.cidade)
                        changeImgIcon(1, SoundsName.CIDADE)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.cidade)
                        changeImgIcon(2, SoundsName.CIDADE)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.cidade)
                        changeImgIcon(3, SoundsName.CIDADE)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.CLIMATIZADOR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        changeImgIcon(1, SoundsName.CLIMATIZADOR)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        changeImgIcon(2, SoundsName.CLIMATIZADOR)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.climatizador)
                        changeImgIcon(3, SoundsName.CLIMATIZADOR)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.FLORESTA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        changeImgIcon(1, SoundsName.FLORESTA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        changeImgIcon(2, SoundsName.FLORESTA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.floresta)
                        changeImgIcon(3, SoundsName.FLORESTA)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.FOGUEIRA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        changeImgIcon(1, SoundsName.FOGUEIRA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        changeImgIcon(2, SoundsName.FOGUEIRA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.fogueira)
                        changeImgIcon(3, SoundsName.FOGUEIRA)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.PRAIA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        changeImgIcon(1, SoundsName.PRAIA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        changeImgIcon(2, SoundsName.PRAIA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.praia)
                        changeImgIcon(3, SoundsName.PRAIA)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.GUARDA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.guarda)
                        changeImgIcon(1, SoundsName.GUARDA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.guarda)
                        changeImgIcon(2, SoundsName.GUARDA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.guarda)
                        changeImgIcon(3, SoundsName.GUARDA)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.RELOGIO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.relogio)
                        changeImgIcon(1, SoundsName.RELOGIO)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.relogio)
                        changeImgIcon(2, SoundsName.RELOGIO)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.relogio)
                        changeImgIcon(3, SoundsName.RELOGIO)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.VENTO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.vento)
                        changeImgIcon(1, SoundsName.VENTO)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.vento)
                        changeImgIcon(2, SoundsName.VENTO)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.vento)
                        changeImgIcon(3, SoundsName.VENTO)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.GRILO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.grilo)
                        changeImgIcon(1, SoundsName.GRILO)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.grilo)
                        changeImgIcon(2, SoundsName.GRILO)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.grilo)
                        changeImgIcon(3, SoundsName.GRILO)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.CIGARRA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.cigarra)
                        changeImgIcon(1, SoundsName.CIGARRA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.cigarra)
                        changeImgIcon(2, SoundsName.CIGARRA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.cigarra)
                        changeImgIcon(3, SoundsName.CIGARRA)
                        mediaPlayerConfig(3)
                    }
                }


            }
        }



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

        btnSleep.setOnClickListener{
            if (btnSleep.tag == "wake") { // animações de  elementos sumindo e ficando tudo escuro
                btnSleep.tag = "sleep"

                btnSleep.setImageResource(R.drawable.acordar)

                thisActivity.setBackgroundResource(R.drawable.fundo_preto)

                firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                btnPause.animate().setDuration(2500).alpha(AlphaValues.AlmostTransparent)
                btnSleep.animate().setDuration(2500).alpha(AlphaValues.AlmostTransparent)

                desligarText.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                quiCheck.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                triCheck.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                umaCheck.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

            }
            else {
                btnSleep.tag = "wake"

                btnSleep.setImageResource(R.drawable.soneca)

                thisActivity.setBackgroundResource(R.drawable.second_background)

                firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
                firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
                secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
                thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                btnPause.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)
                btnSleep.animate().setDuration(2500).alpha(AlphaValues.transparencyMedium)

                desligarText.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                quiCheck.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)
                triCheck.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)
                umaCheck.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)


            }

        }

        btnPause.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        quiCheck.setOnClickListener{
            if (!quiCheck.isChecked) {
                timerConfig(action = 1)
            } else {
                if (triCheck.isChecked) {
                    triCheck.isChecked = false
                }
                else if (umaCheck.isChecked) {
                    umaCheck.isChecked = false
                }
                timerConfig(15.0, 2)
            }




        }

        triCheck.setOnClickListener{
            if (!triCheck.isChecked) {
                timerConfig(action = 1)
            } else {
                if (quiCheck.isChecked) {
                    quiCheck.isChecked = false
                }
                else if (umaCheck.isChecked) {
                    umaCheck.isChecked = false
                }
                timerConfig(30.0, 2)
            }




        }

        umaCheck.setOnClickListener{
            if (!umaCheck.isChecked) {
                timerConfig(action = 1)
            } else {
                if (quiCheck.isChecked) {
                    quiCheck.isChecked = false
                }
                else if (triCheck.isChecked) {
                    triCheck.isChecked = false
                }
                timerConfig(60.0, 2)
            }

        }

    }

    var count : CountDownTimer? = null
    private fun timerConfig(minTime: Double = 0.1, action: Int = 0) { // action 1 to cancel and action 2 to start
        val convertedTime = minTime * 60000

        when (action) {
            1-> {
                count?.cancel()
                count = null
            }
            2 -> {
                count?.cancel()
                count = null
                count = object : CountDownTimer(convertedTime.toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                    }

                    override fun onFinish() {
                        finish()
                    }


                }.start()
            }
        }
    }

    private fun initialAnimation() {
        btnPause.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
        btnSleep.animate().setDuration(275).alpha(AlphaValues.transparencyMedium)

        desligarText.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)

        quiCheck.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
        triCheck.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
        umaCheck.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
    }

    private fun verifySoundQuantity(listSize: Int? = 0) {
        when (listSize) {
            0 -> displayErrorMsg(0)
            1 -> {
                firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
            }
            2 -> {
                firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
                secondVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                secondVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
            }
            3 -> {
                firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
                secondVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                secondVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
                thirdVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                thirdVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
            }
        }
    }

    private fun displayErrorMsg(errorNum: Int) {
        when (errorNum) {
            0-> Toast.makeText(this, "Essa mensagem não deveria aparecer aqui", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mediaPlayerConfig(number: Int) {
        println(number)

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


    private fun changeImgIcon(mediaPlayerNum: Int, nameOfSound: SoundsName){
        when (mediaPlayerNum) {
            1-> {
                if (nameOfSound == SoundsName.CHUVA){
                    firstVolumeImg.setImageResource(R.drawable.chuva)
                }
                else if (nameOfSound == SoundsName.TROVAO) {
                    firstVolumeImg.setImageResource(R.drawable.trovao)
                }
                else if (nameOfSound == SoundsName.VENTILADOR) {
                    firstVolumeImg.setImageResource(R.drawable.ventilador)
                }
                else if (nameOfSound == SoundsName.CIDADE) {
                    firstVolumeImg.setImageResource(R.drawable.cidade)
                }
                else if (nameOfSound == SoundsName.CLIMATIZADOR) {
                    firstVolumeImg.setImageResource(R.drawable.climatizador)
                }
                else if (nameOfSound == SoundsName.GUARDA) {
                    firstVolumeImg.setImageResource(R.drawable.guarda)
                }
                else if (nameOfSound == SoundsName.FOGUEIRA) {
                    firstVolumeImg.setImageResource(R.drawable.fogueira)
                }
                else if (nameOfSound == SoundsName.PRAIA) {
                    firstVolumeImg.setImageResource(R.drawable.praia)
                }
                else if (nameOfSound == SoundsName.FLORESTA) {
                    firstVolumeImg.setImageResource(R.drawable.floresta)
                }
                else if (nameOfSound == SoundsName.RELOGIO) {
                    firstVolumeImg.setImageResource(R.drawable.relogio)
                }
                else if (nameOfSound == SoundsName.VENTO) {
                    firstVolumeImg.setImageResource(R.drawable.vento)
                }
                else if (nameOfSound == SoundsName.GRILO) {
                    firstVolumeImg.setImageResource(R.drawable.grilo)
                }
                else if (nameOfSound == SoundsName.CIGARRA) {
                    firstVolumeImg.setImageResource(R.drawable.cigarra)
                }

            }
            2-> {
                if (nameOfSound == SoundsName.CHUVA){
                    secondVolumeImg.setImageResource(R.drawable.chuva)
                }
                else if (nameOfSound == SoundsName.TROVAO) {
                    secondVolumeImg.setImageResource(R.drawable.trovao)
                }
                else if (nameOfSound == SoundsName.VENTILADOR) {
                    secondVolumeImg.setImageResource(R.drawable.ventilador)
                }
                else if (nameOfSound == SoundsName.CIDADE) {
                    secondVolumeImg.setImageResource(R.drawable.cidade)
                }
                else if (nameOfSound == SoundsName.CLIMATIZADOR) {
                    secondVolumeImg.setImageResource(R.drawable.climatizador)
                }
                else if (nameOfSound == SoundsName.GUARDA) {
                    secondVolumeImg.setImageResource(R.drawable.guarda)
                }
                else if (nameOfSound == SoundsName.FOGUEIRA) {
                    secondVolumeImg.setImageResource(R.drawable.fogueira)
                }
                else if (nameOfSound == SoundsName.PRAIA) {
                    secondVolumeImg.setImageResource(R.drawable.praia)
                }
                else if (nameOfSound == SoundsName.FLORESTA) {
                    secondVolumeImg.setImageResource(R.drawable.floresta)
                }
                else if (nameOfSound == SoundsName.RELOGIO) {
                    secondVolumeImg.setImageResource(R.drawable.relogio)
                }
                else if (nameOfSound == SoundsName.VENTO) {
                    secondVolumeImg.setImageResource(R.drawable.vento)
                }
                else if (nameOfSound == SoundsName.GRILO) {
                    secondVolumeImg.setImageResource(R.drawable.grilo)
                }
                else if (nameOfSound == SoundsName.CIGARRA) {
                    secondVolumeImg.setImageResource(R.drawable.cigarra)
                }
            }
            3 ->{
                if (nameOfSound == SoundsName.CHUVA){
                    thirdVolumeImg.setImageResource(R.drawable.chuva)
                }
                else if (nameOfSound == SoundsName.TROVAO) {
                    thirdVolumeImg.setImageResource(R.drawable.trovao)
                }
                else if (nameOfSound == SoundsName.VENTILADOR) {
                    thirdVolumeImg.setImageResource(R.drawable.ventilador)
                }
                else if (nameOfSound == SoundsName.CIDADE) {
                    thirdVolumeImg.setImageResource(R.drawable.cidade)
                }
                else if (nameOfSound == SoundsName.CLIMATIZADOR) {
                    thirdVolumeImg.setImageResource(R.drawable.climatizador)
                }
                else if (nameOfSound == SoundsName.GUARDA) {
                    thirdVolumeImg.setImageResource(R.drawable.guarda)
                }
                else if (nameOfSound == SoundsName.FOGUEIRA) {
                    thirdVolumeImg.setImageResource(R.drawable.fogueira)
                }
                else if (nameOfSound == SoundsName.PRAIA) {
                    thirdVolumeImg.setImageResource(R.drawable.praia)
                }
                else if (nameOfSound == SoundsName.FLORESTA) {
                    thirdVolumeImg.setImageResource(R.drawable.floresta)
                }
                else if (nameOfSound == SoundsName.RELOGIO) {
                    thirdVolumeImg.setImageResource(R.drawable.relogio)
                }
                else if (nameOfSound == SoundsName.VENTO) {
                    thirdVolumeImg.setImageResource(R.drawable.vento)
                }
                else if (nameOfSound == SoundsName.GRILO) {
                    thirdVolumeImg.setImageResource(R.drawable.grilo)
                }
                else if (nameOfSound == SoundsName.CIGARRA) {
                    thirdVolumeImg.setImageResource(R.drawable.cigarra)
                }
            }
        }
    }


    private fun initInterfaceComponents() {

        btnPause = findViewById(R.id.pauseButton)
        btnPause.alpha = AlphaValues.initialTransparency

        btnSleep = findViewById(R.id.btnSleep)
        btnSleep.tag = "wake"
        btnSleep.alpha = AlphaValues.initialTransparency

        firstVolumeBar = findViewById(R.id.firstVolumeBar)
        firstVolumeBar.progress = 50
        firstVolumeBar.alpha = AlphaValues.initialTransparency

        firstVolumeImg = findViewById(R.id.firstVolumeImg)
        firstVolumeImg.alpha = AlphaValues.initialTransparency

        secondVolumeBar = findViewById(R.id.secondVolumeBar)
        secondVolumeBar.progress = 50
        secondVolumeBar.alpha = AlphaValues.initialTransparency

        secondVolumeImg = findViewById(R.id.secondVolumeImg)
        secondVolumeImg.alpha = AlphaValues.initialTransparency

        thirdVolumeBar = findViewById(R.id.thirdVolumeBar)
        thirdVolumeBar.progress = 50
        thirdVolumeBar.alpha = AlphaValues.initialTransparency

        thirdVolumeImg = findViewById(R.id.thirdVolumeImg)
        thirdVolumeImg.alpha = AlphaValues.initialTransparency

        firstMediaPlayer.setVolume(0.5F, 0.5F)
        secondMediaPlayer.setVolume(0.5F, 0.5F)
        thirdMediaPlayer.setVolume(0.5F, 0.5F)

        thisActivity = findViewById<View>(R.id.second_activity) // tentando

        desligarText = findViewById(R.id.turnOffText)
        desligarText.alpha = AlphaValues.initialTransparency

        quiCheck = findViewById(R.id.quinzeCheck)
        quiCheck.alpha = AlphaValues.initialTransparency

        triCheck = findViewById(R.id.trintaCheck)
        triCheck.alpha = AlphaValues.initialTransparency

        umaCheck = findViewById(R.id.umaCheck)
        umaCheck.alpha = AlphaValues.initialTransparency

    }



}