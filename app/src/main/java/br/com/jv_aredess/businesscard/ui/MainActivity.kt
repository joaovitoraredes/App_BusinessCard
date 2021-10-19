package br.com.jv_aredess.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.jv_aredess.businesscard.ui.AddCard
import br.com.jv_aredess.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnPlus.setOnClickListener{
            val intent = Intent(this@MainActivity, AddCard::class.java)
            startActivity(intent)
        }
    }
}


