package uz.hamroev.linuxgo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.linuxgo.databinding.ItemSubjectBinding
import uz.hamroev.linuxgo.models.Subject

class SubjectAdapter(
    var context: Context,
    var list: ArrayList<Subject>,
    var onSubjectClickListener: OnSubjectClickListener
) :
    RecyclerView.Adapter<SubjectAdapter.VhSubject>() {

    inner class VhSubject(var itemSubjectBinding: ItemSubjectBinding) :
        RecyclerView.ViewHolder(itemSubjectBinding.root) {

        fun onBind(subject: Subject, position: Int) {
            itemSubjectBinding.subjectName.text = subject.subjectName
            itemSubjectBinding.subjectImage.setImageResource(subject.subjectImage)

            itemSubjectBinding.main.setOnClickListener {
                onSubjectClickListener.onCLick(subject, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSubject {
        return VhSubject(
            ItemSubjectBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhSubject, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnSubjectClickListener {
        fun onCLick(subject: Subject, position: Int)
    }
}