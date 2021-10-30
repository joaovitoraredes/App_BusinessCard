package br.com.jv_aredess.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.jv_aredess.businesscard.App
import br.com.jv_aredess.businesscard.databinding.ActivityMainBinding
import br.com.jv_aredess.businesscard.databinding.ActivityMeusCartoesBinding

class MeusCartoes : AppCompatActivity() {

    private val binding by lazy { ActivityMeusCartoesBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener() {
        binding.btnBack2.setOnClickListener{
            val intent = Intent(this@MeusCartoes,MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnPlus2.setOnClickListener{
            val intent = Intent(this@MeusCartoes,AddCard::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, { businessCards ->
            adapter.submitList(businessCards)
        })
    }

}