package uz.hamroev.linuxgo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.linuxgo.databinding.ItemContentBinding
import uz.hamroev.linuxgo.databinding.ItemSubjectBinding
import uz.hamroev.linuxgo.models.Content
import uz.hamroev.linuxgo.models.Subject

class ContentAdapter(
    var context: Context,
    var list: ArrayList<Content>,
    var onContentClickListener: OnContentClickListener
) :
    RecyclerView.Adapter<ContentAdapter.VhContent>() {

    inner class VhContent(var itemContentBinding: ItemContentBinding) :
        RecyclerView.ViewHolder(itemContentBinding.root) {

        fun onBind(content: Content, position: Int) {

            itemContentBinding.contentName.text = content.contentName
            itemContentBinding.contentInfo.text = content.contentInfo
            itemContentBinding.lessonCountTv.text = content.lessonCount
            itemContentBinding.contentImage.setImageResource(content.contentImage)

            itemContentBinding.main.setOnClickListener {
                onContentClickListener.onCLick(content, position)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhContent {
        return VhContent(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhContent, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnContentClickListener {
        fun onCLick(content: Content, position: Int)
    }
}


