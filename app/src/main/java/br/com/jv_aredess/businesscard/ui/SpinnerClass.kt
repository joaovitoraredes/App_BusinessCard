package br.com.jv_aredess.businesscard.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.jv_aredess.businesscard.R

class SpinnerClass : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var imagem: ImageView
    lateinit var menu: Spinner

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_class)


        texto = findViewById(R.id.textView)
        menu = findViewById(R.id.spinner)
        imagem = findViewById(R.id.imagemcard)

        var tipos = arrayOf("Black","Rubi","Esmeralda","Diamante")
        findViewById<Spinner>(R.id.spinner).adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipos)

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                texto.text = tipos[position]

                if (texto.text == "Black" ){
                imagem.setImageResource(R.drawable.ic_poly_grid_black_)
                }

                else if (texto.text == "Rubi" ){
                    imagem.setImageResource(R.drawable.ic_poly_grid_rubi)
                }

                else if (texto.text == "Esmeralda" ){
                    imagem.setImageResource(R.drawable.ic_poly_grid_esmeralda)
                }

                else if (texto.text == "Diamante" ){
                    imagem.setImageResource(R.drawable.ic_poly_grid_dima)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}