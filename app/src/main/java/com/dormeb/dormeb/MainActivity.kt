package com.dormeb.dormeb

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
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
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawableResource(R.drawable.background_dialog_box)
        dialog.setCancelable(true) // se o usuario clicar fora, ela vai desaparecer




        initialAnimation()
        val audiosArray = arrayOf(
            binding.btnChuva,
            binding.btnTrovao,
            binding.btnVentilador,
            binding.btnClimatizador,
            binding.btnCidade,
            binding.btnFloresta,
            binding.btnFogueira,
            binding.btnPraia,
            binding.btnGuarda,
            binding.btnRelogio,
            binding.btnVento,
            binding.btnGrilo,
            binding.btnCigarra,
            binding.btnCachoeira
        ) // o codigo pra passar pra second activity vai percorrer essa lista e vai verificar quais audios estão "pressed"


        binding.btnChuva.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnChuva.tag == "pressed") {
                changeImgButtonandText(SoundsName.CHUVA, 2)
                binding.btnChuva.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CHUVA, 1)
                binding.btnChuva.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        binding.btnTrovao.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeScrollsVisibility()

            if (binding.btnTrovao.tag == "pressed") {
                changeImgButtonandText(SoundsName.TROVAO, 2)
                binding.btnTrovao.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.TROVAO, 1)
                binding.btnTrovao.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }

        }

        binding.btnVentilador.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnVentilador.tag == "pressed") {
                changeImgButtonandText(SoundsName.VENTILADOR, 2)
                binding.btnVentilador.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.VENTILADOR, 1)
                binding.btnVentilador.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnGuarda.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnGuarda.tag == "pressed") {
                changeImgButtonandText(SoundsName.GUARDA, 2)
                binding.btnGuarda.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.GUARDA, 1)
                binding.btnGuarda.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnCidade.setOnClickListener { // ao inves dessa complexidade, eu posso fazer uma fun (nome do som) e associar os dois botões a uma so função
            changeScrollsVisibility()

            if (binding.btnCidade.tag == "pressed") {
                changeImgButtonandText(SoundsName.CIDADE, 2)
                binding.btnCidade.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CIDADE, 1)
                binding.btnCidade.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnClimatizador.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnClimatizador.tag == "pressed") {
                changeImgButtonandText(SoundsName.CLIMATIZADOR, 2)
                binding.btnClimatizador.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CLIMATIZADOR, 1)
                binding.btnClimatizador.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnFloresta.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnFloresta.tag == "pressed") {
                changeImgButtonandText(SoundsName.FLORESTA, 2)
                binding.btnFloresta.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.FLORESTA, 1)
                binding.btnFloresta.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnPraia.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnPraia.tag == "pressed") {
                changeImgButtonandText(SoundsName.PRAIA, 2)
                binding.btnPraia.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.PRAIA, 1)
                binding.btnPraia.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnFogueira.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnFogueira.tag == "pressed") {
                changeImgButtonandText(SoundsName.FOGUEIRA, 2)
                binding.btnFogueira.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.FOGUEIRA, 1)
                binding.btnFogueira.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnRelogio.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnRelogio.tag == "pressed") {
                changeImgButtonandText(SoundsName.RELOGIO, 2)
                binding.btnRelogio.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.RELOGIO, 1)
                binding.btnRelogio.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnVento.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnVento.tag == "pressed") {
                changeImgButtonandText(SoundsName.VENTO, 2)
                binding.btnVento.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.VENTO, 1)
                binding.btnVento.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnGrilo.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnGrilo.tag == "pressed") {
                changeImgButtonandText(SoundsName.GRILO, 2)
                binding.btnGrilo.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.GRILO, 1)
                binding.btnGrilo.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnCigarra.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnCigarra.tag == "pressed") {
                changeImgButtonandText(SoundsName.CIGARRA, 2)
                binding.btnCigarra.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CIGARRA, 1)
                binding.btnCigarra.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        binding.btnCachoeira.setOnClickListener {
            changeScrollsVisibility()

            if (binding.btnCachoeira.tag == "pressed") {
                changeImgButtonandText(SoundsName.CACHOEIRA, 2)
                binding.btnCachoeira.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CACHOEIRA, 1)
                binding.btnCachoeira.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        // migrating all data to another class VVV

        binding.btnPlay.setOnClickListener {
            if (selectCount == 0) { // não pode apertar play sem ter escolhido ao menos 1 audio
                displayErrorMsg(2)
            } else {
                // Me
                val audioMutable = mutableListOf<String>()
                for (audio in audiosArray) { // lista com todos os botões (vou percorre-la e procurar qual botão está pressionado
                    if (audio.tag == "pressed") {
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
            binding.verticalScroll.alpha = AlphaValues.TransparencyMax
            binding.verticalScroll.animate().setDuration(12000).alpha(AlphaValues.AlmostTransparent)
        }


        binding.btnInfo.setOnClickListener{
            if (binding.btnInfo.tag == "pressed") {
                binding.btnInfo.tag = "not_pressed"
            } else {
                binding.btnInfo.tag = "pressed"
            }

            dialog.show()

        }

    }




    private fun displayErrorMsg(context: Int) {
        when (context) {
            1 -> Toast.makeText(this, "Você só pode escolher no máximo 3 áudios para tocar", Toast.LENGTH_SHORT).show() // mensagem de erro se o usuario tentar escolher 4 elementos
            2 -> Toast.makeText(this, "Escolha ao menos 1 áudio para tocar", Toast.LENGTH_SHORT).show()
        }
    }


    private fun changeScrollsVisibility() {
        binding.verticalScroll.alpha = AlphaValues.TransparencyMax
        binding.verticalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
    }

    private fun changeImgButtonandText(enum: SoundsName, playorpause: Int) { // 1 - play and 2 - pause
        when (playorpause) {
            1-> {
                when (enum) {
                    SoundsName.CHUVA -> {
                        binding.btnChuva.setImageResource(R.drawable.chuva_pressed)
                        changeMusicandDescText(SoundsName.CHUVA)
                    }
                    SoundsName.TROVAO -> {
                        binding.btnTrovao.setImageResource(R.drawable.trovao_pressed)
                        changeMusicandDescText(SoundsName.TROVAO)
                    }
                    SoundsName.VENTILADOR -> {
                        binding.btnVentilador.setImageResource(R.drawable.ventilador_pressed)
                        changeMusicandDescText(SoundsName.VENTILADOR)
                    }
                    SoundsName.GUARDA -> {
                        binding.btnGuarda.setImageResource(R.drawable.guarda_pressed)
                        changeMusicandDescText(SoundsName.GUARDA)
                    }
                    SoundsName.CIDADE -> {
                        binding.btnCidade.setImageResource(R.drawable.cidade_pressed)
                        changeMusicandDescText(SoundsName.CIDADE)
                    }
                    SoundsName.CLIMATIZADOR -> {
                        binding.btnClimatizador.setImageResource(R.drawable.climatizador_pressed)
                        changeMusicandDescText(SoundsName.CLIMATIZADOR)
                    }
                    SoundsName.FLORESTA -> {
                        binding.btnFloresta.setImageResource(R.drawable.floresta_pressed)
                        changeMusicandDescText(SoundsName.FLORESTA)
                    }
                    SoundsName.PRAIA -> {
                        binding.btnPraia.setImageResource(R.drawable.praia_pressed)
                        changeMusicandDescText(SoundsName.PRAIA)
                    }
                    SoundsName.FOGUEIRA -> {
                        binding.btnFogueira.setImageResource(R.drawable.fogueira_pressed)
                        changeMusicandDescText(SoundsName.FOGUEIRA)
                    }

                    SoundsName.RELOGIO -> {
                        binding.btnRelogio.setImageResource(R.drawable.relogio_pressed)
                        changeMusicandDescText(SoundsName.RELOGIO)
                    }
                    SoundsName.CIGARRA -> {
                        binding.btnCigarra.setImageResource(R.drawable.cigarra_pressed)
                        changeMusicandDescText(SoundsName.CIGARRA)
                    }
                    SoundsName.GRILO -> {
                        binding.btnGrilo.setImageResource(R.drawable.grilo_pressed)
                        changeMusicandDescText(SoundsName.GRILO)
                    }
                    SoundsName.VENTO -> {
                        binding.btnVento.setImageResource(R.drawable.vento_pressed)
                        changeMusicandDescText(SoundsName.VENTO)
                    }

                    SoundsName.CACHOEIRA -> {
                        binding.btnCachoeira.setImageResource(R.drawable.cachoeira_pressed)
                        changeMusicandDescText(SoundsName.CACHOEIRA)
                    }
                }
            }
            2 -> {
                when (enum) {
                    SoundsName.CHUVA -> binding.btnChuva.setImageResource(R.drawable.chuva)
                    SoundsName.TROVAO -> binding.btnTrovao.setImageResource(R.drawable.trovao)
                    SoundsName.VENTILADOR -> binding.btnVentilador.setImageResource(R.drawable.ventilador)
                    SoundsName.GUARDA -> binding.btnGuarda.setImageResource(R.drawable.guarda)
                    SoundsName.CIDADE -> binding.btnCidade.setImageResource(R.drawable.cidade)
                    SoundsName.CLIMATIZADOR -> binding.btnClimatizador.setImageResource(R.drawable.climatizador)
                    SoundsName.FLORESTA -> binding.btnFloresta.setImageResource(R.drawable.floresta)
                    SoundsName.PRAIA -> binding.btnPraia.setImageResource(R.drawable.praia)
                    SoundsName.FOGUEIRA -> binding.btnFogueira.setImageResource(R.drawable.fogueira)
                    SoundsName.RELOGIO -> binding.btnRelogio.setImageResource(R.drawable.relogio)
                    SoundsName.CIGARRA -> binding.btnCigarra.setImageResource(R.drawable.cigarra)
                    SoundsName.GRILO -> binding.btnGrilo.setImageResource(R.drawable.grilo)
                    SoundsName.VENTO -> binding.btnVento.setImageResource(R.drawable.vento)
                    SoundsName.CACHOEIRA -> binding.btnCachoeira.setImageResource(R.drawable.cachoeira)
                }
            }
        }

    }

    private fun changeMusicandDescText(enum: SoundsName) {
        binding.textMusic.alpha = AlphaValues.fullVisibility
        binding.textDesc.alpha = AlphaValues.fullVisibility

        binding.textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        binding.textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        when (enum) {
            SoundsName.CHUVA -> {// aqui eu criei um enum para resumir mais o codigo e editar toodo o texto em um so lugar
                binding.textMusic.text = getString(R.string.barulho_de_chuva)
                binding.textDesc.text = getString(R.string.melodia_chuva)
            }

            SoundsName.TROVAO -> {
                binding.textMusic.text = getString(R.string.barulho_de_chuva_com_trovao)
                binding.textDesc.text = getString(R.string.desc_trovao)
            }

            SoundsName.VENTILADOR -> {
                binding.textMusic.text = getString(R.string.barulho_de_ventilador)
                binding.textDesc.text = getString(R.string.desc_ventilador)
            }

            SoundsName.GUARDA -> {
                binding.textMusic.text = getString(R.string.sirene_do_guarda_nortuno)
                binding.textDesc.text = getString(R.string.desc_guarda)
            }

            SoundsName.CIDADE -> {
                binding.textMusic.text = getString(R.string.som_rua)
                binding.textDesc.text = getString(R.string.desc_rua)
            }

            SoundsName.FLORESTA -> {
                binding.textMusic.text = getString(R.string.floresta)
                binding.textDesc.text = getString(R.string.desc_floresta)
            }

            SoundsName.CLIMATIZADOR -> {
                binding.textMusic.text = getString(R.string.ar_condicionado)
                binding.textDesc.text = getString(R.string.desc_ar_condicionado)
            }

            SoundsName.PRAIA -> {
                binding.textMusic.text = getString(R.string.praia)
                binding.textDesc.text = getString(R.string.desc_praia)
            }

            SoundsName.FOGUEIRA -> {
                binding.textMusic.text = getString(R.string.fogueira)
                binding.textDesc.text = getString(R.string.desc_fogueira)
            }

            SoundsName.RELOGIO -> {
                binding.textMusic.text = getString(R.string.relogio)
                binding.textDesc.text = getString(R.string.desc_relogio)
            }
            SoundsName.CIGARRA -> {
                binding.textMusic.text = getString(R.string.cigarra)
                binding.textDesc.text = getString(R.string.desc_cigarra)
            }
            SoundsName.GRILO -> {
                binding.textMusic.text = getString(R.string.grilo)
                binding.textDesc.text = getString(R.string.desc_grilo)
            }
            SoundsName.VENTO -> {
                binding.textMusic.text = getString(R.string.vento)
                binding.textDesc.text = getString(R.string.desc_vento)
            }

            SoundsName.CACHOEIRA -> {
                binding.textMusic.text = getString(R.string.cachoeira)
                binding.textDesc.text = getString(R.string.desc_cachoeira)
            }
        }
    }

    private fun initialAnimation() {
        binding.textMusic.text = getString(R.string.First_message)
        binding.textMusic.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)

        binding.textDesc.text = ""
        binding.textDesc.animate().setDuration(200).alpha(AlphaValues.TransparencyMin)

        binding.verticalScroll.animate().setDuration(750).alpha(AlphaValues.TransparencyMax)

        binding.btnPlay.animate().setDuration(750).alpha(AlphaValues.TransparencyMin)

        binding.btnInfo.animate().setDuration(1000).alpha(AlphaValues.transparencyMedium)


    }

    private fun initInterfaceComponents() {

        binding.btnPlay.alpha = AlphaValues.initialTransparency

        binding.textMusic.alpha = AlphaValues.initialTransparency

        binding.textDesc.alpha = AlphaValues.initialTransparency

        binding.verticalScroll.alpha = AlphaValues.initialTransparency

        binding.btnInfo.alpha = AlphaValues.initialTransparency

    }
}