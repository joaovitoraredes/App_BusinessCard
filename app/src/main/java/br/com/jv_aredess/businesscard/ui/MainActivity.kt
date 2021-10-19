package br.com.jv_aredess.businesscard.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.jv_aredess.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}