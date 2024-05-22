package com.dormeb.dormeb

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
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
import kotlin.math.E

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

    override fun onCreate(savedInstanceState: Bundle?) {
        // tornando a variavel global para ser usada na função


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
        val audiosArray = arrayOf(btnChuva, btnTrovao, btnVentilador, btnClimatizador, btnCidade, btnFloresta, btnFogueira, btnPraia, btnGuarda)

        

        btnChuva.setOnClickListener {
            changeMusicandDescText(SoundsName.CHUVA)
            changeScrollsVisibility(1)

            if (btnChuva.tag == "pressed") {
                btnChuva.setImageResource(R.drawable.chuva)
                btnChuva.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnChuva.setImageResource(R.drawable.chuva_pressed)
                btnChuva.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }
        // o codigo executa normal, mas quando é pra pausar ele não pausa o audio atual pois o mp3 é um recurso global aí se eu pedir pra pausar fora da ordem reversa, ele buga o sistema e nunca da pra pausar um elemento
        btnTrovao.setOnClickListener { // posso criar uma variavel mp3 para cada audio
            changeMusicandDescText(SoundsName.TROVAO)
            changeScrollsVisibility(1)

            if (btnTrovao.tag == "pressed") {
                btnTrovao.setImageResource(R.drawable.trovao)
                btnTrovao.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnTrovao.setImageResource(R.drawable.trovao_pressed)
                btnTrovao.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }

        }

        btnVentilador.setOnClickListener {
            changeMusicandDescText(SoundsName.VENTILADOR)
            changeScrollsVisibility(1)

            if (btnVentilador.tag == "pressed") {
                btnVentilador.setImageResource(R.drawable.ventilador)
                btnVentilador.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnVentilador.setImageResource(R.drawable.ventilador_pressed)
                btnVentilador.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnGuarda.setOnClickListener {
            changeMusicandDescText(SoundsName.GUARDA)
            changeScrollsVisibility(1)

            if (btnGuarda.tag == "pressed") {
                btnGuarda.setImageResource(R.drawable.guarda)
                btnGuarda.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnGuarda.setImageResource(R.drawable.guarda_pressed)
                btnGuarda.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnCidade.setOnClickListener { // ao inves dessa complexidade, eu posso fazer uma fun (nome do som) e associar os dois botões a uma so função
            changeMusicandDescText(SoundsName.CIDADE)
            changeScrollsVisibility(1)

            if (btnCidade.tag == "pressed") {
                btnCidade.setImageResource(R.drawable.cidade)
                btnCidade.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnCidade.setImageResource(R.drawable.cidade_pressed)
                btnCidade.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnClimatizador.setOnClickListener {
            changeMusicandDescText(SoundsName.CLIMATIZADOR)
            changeScrollsVisibility(1)

            if (btnClimatizador.tag == "pressed") {
                btnClimatizador.setImageResource(R.drawable.arcondicionado)
                btnClimatizador.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnClimatizador.setImageResource(R.drawable.arcondicionado_pressed)
                btnClimatizador.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnFloresta.setOnClickListener {
            changeMusicandDescText(SoundsName.FLORESTA)
            changeScrollsVisibility(1)

            if (btnFloresta.tag == "pressed") {
                btnFloresta.setImageResource(R.drawable.floresta)
                btnFloresta.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnFloresta.setImageResource(R.drawable.floresta_pressed)
                btnFloresta.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnPraia.setOnClickListener {
            changeMusicandDescText(SoundsName.PRAIA)
            changeScrollsVisibility(1)

            if (btnPraia.tag == "pressed") {
                btnPraia.setImageResource(R.drawable.praia)
                btnPraia.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnPraia.setImageResource(R.drawable.praia_pressed)
                btnPraia.tag = "pressed"
                selectCount += 1
            } else {
                displayErrorMsg(1)
            }
        }

        btnFogueira.setOnClickListener {
            changeMusicandDescText(SoundsName.FOGUEIRA)
            changeScrollsVisibility(1)

            if (btnFogueira.tag == "pressed") {
                btnFogueira.setImageResource(R.drawable.fogueira)
                btnFogueira.tag = "not_pressed"
                selectCount -= 1
            }
            else if (selectCount < 3) {
                btnFogueira.setImageResource(R.drawable.fogueira_pressed)
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
                val audioMutable = mutableListOf<String>()
                for (audio in audiosArray) { // lista com todos os botões (vou percorre-la e procurar qual botão está pressionado
                    if (audio.tag == "pressed") {
                        audioMutable.add(audio.contentDescription.toString()) // pegando a descrição do audio
                    }
                }
                var transfer = AudiostoPass(audioMutable)

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Sounds", transfer) // passando como string o nome dos audios

                startActivity(intent)
            }
        }


        // ------------------ animation of list of sounds part
        // preciso deixar todas essas variaveis de transparencia em um so lugar
        verticalScroll.setOnScrollChangeListener { _, _, _, _, _ ->
            verticalScroll.alpha = AlphaValues.TransparencyMax
            verticalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)


        }

    }

    private fun displayErrorMsg(context: Int) {
        when (context) {

            1 -> Toast.makeText(this, "Você só pode escolher no máximo 3 áudios para tocar", Toast.LENGTH_SHORT).show() // mensagem de erro se o usuario tentar escolher 4 elementos

            2 -> Toast.makeText(this, "Escolha ao menos 1 áudio para tocar", Toast.LENGTH_SHORT).show()

        }
    }



    private fun changeScrollsVisibility(scroll: Int) {
        if (scroll == 1) {
            verticalScroll.alpha = AlphaValues.TransparencyMax
            verticalScroll.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)

        }
    }

    private fun changeMusicandDescText(enum: SoundsName) {
        textMusic.alpha = AlphaValues.fullVisibility
        textDesc.alpha = AlphaValues.fullVisibility

        textMusic.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        textDesc.animate().setDuration(15000).alpha(AlphaValues.AlmostTransparent)
        if (enum == SoundsName.CHUVA) {// aqui eu criei um enum para resumir mais o codigo e editar toodo o texto em um so lugar
            textMusic.text = getString(R.string.barulho_de_chuva)
            textDesc.text = getString(R.string.melodia_chuva)
        } else if (enum == SoundsName.TROVAO) {
            textMusic.text = getString(R.string.barulho_de_chuva_com_trovao)
            textDesc.text = getString(R.string.desc_trovao)
        } else if (enum == SoundsName.VENTILADOR) {
            textMusic.text = getString(R.string.barulho_de_ventilador)
            textDesc.text = getString(R.string.desc_ventilador)
        } else if (enum == SoundsName.GUARDA) {
            textMusic.text = getString(R.string.sirene_do_guarda_nortuno)
            textDesc.text = getString(R.string.desc_guarda)
        } else if (enum == SoundsName.CIDADE) {
            textMusic.text = getString(R.string.som_rua)
            textDesc.text = getString(R.string.desc_rua)
        } else if (enum == SoundsName.FLORESTA) {
            textMusic.text = "Floresta"
            textDesc.text = "O agradável som da floresta lorem ipsum"
        } else if (enum == SoundsName.CLIMATIZADOR) {
            textMusic.text = "Ar-Condicionado"
            textDesc.text = "texto aleatorio so pra depois eu testar o tamanho dele em relação ao layout"
        } else if (enum == SoundsName.PRAIA) {
            textMusic.text = "Praia"
            textDesc.text = "texto aleatorio so pra depois eu testar o tamanho dele em relação ao layout"
        } else if (enum == SoundsName.FOGUEIRA) {
            textMusic.text = "Fogueira"
            textDesc.text = "texto aleatorio so pra depois eu testar o tamanho dele em relação ao layout"
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
            imagem.setImageResource(R.drawable.chuva_pressed)
        } else if (imagem.contentDescription.toString() == "trovao") {
            imagem.setImageResource(R.drawable.trovao_pressed)
        } else if (imagem.contentDescription.toString() == "ventilador") {
            imagem.setImageResource(R.drawable.ventilador_pressed)
        } else if (imagem.contentDescription.toString() == "guarda") {
            imagem.setImageResource(R.drawable.guarda_pressed)
        } else if (imagem.contentDescription.toString() == "cidade") {
            imagem.setImageResource(R.drawable.cidade_pressed)
        } else if (imagem.contentDescription.toString() == "climatizador") {
            imagem.setImageResource(R.drawable.arcondicionado_pressed)
        } else if (imagem.contentDescription.toString() == "floresta") {
            imagem.setImageResource(R.drawable.floresta_pressed)
        } else if (imagem.contentDescription.toString() == "fogueira") {
            imagem.setImageResource(R.drawable.fogueira_pressed)
        } else if (imagem.contentDescription.toString() == "praia") {
            imagem.setImageResource(R.drawable.praia_pressed)
        }
    }
}