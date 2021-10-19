package br.com.jv_aredess.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.jv_aredess.businesscard.databinding.ActivityAddCardBinding

class AddCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}

