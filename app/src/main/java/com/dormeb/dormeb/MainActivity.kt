package com.dormeb.dormeb

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues

class MainActivity : AppCompatActivity() {

    private lateinit var btnPlay: ImageButton


    private lateinit var textMusic: TextView
    private lateinit var textDesc: TextView

    private lateinit var verticalScroll: ScrollView

    private lateinit var btnChuva: ImageButton
    private lateinit var btnTrovao: ImageButton
    private lateinit var btnVentilador: ImageButton
    private lateinit var btnGuarda: ImageButton
    private lateinit var btnCidade: ImageButton
    private lateinit var btnClimatizador: ImageButton
    private lateinit var btnFloresta: ImageButton
    private lateinit var btnPraia: ImageButton
    private lateinit var btnFogueira: ImageButton
    var selectCount = 0

    private lateinit var btnInfo: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        initInterfaceComponents()
        initialAnimation()
        val audiosArray = arrayOf(
            btnChuva,
            btnTrovao,
            btnVentilador,
            btnClimatizador,
            btnCidade,
            btnFloresta,
            btnFogueira,
            btnPraia,
            btnGuarda
        )

        

        btnChuva.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnChuva.tag == "pressed") {
                changeImgButtonandText(SoundsName.CHUVA, 2)
                btnChuva.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CHUVA, 1)
                btnChuva.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        btnTrovao.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeScrollsVisibility(1)

            if (btnTrovao.tag == "pressed") {
                changeImgButtonandText(SoundsName.TROVAO, 2)
                btnTrovao.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.TROVAO, 1)
                btnTrovao.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }

        }

        btnVentilador.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnVentilador.tag == "pressed") {
                changeImgButtonandText(SoundsName.VENTILADOR, 2)
                btnVentilador.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.VENTILADOR, 1)
                btnVentilador.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnGuarda.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnGuarda.tag == "pressed") {
                changeImgButtonandText(SoundsName.GUARDA, 2)
                btnGuarda.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.GUARDA, 1)
                btnGuarda.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnCidade.setOnClickListener { // ao inves dessa complexidade, eu posso fazer uma fun (nome do som) e associar os dois botões a uma so função
            changeScrollsVisibility(1)

            if (btnCidade.tag == "pressed") {
                changeImgButtonandText(SoundsName.CIDADE, 2)
                btnCidade.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CIDADE, 1)
                btnCidade.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnClimatizador.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnClimatizador.tag == "pressed") {
                changeImgButtonandText(SoundsName.CLIMATIZADOR, 2)
                btnClimatizador.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.CLIMATIZADOR, 1)
                btnClimatizador.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnFloresta.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnFloresta.tag == "pressed") {
                changeImgButtonandText(SoundsName.FLORESTA, 2)
                btnFloresta.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.FLORESTA, 1)
                btnFloresta.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnPraia.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnPraia.tag == "pressed") {
                changeImgButtonandText(SoundsName.PRAIA, 2)
                btnPraia.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.PRAIA, 1)
                btnPraia.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnFogueira.setOnClickListener {
            changeScrollsVisibility(1)

            if (btnFogueira.tag == "pressed") {
                changeImgButtonandText(SoundsName.FOGUEIRA, 2)
                btnFogueira.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                changeImgButtonandText(SoundsName.FOGUEIRA, 1)
                btnFogueira.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        // migrating all data to another class VVV

        btnPlay.setOnClickListener {
            if (selectCount == 0) { // não pode apertar play sem ter escolhido ao menos 1 audio
                displayErrorMsg(2)
            } else {
                // Me
                val audioMutable = mutableListOf<String>()
                for (audio in audiosArray) { // lista com todos os botões (vou percorre-la e procurar qual botão está pressionado
                    if (audio.tag == "pressed") {
                        audioMutable.add(audio.contentDescription.toString()) // pegando a descrição do audio
                    }
                }
                val transfer = AudiostoPass(audioMutable)

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Sounds", transfer) // passando como string o nome dos audios
                startActivity(intent)
                finish()
            }
        }

        verticalScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            verticalScroll.alpha = AlphaValues.TransparencyMax
            verticalScroll.animate().setDuration(12000).alpha(AlphaValues.AlmostTransparent)
        }


        btnInfo.setOnClickListener{
            TODO("Aprender a como abrir um fragment e fazer botão de fechar")
        }

    }

    private fun displayErrorMsg(context: Int) {
        when (context) {
            1 -> Toast.makeText(this, "Você só pode escolher no máximo 3 áudios para tocar", Toast.LENGTH_SHORT).show() // mensagem de erro se o usuario tentar escolher 4 elementos
            2 -> Toast.makeText(this, "Escolha ao menos 1 áudio para tocar", Toast.LENGTH_SHORT).show()
        }
    }


    private fun changeScrollsVisibility(scroll: Int) {
        when (scroll) {
            1 -> {
                verticalScroll.alpha = AlphaValues.TransparencyMax
                verticalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            }
        }
    }

    private fun changeImgButtonandText(enum: SoundsName, playorpause: Int) { // 1 - play and 2 - pause
        when (playorpause) {
            1-> {
                when (enum) {
                    SoundsName.CHUVA -> {
                        btnChuva.setImageResource(R.drawable.chuva_pressed)
                        changeMusicandDescText(SoundsName.CHUVA)
                    }
                    SoundsName.TROVAO -> {
                        btnTrovao.setImageResource(R.drawable.trovao_pressed)
                        changeMusicandDescText(SoundsName.TROVAO)
                    }
                    SoundsName.VENTILADOR -> {
                        btnVentilador.setImageResource(R.drawable.ventilador_pressed)
                        changeMusicandDescText(SoundsName.VENTILADOR)
                    }
                    SoundsName.GUARDA -> {
                        btnGuarda.setImageResource(R.drawable.guarda_pressed)
                        changeMusicandDescText(SoundsName.GUARDA)
                    }
                    SoundsName.CIDADE -> {
                        btnCidade.setImageResource(R.drawable.cidade_pressed)
                        changeMusicandDescText(SoundsName.CIDADE)
                    }
                    SoundsName.CLIMATIZADOR -> {
                        btnClimatizador.setImageResource(R.drawable.climatizador_pressed)
                        changeMusicandDescText(SoundsName.CLIMATIZADOR)
                    }
                    SoundsName.FLORESTA -> {
                        btnFloresta.setImageResource(R.drawable.floresta_pressed)
                        changeMusicandDescText(SoundsName.FLORESTA)
                    }
                    SoundsName.PRAIA -> {
                        btnPraia.setImageResource(R.drawable.praia_pressed)
                        changeMusicandDescText(SoundsName.PRAIA)
                    }
                    SoundsName.FOGUEIRA -> {
                        btnFogueira.setImageResource(R.drawable.fogueira_pressed)
                        changeMusicandDescText(SoundsName.FOGUEIRA)
                    }
                }
            }
            2 -> {
                when (enum) {
                    SoundsName.CHUVA -> btnChuva.setImageResource(R.drawable.chuva)
                    SoundsName.TROVAO -> btnTrovao.setImageResource(R.drawable.trovao)
                    SoundsName.VENTILADOR -> btnVentilador.setImageResource(R.drawable.ventilador)
                    SoundsName.GUARDA -> btnGuarda.setImageResource(R.drawable.guarda)
                    SoundsName.CIDADE -> btnCidade.setImageResource(R.drawable.cidade)
                    SoundsName.CLIMATIZADOR -> btnClimatizador.setImageResource(R.drawable.climatizador)
                    SoundsName.FLORESTA -> btnFloresta.setImageResource(R.drawable.floresta)
                    SoundsName.PRAIA -> btnPraia.setImageResource(R.drawable.praia)
                    SoundsName.FOGUEIRA -> btnFogueira.setImageResource(R.drawable.fogueira)
                }
            }
        }

    }

    private fun changeMusicandDescText(enum: SoundsName) {
        textMusic.alpha = AlphaValues.fullVisibility
        textDesc.alpha = AlphaValues.fullVisibility

        textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        when (enum) {
            SoundsName.CHUVA -> {// aqui eu criei um enum para resumir mais o codigo e editar toodo o texto em um so lugar
                textMusic.text = getString(R.string.barulho_de_chuva)
                textDesc.text = getString(R.string.melodia_chuva)
            }

            SoundsName.TROVAO -> {
                textMusic.text = getString(R.string.barulho_de_chuva_com_trovao)
                textDesc.text = getString(R.string.desc_trovao)
            }

            SoundsName.VENTILADOR -> {
                textMusic.text = getString(R.string.barulho_de_ventilador)
                textDesc.text = getString(R.string.desc_ventilador)
            }

            SoundsName.GUARDA -> {
                textMusic.text = getString(R.string.sirene_do_guarda_nortuno)
                textDesc.text = getString(R.string.desc_guarda)
            }

            SoundsName.CIDADE -> {
                textMusic.text = getString(R.string.som_rua)
                textDesc.text = getString(R.string.desc_rua)
            }

            SoundsName.FLORESTA -> {
                textMusic.text = getString(R.string.floresta)
                textDesc.text = getString(R.string.desc_floresta)
            }

            SoundsName.CLIMATIZADOR -> {
                textMusic.text = getString(R.string.ar_condicionado)
                textDesc.text = getString(R.string.desc_ar_condicionado)
            }

            SoundsName.PRAIA -> {
                textMusic.text = getString(R.string.praia)
                textDesc.text = getString(R.string.desc_praia)
            }

            SoundsName.FOGUEIRA -> {
                textMusic.text = getString(R.string.fogueira)
                textDesc.text = getString(R.string.desc_fogueira)
            }
        }
    }

    private fun initialAnimation() {
        textMusic.text = getString(R.string.First_message)
        textMusic.animate().setDuration(250).alpha(AlphaValues.TransparencyMin)

        textDesc.text = ""
        textDesc.animate().setDuration(200).alpha(AlphaValues.TransparencyMin)

        verticalScroll.animate().setDuration(750).alpha(AlphaValues.TransparencyMax)

        btnPlay.animate().setDuration(750).alpha(AlphaValues.TransparencyMin)

        btnInfo.animate().setDuration(1000).alpha(AlphaValues.transparencyMedium)


    }

    private fun initInterfaceComponents() {


        btnPlay = findViewById(R.id.playButton)
        btnPlay.alpha = AlphaValues.initialTransparency

        textMusic = findViewById(R.id.textMusicaNome)
        textMusic.alpha = AlphaValues.initialTransparency

        textDesc = findViewById(R.id.textDesc)
        textDesc.alpha = AlphaValues.initialTransparency


        verticalScroll = findViewById(R.id.verticalScroll)
        verticalScroll.alpha = AlphaValues.initialTransparency

        btnChuva = findViewById(R.id.btnChuva)
        btnChuva.tag = "not_pressed"

        btnTrovao = findViewById(R.id.btnTrovao)
        btnTrovao.tag = "not_pressed"

        btnVentilador = findViewById(R.id.btnVentilador)
        btnVentilador.tag = "not_pressed"

        btnGuarda = findViewById(R.id.btnGuarda)
        btnGuarda.tag = "not_pressed"

        btnCidade = findViewById(R.id.btnCidade)
        btnCidade.tag = "not_pressed"

        btnClimatizador = findViewById(R.id.btnClimatizador)
        btnClimatizador.tag = "not_pressed"

        btnFloresta = findViewById(R.id.btnFloresta)
        btnFloresta.tag = "not_pressed"

        btnPraia = findViewById(R.id.btnPraia)
        btnPraia.tag = "not_pressed"

        btnFogueira = findViewById(R.id.btnFogueira)
        btnFogueira.tag = "not_pressed"

        btnInfo = findViewById(R.id.btnInfo)
        btnInfo.alpha = AlphaValues.initialTransparency


    }
}