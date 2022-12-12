package xocoo.miu.cvbuilder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contact.*


class ContactFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    fun onClick(v: View) {
//        if (v === tv_phone) {
//            val webIntent = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(tv_phone.toString())
//            )
//            startActivity(webIntent)
//        }
        if (v === tv_phone) {
            val phoneIntent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:" + tv_phone.toString())
            )
            startActivity(phoneIntent)
        }
//        if (v === mAddressLabel) {
//            val mapIntent = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(
//                    "geo:" + mRestaurant.getLatitude()
//                        .toString() + "," + mRestaurant.getLongitude()
//                        .toString() + "?q=(" + mRestaurant.getName().toString() + ")"
//                )
//            )
//            startActivity(mapIntent)
//        }
    }
}