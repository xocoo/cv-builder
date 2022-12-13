package xocoo.miu.cvbuilder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact.view.*


class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_contact, container, false)
        view.tr_phone.setOnClickListener {
            val phoneIntent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:${tv_phone.text}")
            )
            startActivity(phoneIntent)
        }
        view.tr_email.setOnClickListener {
            val emailIntent = Intent(
                Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "${tv_email.text}", null
                )
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello from your App")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Your CV app is awesome")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        view.tr_location.setOnClickListener {
            val mapIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://goo.gl/maps/5G384XHsovNTKZe36")
            )
            startActivity(mapIntent)
        }

        view.tr_facebook.setOnClickListener {
            val facebookIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/${tv_facebook.text}"))
            startActivity(facebookIntent)
        }
        view.tr_linkedin.setOnClickListener {
            val linedinIntent = Intent(Intent.ACTION_VIEW)
            linedinIntent.data = Uri.parse("https://www.linkedin.com/in/khosbayar-sandag/")
            linedinIntent.setPackage("com.linkedin.android")
            startActivity(linedinIntent)
        }

        view.tr_whatsapp.setOnClickListener {
            val url =
                "https://api.whatsapp.com/send?phone=97688629242&text=Hello, your CV app is awesome"
            val whatsappIntent = Intent(Intent.ACTION_VIEW)
            whatsappIntent.data = Uri.parse(url)
            startActivity(whatsappIntent)
        }
        return view
    }

}