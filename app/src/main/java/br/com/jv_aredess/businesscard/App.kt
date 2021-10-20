package br.com.jv_aredess.businesscard

import android.app.Application
import br.com.jv_aredess.businesscard.data.AppDataBase
import br.com.jv_aredess.businesscard.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDataBase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}