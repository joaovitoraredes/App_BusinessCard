package br.com.jv_aredess.businesscard.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import br.com.jv_aredess.businesscard.App
import br.com.jv_aredess.businesscard.R
import br.com.jv_aredess.businesscard.data.BusinessCard
import br.com.jv_aredess.businesscard.databinding.ActivityAddCardBinding

class AddCard : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var menu: Spinner
    lateinit var imagem: ImageView

    public var identificador: Int = -1

    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()

        texto = findViewById(R.id.textView)
        menu = findViewById(R.id.cd_spinner)
        imagem = findViewById(R.id.imagemcardAdd)

        var tipos = arrayOf("Black","Rubi","Esmeralda","Diamante")
        findViewById<Spinner>(R.id.cd_spinner).adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipos)

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if (position == 0) {
                    imagem.setImageResource(R.drawable.ic_poly_grid_black_)
                }

                else if (position == 1){
                    imagem.setImageResource(R.drawable.ic_poly_grid_rubi)
                }

                else if (position == 2){
                    imagem.setImageResource(R.drawable.ic_poly_grid_esmeralda)
                }

                else if (position == 3){
                    imagem.setImageResource(R.drawable.ic_poly_grid_dima)
                }

                identificador = position
                println("position = $identificador")

            }


            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }


//    usar esse identificador para criar 4 ifs um pra cada numero, e em cada um colocar o private fun insrtListener abaixo, e tentar
//    fazer ele ir com as as caracteristicas do card


    private fun insertListener() {
        binding.btnConfirm.setOnClickListener{
            val businessCard =  BusinessCard(
                nome = binding.cdNome.editText?.text.toString(),
                telefone = binding.cdTelefone.editText?.text.toString(),
                email = binding.cdEmail.editText?.text.toString(),
                empresa = binding.cdEmpresa.editText?.text.toString(),
                tipoId = binding.cdSpinner.selectedItemPosition,
            )

            //o binding sai daqui e vai pro BusinessCardAdapater
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

}

