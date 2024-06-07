package com.dormeb.dormeb

import android.app.Dialog
import android.os.Build
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.databinding.ActivitySecondBinding
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class SecondActivity : AppCompatActivity() {

    private var firstMediaPlayer = MediaPlayer()
    private var secondMediaPlayer = MediaPlayer()
    private var thirdMediaPlayer = MediaPlayer()

    private lateinit var binding: ActivitySecondBinding

    private lateinit var dialog: Dialog

    private var mInterstitialAd: InterstitialAd? = null
    private val tag = "SecondActivityAd"


    override fun onDestroy() {

        if (firstMediaPlayer.isPlaying) {
            Log.d("MediaPlayerReleasing", "Releasing firstMediaPlayer")
            firstMediaPlayer.pause()
            firstMediaPlayer.stop()
            firstMediaPlayer.reset()
            firstMediaPlayer.release()
        }

        if (secondMediaPlayer.isPlaying) {
            Log.d("MediaPlayerReleasing", "Releasing secondMediaPlayer")
            secondMediaPlayer.pause()
            secondMediaPlayer.stop()
            secondMediaPlayer.reset()
            secondMediaPlayer.release()
        }

        if (thirdMediaPlayer.isPlaying) {
            Log.d("MediaPlayerReleasing", "Releasing thirdMediaPlayer")
            thirdMediaPlayer.pause()
            thirdMediaPlayer.stop()
            thirdMediaPlayer.reset()
            thirdMediaPlayer.release()

        }

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

        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()
        // carregando anuncio
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(tag, adError.toString())
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(tag, "Ad was loaded.")
                mInterstitialAd = interstitialAd
                setupCallBackCalls()
            }

        })

        initInterfaceComponents()
        initialAnimation()

        val transferList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // aqui é para versões mais recentes do andoid
            intent.getParcelableExtra("Sounds", AudiostoPass::class.java)?.audios
        } else { // versões mais antigas do android
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<AudiostoPass>("Sounds")?.audios
        }

        val soundQuantity = verifySoundQuantity(transferList?.size)


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

                if (audios == SoundsName.GANSO.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.ganso)
                        changeImgIcon(1, SoundsName.GANSO)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.ganso)
                        changeImgIcon(2, SoundsName.GANSO)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.ganso)
                        changeImgIcon(3, SoundsName.GANSO)
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
            if (binding.btnSleep.tag == getString(R.string.button_tag_wake)) { // animações de  elementos sumindo e ficando tudo escuro
                changeComponentsVisibility(1)
                binding.btnSleep.tag = getString(R.string.button_tag_sleep)
            }
            else {
                changeComponentsVisibility(2)
                binding.btnSleep.tag = getString(R.string.button_tag_wake)

            }

        }

        binding.btnPause.setOnClickListener{
            // exibindo anuncio antes de voltar pra outra tela
            if (soundQuantity > 2) { // o anuncio so aparecerá se tiver tocando 3 audios na hora que der pause
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this)
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.")
                    changeToMainActivity()
                }
            } else {
                changeToMainActivity()
            }
        }

        binding.btnTimer.setOnClickListener{
            showTimerDialogBox()
        }
    }

    private fun setupCallBackCalls() { // setando o anuncio full screen
        Log.d(tag, "ad full screen set up")

        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(tag, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                Log.d(tag, "Ad dismissed fullscreen content.")
                changeToMainActivity()
                mInterstitialAd = null
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                // Called when ad fails to show.
                Log.e(tag, "Ad failed to show fullscreen content.")
                mInterstitialAd = null
                changeToMainActivity()
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(tag, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                firstMediaPlayer.setVolume(0.0F, 0.0f)
                secondMediaPlayer.setVolume(0.0F, 0.0f)
                thirdMediaPlayer.setVolume(0.0F, 0.0f)
                Log.d(tag, "Ad showed fullscreen content.")
            }

        }
    }

    private fun changeToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun changeComponentsVisibility(i: Int) { // 1 - tudo transparente, 2 - aparece tudo
        when(i) {
            1-> {
                binding.btnSleep.setImageResource(R.drawable.acordar)
                binding.secondActivity.setBackgroundResource(R.drawable.fundo_preto)
                binding.firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.btnPause.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_ALMOST)
                binding.btnSleep.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_ALMOST)
                binding.btnTimer.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
            }
            2-> {
                binding.btnSleep.setImageResource(R.drawable.soneca)
                binding.secondActivity.setBackgroundResource(R.drawable.second_background)
                binding.firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MED)

                if (secondMediaPlayer.isPlaying) {
                    if (thirdMediaPlayer.isPlaying) {
                        binding.thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MAX)
                        binding.thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MED)
                    }
                    binding.secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MAX)
                    binding.secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MED)
                }

                binding.btnPause.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MED)
                binding.btnSleep.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MED)
                binding.btnTimer.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MED)
            }
        }


    }

    private fun showTimerDialogBox() {
        dialog.show()
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
        binding.btnPause.animate().setDuration(250).alpha(AlphaValues.TRANSPARENCY_MED)
        binding.btnSleep.animate().setDuration(275).alpha(AlphaValues.TRANSPARENCY_MIN)
        binding.btnTimer.animate().setDuration(275).alpha(AlphaValues.TRANSPARENCY_MED)
    }

    private fun verifySoundQuantity(listSize: Int? = 0): Int {
        when (listSize) {
            0 -> {
                displayErrorMsg(0)
                return 0
            }
            1 -> {
                binding.firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TRANSPARENCY_MED)
                return 1
            }
            2 -> {
                binding.firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TRANSPARENCY_MED)
                binding.secondVolumeBar.animate().setDuration(500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.secondVolumeImg.animate().setDuration(700).alpha(AlphaValues.TRANSPARENCY_MED)
                return 2
            }
            3 -> {
                binding.firstVolumeBar.animate().setDuration(500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.firstVolumeImg.animate().setDuration(700).alpha(AlphaValues.TRANSPARENCY_MED)
                binding.secondVolumeBar.animate().setDuration(500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.secondVolumeImg.animate().setDuration(700).alpha(AlphaValues.TRANSPARENCY_MED)
                binding.thirdVolumeBar.animate().setDuration(500).alpha(AlphaValues.TRANSPARENCY_MAX)
                binding.thirdVolumeImg.animate().setDuration(700).alpha(AlphaValues.TRANSPARENCY_MED)
                return 3
            }
            4 -> {
                displayErrorMsg(1)
                return 4
            }
        }
        return 0
    }

    private fun displayErrorMsg(errorNum: Int) {
        when (errorNum) {
            0-> Toast.makeText(this, getString(R.string.error_no_audio_playing), Toast.LENGTH_SHORT).show()
            1-> Toast.makeText(this, getString(R.string.error_more_audio_than_support), Toast.LENGTH_SHORT).show()
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

                    SoundsName.GANSO -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.ganso)
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

                    SoundsName.GANSO -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.ganso)
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

                    SoundsName.GANSO -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.ganso)
                    }
                }
            }
        }
    }

    private fun initInterfaceComponents() {

        initDialogComponents()

        firstMediaPlayer.setVolume(0.5F, 0.5F)
        secondMediaPlayer.setVolume(0.5F, 0.5F)
        thirdMediaPlayer.setVolume(0.5F, 0.5F)

        binding.firstVolumeBar.progress = 50
        binding.firstVolumeBar.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.secondVolumeBar.progress = 50
        binding.secondVolumeBar.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.thirdVolumeBar.progress = 50
        binding.thirdVolumeBar.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.btnPause.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.btnSleep.tag = getString(R.string.button_tag_wake)
        binding.btnSleep.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.firstVolumeImg.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.secondVolumeImg.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.thirdVolumeImg.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.btnTimer.alpha = AlphaValues.TRANSPARENCY_INITIAL
    }

    private fun initDialogComponents() {
        dialog = Dialog(this@SecondActivity)
        dialog.setContentView(R.layout.dialog_timer)
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawableResource(R.drawable.background_dialog_box)
        dialog.setCancelable(true)
        val checkQui: CheckBox = dialog.findViewById(R.id.checkQui)
        val checkTri: CheckBox = dialog.findViewById(R.id.checkTri)
        val checkUma: CheckBox = dialog.findViewById(R.id.checkUma)


        // configurando os botões para o usuario n ativar 2 tempos de uma vez so
        checkQui.setOnClickListener{
            if (!checkQui.isChecked) {
                timerConfig(action = 1)
            } else {
                if (checkTri.isChecked) {
                    checkTri.isChecked = false
                }
                else if (checkUma.isChecked) {
                    checkUma.isChecked = false
                }
                timerConfig(15.0, 2)
            }
        }

        checkTri.setOnClickListener{
            if (!checkTri.isChecked) {
                timerConfig(action = 1)
            } else {
                if (checkQui.isChecked) {
                    checkQui.isChecked = false
                }
                else if (checkUma.isChecked) {
                    checkUma.isChecked = false
                }
                timerConfig(30.0, 2)
            }
        }

        checkUma.setOnClickListener{
            if (!checkUma.isChecked) {
                timerConfig(action = 1)
            } else {
                if (checkQui.isChecked) {
                    checkQui.isChecked = false
                }
                else if (checkTri.isChecked) {
                    checkTri.isChecked = false
                }
                timerConfig(60.0, 2)
            }

        }
    }
}