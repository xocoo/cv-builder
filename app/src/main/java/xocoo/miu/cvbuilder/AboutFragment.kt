package xocoo.miu.cvbuilder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_about, container, false)
        view.linear_oci_cert.setOnClickListener {
//            wview.loadUrl("https://catalog-education.oracle.com/pls/certview/sharebadge?id=9AC1465C227C54B74466BB68D4A71976C76D0707E0F51A1AE23BC8EF6A098DC6")
//            wview.webViewClient = WebViewClient()
            val url =
                "https://catalog-education.oracle.com/pls/certview/sharebadge?id=9AC1465C227C54B74466BB68D4A71976C76D0707E0F51A1AE23BC8EF6A098DC6"
            val ociURL = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, ociURL)
            startActivity(intent)
        }

        view.linear_aws_cert.setOnClickListener {
            val url =
                "https://www.credly.com/badges/1647d4cb-8bf5-4fe8-ad28-5c69eacda570/public_url"
            val ociURL = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, ociURL)
            startActivity(intent)
        }
        return view
    }

}