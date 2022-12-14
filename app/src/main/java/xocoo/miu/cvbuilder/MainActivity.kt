package xocoo.miu.cvbuilder

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prf = getSharedPreferences("user_details", MODE_PRIVATE);
        Toast.makeText(
            applicationContext,
            "Hello, " + prf.getString("username", null),
            Toast.LENGTH_SHORT
        ).show()

        val adapter = MenuAdapter(supportFragmentManager, lifecycle)
        viewpager.adapter = adapter
        tblayout.tabGravity = TabLayout.GRAVITY_FILL

        TabLayoutMediator(tblayout, viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.ic_baseline_roofing_24)
                }
                1 -> {
                    tab.text = "About"
                    tab.setIcon(R.drawable.ic_baseline_account_circle_24)
                }
                2 -> {
                    tab.text = "Work"
                    tab.setIcon(R.drawable.ic_baseline_work_24)
                }
                3 -> {
                    tab.text = "Contact"
                    tab.setIcon(R.drawable.ic_baseline_email_24)
                }
            }
        }.attach()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("IntentReset")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.web -> {
                val url = "https://xocoo.me"
                val webpage = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                startActivity(intent)
            }
            R.id.linkedin -> {
                try {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.linkedin.com/in/khosbayar-sandag/")
                    intent.setPackage("com.linkedin.android")
                    startActivity(intent)
                } catch (anfe: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.linkedin.com/in/khosbayar-sandag/")
                        )
                    )
                }
            }
            R.id.whatsapp -> {
                val url =
                    "https://api.whatsapp.com/send?phone=97688629242&text=Hello, your CV app is awesome"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            R.id.contact -> {
                val recipient = "hello@xocoo.me"
                val subject = "Contact from your CV app"
                val message = "Hello, your CV app is awesome"

                val mIntent = Intent(Intent.ACTION_SEND)
                /*To send an email you need to specify mailto: as  URI using setData() method
                and data type will be to text/plain using setType() method*/
                Uri.parse("mailto:").also { mIntent.data = it }
                mIntent.type = "text/plain"
                // put recipient email in intent
                /* recipient is put as array because you may wanna send email to multiple emails
                   so enter comma(,) separated emails, it will be stored in array*/
                mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                //put the Subject in the intent
                mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
                //put the message in the intent
                mIntent.putExtra(Intent.EXTRA_TEXT, message)

                try {
                    //start email intent
                    startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
                } catch (e: Exception) {
                    //if any thing goes wrong for example no email client application or any exception
                    //get and show exception message
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                }
            }

            R.id.logout -> {
                val prf = getSharedPreferences("user_details", MODE_PRIVATE);
                intent = Intent(this@MainActivity, Login::class.java)
                val editor = prf.edit()
                editor.clear()
                editor.commit()
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}