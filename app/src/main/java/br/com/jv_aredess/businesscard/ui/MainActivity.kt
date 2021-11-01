package br.com.jv_aredess.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.jv_aredess.businesscard.App
import br.com.jv_aredess.businesscard.databinding.ActivityMainBinding
import br.com.jv_aredess.businesscard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }



    private fun insertListener() {
        binding.btnMeusCartoes.setOnClickListener {
            val intent = Intent(this@MainActivity, MeusCartoes::class.java)
            startActivity(intent)
        }

    }
}

