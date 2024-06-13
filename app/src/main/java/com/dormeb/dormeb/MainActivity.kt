package com.dormeb.dormeb

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.databinding.ActivityMainBinding
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog
    private lateinit var binding: ActivityMainBinding
    private var selectCount = 0

    private fun welcomeActivity(num: Int) {
        when (num) {
            1 -> {  // 1 é porque é a primeira vez entrando no app e na main activity
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)


            }
            2 -> { // 2 é porque ele so pausou o second activity ou o first e voltou pra main acitvity


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

        val keepMainActivity: Int = intent.getIntExtra("KeepMainActivity", 1) // 1 é o valor default se nada for passado, ent ele vai iniciar a first acitivty

        welcomeActivity(keepMainActivity)

        initInterfaceComponents()

        dialog = Dialog(this@MainActivity)
        dialog.setContentView(R.layout.dialog_box)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(R.drawable.background_dialog_box)
        dialog.setCancelable(true) // se o usuario clicar fora, ela vai desaparecer


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

        ) // o codigo pra passar pra second activity vai percorrer essa lista e vai verificar quais audios estão "pressed"


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
                changeImgButtonandText(SoundsName.CHUVA, 2)
                binding.imgBtnRain.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CHUVA, 1)
                binding.imgBtnRain.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        binding.imgBtnThunder.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeScrollsVisibility(2)

            if (binding.imgBtnThunder.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.TROVAO, 2)
                binding.imgBtnThunder.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.TROVAO, 1)
                binding.imgBtnThunder.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }

        }

        binding.imgBtnFan.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnFan.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.VENTILADOR, 2)
                binding.imgBtnFan.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.VENTILADOR, 1)
                binding.imgBtnFan.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnNightGuard.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnNightGuard.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.GUARDA, 2)
                binding.imgBtnNightGuard.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.GUARDA, 1)
                binding.imgBtnNightGuard.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCity.setOnClickListener { // ao inves dessa complexidade, eu posso fazer uma fun (nome do som) e associar os dois botões a uma so função
            changeScrollsVisibility(2)

            if (binding.imgBtnCity.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.CIDADE, 2)
                binding.imgBtnCity.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CIDADE, 1)
                binding.imgBtnCity.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnAirConditioner.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnAirConditioner.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.CLIMATIZADOR, 2)
                binding.imgBtnAirConditioner.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CLIMATIZADOR, 1)
                binding.imgBtnAirConditioner.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnForest.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnForest.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.FLORESTA, 2)
                binding.imgBtnForest.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.FLORESTA, 1)
                binding.imgBtnForest.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnBeach.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnBeach.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.PRAIA, 2)
                binding.imgBtnBeach.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.PRAIA, 1)
                binding.imgBtnBeach.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnFireplace.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnFireplace.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.FOGUEIRA, 2)
                binding.imgBtnFireplace.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.FOGUEIRA, 1)
                binding.imgBtnFireplace.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnClock.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnClock.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.RELOGIO, 2)
                binding.imgBtnClock.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.RELOGIO, 1)
                binding.imgBtnClock.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnWind.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnWind.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.VENTO, 2)
                binding.imgBtnWind.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.VENTO, 1)
                binding.imgBtnWind.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCricket.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCricket.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.GRILO, 2)
                binding.imgBtnCricket.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.GRILO, 1)
                binding.imgBtnCricket.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCicada.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCicada.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.CIGARRA, 2)
                binding.imgBtnCicada.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CIGARRA, 1)
                binding.imgBtnCicada.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnWaterfall.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnWaterfall.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.CACHOEIRA, 2)
                binding.imgBtnWaterfall.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CACHOEIRA, 1)
                binding.imgBtnWaterfall.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnGoose.setOnClickListener{
            changeScrollsVisibility(2)

            if (binding.imgBtnGoose.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.GANSO, 2)
                binding.imgBtnGoose.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.GANSO, 1)
                binding.imgBtnGoose.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnWhale.setOnClickListener{
            changeScrollsVisibility(2)

            if (binding.imgBtnWhale.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.BALEIA, 2)
                binding.imgBtnWhale.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.BALEIA, 1)
                binding.imgBtnWhale.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnPenguin.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnPenguin.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.PINGUIM, 2)
                binding.imgBtnPenguin.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.PINGUIM, 1)
                binding.imgBtnPenguin.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnBird.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnBird.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.PASSARO, 2)
                binding.imgBtnBird.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.PASSARO, 1)
                binding.imgBtnBird.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnCar.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnCar.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.CARRO, 2)
                binding.imgBtnCar.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CARRO, 1)
                binding.imgBtnCar.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnDesert.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnDesert.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.DESERTO, 2)
                binding.imgBtnDesert.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.DESERTO, 1)
                binding.imgBtnDesert.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.imgBtnConstructionSite.setOnClickListener {
            changeScrollsVisibility(2)

            if (binding.imgBtnConstructionSite.tag == getString(R.string.button_pressed)) {
                changeImgButtonandText(SoundsName.OBRA, 2)
                binding.imgBtnConstructionSite.tag = getString(R.string.button_not_pressed)
                selectCount -= 1
            } else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.OBRA, 1)
                binding.imgBtnConstructionSite.tag = getString(R.string.button_pressed)
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        // migrating all data to another class VVV

        binding.imgBtnPlay.setOnClickListener {
            if (selectCount == 0) { // não pode apertar play sem ter escolhido ao menos 1 audio
                displayErrorMsg(2)
            } else {
                // Me
                val audioMutable = mutableListOf<String>()
                for (audio in audiosArray) { // lista com todos os botões (vou percorre-la e procurar qual botão está pressionado
                    if (audio.tag == getString(R.string.button_pressed)) {
                        audioMutable.add(audio.contentDescription.toString()) // pegando a descrição do audio (que é o nome dos enum)
                    }
                }
                val transfer = AudiostoPass(audioMutable)

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Sounds", transfer) // passando como string o nome dos audios
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
            if (binding.imgBtnInfo.tag == getString(R.string.button_pressed)) {
                binding.imgBtnInfo.tag = getString(R.string.button_not_pressed)
            } else {
                binding.imgBtnInfo.tag = getString(R.string.button_pressed)
            }

            dialog.show()

        }

    }

    private fun displayErrorMsg(context: Int) {
        when (context) {
            1 -> Toast.makeText(
                this,
                getString(R.string.error_max_audio_capacity_reached), Toast.LENGTH_SHORT
            ).show() // mensagem de erro se o usuario tentar escolher 4 elementos
            2 -> Toast.makeText(
                this,
                getString(R.string.error_min_audio_quantity_to_play), Toast.LENGTH_SHORT
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

    private fun changeImgButtonandText(enum: SoundsName, playorpause: Int
    ) { // 1 - play and 2 - pause
        when (playorpause) {
            1 -> {
                when (enum) {
                    SoundsName.CHUVA -> {
                        binding.imgBtnRain.setImageResource(R.drawable.rain_pressed)
                        changeMusicandDescText(SoundsName.CHUVA)
                    }

                    SoundsName.TROVAO -> {
                        binding.imgBtnThunder.setImageResource(R.drawable.thunder_pressed)
                        changeMusicandDescText(SoundsName.TROVAO)
                    }

                    SoundsName.VENTILADOR -> {
                        binding.imgBtnFan.setImageResource(R.drawable.fan_pressed)
                        changeMusicandDescText(SoundsName.VENTILADOR)
                    }

                    SoundsName.GUARDA -> {
                        binding.imgBtnNightGuard.setImageResource(R.drawable.night_guard_pressed)
                        changeMusicandDescText(SoundsName.GUARDA)
                    }

                    SoundsName.CIDADE -> {
                        binding.imgBtnCity.setImageResource(R.drawable.city_pressed)
                        changeMusicandDescText(SoundsName.CIDADE)
                    }

                    SoundsName.CLIMATIZADOR -> {
                        binding.imgBtnAirConditioner.setImageResource(R.drawable.air_conditioner_pressed)
                        changeMusicandDescText(SoundsName.CLIMATIZADOR)
                    }

                    SoundsName.FLORESTA -> {
                        binding.imgBtnForest.setImageResource(R.drawable.forest_pressed)
                        changeMusicandDescText(SoundsName.FLORESTA)
                    }

                    SoundsName.PRAIA -> {
                        binding.imgBtnBeach.setImageResource(R.drawable.beach_pressed)
                        changeMusicandDescText(SoundsName.PRAIA)
                    }

                    SoundsName.FOGUEIRA -> {
                        binding.imgBtnFireplace.setImageResource(R.drawable.fireplace_pressed)
                        changeMusicandDescText(SoundsName.FOGUEIRA)
                    }

                    SoundsName.RELOGIO -> {
                        binding.imgBtnClock.setImageResource(R.drawable.clock_pressed)
                        changeMusicandDescText(SoundsName.RELOGIO)
                    }

                    SoundsName.CIGARRA -> {
                        binding.imgBtnCicada.setImageResource(R.drawable.cicada_pressed)
                        changeMusicandDescText(SoundsName.CIGARRA)
                    }

                    SoundsName.GRILO -> {
                        binding.imgBtnCricket.setImageResource(R.drawable.cricket_pressed)
                        changeMusicandDescText(SoundsName.GRILO)
                    }

                    SoundsName.VENTO -> {
                        binding.imgBtnWind.setImageResource(R.drawable.wind_pressed)
                        changeMusicandDescText(SoundsName.VENTO)
                    }

                    SoundsName.CACHOEIRA -> {
                        binding.imgBtnWaterfall.setImageResource(R.drawable.waterfall_pressed)
                        changeMusicandDescText(SoundsName.CACHOEIRA)
                    }

                    SoundsName.GANSO -> {
                        binding.imgBtnGoose.setImageResource(R.drawable.goose_pressed)
                        changeMusicandDescText(SoundsName.GANSO)
                    }

                    SoundsName.BALEIA -> {
                        binding.imgBtnWhale.setImageResource(R.drawable.whale_pressed)
                        changeMusicandDescText(SoundsName.BALEIA)
                    }

                    SoundsName.DESERTO -> {
                        binding.imgBtnDesert.setImageResource(R.drawable.desert_pressed)
                        changeMusicandDescText(SoundsName.DESERTO)
                    }

                    SoundsName.PASSARO -> {
                        binding.imgBtnBird.setImageResource(R.drawable.bird_pressed)
                        changeMusicandDescText(SoundsName.PASSARO)
                    }

                    SoundsName.PINGUIM -> {
                        binding.imgBtnPenguin.setImageResource(R.drawable.penguin_pressed)
                        changeMusicandDescText(SoundsName.PINGUIM)
                    }

                    SoundsName.CARRO -> {
                        binding.imgBtnCar.setImageResource(R.drawable.car_pressed)
                        changeMusicandDescText(SoundsName.CARRO)
                    }

                    SoundsName.OBRA -> {
                        binding.imgBtnConstructionSite.setImageResource(R.drawable.construction_site_pressed)
                        changeMusicandDescText(SoundsName.OBRA)
                    }
                }
            }

            2 -> {
                when (enum) {
                    SoundsName.CHUVA -> binding.imgBtnRain.setImageResource(R.drawable.rain)
                    SoundsName.TROVAO -> binding.imgBtnThunder.setImageResource(R.drawable.thunder)
                    SoundsName.VENTILADOR -> binding.imgBtnFan.setImageResource(R.drawable.fan)
                    SoundsName.GUARDA -> binding.imgBtnNightGuard.setImageResource(R.drawable.night_guard)
                    SoundsName.CIDADE -> binding.imgBtnCity.setImageResource(R.drawable.city)
                    SoundsName.CLIMATIZADOR -> binding.imgBtnAirConditioner.setImageResource(R.drawable.air_conditioner)
                    SoundsName.FLORESTA -> binding.imgBtnForest.setImageResource(R.drawable.forest)
                    SoundsName.PRAIA -> binding.imgBtnBeach.setImageResource(R.drawable.beach)
                    SoundsName.FOGUEIRA -> binding.imgBtnFireplace.setImageResource(R.drawable.fireplace)
                    SoundsName.RELOGIO -> binding.imgBtnClock.setImageResource(R.drawable.clock)
                    SoundsName.CIGARRA -> binding.imgBtnCicada.setImageResource(R.drawable.cicada)
                    SoundsName.GRILO -> binding.imgBtnCricket.setImageResource(R.drawable.cricket)
                    SoundsName.VENTO -> binding.imgBtnWind.setImageResource(R.drawable.wind)
                    SoundsName.CACHOEIRA -> binding.imgBtnWaterfall.setImageResource(R.drawable.waterfall)
                    SoundsName.GANSO -> binding.imgBtnGoose.setImageResource(R.drawable.goose)
                    SoundsName.BALEIA -> binding.imgBtnWhale.setImageResource(R.drawable.whale)
                    SoundsName.DESERTO -> binding.imgBtnDesert.setImageResource(R.drawable.desert)
                    SoundsName.PASSARO -> binding.imgBtnBird.setImageResource(R.drawable.bird)
                    SoundsName.PINGUIM -> binding.imgBtnPenguin.setImageResource(R.drawable.penguin)
                    SoundsName.CARRO -> binding.imgBtnCar.setImageResource(R.drawable.car)
                    SoundsName.OBRA -> binding.imgBtnConstructionSite.setImageResource(R.drawable.construction_site)
                }
            }
        }

    }

    private fun changeMusicandDescText(enum: SoundsName) {
        binding.txtAudioName.alpha = AlphaValues.TRANSPARENCY_FULL
        binding.txtAudioDesc.alpha = AlphaValues.TRANSPARENCY_FULL

        binding.txtAudioName.animate().setDuration(15000).alpha(AlphaValues.TRANSPARENCY_ALMOST)
        binding.txtAudioDesc.animate().setDuration(15000).alpha(AlphaValues.TRANSPARENCY_ALMOST)
        when (enum) {
            SoundsName.CHUVA -> {// aqui eu criei um enum para resumir mais o codigo e editar toodo o texto em um so lugar
                binding.txtAudioName.text = getString(R.string.audio_rain)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_rain)
            }

            SoundsName.TROVAO -> {
                binding.txtAudioName.text = getString(R.string.audio_thunder)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_thunder)
            }

            SoundsName.VENTILADOR -> {
                binding.txtAudioName.text = getString(R.string.audio_fan)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_fan)
            }

            SoundsName.GUARDA -> {
                binding.txtAudioName.text = getString(R.string.audio_night_guard)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_night_guard)
            }

            SoundsName.CIDADE -> {
                binding.txtAudioName.text = getString(R.string.audio_street)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_street)
            }

            SoundsName.FLORESTA -> {
                binding.txtAudioName.text = getString(R.string.audio_forest)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_forest)
            }

            SoundsName.CLIMATIZADOR -> {
                binding.txtAudioName.text = getString(R.string.audio_air_conditioner)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_air_conditioner)
            }

            SoundsName.PRAIA -> {
                binding.txtAudioName.text = getString(R.string.audio_beach)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_beach)
            }

            SoundsName.FOGUEIRA -> {
                binding.txtAudioName.text = getString(R.string.audio_fireplace)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_fireplace)
            }

            SoundsName.RELOGIO -> {
                binding.txtAudioName.text = getString(R.string.audio_clock)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_clock)
            }

            SoundsName.CIGARRA -> {
                binding.txtAudioName.text = getString(R.string.audio_cicada)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_cicada)
            }

            SoundsName.GRILO -> {
                binding.txtAudioName.text = getString(R.string.audio_cricket)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_cricket)
            }

            SoundsName.VENTO -> {
                binding.txtAudioName.text = getString(R.string.audio_wind)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_wind)
            }

            SoundsName.CACHOEIRA -> {
                binding.txtAudioName.text = getString(R.string.audio_waterfall)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_waterfall)
            }

            SoundsName.GANSO -> {
                binding.txtAudioName.text = getString(R.string.audio_goose)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_goose)
            }

            SoundsName.BALEIA -> {
                binding.txtAudioName.text = getString(R.string.audio_whale)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_whale)
            }

            SoundsName.DESERTO -> {
                binding.txtAudioName.text = getString(R.string.audio_desert)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_desert)
            }
            SoundsName.PASSARO -> {
                binding.txtAudioName.text = getString(R.string.audio_bird)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_bird)
            }
            SoundsName.PINGUIM -> {
                binding.txtAudioName.text = getString(R.string.audio_penguin)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_penguin)
            }
            SoundsName.CARRO -> {
                binding.txtAudioName.text = getString(R.string.audio_car)
                binding.txtAudioDesc.text = getString(R.string.audio_desc_car)
            }
            SoundsName.OBRA -> {
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

        binding.horizontalScroll.animate().setDuration(750).alpha(AlphaValues.TRANSPARENCY_MAX)


    }

    private fun initInterfaceComponents() {

        binding.imgBtnPlay.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.txtAudioName.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.txtAudioDesc.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.verticalScroll.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.imgBtnInfo.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.horizontalScroll.alpha = AlphaValues.TRANSPARENCY_INITIAL

    }
}