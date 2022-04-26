package uz.hamroev.linuxgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import uz.hamroev.linuxgo.activity.HomeActivity
import uz.hamroev.linuxgo.databinding.ActivityMainBinding
import uz.hamroev.linuxgo.shadow.RenderScriptBlur
import uz.hamroev.linuxgo.shadow.RenderScriptProvider

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        init_shadow()

        startAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 15000)

    }

    private fun init_shadow() {
        val renderScriptProvider = RenderScriptProvider(this)
        binding.typeWriter.clipToOutline = true
        binding.spaceShadow.blurScript = RenderScriptBlur(renderScriptProvider)
    }

    private fun startAnimation() {
        binding.typeWriter.animateText("Linux \nGo")
        binding.typeWriter.setCharacterDeley(100)
    }
}