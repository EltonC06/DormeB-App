package com.dormeb.dormeb

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.databinding.ActivitySecondBinding
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues

class SecondActivity : AppCompatActivity() {

    private var firstMediaPlayer = MediaPlayer()
    private var secondMediaPlayer = MediaPlayer()
    private var thirdMediaPlayer = MediaPlayer()

    private lateinit var binding: ActivitySecondBinding

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
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

                if (audios == SoundsName.CACHOEIRA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.cachoeira)
                        changeImgIcon(1, SoundsName.CACHOEIRA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.cachoeira)
                        changeImgIcon(2, SoundsName.CACHOEIRA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.cachoeira)
                        changeImgIcon(3, SoundsName.CACHOEIRA)
                        mediaPlayerConfig(3)
                    }
                }


            }
        }



        binding.firstVolumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // seekbar.progress return a percent value (so i just need to divide /2 to adptate to mediaplayer)
                val volume = progress.toFloat().div(100)
                firstMediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.secondVolumeBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress.toFloat().div(100)
                secondMediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.thirdVolumeBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress.toFloat().div(100)
                thirdMediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.btnSleep.setOnClickListener{
            if (binding.btnSleep.tag == "wake") { // animações de  elementos sumindo e ficando tudo escuro
                binding.btnSleep.tag = "sleep"

                binding.btnSleep.setImageResource(R.drawable.acordar)

                binding.secondActivity.setBackgroundResource(R.drawable.fundo_preto)

                binding.firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                binding.firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                binding.secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                binding.secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                binding.thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                binding.thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                binding.btnPause.animate().setDuration(2500).alpha(AlphaValues.AlmostTransparent)
                binding.btnSleep.animate().setDuration(2500).alpha(AlphaValues.AlmostTransparent)

                binding.turnOffText.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

                binding.quiCheck.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                binding.triCheck.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)
                binding.umaCheck.animate().setDuration(2500).alpha(AlphaValues.initialTransparency)

            }
            else {
                binding.btnSleep.tag = "wake"

                binding.btnSleep.setImageResource(R.drawable.soneca)

                binding.secondActivity.setBackgroundResource(R.drawable.second_background)

                binding.firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
                binding.firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                binding.secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
                binding.secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                binding.thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
                binding.thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                binding.btnPause.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)
                binding.btnSleep.animate().setDuration(2500).alpha(AlphaValues.transparencyMedium)

                binding.turnOffText.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)

                binding.quiCheck.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)
                binding.triCheck.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)
                binding.umaCheck.animate().setDuration(2500).alpha(AlphaValues.TransparencyMin)


            }

        }

        binding.btnPause.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.quiCheck.setOnClickListener{
            if (!binding.quiCheck.isChecked) {
                timerConfig(action = 1)
            } else {
                if (binding.triCheck.isChecked) {
                    binding.triCheck.isChecked = false
                }
                else if (binding.umaCheck.isChecked) {
                    binding.umaCheck.isChecked = false
                }
                timerConfig(15.0, 2)
            }




        }

        binding.triCheck.setOnClickListener{
            if (!binding.triCheck.isChecked) {
                timerConfig(action = 1)
            } else {
                if (binding.quiCheck.isChecked) {
                    binding.quiCheck.isChecked = false
                }
                else if (binding.umaCheck.isChecked) {
                    binding.umaCheck.isChecked = false
                }
                timerConfig(30.0, 2)
            }




        }

        binding.umaCheck.setOnClickListener{
            if (!binding.umaCheck.isChecked) {
                timerConfig(action = 1)
            } else {
                if (binding.quiCheck.isChecked) {
                    binding.quiCheck.isChecked = false
                }
                else if (binding.triCheck.isChecked) {
                    binding.triCheck.isChecked = false
                }
                timerConfig(60.0, 2)
            }

        }

    }

    private var count : CountDownTimer? = null
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
        binding.btnPause.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
        binding.btnSleep.animate().setDuration(275).alpha(AlphaValues.transparencyMedium)

        binding.turnOffText.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)

        binding.quiCheck.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
        binding.triCheck.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
        binding.umaCheck.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)
    }

    private fun verifySoundQuantity(listSize: Int? = 0) {
        when (listSize) {
            0 -> displayErrorMsg(0)
            1 -> {
                binding.firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                binding.firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
            }
            2 -> {
                binding.firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                binding.firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
                binding.secondVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                binding.secondVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
            }
            3 -> {
                binding.firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                binding.firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
                binding.secondVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                binding.secondVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
                binding.thirdVolumeBar.animate().setDuration(500).alpha(AlphaValues.TransparencyMax)
                binding.thirdVolumeImg.animate().setDuration(700).alpha(AlphaValues.TransparencyMin)
            }
            4 -> {
                displayErrorMsg(1)
            }
        }
    }

    private fun displayErrorMsg(errorNum: Int) {
        when (errorNum) {
            0-> Toast.makeText(this, "Essa mensagem não deveria aparecer aqui", Toast.LENGTH_SHORT).show()
            1-> Toast.makeText(this, "Há mais áudio do que o aplicativo suporta", Toast.LENGTH_SHORT).show()
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
                when (nameOfSound) {
                    SoundsName.CHUVA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.chuva)
                    }

                    SoundsName.TROVAO -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.trovao)
                    }

                    SoundsName.VENTILADOR -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.ventilador)
                    }

                    SoundsName.CIDADE -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.cidade)
                    }

                    SoundsName.CLIMATIZADOR -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.climatizador)
                    }

                    SoundsName.GUARDA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.guarda)
                    }

                    SoundsName.FOGUEIRA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.fogueira)
                    }

                    SoundsName.PRAIA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.praia)
                    }

                    SoundsName.FLORESTA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.floresta)
                    }

                    SoundsName.RELOGIO -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.relogio)
                    }

                    SoundsName.VENTO -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.vento)
                    }

                    SoundsName.GRILO -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.grilo)
                    }

                    SoundsName.CIGARRA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.cigarra)
                    }

                    SoundsName.CACHOEIRA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.cachoeira)
                    }
                }

            }
            2-> {
                when (nameOfSound) {
                    SoundsName.CHUVA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.chuva)
                    }

                    SoundsName.TROVAO -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.trovao)
                    }

                    SoundsName.VENTILADOR -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.ventilador)
                    }

                    SoundsName.CIDADE -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.cidade)
                    }

                    SoundsName.CLIMATIZADOR -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.climatizador)
                    }

                    SoundsName.GUARDA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.guarda)
                    }

                    SoundsName.FOGUEIRA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.fogueira)
                    }

                    SoundsName.PRAIA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.praia)
                    }

                    SoundsName.FLORESTA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.floresta)
                    }

                    SoundsName.RELOGIO -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.relogio)
                    }

                    SoundsName.VENTO -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.vento)
                    }

                    SoundsName.GRILO -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.grilo)
                    }

                    SoundsName.CIGARRA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.cigarra)
                    }

                    SoundsName.CACHOEIRA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.cachoeira)
                    }
                }
            }
            3 -> {
                when (nameOfSound) {
                    SoundsName.CHUVA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.chuva)
                    }

                    SoundsName.TROVAO -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.trovao)
                    }

                    SoundsName.VENTILADOR -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.ventilador)
                    }

                    SoundsName.CIDADE -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.cidade)
                    }

                    SoundsName.CLIMATIZADOR -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.climatizador)
                    }

                    SoundsName.GUARDA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.guarda)
                    }

                    SoundsName.FOGUEIRA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.fogueira)
                    }

                    SoundsName.PRAIA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.praia)
                    }

                    SoundsName.FLORESTA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.floresta)
                    }

                    SoundsName.RELOGIO -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.relogio)
                    }

                    SoundsName.VENTO -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.vento)
                    }

                    SoundsName.GRILO -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.grilo)
                    }

                    SoundsName.CIGARRA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.cigarra)
                    }

                    SoundsName.CACHOEIRA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.cachoeira)
                    }
                }
            }
        }
    }

    private fun initInterfaceComponents() {

        firstMediaPlayer.setVolume(0.5F, 0.5F)
        secondMediaPlayer.setVolume(0.5F, 0.5F)
        thirdMediaPlayer.setVolume(0.5F, 0.5F)

        binding.firstVolumeBar.progress = 50
        binding.firstVolumeBar.alpha = AlphaValues.initialTransparency

        binding.secondVolumeBar.progress = 50
        binding.secondVolumeBar.alpha = AlphaValues.initialTransparency

        binding.thirdVolumeBar.progress = 50
        binding.thirdVolumeBar.alpha = AlphaValues.initialTransparency

        binding.btnPause.alpha = AlphaValues.initialTransparency

        binding.btnSleep.tag = "wake"
        binding.btnSleep.alpha = AlphaValues.initialTransparency

        binding.firstVolumeImg.alpha = AlphaValues.initialTransparency

        binding.secondVolumeImg.alpha = AlphaValues.initialTransparency

        binding.thirdVolumeImg.alpha = AlphaValues.initialTransparency

        binding.turnOffText.alpha = AlphaValues.initialTransparency

        binding.quiCheck.alpha = AlphaValues.initialTransparency

        binding.triCheck.alpha = AlphaValues.initialTransparency

        binding.umaCheck.alpha = AlphaValues.initialTransparency



    }



}