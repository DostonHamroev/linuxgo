package uz.hamroev.linuxgo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import com.google.android.gms.ads.MobileAds
import uz.hamroev.linuxgo.R
import uz.hamroev.linuxgo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}


        binding.cardMenu.setOnClickListener {
            binding.drawerLayout.open()
        }

        startNavAnimation()


    }

    private fun startNavAnimation() {
        val anim_left = AnimationUtils.loadAnimation(this, R.anim.anim_left)
        val anim_top = AnimationUtils.loadAnimation(this, R.anim.anim_top)

        binding.cardMenu.startAnimation(anim_top)
        binding.icMenuIv.startAnimation(anim_left)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }
}