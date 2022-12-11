package xocoo.miu.cvbuilder

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.web -> {
                var url = "https://xocoo.me"
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
                mIntent.data = Uri.parse("mailto:")
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
        }

        return super.onOptionsItemSelected(item)
    }
}