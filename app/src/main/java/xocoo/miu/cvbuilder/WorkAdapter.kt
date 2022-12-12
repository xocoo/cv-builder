package xocoo.miu.cvbuilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.work_list.view.*

class WorkAdapter(var jobList: ArrayList<Job>) :
    RecyclerView.Adapter<WorkAdapter.JobViewHolder>() {

    inner class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.work_list, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.itemView.work_layout.apply {
            tv_role.text = jobList[position].role
            tv_company_name.text = jobList[position].companyName
            tv_work_date.text = jobList[position].workDate
            tv_company_location.text = jobList[position].companyLocation
            company_image.setImageResource((jobList[position].image))
        }
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

}