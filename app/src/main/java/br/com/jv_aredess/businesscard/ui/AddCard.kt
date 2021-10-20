package br.com.jv_aredess.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.jv_aredess.businesscard.App
import br.com.jv_aredess.businesscard.R
import br.com.jv_aredess.businesscard.data.BusinessCard
import br.com.jv_aredess.businesscard.databinding.ActivityAddCardBinding

class AddCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnConfirm.setOnClickListener{
            val businessCard = BusinessCard(
                nome = binding.cdNome.editText?.text.toString(),
                telefone = binding.cdTelefone.editText?.text.toString(),
                email = binding.cdEmail.editText?.text.toString(),
                empresa = binding.cdEmpresa.editText?.text.toString(),
                fundoPersonalizado = binding.cdCor1.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}

