package uz.hamroev.linuxgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import uz.hamroev.linuxgo.R
import uz.hamroev.linuxgo.adapters.ThemeAdapter
import uz.hamroev.linuxgo.cache.Cache
import uz.hamroev.linuxgo.databinding.FragmentSubjectsBinding
import uz.hamroev.linuxgo.models.Theme
import uz.hamroev.linuxgo.shadow.RenderScriptBlur
import uz.hamroev.linuxgo.shadow.RenderScriptProvider

class SubjectsFragment : Fragment() {


    lateinit var binding: FragmentSubjectsBinding
    lateinit var list: ArrayList<Theme>
    lateinit var themeAdapter: ThemeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubjectsBinding.inflate(layoutInflater, container, false)

        MobileAds.initialize(binding.root.context) {}
        loadAds()




        loadSubjects()
        themeAdapter =
            ThemeAdapter(binding.root.context, list, object : ThemeAdapter.OnThemeClickListener {
                override fun onCLickTheme(theme: Theme, position: Int) {
                    Cache.title_data = list[position].themeName
                    Cache.dataPosition = position
                    findNavController().navigate(R.id.dataFragment)
                }
            })
        binding.rvTheme.adapter = themeAdapter

        return binding.root
    }

    private fun loadAds() {
        loadBannerAd()
    }

    private fun loadBannerAd() {
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

    }


    private fun loadSubjects() {
        list = ArrayList()
        list.clear()
        when (Cache.modulePoition) {
            0 -> {
                when (Cache.contentPosition) {
                    0 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.getting_started)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.getting_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.getting_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.getting_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.getting_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.getting_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.getting_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.getting_7)))
                        list.add(Theme(8, activity?.resources!!.getString(R.string.getting_8)))
                        list.add(Theme(9, activity?.resources!!.getString(R.string.getting_9)))
                        list.add(Theme(10, activity?.resources!!.getString(R.string.getting_10)))
                    }
                    1 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.command_line)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.command_line_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.command_line_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.command_line_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.command_line_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.command_line_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.command_line_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.command_line_7)))
                        list.add(Theme(8, activity?.resources!!.getString(R.string.command_line_8)))
                        list.add(Theme(9, activity?.resources!!.getString(R.string.command_line_9)))
                        list.add(
                            Theme(
                                10,
                                activity?.resources!!.getString(R.string.command_line_10)
                            )
                        )
                        list.add(
                            Theme(
                                11,
                                activity?.resources!!.getString(R.string.command_line_11)
                            )
                        )
                        list.add(
                            Theme(
                                12,
                                activity?.resources!!.getString(R.string.command_line_12)
                            )
                        )
                        list.add(
                            Theme(
                                13,
                                activity?.resources!!.getString(R.string.command_line_13)
                            )
                        )
                        list.add(
                            Theme(
                                14,
                                activity?.resources!!.getString(R.string.command_line_14)
                            )
                        )
                        list.add(
                            Theme(
                                15,
                                activity?.resources!!.getString(R.string.command_line_15)
                            )
                        )
                        list.add(
                            Theme(
                                16,
                                activity?.resources!!.getString(R.string.command_line_16)
                            )
                        )
                        list.add(
                            Theme(
                                17,
                                activity?.resources!!.getString(R.string.command_line_17)
                            )
                        )
                        list.add(
                            Theme(
                                18,
                                activity?.resources!!.getString(R.string.command_line_18)
                            )
                        )
                        list.add(
                            Theme(
                                19,
                                activity?.resources!!.getString(R.string.command_line_19)
                            )
                        )

                    }
                    2 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.text_fu)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.text_fu_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.text_fu_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.text_fu_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.text_fu_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.text_fu_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.text_fu_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.text_fu_7)))
                        list.add(Theme(8, activity?.resources!!.getString(R.string.text_fu_8)))
                        list.add(Theme(9, activity?.resources!!.getString(R.string.text_fu_9)))
                        list.add(Theme(10, activity?.resources!!.getString(R.string.text_fu_10)))
                        list.add(Theme(11, activity?.resources!!.getString(R.string.text_fu_11)))
                        list.add(Theme(12, activity?.resources!!.getString(R.string.text_fu_12)))
                        list.add(Theme(13, activity?.resources!!.getString(R.string.text_fu_13)))
                        list.add(Theme(14, activity?.resources!!.getString(R.string.text_fu_14)))
                        list.add(Theme(15, activity?.resources!!.getString(R.string.text_fu_15)))
                        list.add(Theme(16, activity?.resources!!.getString(R.string.text_fu_16)))
                    }
                    3 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.text_fu_advanced)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.advanced_text_fu_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.advanced_text_fu_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.advanced_text_fu_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.advanced_text_fu_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.advanced_text_fu_5)
                            )
                        )
                        list.add(
                            Theme(
                                6,
                                activity?.resources!!.getString(R.string.advanced_text_fu_6)
                            )
                        )
                        list.add(
                            Theme(
                                7,
                                activity?.resources!!.getString(R.string.advanced_text_fu_7)
                            )
                        )
                        list.add(
                            Theme(
                                8,
                                activity?.resources!!.getString(R.string.advanced_text_fu_8)
                            )
                        )
                        list.add(
                            Theme(
                                9,
                                activity?.resources!!.getString(R.string.advanced_text_fu_9)
                            )
                        )
                        list.add(
                            Theme(
                                10,
                                activity?.resources!!.getString(R.string.advanced_text_fu_10)
                            )
                        )
                        list.add(
                            Theme(
                                11,
                                activity?.resources!!.getString(R.string.advanced_text_fu_11)
                            )
                        )
                        list.add(
                            Theme(
                                12,
                                activity?.resources!!.getString(R.string.advanced_text_fu_12)
                            )
                        )
                        list.add(
                            Theme(
                                13,
                                activity?.resources!!.getString(R.string.advanced_text_fu_13)
                            )
                        )
                    }
                    4 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.user_management)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.user_management_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.user_management_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.user_management_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.user_management_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.user_management_5)
                            )
                        )
                        list.add(
                            Theme(
                                6,
                                activity?.resources!!.getString(R.string.user_management_6)
                            )
                        )
                    }
                    5 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.permissions)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.permissions_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.permissions_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.permissions_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.permissions_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.permissions_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.permissions_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.permissions_7)))
                        list.add(Theme(8, activity?.resources!!.getString(R.string.permissions_8)))
                    }
                    6 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.processes)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.processes_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.processes_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.processes_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.processes_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.processes_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.processes_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.processes_7)))
                        list.add(Theme(8, activity?.resources!!.getString(R.string.processes_8)))
                        list.add(Theme(9, activity?.resources!!.getString(R.string.processes_9)))
                        list.add(Theme(10, activity?.resources!!.getString(R.string.processes_10)))
                        list.add(Theme(11, activity?.resources!!.getString(R.string.processes_11)))
                    }
                    7 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.packages)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.packages_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.packages_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.packages_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.packages_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.packages_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.packages_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.packages_7)))
                    }
                }
            }
            1 -> {
                when (Cache.contentPosition) {
                    0 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.devices)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.device_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.device_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.device_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.device_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.device_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.device_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.device_7)))
                    }
                    1 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.the_filesystem)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.filesystem_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.filesystem_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.filesystem_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.filesystem_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.filesystem_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.filesystem_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.filesystem_7)))
                        list.add(Theme(8, activity?.resources!!.getString(R.string.filesystem_8)))
                        list.add(Theme(9, activity?.resources!!.getString(R.string.filesystem_9)))
                        list.add(Theme(10, activity?.resources!!.getString(R.string.filesystem_10)))
                        list.add(Theme(11, activity?.resources!!.getString(R.string.filesystem_11)))
                        list.add(Theme(12, activity?.resources!!.getString(R.string.filesystem_12)))
                    }
                    2 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.boot_the_system)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.boot_system_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.boot_system_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.boot_system_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.boot_system_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.boot_system_5)))
                    }
                    3 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.kernel)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.kernel_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.kernel_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.kernel_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.kernel_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.kernel_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.kernel_6)))
                    }
                    4 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.init)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.init_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.init_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.init_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.init_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.init_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.init_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.init_7)))
                    }
                    5 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.process_utilization)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.process_utilization_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.process_utilization_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.process_utilization_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.process_utilization_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.process_utilization_5)
                            )
                        )
                        list.add(
                            Theme(
                                6,
                                activity?.resources!!.getString(R.string.process_utilization_6)
                            )
                        )
                        list.add(
                            Theme(
                                7,
                                activity?.resources!!.getString(R.string.process_utilization_7)
                            )
                        )
                        list.add(
                            Theme(
                                8,
                                activity?.resources!!.getString(R.string.process_utilization_8)
                            )
                        )
                    }
                    6 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.logging)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.logging_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.logging_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.logging_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.logging_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.logging_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.logging_6)))
                    }
                }
            }
            2 -> {
                when (Cache.contentPosition) {
                    0 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.network_sharing)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.network_sharing_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.network_sharing_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.network_sharing_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.network_sharing_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.network_sharing_5)
                            )
                        )
                    }
                    1 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.network_basic)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.network_basic_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.network_basic_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.network_basic_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.network_basic_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.network_basic_5)
                            )
                        )
                        list.add(
                            Theme(
                                6,
                                activity?.resources!!.getString(R.string.network_basic_6)
                            )
                        )
                        list.add(
                            Theme(
                                7,
                                activity?.resources!!.getString(R.string.network_basic_7)
                            )
                        )
                        list.add(
                            Theme(
                                8,
                                activity?.resources!!.getString(R.string.network_basic_8)
                            )
                        )
                        list.add(
                            Theme(
                                9,
                                activity?.resources!!.getString(R.string.network_basic_9)
                            )
                        )
                    }
                    2 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.subnetting)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.subnetting_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.subnetting_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.subnetting_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.subnetting_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.subnetting_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.subnetting_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.subnetting_7)))
                    }
                    3 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.routing)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.routing_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.routing_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.routing_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.routing_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.routing_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.routing_6)))
                        list.add(Theme(7, activity?.resources!!.getString(R.string.routing_7)))
                    }
                    4 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.network_config)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.network_config_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.network_config_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.network_config_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.network_config_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.network_config_5)
                            )
                        )
                    }
                    5 -> {
                        binding.title.text =
                            activity?.resources!!.getString(R.string.troubleshooting)
                        list.add(
                            Theme(
                                1,
                                activity?.resources!!.getString(R.string.troubleshooting_1)
                            )
                        )
                        list.add(
                            Theme(
                                2,
                                activity?.resources!!.getString(R.string.troubleshooting_2)
                            )
                        )
                        list.add(
                            Theme(
                                3,
                                activity?.resources!!.getString(R.string.troubleshooting_3)
                            )
                        )
                        list.add(
                            Theme(
                                4,
                                activity?.resources!!.getString(R.string.troubleshooting_4)
                            )
                        )
                        list.add(
                            Theme(
                                5,
                                activity?.resources!!.getString(R.string.troubleshooting_5)
                            )
                        )
                    }
                    6 -> {
                        binding.title.text = activity?.resources!!.getString(R.string.dns)
                        list.add(Theme(1, activity?.resources!!.getString(R.string.dns_1)))
                        list.add(Theme(2, activity?.resources!!.getString(R.string.dns_2)))
                        list.add(Theme(3, activity?.resources!!.getString(R.string.dns_3)))
                        list.add(Theme(4, activity?.resources!!.getString(R.string.dns_4)))
                        list.add(Theme(5, activity?.resources!!.getString(R.string.dns_5)))
                        list.add(Theme(6, activity?.resources!!.getString(R.string.dns_6)))
                    }
                }
            }
        }

    }


}