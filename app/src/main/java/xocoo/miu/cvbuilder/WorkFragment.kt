package xocoo.miu.cvbuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {

    // Make sure to use the FloatingActionButton for all the FABs
    private lateinit var mAddFab: FloatingActionButton
    private lateinit var mAddAlarmFab: FloatingActionButton
    private lateinit var mAddPersonFab: FloatingActionButton

    // These are taken to make visible and invisible along with FABs
    private lateinit var addAlarmActionText: TextView
    private lateinit var addPersonActionText: TextView

    // to check whether sub FAB buttons are visible or not.
    private var isAllFabsVisible: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_work, container, false)false

        // Register all the FABs with their IDs This FAB button is the Parent
        val view = inflater.inflate(R.layout.fragment_work, container, false)
        mAddFab = view.findViewById(R.id.add_fab)

        // FAB button
        mAddAlarmFab = view.findViewById(R.id.add_alarm_fab)
        mAddPersonFab = view.findViewById(R.id.add_person_fab)

        // Also register the action name text, of all the FABs.
        addAlarmActionText = view.findViewById(R.id.add_alarm_action_text)
        addPersonActionText = view.findViewById(R.id.add_person_action_text)

        // Now set all the FABs and all the action name texts as GONE
        mAddAlarmFab.visibility = View.GONE
        mAddPersonFab.visibility = View.GONE
        addAlarmActionText.visibility = View.GONE
        addPersonActionText.visibility = View.GONE

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(View.OnClickListener {
            (if (!isAllFabsVisible!!) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab.show()
                mAddPersonFab.show()
                addAlarmActionText.visibility = View.VISIBLE
                addPersonActionText.visibility = View.VISIBLE

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                true
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab.hide()
                mAddPersonFab.hide()
                addAlarmActionText.visibility = View.GONE
                addPersonActionText.visibility = View.GONE

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                false
            }).also { isAllFabsVisible = it }
        })
        // below is the sample action to handle add person FAB. Here it shows simple Toast msg.
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddPersonFab.setOnClickListener {
            Toast.makeText(context, "Project", Toast.LENGTH_SHORT).show()
        }

        // below is the sample action to handle add alarm FAB. Here it shows simple Toast msg
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddAlarmFab.setOnClickListener {
            Toast.makeText(context, "Skill", Toast.LENGTH_SHORT).show()
        }
        return view
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val skillsArray = arrayOf(
            "AWS", "Devops", "Java", "Linux/Unix",
            "PHP", "HTML", "CSS", "JavaScript", "SQL", "Project management", "Python"
        )
        val lv = requireView().findViewById<ListView>(R.id.lv_skill)
        lv.adapter =
            context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_expandable_list_item_1,
                    skillsArray
                )
            }

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