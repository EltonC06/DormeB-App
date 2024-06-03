package com.dormeb.dormeb

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.databinding.ActivityMainBinding
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog
    private lateinit var binding: ActivityMainBinding // agr eu vou inflar ele la no init
    private var selectCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
            binding.imgBtnWaterfall
        ) // o codigo pra passar pra second activity vai percorrer essa lista e vai verificar quais audios estão "pressed"



        binding.imgBtnRain.setOnClickListener {
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            changeScrollsVisibility()

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
            binding.verticalScroll.alpha = AlphaValues.TRANSPARENCY_MAX
            binding.verticalScroll.animate().setDuration(12000)
                .alpha(AlphaValues.TRANSPARENCY_ALMOST)
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


    private fun changeScrollsVisibility() {
        binding.verticalScroll.alpha = AlphaValues.TRANSPARENCY_MAX
        binding.verticalScroll.animate().setDuration(15000).alpha(AlphaValues.TRANSPARENCY_ALMOST)
    }

    private fun changeImgButtonandText(enum: SoundsName, playorpause: Int
    ) { // 1 - play and 2 - pause
        when (playorpause) {
            1 -> {
                when (enum) {
                    SoundsName.CHUVA -> {
                        binding.imgBtnRain.setImageResource(R.drawable.chuva_pressed)
                        changeMusicandDescText(SoundsName.CHUVA)
                    }

                    SoundsName.TROVAO -> {
                        binding.imgBtnThunder.setImageResource(R.drawable.trovao_pressed)
                        changeMusicandDescText(SoundsName.TROVAO)
                    }

                    SoundsName.VENTILADOR -> {
                        binding.imgBtnFan.setImageResource(R.drawable.ventilador_pressed)
                        changeMusicandDescText(SoundsName.VENTILADOR)
                    }

                    SoundsName.GUARDA -> {
                        binding.imgBtnNightGuard.setImageResource(R.drawable.guarda_pressed)
                        changeMusicandDescText(SoundsName.GUARDA)
                    }

                    SoundsName.CIDADE -> {
                        binding.imgBtnCity.setImageResource(R.drawable.cidade_pressed)
                        changeMusicandDescText(SoundsName.CIDADE)
                    }

                    SoundsName.CLIMATIZADOR -> {
                        binding.imgBtnAirConditioner.setImageResource(R.drawable.climatizador_pressed)
                        changeMusicandDescText(SoundsName.CLIMATIZADOR)
                    }

                    SoundsName.FLORESTA -> {
                        binding.imgBtnForest.setImageResource(R.drawable.floresta_pressed)
                        changeMusicandDescText(SoundsName.FLORESTA)
                    }

                    SoundsName.PRAIA -> {
                        binding.imgBtnBeach.setImageResource(R.drawable.praia_pressed)
                        changeMusicandDescText(SoundsName.PRAIA)
                    }

                    SoundsName.FOGUEIRA -> {
                        binding.imgBtnFireplace.setImageResource(R.drawable.fogueira_pressed)
                        changeMusicandDescText(SoundsName.FOGUEIRA)
                    }

                    SoundsName.RELOGIO -> {
                        binding.imgBtnClock.setImageResource(R.drawable.relogio_pressed)
                        changeMusicandDescText(SoundsName.RELOGIO)
                    }

                    SoundsName.CIGARRA -> {
                        binding.imgBtnCicada.setImageResource(R.drawable.cigarra_pressed)
                        changeMusicandDescText(SoundsName.CIGARRA)
                    }

                    SoundsName.GRILO -> {
                        binding.imgBtnCricket.setImageResource(R.drawable.grilo_pressed)
                        changeMusicandDescText(SoundsName.GRILO)
                    }

                    SoundsName.VENTO -> {
                        binding.imgBtnWind.setImageResource(R.drawable.vento_pressed)
                        changeMusicandDescText(SoundsName.VENTO)
                    }

                    SoundsName.CACHOEIRA -> {
                        binding.imgBtnWaterfall.setImageResource(R.drawable.cachoeira_pressed)
                        changeMusicandDescText(SoundsName.CACHOEIRA)
                    }
                }
            }

            2 -> {
                when (enum) {
                    SoundsName.CHUVA -> binding.imgBtnRain.setImageResource(R.drawable.chuva)
                    SoundsName.TROVAO -> binding.imgBtnThunder.setImageResource(R.drawable.trovao)
                    SoundsName.VENTILADOR -> binding.imgBtnFan.setImageResource(R.drawable.ventilador)
                    SoundsName.GUARDA -> binding.imgBtnNightGuard.setImageResource(R.drawable.guarda)
                    SoundsName.CIDADE -> binding.imgBtnCity.setImageResource(R.drawable.cidade)
                    SoundsName.CLIMATIZADOR -> binding.imgBtnAirConditioner.setImageResource(R.drawable.climatizador)
                    SoundsName.FLORESTA -> binding.imgBtnForest.setImageResource(R.drawable.floresta)
                    SoundsName.PRAIA -> binding.imgBtnBeach.setImageResource(R.drawable.praia)
                    SoundsName.FOGUEIRA -> binding.imgBtnFireplace.setImageResource(R.drawable.fogueira)
                    SoundsName.RELOGIO -> binding.imgBtnClock.setImageResource(R.drawable.relogio)
                    SoundsName.CIGARRA -> binding.imgBtnCicada.setImageResource(R.drawable.cigarra)
                    SoundsName.GRILO -> binding.imgBtnCricket.setImageResource(R.drawable.grilo)
                    SoundsName.VENTO -> binding.imgBtnWind.setImageResource(R.drawable.vento)
                    SoundsName.CACHOEIRA -> binding.imgBtnWaterfall.setImageResource(R.drawable.cachoeira)
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


    }

    private fun initInterfaceComponents() {

        binding.imgBtnPlay.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.txtAudioName.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.txtAudioDesc.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.verticalScroll.alpha = AlphaValues.TRANSPARENCY_INITIAL

        binding.imgBtnInfo.alpha = AlphaValues.TRANSPARENCY_INITIAL

    }
}