package com.dormeb.dormeb

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        iniciarComponentesInterface()
        initialAnimation()

        btnChuva.setOnClickListener {
            changeMusicandDescText(SoundsName.CHUVA)
            changeScrollsVisibility(1)

            if (btnChuva.tag == "paused") { // se estiver pausado:

                btnChuva.setImageResource(R.drawable.chuva_pause)
                btnChuva.tag = "played"
            } else {  // se estiver tocando, e clicar vai dá o comando mp3.pause

                btnChuva.setImageResource(R.drawable.chuva_play)
                btnChuva.tag = "paused"
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        btnTrovao.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeMusicandDescText(SoundsName.TROVAO)
            changeScrollsVisibility(1)

            if (btnTrovao.tag == "paused") {

                btnTrovao.setImageResource(R.drawable.trovao_pause)
                btnTrovao.tag = "played"
            } else {

                btnTrovao.setImageResource(R.drawable.trovao_play)
                btnTrovao.tag = "paused"
            }

        }

        btnVentilador.setOnClickListener {
            changeMusicandDescText(SoundsName.VENTILADOR)
            changeScrollsVisibility(1)

            if (btnVentilador.tag == "paused") {

                btnVentilador.setImageResource(R.drawable.ventilador_pause)
                btnVentilador.tag = "played"
            } else {

                btnVentilador.setImageResource(R.drawable.ventilador_play)
                btnVentilador.tag = "paused"
            }
        }

        btnGuarda.setOnClickListener {
            changeMusicandDescText(SoundsName.GUARDA)
            changeScrollsVisibility(1)

            if (btnGuarda.tag == "paused") {

                btnGuarda.setImageResource(R.drawable.guarda_pause)
                btnGuarda.tag = "played"
            } else {

                btnGuarda.setImageResource(R.drawable.guarda_play)
                btnGuarda.tag = "paused"
            }
        }

        btnCidade.setOnClickListener { // ao inves dessa complexidade, eu posso fazer uma fun (nome do som) e associar os dois botões a uma so função
            changeMusicandDescText(SoundsName.RUA)
            changeScrollsVisibility(1)

            if (btnCidade.tag == "paused") {

                btnCidade.setImageResource(R.drawable.cidade_pause)
                btnCidade.tag = "played"
            } else {

                btnCidade.setImageResource(R.drawable.cidade_play)
                btnCidade.tag = "paused"
            }
        }

        btnClimatizador.setOnClickListener {
            changeMusicandDescText(SoundsName.CLIMATIZADOR)
            changeScrollsVisibility(1)

            if (btnClimatizador.tag == "paused") {

                btnClimatizador.setImageResource(R.drawable.climatizador_pause)
                btnClimatizador.tag = "played"
            } else {

                btnClimatizador.setImageResource(R.drawable.climatizador_play)
                btnClimatizador.tag = "paused"
            }
        }

        btnFloresta.setOnClickListener {
            changeMusicandDescText(SoundsName.FLORESTA)
            changeScrollsVisibility(1)

            if (btnFloresta.tag == "paused") {

                btnFloresta.setImageResource(R.drawable.floresta_pause)
                btnFloresta.tag = "played"
            } else {

                btnFloresta.setImageResource(R.drawable.floresta_play)
                btnFloresta.tag = "paused"
            }
        }

        btnPraia.setOnClickListener {
            changeMusicandDescText(SoundsName.PRAIA)
            changeScrollsVisibility(1)

            if (btnPraia.tag == "paused") {

                btnPraia.setImageResource(R.drawable.praia_pause)
                btnPraia.tag = "played"
            } else {

                btnPraia.setImageResource(R.drawable.praia_play)
                btnPraia.tag = "paused"
            }
        }

        btnFogueira.setOnClickListener {
            changeMusicandDescText(SoundsName.FOGUEIRA)
            changeScrollsVisibility(1)

            if (btnFogueira.tag == "paused") {

                btnFogueira.setImageResource(R.drawable.fogueira_pause)
                btnFogueira.tag = "played"
            } else {

                btnFogueira.setImageResource(R.drawable.fogueira_play)
                btnFogueira.tag = "paused"
            }
        }

        btnPlay.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


        // ------------------ animation of list of sounds part
        // preciso deixar todas essas variaveis de transparencia em um so lugar
        verticalScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            verticalScroll.alpha = AlphaValues.TransparencyMax
            verticalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)


        }

    }

    private fun changeScrollsVisibility(scroll: Int) {
        if (scroll == 1) {
            verticalScroll.alpha = AlphaValues.TransparencyMax
            verticalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)

        }
    }

    private fun changeMusicandDescText(enum: SoundsName) {
        if (enum == SoundsName.CHUVA) {// aqui eu criei um enum para resumir mais o codigo e editar toodo o texto em um so lugar
            // animate: preventing the text to begin already transparent
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha =
                AlphaValues.fullVisibility // i cant do 2 animation in same function, this will cause conflict and one animation will interrupt another

            // change text:
            textMusic.text = getString(R.string.barulho_de_chuva)
            textDesc.text = getString(R.string.melodia_chuva)

            // animate:
            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        } else if (enum == SoundsName.TROVAO) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.barulho_de_chuva_com_trovao)
            textDesc.text = getString(R.string.desc_trovao)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        } else if (enum == SoundsName.VENTILADOR) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.barulho_de_ventilador)
            textDesc.text = getString(R.string.desc_ventilador)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        } else if (enum == SoundsName.GUARDA) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.sirene_do_guarda_nortuno)
            textDesc.text = getString(R.string.desc_guarda)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        } else if (enum == SoundsName.RUA) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.som_rua)
            textDesc.text = getString(R.string.desc_rua)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        }
    }

    private fun initialAnimation() {
        textMusic.text = getString(R.string.First_message)
        textMusic.alpha = AlphaValues.TransparencyMin

        textDesc.text = getString(R.string.first_message_desc)
        textDesc.alpha = AlphaValues.TransparencyMin

        verticalScroll.animate().setDuration(2000).alpha(AlphaValues.TransparencyMax)
    }

    private fun iniciarComponentesInterface() {

        btnPlay = findViewById(R.id.playButton)

        textMusic = findViewById(R.id.textMusicaNome)
        textMusic.alpha = AlphaValues.initialTransparency

        textDesc = findViewById(R.id.textDesc)
        textDesc.alpha = AlphaValues.initialTransparency


        verticalScroll = findViewById(R.id.verticalScroll)

        btnChuva = findViewById(R.id.btnChuva)
        btnChuva.tag = "paused"

        btnTrovao = findViewById(R.id.btnTrovao)
        btnTrovao.tag = "paused"

        btnVentilador = findViewById(R.id.btnVentilador)
        btnVentilador.tag = "paused"

        btnGuarda = findViewById(R.id.btnGuarda)
        btnGuarda.tag = "paused"

        btnCidade = findViewById(R.id.btnCidade)
        btnCidade.tag = "paused"

        btnClimatizador = findViewById(R.id.btnClimatizador)
        btnClimatizador.tag = "paused"

        btnFloresta = findViewById(R.id.btnFloresta)
        btnFloresta.tag = "paused"

        btnPraia = findViewById(R.id.btnPraia)
        btnPraia.tag = "paused"

        btnFogueira = findViewById(R.id.btnFogueira)
        btnFogueira.tag = "paused"

        // -----
    }

    /*    private fun verifyIfisPlaying(){
            val simpleArray = arrayOf(btnChuva, btnTrovao, btnVentilador, btnGuarda, btnCidade, btnClimatizador, btnFloresta, btnPraia, btnFogueira)
            // aq eu posso verificar se alguma ta tocando e pausar (vou botar dentro das funções de play)
            for (audioBtn in simpleArray){
                if (audioBtn.tag == "played"){
                    firstMediaPlayer.stop()
                    audioBtn.tag = "paused"
                    changeIcon(audioBtn)
                }
            }
        }*/

    private fun changeIcon(imagem: ImageButton) { // salvei todos os id de imagem em uma classe
        println(imagem.contentDescription.toString())
        if (imagem.contentDescription.toString() == "chuva") {
            imagem.setImageResource(R.drawable.chuva_play)
        } else if (imagem.contentDescription.toString() == "trovao") {
            imagem.setImageResource(R.drawable.trovao_play)
        } else if (imagem.contentDescription.toString() == "ventilador") {
            imagem.setImageResource(R.drawable.ventilador_play)
        } else if (imagem.contentDescription.toString() == "guarda") {
            imagem.setImageResource(R.drawable.guarda_play)
        } else if (imagem.contentDescription.toString() == "cidade") {
            imagem.setImageResource(R.drawable.cidade_play)
        } else if (imagem.contentDescription.toString() == "climatizador") {
            imagem.setImageResource(R.drawable.climatizador_play)
        } else if (imagem.contentDescription.toString() == "floresta") {
            imagem.setImageResource(R.drawable.floresta_play)
        } else if (imagem.contentDescription.toString() == "fogueira") {
            imagem.setImageResource(R.drawable.fogueira_play)
        } else if (imagem.contentDescription.toString() == "praia") {
            imagem.setImageResource(R.drawable.praia_play)
        }
    }
}