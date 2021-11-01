package br.com.jv_aredess.businesscard.ui

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import br.com.jv_aredess.businesscard.App
import br.com.jv_aredess.businesscard.databinding.ActivityMainBinding
import br.com.jv_aredess.businesscard.databinding.ActivityMeusCartoesBinding
import br.com.jv_aredess.businesscard.util.Image

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

    private fun setUpPermissions() {
        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
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
        adapter.listenerShare = { card ->
            Image.share(this@MeusCartoes, card )
        }
    }



    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, { businessCards ->
            adapter.submitList(businessCards)
        })
    }

}