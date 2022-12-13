package xocoo.miu.cvbuilder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    val KEY = "PERSON"
    val PREF = "CVPREF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val spf = getSharedPreferences("myspf", Context.MODE_PRIVATE)

        val spe = spf.edit()
        spe.putString("data", "xocoo")
        spe.apply()

        var inputEmail = et_email.text.toString()
//        if(spf.getBoolean())

        sign_in_btn.setOnClickListener {
            var mainIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}