package uz.hamroev.linuxgo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.linuxgo.R
import uz.hamroev.linuxgo.databinding.ItemModulBinding
import uz.hamroev.linuxgo.models.Content
import uz.hamroev.linuxgo.models.Modul

class ModulAdapter(
    var context: Context,
    var list: ArrayList<Modul>,
    var onModuleItemCLickListener: OnModuleItemCLickListener
) :
    RecyclerView.Adapter<ModulAdapter.VhModul>() {


    lateinit var contentAdapter: ContentAdapter

    inner class VhModul(var itemModulBinding: ItemModulBinding) :
        RecyclerView.ViewHolder(itemModulBinding.root) {

        val anim_right = AnimationUtils.loadAnimation(context, R.anim.anim_left)



        fun onBind(modul: Modul, positionModul: Int) {

            itemModulBinding.moduleName.text = modul.modulName
            contentAdapter = ContentAdapter(
                context,
                modul.listSubject,
                object : ContentAdapter.OnContentClickListener {
                    override fun onCLick(content: Content, position: Int) {
                        onModuleItemCLickListener.onCLick(modul, positionModul, position)
                    }
                })
            itemModulBinding.rvModule.adapter = contentAdapter
            itemModulBinding.imageArrowRight.animation = anim_right


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhModul {
        return VhModul(ItemModulBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhModul, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnModuleItemCLickListener {
        fun onCLick(modul: Modul, position: Int, contentPosition: Int)
    }

}