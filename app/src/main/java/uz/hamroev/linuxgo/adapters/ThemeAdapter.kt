package uz.hamroev.linuxgo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.linuxgo.databinding.ItemThemeBinding
import uz.hamroev.linuxgo.models.Theme
import uz.hamroev.linuxgo.shadow.RenderScriptBlur
import uz.hamroev.linuxgo.shadow.RenderScriptProvider

class ThemeAdapter(
    var context: Context,
    var list: ArrayList<Theme>,
    var onThemeClickListener: OnThemeClickListener
) :
    RecyclerView.Adapter<ThemeAdapter.VhTheme>() {

    inner class VhTheme(var itemThemeBinding: ItemThemeBinding) :
        RecyclerView.ViewHolder(itemThemeBinding.root) {

        fun onBind(theme: Theme, position: Int) {

            val renderScriptProvider = RenderScriptProvider(context)
            itemThemeBinding.themeName.clipToOutline = true
            itemThemeBinding.spaceShadow.blurScript = RenderScriptBlur(renderScriptProvider)

            itemThemeBinding.themeNumber.text = theme.themeNumber.toString()
            itemThemeBinding.themeName.text = theme.themeName

            itemThemeBinding.main.setOnClickListener {
                onThemeClickListener.onCLickTheme(theme, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhTheme {
        return VhTheme(ItemThemeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhTheme, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnThemeClickListener {
        fun onCLickTheme(theme: Theme, position: Int) {

        }
    }
}