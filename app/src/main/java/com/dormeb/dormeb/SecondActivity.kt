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
import com.dormeb.dormeb.enums.Themes
import com.dormeb.dormeb.values.AlphaValues
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class SecondActivity : AppCompatActivity() {

    private lateinit var firstMediaPlayer: MediaPlayer
    private lateinit var secondMediaPlayer: MediaPlayer
    private lateinit var thirdMediaPlayer: MediaPlayer

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
        isRunning = false

        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        firstMediaPlayer = MediaPlayer()
        secondMediaPlayer = MediaPlayer()
        thirdMediaPlayer = MediaPlayer()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val transferList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // this is for most recent android versions
            intent.getParcelableExtra("Sounds", AudiostoPass::class.java)?.audios
        } else { // older android versions
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<AudiostoPass>("Sounds")?.audios
        }

        val passedTheme = intent.getStringExtra("Theme")

        val soundQuantity = verifySoundQuantity(transferList?.size)
        var adStatus = 1

        if (soundQuantity > 2) { // loading ads only if the audio quantity is > 2
            val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()
            // loading ads
            InterstitialAd.load(this, "ca-app-pub-5048096201990671/1271119298", adRequest, object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(tag, adError.toString())
                    mInterstitialAd = null
                    adStatus = 0
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(tag, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                    setupCallBackCalls()
                }

            })
        }

        changeBackgroundTheme(passedTheme)
        initInterfaceComponents()
        initialAnimation()



        if (transferList != null) {
            for (audios in transferList){
                if (audios == SoundsName.RAIN.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.rain)
                        changeImgIcon(1, SoundsName.RAIN)
                        mediaPlayerConfig(1)

                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.rain)
                        changeImgIcon(2, SoundsName.RAIN)
                        mediaPlayerConfig(2)

                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.rain)
                        changeImgIcon(3, SoundsName.RAIN)
                        mediaPlayerConfig(3)

                    }
                }

                else if (audios == SoundsName.THUNDER.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.thunder)
                        changeImgIcon(1, SoundsName.THUNDER)
                        mediaPlayerConfig(1)

                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.thunder)
                        changeImgIcon(2, SoundsName.THUNDER)
                        mediaPlayerConfig(2)

                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.thunder)
                        changeImgIcon(3, SoundsName.THUNDER)
                        mediaPlayerConfig(3)

                    }
                }
                else if (audios == SoundsName.FAN.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.fan)
                        changeImgIcon(1, SoundsName.FAN)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.fan)
                        changeImgIcon(2, SoundsName.FAN)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.fan)
                        changeImgIcon(3, SoundsName.FAN)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.CITY.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.city)
                        changeImgIcon(1, SoundsName.CITY)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.city)
                        changeImgIcon(2, SoundsName.CITY)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.city)
                        changeImgIcon(3, SoundsName.CITY)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.AIR_CONDITIONER.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.air_conditioner)
                        changeImgIcon(1, SoundsName.AIR_CONDITIONER)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.air_conditioner)
                        changeImgIcon(2, SoundsName.AIR_CONDITIONER)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.air_conditioner)
                        changeImgIcon(3, SoundsName.AIR_CONDITIONER)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.FOREST.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.forest)
                        changeImgIcon(1, SoundsName.FOREST)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.forest)
                        changeImgIcon(2, SoundsName.FOREST)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.forest)
                        changeImgIcon(3, SoundsName.FOREST)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.FIREPLACE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.fireplace)
                        changeImgIcon(1, SoundsName.FIREPLACE)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.fireplace)
                        changeImgIcon(2, SoundsName.FIREPLACE)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.fireplace)
                        changeImgIcon(3, SoundsName.FIREPLACE)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.BEACH.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.beach)
                        changeImgIcon(1, SoundsName.BEACH)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.beach)
                        changeImgIcon(2, SoundsName.BEACH)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.beach)
                        changeImgIcon(3, SoundsName.BEACH)
                        mediaPlayerConfig(3)
                    }
                }
                else if (audios == SoundsName.NIGHT_GUARD.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.night_guard)
                        changeImgIcon(1, SoundsName.NIGHT_GUARD)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.night_guard)
                        changeImgIcon(2, SoundsName.NIGHT_GUARD)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.night_guard)
                        changeImgIcon(3, SoundsName.NIGHT_GUARD)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.CLOCK.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.clock)
                        changeImgIcon(1, SoundsName.CLOCK)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.clock)
                        changeImgIcon(2, SoundsName.CLOCK)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.clock)
                        changeImgIcon(3, SoundsName.CLOCK)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.WIND.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.wind)
                        changeImgIcon(1, SoundsName.WIND)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.wind)
                        changeImgIcon(2, SoundsName.WIND)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.wind)
                        changeImgIcon(3, SoundsName.WIND)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.CRICKET.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.cricket)
                        changeImgIcon(1, SoundsName.CRICKET)
                        mediaPlayerConfig(1)
                        firstMediaPlayer.start()
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.cricket)
                        changeImgIcon(2, SoundsName.CRICKET)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.cricket)
                        changeImgIcon(3, SoundsName.CRICKET)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.CICADA.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.cicada)
                        changeImgIcon(1, SoundsName.CICADA)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.cicada)
                        changeImgIcon(2, SoundsName.CICADA)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.cicada)
                        changeImgIcon(3, SoundsName.CICADA)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.WATERFALL.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.waterfall)
                        changeImgIcon(1, SoundsName.WATERFALL)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.waterfall)
                        changeImgIcon(2, SoundsName.WATERFALL)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.waterfall)
                        changeImgIcon(3, SoundsName.WATERFALL)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.GOOSE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.goose)
                        changeImgIcon(1, SoundsName.GOOSE)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.goose)
                        changeImgIcon(2, SoundsName.GOOSE)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.goose)
                        changeImgIcon(3, SoundsName.GOOSE)
                        mediaPlayerConfig(3)
                    }
                }
                if (audios == SoundsName.WHALE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.whale)
                        changeImgIcon(1, SoundsName.WHALE)
                        mediaPlayerConfig(1)
                    }
                    else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.whale)
                        changeImgIcon(2, SoundsName.WHALE)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.whale)
                        changeImgIcon(3, SoundsName.WHALE)
                        mediaPlayerConfig(3)
                    }
                }

                if (audios == SoundsName.DESERT.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.desert)
                        changeImgIcon(1, SoundsName.DESERT)
                        mediaPlayerConfig(1)
                    } else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.desert)
                        changeImgIcon(2, SoundsName.DESERT)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.desert)
                        changeImgIcon(3, SoundsName.DESERT)
                        mediaPlayerConfig(3)
                    }
                }
                if (audios == SoundsName.BIRD.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.bird)
                        changeImgIcon(1, SoundsName.BIRD)
                        mediaPlayerConfig(1)
                    } else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.bird)
                        changeImgIcon(2, SoundsName.BIRD)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.bird)
                        changeImgIcon(3, SoundsName.BIRD)
                        mediaPlayerConfig(3)
                    }
                }
                if (audios == SoundsName.PENGUIN.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.penguin)
                        changeImgIcon(1, SoundsName.PENGUIN)
                        mediaPlayerConfig(1)
                    } else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.penguin)
                        changeImgIcon(2, SoundsName.PENGUIN)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.penguin)
                        changeImgIcon(3, SoundsName.PENGUIN)
                        mediaPlayerConfig(3)
                    }
                }
                if (audios == SoundsName.CAR.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.car)
                        changeImgIcon(1, SoundsName.CAR)
                        mediaPlayerConfig(1)
                    } else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.car)
                        changeImgIcon(2, SoundsName.CAR)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.car)
                        changeImgIcon(3, SoundsName.CAR)
                        mediaPlayerConfig(3)
                    }
                }
                if (audios == SoundsName.CONSTRUCTION_SITE.toString()) {
                    if (!firstMediaPlayer.isPlaying) {
                        firstMediaPlayer = MediaPlayer.create(this, R.raw.construction_site)
                        changeImgIcon(1, SoundsName.CONSTRUCTION_SITE)
                        mediaPlayerConfig(1)
                    } else if (firstMediaPlayer.isPlaying && !secondMediaPlayer.isPlaying) {
                        secondMediaPlayer = MediaPlayer.create(this, R.raw.construction_site)
                        changeImgIcon(2, SoundsName.CONSTRUCTION_SITE)
                        mediaPlayerConfig(2)
                    } else {
                        thirdMediaPlayer = MediaPlayer.create(this, R.raw.construction_site)
                        changeImgIcon(3, SoundsName.CONSTRUCTION_SITE)
                        mediaPlayerConfig(3)
                    }
                }


            }
        }





        binding.firstVolumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // seekbar.progress return a percent value (so i just need to divide /100 to adapt to mediaplayer)
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
            if (binding.btnSleep.tag == getString(R.string.button_tag_wake)) {
                changeComponentsVisibility(1)
                binding.btnSleep.tag = getString(R.string.button_tag_sleep)
            }
            else {
                changeComponentsVisibility(2)
                binding.btnSleep.tag = getString(R.string.button_tag_wake)

            }

        }

        binding.btnPause.setOnClickListener{
            // showing ads before going back to main activity
            if (soundQuantity > 2) { // the ads will only show if there is 3 audios playing

                if (adStatus == 1) { // ad status 1: Was loaded or is being loaded. status 0: Didn't load

                    if (mInterstitialAd != null) {

                        mInterstitialAd?.show(this)
                    } else {

                        Log.d("TAG", "The interstitial ad wasn't ready yet.")
                        displayErrorMsg(2)
                    }
                } else {

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



    private fun setupCallBackCalls() { // ads full screen
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
        intent.putExtra("KeepMainActivity", 2)
        startActivity(intent)
        finish()
    }

    private fun changeComponentsVisibility(i: Int) { // 1 - everything transparent, 2 - show everything
        when(i) {
            1-> {
                isSleeping = true
                binding.btnSleep.setImageResource(R.drawable.wake)
                binding.secondActivity.setBackgroundResource(R.drawable.black_background)
                binding.firstVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.firstVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.secondVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.secondVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.thirdVolumeImg.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.thirdVolumeBar.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                binding.btnPause.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_ALMOST)
                binding.btnSleep.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_ALMOST)
                binding.btnTimer.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
                if (isRunning) {
                    binding.txtTimer.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_ALMOST)
                }
            }
            2-> {
                isSleeping = false
                binding.btnSleep.setImageResource(R.drawable.sleep)
                when (binding.secondActivity.tag) {
                    Themes.SPACE.toString() -> binding.secondActivity.setBackgroundResource(R.drawable.space_second_background)
                    Themes.FOREST.toString() -> binding.secondActivity.setBackgroundResource(R.drawable.forest_second_background)
                    Themes.CITY.toString() -> binding.secondActivity.setBackgroundResource(R.drawable.city_second_background)
                    Themes.BEACH.toString() -> binding.secondActivity.setBackgroundResource(R.drawable.beach_second_background)
                }

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

                if (isRunning) {
                    binding.txtTimer.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MAX)
                }
            }
        }
    }

    private fun showTimerDialogBox() {
        dialog.show()
    }

    private var isRunning : Boolean = false
    private var isSleeping : Boolean = false
    private var count : CountDownTimer? = null

    private fun timerConfig(minTime: Double = 0.1, action: Int = 0) { // action 1 to cancel and action 2 to start
        val convertedTime = minTime * 60000

        when (action) { // 1 to pause // 2 to start a new timer
            1-> {
                count?.cancel()
                isRunning = false
                count = null
                binding.txtTimer.text = getString(R.string.countdown_timer, "00", "00")
                binding.txtTimer.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
            }
            2 -> {
                if (isSleeping) {
                    binding.txtTimer.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_ALMOST)
                }
                else {
                    binding.txtTimer.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)
                }

                count?.cancel()
                count = null
                isRunning = true
                count = object : CountDownTimer(convertedTime.toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        var secsUntilFinish: Int = millisUntilFinished.toInt() / 1000
                        val minUntilFinish: Int = secsUntilFinish  / 60
                        secsUntilFinish %= 60


                        if (secsUntilFinish < 10) {
                            binding.txtTimer.text = getString(R.string.countdown_timer, minUntilFinish.toString(), "0$secsUntilFinish")
                        }
                        else {
                            binding.txtTimer.text = getString(R.string.countdown_timer, minUntilFinish.toString(), secsUntilFinish.toString())
                        }


                    }

                    override fun onFinish() {
                        isRunning = false
                        finish()
                        binding.txtTimer.text = getString(R.string.countdown_timer, "00", "00")
                        binding.txtTimer.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_INITIAL)
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
            2-> Toast.makeText(this, getString(R.string.error_wait_ads), Toast.LENGTH_SHORT).show()
        }
    }

    private fun mediaPlayerConfig(number: Int) {

        when (number) {
            1-> {
                firstMediaPlayer.isLooping = true
                firstMediaPlayer.setVolume(0.5F, 0.5F)
                firstMediaPlayer.start()

            }

            2-> {
                secondMediaPlayer.isLooping = true
                secondMediaPlayer.setVolume(0.5F, 0.5F)
                secondMediaPlayer.start()}

            3-> {
                thirdMediaPlayer.isLooping = true
                thirdMediaPlayer.setVolume(0.5F, 0.5F)
                thirdMediaPlayer.start()}
        }
    }




    private fun changeImgIcon(mediaPlayerNum: Int, nameOfSound: SoundsName){
        when (mediaPlayerNum) {
            1-> {
                when (nameOfSound) {
                    SoundsName.RAIN -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.rain)
                    }

                    SoundsName.THUNDER -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.thunder)
                    }

                    SoundsName.FAN -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.fan)
                    }

                    SoundsName.CITY -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.city)
                    }

                    SoundsName.AIR_CONDITIONER -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.air_conditioner)
                    }

                    SoundsName.NIGHT_GUARD -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.night_guard)
                    }

                    SoundsName.FIREPLACE -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.fireplace)
                    }

                    SoundsName.BEACH -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.beach)
                    }

                    SoundsName.FOREST -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.forest)
                    }

                    SoundsName.CLOCK -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.clock)
                    }

                    SoundsName.WIND -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.wind)
                    }

                    SoundsName.CRICKET -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.cricket)
                    }

                    SoundsName.CICADA -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.cicada)
                    }

                    SoundsName.WATERFALL -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.waterfall)
                    }

                    SoundsName.GOOSE -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.goose)
                    }

                    SoundsName.WHALE -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.whale)
                    }

                    SoundsName.DESERT -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.desert)
                    }

                    SoundsName.BIRD -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.bird)
                    }

                    SoundsName.PENGUIN -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.penguin)
                    }

                    SoundsName.CAR -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.car)
                    }

                    SoundsName.CONSTRUCTION_SITE -> {
                        binding.firstVolumeImg.setImageResource(R.drawable.construction_site)
                    }
                }

            }
            2-> {
                when (nameOfSound) {
                    SoundsName.RAIN -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.rain)
                    }

                    SoundsName.THUNDER -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.thunder)
                    }

                    SoundsName.FAN -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.fan)
                    }

                    SoundsName.CITY -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.city)
                    }

                    SoundsName.AIR_CONDITIONER -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.air_conditioner)
                    }

                    SoundsName.NIGHT_GUARD -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.night_guard)
                    }

                    SoundsName.FIREPLACE -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.fireplace)
                    }

                    SoundsName.BEACH -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.beach)
                    }

                    SoundsName.FOREST -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.forest)
                    }

                    SoundsName.CLOCK -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.clock)
                    }

                    SoundsName.WIND -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.wind)
                    }

                    SoundsName.CRICKET -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.cricket)
                    }

                    SoundsName.CICADA -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.cicada)
                    }

                    SoundsName.WATERFALL -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.waterfall)
                    }

                    SoundsName.GOOSE -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.goose)
                    }

                    SoundsName.WHALE -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.whale)
                    }

                    SoundsName.DESERT -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.desert)
                    }

                    SoundsName.BIRD -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.bird)
                    }

                    SoundsName.PENGUIN -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.penguin)
                    }

                    SoundsName.CAR -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.car)
                    }

                    SoundsName.CONSTRUCTION_SITE -> {
                        binding.secondVolumeImg.setImageResource(R.drawable.construction_site)
                    }
                }
            }
            3 -> {
                when (nameOfSound) {
                    SoundsName.RAIN -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.rain)
                    }

                    SoundsName.THUNDER -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.thunder)
                    }

                    SoundsName.FAN -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.fan)
                    }

                    SoundsName.CITY -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.city)
                    }

                    SoundsName.AIR_CONDITIONER -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.air_conditioner)
                    }

                    SoundsName.NIGHT_GUARD -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.night_guard)
                    }

                    SoundsName.FIREPLACE -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.fireplace)
                    }

                    SoundsName.BEACH -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.beach)
                    }

                    SoundsName.FOREST -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.forest)
                    }

                    SoundsName.CLOCK -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.clock)
                    }

                    SoundsName.WIND -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.wind)
                    }

                    SoundsName.CRICKET -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.cricket)
                    }

                    SoundsName.CICADA -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.cicada)
                    }

                    SoundsName.WATERFALL -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.waterfall)
                    }

                    SoundsName.GOOSE -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.goose)
                    }

                    SoundsName.WHALE -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.whale)
                    }
                    SoundsName.DESERT -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.desert)
                    }

                    SoundsName.BIRD -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.bird)
                    }

                    SoundsName.PENGUIN -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.penguin)
                    }

                    SoundsName.CAR -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.car)
                    }

                    SoundsName.CONSTRUCTION_SITE -> {
                        binding.thirdVolumeImg.setImageResource(R.drawable.construction_site)
                    }
                }
            }
        }
    }

    private fun initInterfaceComponents() {

        initDialogComponents()

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

        binding.txtTimer.alpha = AlphaValues.TRANSPARENCY_INITIAL
    }

    private fun changeBackgroundTheme(passedTheme: String?) {
        when (passedTheme) {
            Themes.SPACE.toString() -> {
                binding.secondActivity.setBackgroundResource(R.drawable.space_second_background)
                binding.secondActivity.tag = Themes.SPACE.toString()
            }
            Themes.FOREST.toString() -> {
                binding.secondActivity.setBackgroundResource(R.drawable.forest_second_background)
                binding.secondActivity.tag = Themes.FOREST.toString()
            }
            Themes.CITY.toString() -> {
                binding.secondActivity.setBackgroundResource(R.drawable.city_second_background)
                binding.secondActivity.tag = Themes.CITY.toString()
            }
            Themes.BEACH.toString() -> {
                binding.secondActivity.setBackgroundResource(R.drawable.beach_second_background)
                binding.secondActivity.tag = Themes.BEACH.toString()
            }
        }
    }

    private fun initDialogComponents() { // timer dialog box
        dialog = Dialog(this@SecondActivity)
        dialog.setContentView(R.layout.dialog_timer)
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawableResource(R.drawable.background_gradient)
        dialog.setCancelable(true)
        val checkQui: CheckBox = dialog.findViewById(R.id.checkQui)
        val checkTri: CheckBox = dialog.findViewById(R.id.checkTri)
        val checkUma: CheckBox = dialog.findViewById(R.id.checkUma)

        // the user cant activate 2 timers at the same time
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