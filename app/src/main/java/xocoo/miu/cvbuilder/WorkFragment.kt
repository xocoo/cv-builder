package xocoo.miu.cvbuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

//        val skillsArray = arrayOf(
//            "AWS", "Devops", "Java", "Linux/Unix",
//            "PHP", "HTML", "CSS", "JavaScript", "SQL", "Project management", "Python"
//        )
//        val lv = requireView().findViewById<ListView>(R.id.lv_skill)
//        lv.adapter =
//            context?.let {
//                ArrayAdapter(
//                    it,
//                    android.R.layout.simple_expandable_list_item_1,
//                    skillsArray
//                )
//            }

        rv_work.apply {
            val jobs = ArrayList<Job>()
            jobs.add(
                Job(
                    "Senior AWS DevOps Engineer",
                    "Sorenson Communication",
                    "Nov 2022 - Present",
                    "Salt Lake, Utah",
                    R.drawable.sorenson_logo
                )
            )
            jobs.add(
                Job(
                    "Senior DevOps Engineer",
                    "Vertexmon",
                    "Mar 2021 - Oct 2021",
                    "Ulaanbaatar, Mongolia",
                    R.drawable.vertexmon_logo
                )
            )
            jobs.add(
                Job(
                    "Full Stack Developer",
                    "DigitalMedic",
                    "Dec 2020 - Mar 2021",
                    "Ulaanbaatar, Mongolia",
                    R.drawable.digitalmedic_logo
                )
            )
            jobs.add(
                Job(
                    "Software Engineer",
                    "Steppe Link Holding",
                    "Sep 2017 - May 2020",
                    "Ulaanbaatar, Mongolia",
                    R.drawable.steppelink_logo
                )
            )
            jobs.add(
                Job(
                    "System Engineer",
                    "MobiCom Corporation",
                    "Oct 2008 - Jun 2015",
                    "Ulaanbaatar, Mongolia",
                    R.drawable.mobicom_logo
                )
            )
            rv_work.layoutManager = LinearLayoutManager(activity)
            adapter = WorkAdapter(jobs)
        }
    }
}