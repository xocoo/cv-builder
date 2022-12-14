package xocoo.miu.cvbuilder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val pref = getSharedPreferences("user_details", MODE_PRIVATE);
        var mainIntent = Intent(applicationContext, MainActivity::class.java)
        if (pref.contains("username") && pref.contains("password")) {
            startActivity(mainIntent);
        }

        sign_in_btn.setOnClickListener {
            var inputEmail = et_email.text.toString()
            var inputPass = et_password.text.toString()

            if (inputEmail.equals("xocoo@miu.edu") && inputPass.equals("123")) {
                val editor = pref.edit()
                editor.putString("username", inputEmail)
                editor.putString("password", inputPass)
                editor.commit()
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(mainIntent)
            } else {
                Toast.makeText(applicationContext, "Credentials are not valid", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}