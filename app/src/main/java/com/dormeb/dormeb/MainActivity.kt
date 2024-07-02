package com.dormeb.dormeb

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.databinding.ActivityMainBinding
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.enums.Themes
import com.dormeb.dormeb.values.AlphaValues

class MainActivity : AppCompatActivity() {

    private lateinit var dialogSupport: Dialog
    private lateinit var dialogThemes: Dialog
    private lateinit var binding: ActivityMainBinding
    private var selectCount = 0

    private fun welcomeActivity(num: Int) {
        when (num) {
            1 -> {  // 1 because its opening (or reopening) the app
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)
                finish()


            }
            2 -> { // 2 is because the user passed from second activity or first to the main activity, so it wont show the welcome screen (first activity)


            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val keepMainActivity: Int = intent.getIntExtra("KeepMainActivity", 1) // 1 is a default value. This value make the app open the welcome screen (first activity)

        welcomeActivity(keepMainActivity)

        initInterfaceComponents()

        dialogSupport = Dialog(this@MainActivity)
        dialogSupport.setContentView(R.layout.dialog_support)
        dialogSupport.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )



        initialAnimation()
        val audiosArray = arrayOf(
            binding.imgBtnRain,
            binding.imgBtnThunder,
            binding.imgBtnFan,
            binding.imgBtnAirConditioner,
            binding.imgBtnCity,
            binding.imgBtnForest,
            binding.imgBtnFireplace,
            binding.imgBtnBeach,
            binding.imgBtnNightGuard,
            binding.imgBtnClock,
            binding.imgBtnWind,
            binding.imgBtnCricket,
            binding.imgBtnCicada,
            binding.imgBtnWaterfall,
            binding.imgBtnGoose,
            binding.imgBtnWhale,
            binding.imgBtnBird,
            binding.imgBtnDesert,
            binding.imgBtnCar,
            binding.imgBtnConstructionSite,
            binding.imgBtnPenguin

        )
        // the code to pass to second activity will pass through this list and verify the audios who is tagged "pressed"


        binding.btnNatural.setOnClickListener{
            binding.verticalScroll.smoothScrollTo(0,binding.textCatNat.y.toInt())

        }

        binding.btnWater.setOnClickListener{
            binding.verticalScroll.smoothScrollTo(0,binding.textCatWat.y.toInt())

        }

        binding.btnAnimal.setOnClickListener{
            binding.verticalScroll.smoothScrollTo(0,binding.textCatAni.y.toInt())

        }

        binding.btnUrban.setOnClickListener{
            binding.verticalScroll.smoothScrollTo(0,binding.textCatUrb.y.toInt())

        }

        binding.imgBtnRain.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnRain.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.RAIN, 2)
                binding.imgBtnRain.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.RAIN, 1)
                binding.imgBtnRain.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnThunder.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnThunder.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.THUNDER, 2)
                binding.imgBtnThunder.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.THUNDER, 1)
                binding.imgBtnThunder.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }

        }

        binding.imgBtnFan.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnFan.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.FAN, 2)
                binding.imgBtnFan.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.FAN, 1)
                binding.imgBtnFan.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnNightGuard.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnNightGuard.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.NIGHT_GUARD, 2)
                binding.imgBtnNightGuard.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.NIGHT_GUARD, 1)
                binding.imgBtnNightGuard.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCity.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCity.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.CITY, 2)
                binding.imgBtnCity.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.CITY, 1)
                binding.imgBtnCity.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnAirConditioner.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnAirConditioner.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.AIR_CONDITIONER, 2)
                binding.imgBtnAirConditioner.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.AIR_CONDITIONER, 1)
                binding.imgBtnAirConditioner.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnForest.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnForest.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.FOREST, 2)
                binding.imgBtnForest.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.FOREST, 1)
                binding.imgBtnForest.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnBeach.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnBeach.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.BEACH, 2)
                binding.imgBtnBeach.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.BEACH, 1)
                binding.imgBtnBeach.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnFireplace.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnFireplace.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.FIREPLACE, 2)
                binding.imgBtnFireplace.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.FIREPLACE, 1)
                binding.imgBtnFireplace.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnClock.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnClock.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.CLOCK, 2)
                binding.imgBtnClock.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.CLOCK, 1)
                binding.imgBtnClock.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnWind.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnWind.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.WIND, 2)
                binding.imgBtnWind.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.WIND, 1)
                binding.imgBtnWind.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCricket.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCricket.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.CRICKET, 2)
                binding.imgBtnCricket.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.CRICKET, 1)
                binding.imgBtnCricket.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCicada.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCicada.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.CICADA, 2)
                binding.imgBtnCicada.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.CICADA, 1)
                binding.imgBtnCicada.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnWaterfall.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnWaterfall.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.WATERFALL, 2)
                binding.imgBtnWaterfall.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.WATERFALL, 1)
                binding.imgBtnWaterfall.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnGoose.setOnClickListener{
            changeScrollsVisibility(2)

            if (binding.imgBtnGoose.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.GOOSE, 2)
                binding.imgBtnGoose.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.GOOSE, 1)
                binding.imgBtnGoose.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnWhale.setOnClickListener{
            changeScrollsVisibility(2)

            if (binding.imgBtnWhale.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.WHALE, 2)
                binding.imgBtnWhale.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.WHALE, 1)
                binding.imgBtnWhale.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnPenguin.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnPenguin.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.PENGUIN, 2)
                binding.imgBtnPenguin.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.PENGUIN, 1)
                binding.imgBtnPenguin.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnBird.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnBird.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.BIRD, 2)
                binding.imgBtnBird.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.BIRD, 1)
                binding.imgBtnBird.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCar.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCar.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.CAR, 2)
                binding.imgBtnCar.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.CAR, 1)
                binding.imgBtnCar.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnDesert.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnDesert.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.DESERT, 2)
                binding.imgBtnDesert.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.DESERT, 1)
                binding.imgBtnDesert.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnConstructionSite.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnConstructionSite.tag == getString(R.string.button_pressed)) {
                changeImgButtonAndText(SoundsName.CONSTRUCTION_SITE, 2)
                binding.imgBtnConstructionSite.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonAndText(SoundsName.CONSTRUCTION_SITE, 1)
                binding.imgBtnConstructionSite.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        // migrating all data to another class VVV

        binding.imgBtnPlay.setOnClickListener {
            if (selectCount == 0) { // cant press play without choosing at least 1 audio
                displayErrorMsg(2)
            } else {
                // Me
                val audioMutable = mutableListOf<String>()
                for (audio in audiosArray) { // list with all buttons (this "for" will go through the list and verify what audios are tagged "pressed")
                    if (audio.tag == getString(R.string.button_pressed)) {
                        audioMutable.add(audio.contentDescription.toString()) // the contentDescription of audio matches with its enum equivalent
                    }
                }

                val transfer = AudiostoPass(audioMutable)
                val themeToPass = verifyTheme()

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Sounds", transfer) // passing as string the name of audios to be played
                intent.putExtra("Theme", themeToPass)

                startActivity(intent)
                finish()
            }
        }

        binding.verticalScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            changeScrollsVisibility(2)
        }

        binding.horizontalScroll.setOnScrollChangeListener{ _, _, _, _, _ ->
            changeScrollsVisibility(1)
        }


        binding.imgBtnInfo.setOnClickListener {

            dialogSupport.show()

        }

        binding.imgBtnTheme.setOnClickListener{

            dialogThemes.show()

        }

    }

    private fun displayErrorMsg(context: Int) {
        when (context) {
            1 -> Toast.makeText(
                this,
                getString(R.string.error_max_audio_capacity_reached), Toast.LENGTH_SHORT
            ).show() // error message if the user try to choose 4 audios to play
            2 -> Toast.makeText(
                this,
                getString(R.string.error_min_audio_quantity_to_play), Toast.LENGTH_SHORT
            ).show()

            3 -> Toast.makeText(
                this,
                "The app can't run without any theme", Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun changeScrollsVisibility(num: Int) {
        when (num) {
            1 -> {
                binding.horizontalScroll.alpha = AlphaValues.TRANSPARENCY_MAX
                binding.horizontalScroll.animate().setDuration(15000)
                    .alpha(AlphaValues.TRANSPARENCY_ALMOST)

            }

            2 -> {
                binding.verticalScroll.alpha = AlphaValues.TRANSPARENCY_MAX
                binding.verticalScroll.animate().setDuration(15000)
                    .alpha(AlphaValues.TRANSPARENCY_ALMOST)
            }
        }

    }

    private fun changeImgButtonAndText(enum: SoundsName, playOrPause: Int
    ) { // 1 - play and 2 - pause
        when (playOrPause) {
            1 -> {
                when (enum) {
                    SoundsName.RAIN -> {
                        binding.imgBtnRain.setImageResource(R.drawable.rain_pressed)
                        changeMusicAndDescText(SoundsName.RAIN)
                    }

                    SoundsName.THUNDER -> {
                        binding.imgBtnThunder.setImageResource(R.drawable.thunder_pressed)
                        changeMusicAndDescText(SoundsName.THUNDER)
                    }

                    SoundsName.FAN -> {
                        binding.imgBtnFan.setImageResource(R.drawable.fan_pressed)
                        changeMusicAndDescText(SoundsName.FAN)
                    }

                    SoundsName.NIGHT_GUARD -> {
                        binding.imgBtnNightGuard.setImageResource(R.drawable.night_guard_pressed)
                        changeMusicAndDescText(SoundsName.NIGHT_GUARD)
                    }

                    SoundsName.CITY -> {
                        binding.imgBtnCity.setImageResource(R.drawable.city_pressed)
                        changeMusicAndDescText(SoundsName.CITY)
                    }

                    SoundsName.AIR_CONDITIONER -> {
                        binding.imgBtnAirConditioner.setImageResource(R.drawable.air_conditioner_pressed)
                        changeMusicAndDescText(SoundsName.AIR_CONDITIONER)
                    }

                    SoundsName.FOREST -> {
                        binding.imgBtnForest.setImageResource(R.drawable.forest_pressed)
                        changeMusicAndDescText(SoundsName.FOREST)
                    }

                    SoundsName.BEACH -> {
                        binding.imgBtnBeach.setImageResource(R.drawable.beach_pressed)
                        changeMusicAndDescText(SoundsName.BEACH)
                    }

                    SoundsName.FIREPLACE -> {
                        binding.imgBtnFireplace.setImageResource(R.drawable.fireplace_pressed)
                        changeMusicAndDescText(SoundsName.FIREPLACE)
                    }

                    SoundsName.CLOCK -> {
                        binding.imgBtnClock.setImageResource(R.drawable.clock_pressed)
                        changeMusicAndDescText(SoundsName.CLOCK)
                    }

                    SoundsName.CICADA -> {
                        binding.imgBtnCicada.setImageResource(R.drawable.cicada_pressed)
                        changeMusicAndDescText(SoundsName.CICADA)
                    }

                    SoundsName.CRICKET -> {
                        binding.imgBtnCricket.setImageResource(R.drawable.cricket_pressed)
                        changeMusicAndDescText(SoundsName.CRICKET)
                    }

                    SoundsName.WIND -> {
                        binding.imgBtnWind.setImageResource(R.drawable.wind_pressed)
                        changeMusicAndDescText(SoundsName.WIND)
                    }

                    SoundsName.WATERFALL -> {
                        binding.imgBtnWaterfall.setImageResource(R.drawable.waterfall_pressed)
                        changeMusicAndDescText(SoundsName.WATERFALL)
                    }

                    SoundsName.GOOSE -> {
                        binding.imgBtnGoose.setImageResource(R.drawable.goose_pressed)
                        changeMusicAndDescText(SoundsName.GOOSE)
                    }

                    SoundsName.WHALE -> {
                        binding.imgBtnWhale.setImageResource(R.drawable.whale_pressed)
                        changeMusicAndDescText(SoundsName.WHALE)
                    }

                    SoundsName.DESERT -> {
                        binding.imgBtnDesert.setImageResource(R.drawable.desert_pressed)
                        changeMusicAndDescText(SoundsName.DESERT)
                    }

                    SoundsName.BIRD -> {
                        binding.imgBtnBird.setImageResource(R.drawable.bird_pressed)
                        changeMusicAndDescText(SoundsName.BIRD)
                    }

                    SoundsName.PENGUIN -> {
                        binding.imgBtnPenguin.setImageResource(R.drawable.penguin_pressed)
                        changeMusicAndDescText(SoundsName.PENGUIN)
                    }

                    SoundsName.CAR -> {
                        binding.imgBtnCar.setImageResource(R.drawable.car_pressed)
                        changeMusicAndDescText(SoundsName.CAR)
                    }

                    SoundsName.CONSTRUCTION_SITE -> {
                        binding.imgBtnConstructionSite.setImageResource(R.drawable.construction_site_pressed)
                        changeMusicAndDescText(SoundsName.CONSTRUCTION_SITE)
                    }
                }
            }

            2 -> {
                when (enum) {
                    SoundsName.RAIN -> binding.imgBtnRain.setImageResource(R.drawable.rain)
                    SoundsName.THUNDER -> binding.imgBtnThunder.setImageResource(R.drawable.thunder)
                    SoundsName.FAN -> binding.imgBtnFan.setImageResource(R.drawable.fan)
                    SoundsName.NIGHT_GUARD -> binding.imgBtnNightGuard.setImageResource(R.drawable.night_guard)
                    SoundsName.CITY -> binding.imgBtnCity.setImageResource(R.drawable.city)
                    SoundsName.AIR_CONDITIONER -> binding.imgBtnAirConditioner.setImageResource(R.drawable.air_conditioner)
                    SoundsName.FOREST -> binding.imgBtnForest.setImageResource(R.drawable.forest)
                    SoundsName.BEACH -> binding.imgBtnBeach.setImageResource(R.drawable.beach)
                    SoundsName.FIREPLACE -> binding.imgBtnFireplace.setImageResource(R.drawable.fireplace)
                    SoundsName.CLOCK -> binding.imgBtnClock.setImageResource(R.drawable.clock)
                    SoundsName.CICADA -> binding.imgBtnCicada.setImageResource(R.drawable.cicada)
                    SoundsName.CRICKET -> binding.imgBtnCricket.setImageResource(R.drawable.cricket)
                    SoundsName.WIND -> binding.imgBtnWind.setImageResource(R.drawable.wind)
                    SoundsName.WATERFALL -> binding.imgBtnWaterfall.setImageResource(R.drawable.waterfall)
                    SoundsName.GOOSE -> binding.imgBtnGoose.setImageResource(R.drawable.goose)
                    SoundsName.WHALE -> binding.imgBtnWhale.setImageResource(R.drawable.whale)
                    SoundsName.DESERT -> binding.imgBtnDesert.setImageResource(R.drawable.desert)
                    SoundsName.BIRD -> binding.imgBtnBird.setImageResource(R.drawable.bird)
                    SoundsName.PENGUIN -> binding.imgBtnPenguin.setImageResource(R.drawable.penguin)
                    SoundsName.CAR -> binding.imgBtnCar.setImageResource(R.drawable.car)
                    SoundsName.CONSTRUCTION_SITE -> binding.imgBtnConstructionSite.setImageResource(R.drawable.construction_site)
                }
            }
        }

    }

    private fun changeMusicAndDescText(enum: SoundsName) {
        binding.txtAudioName.alpha = AlphaValues.TRANSPARENCY_FULL
        binding.txtAudioDesc.alpha = AlphaValues.TRANSPARENCY_FULL

        binding.txtAudioName.animate().setDuration(15000).alpha(AlphaValues.TRANSPARENCY_ALMOST)
        binding.txtAudioDesc.animate().setDuration(15000).alpha(AlphaValues.TRANSPARENCY_ALMOST)
        when (enum) {
            SoundsName.RAIN -> {// the enum class resumed the code and its complexity
                binding.txtAudioName.text = getString(R.string.audio_rain)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_rain)
            }

            SoundsName.THUNDER -> {
                binding.txtAudioName.text = getString(R.string.audio_thunder)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_thunder)
            }

            SoundsName.FAN -> {
                binding.txtAudioName.text = getString(R.string.audio_fan)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_fan)
            }

            SoundsName.NIGHT_GUARD -> {
                binding.txtAudioName.text = getString(R.string.audio_night_guard)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_night_guard)
            }

            SoundsName.CITY -> {
                binding.txtAudioName.text = getString(R.string.audio_street)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_street)
            }

            SoundsName.FOREST -> {
                binding.txtAudioName.text = getString(R.string.audio_forest)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_forest)
            }

            SoundsName.AIR_CONDITIONER -> {
                binding.txtAudioName.text = getString(R.string.audio_air_conditioner)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_air_conditioner)
            }

            SoundsName.BEACH -> {
                binding.txtAudioName.text = getString(R.string.audio_beach)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_beach)
            }

            SoundsName.FIREPLACE -> {
                binding.txtAudioName.text = getString(R.string.audio_fireplace)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_fireplace)
            }

            SoundsName.CLOCK -> {
                binding.txtAudioName.text = getString(R.string.audio_clock)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_clock)
            }

            SoundsName.CICADA -> {
                binding.txtAudioName.text = getString(R.string.audio_cicada)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_cicada)
            }

            SoundsName.CRICKET -> {
                binding.txtAudioName.text = getString(R.string.audio_cricket)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_cricket)
            }

            SoundsName.WIND -> {
                binding.txtAudioName.text = getString(R.string.audio_wind)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_wind)
            }

            SoundsName.WATERFALL -> {
                binding.txtAudioName.text = getString(R.string.audio_waterfall)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_waterfall)
            }

            SoundsName.GOOSE -> {
                binding.txtAudioName.text = getString(R.string.audio_goose)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_goose)
            }

            SoundsName.WHALE -> {
                binding.txtAudioName.text = getString(R.string.audio_whale)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_whale)
            }

            SoundsName.DESERT -> {
                binding.txtAudioName.text = getString(R.string.audio_desert)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_desert)
            }
            SoundsName.BIRD -> {
                binding.txtAudioName.text = getString(R.string.audio_bird)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_bird)
            }
            SoundsName.PENGUIN -> {
                binding.txtAudioName.text = getString(R.string.audio_penguin)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_penguin)
            }
            SoundsName.CAR -> {
                binding.txtAudioName.text = getString(R.string.audio_car)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_car)
            }
            SoundsName.CONSTRUCTION_SITE -> {
                binding.txtAudioName.text = getString(R.string.audio_construction_site)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_construction_site)
            }
        }
    }

    private fun initialAnimation() {
        binding.txtAudioName.text = getString(R.string.message_audio_choose)
        binding.txtAudioName.animate().setDuration(250).alpha(AlphaValues.TRANSPARENCY_MED)

        binding.txtAudioDesc.text = ""
        binding.txtAudioDesc.animate().setDuration(200).alpha(AlphaValues.TRANSPARENCY_MED)

        binding.verticalScroll.animate().setDuration(750).alpha(AlphaValues.TRANSPARENCY_MAX)

        binding.imgBtnPlay.animate().setDuration(750).alpha(AlphaValues.TRANSPARENCY_MED)

        binding.imgBtnInfo.animate().setDuration(1000).alpha(AlphaValues.TRANSPARENCY_MIN)

        binding.imgBtnTheme.animate().setDuration(1000).alpha(AlphaValues.TRANSPARENCY_MIN)

        binding.horizontalScroll.animate().setDuration(750).alpha(AlphaValues.TRANSPARENCY_MAX)


    }

    private fun initInterfaceComponents() {

        binding.main.tag = Themes.SPACE.toString()

        initThemesDialogComponents()

        binding.imgBtnPlay.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.txtAudioName.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.txtAudioDesc.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.verticalScroll.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.imgBtnInfo.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.imgBtnTheme.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.horizontalScroll.alpha = AlphaValues.TRANSPARENCY_INITIAL


    }


    private fun initThemesDialogComponents() {
        dialogThemes = Dialog(this@MainActivity)
        dialogThemes.setContentView(R.layout.dialog_theme)
        dialogThemes.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialogThemes.window?.setBackgroundDrawableResource(R.drawable.background_gradient_second)
        dialogThemes.setCancelable(true)

        val spaceTheme: ImageButton = dialogThemes.findViewById(R.id.imgBtnSpaceTheme)
        spaceTheme.tag = R.string.button_not_pressed

        val forestTheme: ImageButton = dialogThemes.findViewById(R.id.imgBtnForestTheme)
        forestTheme.tag = R.string.button_not_pressed

        val cityTheme: ImageButton = dialogThemes.findViewById(R.id.imgBtnCityTheme)
        cityTheme.tag = R.string.button_not_pressed

        val beachTheme: ImageButton = dialogThemes.findViewById(R.id.imgBtnBeachTheme)
        beachTheme.tag = R.string.button_not_pressed

        val listOfButtonsThemes = mutableListOf(spaceTheme, forestTheme, cityTheme, beachTheme)

        fun changeButtonImage(themeButton: ImageButton?) {
            when (themeButton) {
                spaceTheme -> spaceTheme.setImageResource(R.drawable.space_theme)
                forestTheme -> forestTheme.setImageResource(R.drawable.forest_theme)
                cityTheme -> cityTheme.setImageResource(R.drawable.city_theme)
                beachTheme -> beachTheme.setImageResource(R.drawable.beach_theme)
            }
        }

        fun deselectAnyMarkedTheme() {
            for (themes in listOfButtonsThemes) {
                if (themes.tag == R.string.button_pressed) {
                    themes.tag = R.string.button_not_pressed
                    changeButtonImage(themes)
                }
            }
        }




        when (verifyTheme()) {
            Themes.SPACE.toString() -> {
                spaceTheme.setImageResource(R.drawable.space_theme_pressed)
                spaceTheme.tag = R.string.button_pressed
            }
            Themes.FOREST.toString() -> {
                forestTheme.setImageResource(R.drawable.forest_theme_pressed)
                forestTheme.tag = R.string.button_pressed
            }
            Themes.CITY.toString() -> {
                cityTheme.setImageResource(R.drawable.city_theme_pressed)
                cityTheme.tag = R.string.button_pressed
            }
            Themes.BEACH.toString() -> {
                beachTheme.setImageResource(R.drawable.beach_theme_pressed)
                beachTheme.tag = R.string.button_pressed
            }
            null -> {
                displayErrorMsg(3)
            }
        }


        spaceTheme.setOnClickListener{

            if (spaceTheme.tag == R.string.button_pressed) {
                displayErrorMsg(3)
            } else {
                deselectAnyMarkedTheme()

                changeActivityTheme(Themes.SPACE)
                spaceTheme.tag = R.string.button_pressed
                spaceTheme.setImageResource(R.drawable.space_theme_pressed)

            }
        }

        forestTheme.setOnClickListener {
            if (forestTheme.tag == R.string.button_pressed) {
                displayErrorMsg(3)
            } else {
                deselectAnyMarkedTheme()

                changeActivityTheme(Themes.FOREST)
                forestTheme.tag = R.string.button_pressed
                forestTheme.setImageResource(R.drawable.forest_theme_pressed)
            }


        }

        cityTheme.setOnClickListener {
            if (cityTheme.tag == R.string.button_pressed) {
                displayErrorMsg(3)
            } else {
                deselectAnyMarkedTheme()

                changeActivityTheme(Themes.CITY)
                cityTheme.tag = R.string.button_pressed
                cityTheme.setImageResource(R.drawable.city_theme_pressed)

            }


        }

        beachTheme.setOnClickListener {
            if (beachTheme.tag == R.string.button_pressed) {
                displayErrorMsg(3)
            } else {
                deselectAnyMarkedTheme()

                changeActivityTheme(Themes.BEACH)
                beachTheme.tag = R.string.button_pressed
                beachTheme.setImageResource(R.drawable.beach_theme_pressed)

            }
        }



    }

    private fun changeActivityTheme(theme: Themes) {

        when (theme) {
            Themes.SPACE -> {
                binding.main.setBackgroundResource(R.drawable.space_main_background)
                binding.main.tag = Themes.SPACE.toString() // It has to change the tag of main, cause the verifyTheme() will analyse this to determine the actual theme
            }
            Themes.FOREST -> {
                binding.main.setBackgroundResource(R.drawable.forest_main_background)
                binding.main.tag = Themes.FOREST.toString()
            }
            Themes.CITY -> {
                binding.main.setBackgroundResource(R.drawable.city_main_background)
                binding.main.tag = Themes.CITY.toString()
            }
            Themes.BEACH -> {
                binding.main.setBackgroundResource(R.drawable.beach_main_background)
                binding.main.tag = Themes.BEACH.toString()
            }


        }

    }


    private fun verifyTheme(): String? {
        for (theme in Themes.entries) {
            if (theme.toString() == binding.main.tag.toString()) {
                return theme.toString()
            }
        }
        return null
    }


}