package com.dormeb.dormeb

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.enums.SoundsName
import com.dormeb.dormeb.values.AlphaValues

class MainActivity : AppCompatActivity() {

    private var firstMediaPlayer = MediaPlayer()
    private var secondMediaPlayer = MediaPlayer()

    private lateinit var textMusic: TextView
    private lateinit var textDesc: TextView

    private lateinit var optionFirst: TextView
    private lateinit var horizontalScroll: HorizontalScrollView

    private lateinit var optionSecond: TextView
    private lateinit var horizontalScrollSecond: HorizontalScrollView

    private lateinit var btnChuva: ImageButton
    private lateinit var btnTrovao: ImageButton
    private lateinit var btnVentilador: ImageButton
    private lateinit var btnGuarda: ImageButton

    private lateinit var btnChuva2: ImageButton
    private lateinit var btnTrovao2: ImageButton
    private lateinit var btnVentilador2: ImageButton
    private lateinit var btnGuarda2: ImageButton

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
                verifyIfisPlaying()
                firstMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                firstMediaPlayer.isLooping = true
                firstMediaPlayer.start()
                btnChuva.setImageResource(R.drawable.chuva_pause)
                btnChuva.tag = "played"
            }
            else {  // se estiver tocando, e clicar vai dá o comando mp3.pause
                firstMediaPlayer.pause()
                btnChuva.setImageResource(R.drawable.chuva_play)
                btnChuva.tag = "paused"
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        btnTrovao.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeMusicandDescText(SoundsName.TROVAO)
            changeScrollsVisibility(1)

            if (btnTrovao.tag == "paused") {
                verifyIfisPlaying()
                firstMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                firstMediaPlayer.isLooping = true
                firstMediaPlayer.start()
                btnTrovao.setImageResource(R.drawable.trovao_pause)
                btnTrovao.tag = "played"
            }
            else {
                firstMediaPlayer.pause()
                btnTrovao.setImageResource(R.drawable.trovao_play)
                btnTrovao.tag = "paused"
            }

        }

        btnVentilador.setOnClickListener {
            changeMusicandDescText(SoundsName.VENTILADOR)
            changeScrollsVisibility(1)

            if (btnVentilador.tag == "paused") {
                verifyIfisPlaying()
                firstMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                firstMediaPlayer.isLooping = true
                firstMediaPlayer.start()
                btnVentilador.setImageResource(R.drawable.ventilador_pause)
                btnVentilador.tag = "played"
            }
            else {
                firstMediaPlayer.pause()
                btnVentilador.setImageResource(R.drawable.ventilador_play)
                btnVentilador.tag = "paused"
            }
        }

        btnGuarda.setOnClickListener {
            changeMusicandDescText(SoundsName.GUARDA)
            changeScrollsVisibility(1)

            if (btnGuarda.tag == "paused") {
                verifyIfisPlaying()
                firstMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                firstMediaPlayer.isLooping = true
                firstMediaPlayer.start()
                btnGuarda.setImageResource(R.drawable.guarda_pause)
                btnGuarda.tag = "played"
            }
            else {
                firstMediaPlayer.pause()
                btnGuarda.setImageResource(R.drawable.guarda_play)
                btnGuarda.tag = "paused"
            }
        }

        // ----- segundo horizontal view

        btnChuva2.setOnClickListener {
            changeMusicandDescText(SoundsName.CHUVA)
            changeScrollsVisibility(2)

            if (btnChuva2.tag == "paused") { // se estiver pausado:
                verifyIfisPlaying2()
                secondMediaPlayer = MediaPlayer.create(this, R.raw.chuva)
                secondMediaPlayer.start()
                btnChuva2.setImageResource(R.drawable.chuva_pause)
                btnChuva2.tag = "played"
            }
            else {  // se estiver tocando, e clicar vai dá o comando mp3.pause
                secondMediaPlayer.pause()
                btnChuva2.setImageResource(R.drawable.chuva_play)
                btnChuva2.tag = "paused"
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        btnTrovao2.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeMusicandDescText(SoundsName.TROVAO)
            changeScrollsVisibility(2)

            if (btnTrovao2.tag == "paused") {
                verifyIfisPlaying2()
                secondMediaPlayer = MediaPlayer.create(this, R.raw.trovao)
                secondMediaPlayer.isLooping = true
                secondMediaPlayer.start()
                btnTrovao2.setImageResource(R.drawable.trovao_pause)
                btnTrovao2.tag = "played"
            }
            else {
                secondMediaPlayer.pause()
                btnTrovao2.setImageResource(R.drawable.trovao_play)
                btnTrovao2.tag = "paused"
            }

        }

        btnVentilador2.setOnClickListener {
            changeMusicandDescText(SoundsName.VENTILADOR)
            changeScrollsVisibility(2)

            if (btnVentilador2.tag == "paused") {
                verifyIfisPlaying2()
                secondMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua)
                secondMediaPlayer.isLooping = true
                secondMediaPlayer.start()
                btnVentilador2.setImageResource(R.drawable.ventilador_pause)
                btnVentilador2.tag = "played"
            }
            else {
                secondMediaPlayer.pause()
                btnVentilador2.setImageResource(R.drawable.ventilador_play)
                btnVentilador2.tag = "paused"
            }
        }

        btnGuarda2.setOnClickListener {
            changeMusicandDescText(SoundsName.GUARDA)
            changeScrollsVisibility(2)

            if (btnGuarda2.tag == "paused") {
                verifyIfisPlaying2()
                secondMediaPlayer = MediaPlayer.create(this, R.raw.ambiente_rua_guarda)
                secondMediaPlayer.isLooping = true
                secondMediaPlayer.start()
                btnGuarda2.setImageResource(R.drawable.guarda_pause)
                btnGuarda2.tag = "played"
            }
            else {
                secondMediaPlayer.pause()
                btnGuarda2.setImageResource(R.drawable.guarda_play)
                btnGuarda2.tag = "paused"
            }
        }

        // ------------------ animation of list of sounds part
        // preciso deixar todas essas variaveis de transparencia em um so lugar
        horizontalScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            horizontalScroll.alpha = AlphaValues.TransparencyMax
            horizontalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)

            optionFirst.alpha = AlphaValues.TransparencyMax
            optionFirst.animate().setDuration(10000).alpha(AlphaValues.AlmostTransparent)

        }

        horizontalScrollSecond.setOnScrollChangeListener { _, _, _, _, _ ->
            horizontalScrollSecond.alpha = AlphaValues.TransparencyMax
            horizontalScrollSecond.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)

            optionSecond.alpha = AlphaValues.TransparencyMax
            optionSecond.animate().setDuration(10000).alpha(AlphaValues.AlmostTransparent)
        }



    }

    private fun changeScrollsVisibility(scroll: Int) {
        if (scroll == 1) {
            horizontalScroll.alpha = AlphaValues.TransparencyMax
            horizontalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)

            optionFirst.alpha = AlphaValues.TransparencyMax
            optionFirst.animate().setDuration(10000).alpha(AlphaValues.AlmostTransparent)
        }
        else{
            horizontalScrollSecond.alpha = AlphaValues.TransparencyMax
            horizontalScrollSecond.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)

            optionSecond.alpha = AlphaValues.TransparencyMax
            optionSecond.animate().setDuration(10000).alpha(AlphaValues.AlmostTransparent)
        }
    }

    private fun changeMusicandDescText(enum: SoundsName) {
        if (enum == SoundsName.CHUVA) {// aqui eu criei um enum para resumir mais o codigo e editar toodo o texto em um so lugar
            // animate: preventing the text to begin already transparent
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility // i cant do 2 animation in same function, this will cause conflict and one animation will interrupt another

            // change text:
            textMusic.text = getString(R.string.barulho_de_chuva)
            textDesc.text = getString(R.string.melodia_chuva)

            // animate:
            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        }
        else if (enum == SoundsName.TROVAO) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.barulho_de_chuva_com_trovao)
            textDesc.text = getString(R.string.desc_trovao)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        }
        else if (enum == SoundsName.VENTILADOR) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.barulho_de_ventilador)
            textDesc.text = getString(R.string.desc_ventilador)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        }
        else if (enum == SoundsName.GUARDA) {
            textMusic.alpha = AlphaValues.fullVisibility
            textDesc.alpha = AlphaValues.fullVisibility

            textMusic.text = getString(R.string.sirene_do_guarda_nortuno)
            textDesc.text = getString(R.string.desc_guarda)

            textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
            textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        }
    }

    private fun initialAnimation() {
        textMusic.text = getString(R.string.First_message)
        textMusic.alpha = AlphaValues.TransparencyMin

        textDesc.text = getString(R.string.first_message_desc)
        textDesc.alpha = AlphaValues.TransparencyMin

        optionFirst.animate().setDuration(4000).alpha(AlphaValues.TransparencyMax)
        horizontalScroll.animate().setDuration(2000).alpha(AlphaValues.TransparencyMax)

        optionSecond.animate().setDuration(4500).alpha(AlphaValues.TransparencyMax)
        horizontalScrollSecond.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)
    }

    private fun iniciarComponentesInterface() {

        textMusic = findViewById(R.id.textMusicaNome)
        textMusic.alpha = AlphaValues.initialTransparency

        textDesc = findViewById(R.id.textDesc)
        textDesc.alpha = AlphaValues.initialTransparency

        optionFirst = findViewById(R.id.opcao1)
        optionFirst.alpha = AlphaValues.initialTransparency

        horizontalScroll = findViewById(R.id.horizontalScrollView)
        horizontalScroll.alpha = AlphaValues.initialTransparency

        btnChuva = findViewById(R.id.btnChuva)
        btnChuva.tag = "paused"

        btnTrovao = findViewById(R.id.btnTrovao)
        btnTrovao.tag = "paused"

        btnVentilador = findViewById(R.id.btnVentilador)
        btnVentilador.tag = "paused"

        btnGuarda = findViewById(R.id.btnGuarda)
        btnGuarda.tag = "paused"

        // -----
        optionSecond = findViewById(R.id.opcao2)
        optionSecond.alpha = AlphaValues.initialTransparency

        horizontalScrollSecond = findViewById(R.id.horizontalScrollView2)
        horizontalScrollSecond.alpha = AlphaValues.initialTransparency

        btnChuva2 = findViewById(R.id.btnChuva2)
        btnChuva2.tag = "paused"

        btnTrovao2 = findViewById(R.id.btnTrovao2)
        btnTrovao2.tag = "paused"

        btnVentilador2 = findViewById(R.id.btnVentilador2)
        btnVentilador2.tag = "paused"

        btnGuarda2 = findViewById(R.id.btnGuarda2)
        btnGuarda2.tag = "paused"


    }

    private fun verifyIfisPlaying(){
        val simpleArray = arrayOf(btnChuva, btnTrovao, btnVentilador, btnGuarda)
        // aq eu posso verificar se alguma ta tocando e pausar (vou botar dentro das funções de play)
        for (audioBtn in simpleArray){
            if (audioBtn.tag == "played"){
                firstMediaPlayer.stop()
                audioBtn.tag = "paused"
                changeIcon(audioBtn)
            }
        }
    }

    private fun verifyIfisPlaying2(){ // ter isso 2 vezes vai permitir tocar 2 audios ao msm tempo
        val simpleArray = arrayOf(btnChuva2, btnTrovao2, btnVentilador2, btnGuarda2)
        // aq eu posso verificar se alguma ta tocando e pausar (vou botar dentro das funções de play)
        for (audioBtn in simpleArray){
            if (audioBtn.tag == "played"){
                secondMediaPlayer.stop()
                audioBtn.tag = "paused"
                changeIcon(audioBtn)
            }
        }
    }

    private fun changeIcon(imagem: ImageButton) { // salvei todos os id de imagem em uma classe
        println(imagem.contentDescription.toString())
        if (imagem.contentDescription.toString() == "chuva") {
            imagem.setImageResource(R.drawable.chuva_play)
        }
        else if (imagem.contentDescription.toString() == "trovao"){
            imagem.setImageResource(R.drawable.trovao_play)
        }
        else if (imagem.contentDescription.toString() == "ventilador"){
            imagem.setImageResource(R.drawable.ventilador_play)
        }
        else if (imagem.contentDescription.toString() == "guarda"){
            imagem.setImageResource(R.drawable.guarda_play)
        }
    }

}