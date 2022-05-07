package uz.hamroev.linuxgo.cache

import android.content.Context
import android.content.SharedPreferences

object Cache {

    private const val NAME = "linux"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var language: String?
        get() = sharedPreferences.getString("language", "en")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("language", value)
            }
        }

    var modulePoition: Int?
        get() = sharedPreferences.getInt("moduleposition", 0)
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putInt("moduleposition", value)
            }
        }

    var contentPosition: Int?
        get() = sharedPreferences.getInt("contentposition", 0)
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putInt("contentposition", value)
            }
        }


}
