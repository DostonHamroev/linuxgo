package uz.hamroev.linuxgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.hamroev.linuxgo.R
import uz.hamroev.linuxgo.adapters.ModulAdapter
import uz.hamroev.linuxgo.adapters.SubjectAdapter
import uz.hamroev.linuxgo.cache.Cache
import uz.hamroev.linuxgo.databinding.FragmentHomeBinding
import uz.hamroev.linuxgo.models.Content
import uz.hamroev.linuxgo.models.Modul
import uz.hamroev.linuxgo.models.Subject

class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    lateinit var list: ArrayList<Subject>
    lateinit var subjectAdapter: SubjectAdapter

    lateinit var listModule: ArrayList<Modul>
    lateinit var modulAdapter: ModulAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        startTypeWriter()
        loadSubjects()
        loadAdapter()
        loadModul()
        loadModulAdapter()

        return binding.root
    }

    private fun startTypeWriter() {
        binding.typeWriter.animateText("Linux Go")
        binding.typeWriter.setCharacterDeley(100)
    }

    private fun loadModulAdapter() {
        modulAdapter = ModulAdapter(
            binding.root.context,
            listModule,
            object : ModulAdapter.OnModuleItemCLickListener {
                override fun onCLick(modul: Modul, position: Int, contentPosition: Int) {
                    Cache.modulePoition = position
                    Cache.contentPosition = contentPosition
                    findNavController().navigate(R.id.subjectsFragment)
                }
            })
        binding.rvModule.adapter = modulAdapter
    }

    private fun loadModul() {
        listModule = ArrayList()

        val listContent1 = ArrayList<Content>()
        listContent1.add(
            Content(
                resources.getString(R.string.getting_started),
                resources.getString(R.string.getting_started_info),
                resources.getString(R.string.lesson_count_getting_started),
                R.drawable.ic_getting_started
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.command_line),
                resources.getString(R.string.command_line_info),
                resources.getString(R.string.lesson_count_command_line),
                R.drawable.command_line
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.text_fu),
                resources.getString(R.string.text_fu_info),
                resources.getString(R.string.lesson_count_text_fu),
                R.drawable.text_fu
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.text_fu_advanced),
                resources.getString(R.string.text_fu_advanced_info),
                resources.getString(R.string.lesson_count_text_fu_advanced),
                R.drawable.text_fu_advanced
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.user_management),
                resources.getString(R.string.user_management_info),
                resources.getString(R.string.lesson_count_user_management),
                R.drawable.user_management
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.permissions),
                resources.getString(R.string.permissions_info),
                resources.getString(R.string.lesson_count_permissions),
                R.drawable.access
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.processes),
                resources.getString(R.string.processes_info),
                resources.getString(R.string.lesson_count_processes),
                R.drawable.processes
            )
        )
        listContent1.add(
            Content(
                resources.getString(R.string.packages),
                resources.getString(R.string.packages_info),
                resources.getString(R.string.lesson_count_packages),
                R.drawable.package_management
            )
        )

        val listContent2 = ArrayList<Content>()
        listContent2.add(
            Content(
                resources.getString(R.string.devices),
                resources.getString(R.string.devices_info),
                resources.getString(R.string.lesson_count_devices),
                R.drawable.devices
            )
        )
        listContent2.add(
            Content(
                resources.getString(R.string.the_filesystem),
                resources.getString(R.string.the_filesystem_info),
                resources.getString(R.string.lesson_count_the_filesystem),
                R.drawable.filesystem
            )
        )
        listContent2.add(
            Content(
                resources.getString(R.string.boot_the_system),
                resources.getString(R.string.boot_the_system_info),
                resources.getString(R.string.lesson_count_boot_the_system),
                R.drawable.booting
            )
        )
        listContent2.add(
            Content(
                resources.getString(R.string.kernel),
                resources.getString(R.string.kernel_info),
                resources.getString(R.string.lesson_count_kernel),
                R.drawable.kernel
            )
        )
        listContent2.add(
            Content(
                resources.getString(R.string.init),
                resources.getString(R.string.init_info),
                resources.getString(R.string.lesson_count_init),
                R.drawable.init
            )
        )
        listContent2.add(
            Content(
                resources.getString(R.string.process_utilization),
                resources.getString(R.string.process_utilization_info),
                resources.getString(R.string.lesson_count_process_utilization),
                R.drawable.process_utilization
            )
        )
        listContent2.add(
            Content(
                resources.getString(R.string.logging),
                resources.getString(R.string.logging_info),
                resources.getString(R.string.lesson_count_logging),
                R.drawable.logging
            )
        )

        val listContent3 = ArrayList<Content>()
        listContent3.add(
            Content(
                resources.getString(R.string.network_sharing),
                resources.getString(R.string.network_sharing_info),
                resources.getString(R.string.lesson_count_network_sharing),
                R.drawable.network_sharing
            )
        )
        listContent3.add(
            Content(
                resources.getString(R.string.network_basic),
                resources.getString(R.string.network_basic_info),
                resources.getString(R.string.lesson_count_network_basic),
                R.drawable.network_fundamentals
            )
        )
        listContent3.add(
            Content(
                resources.getString(R.string.subnetting),
                resources.getString(R.string.subnetting_info),
                resources.getString(R.string.lesson_count_subnetting),
                R.drawable.subnetting
            )
        )
        listContent3.add(
            Content(
                resources.getString(R.string.routing),
                resources.getString(R.string.routing_info),
                resources.getString(R.string.lesson_count_routing),
                R.drawable.routing
            )
        )
        listContent3.add(
            Content(
                resources.getString(R.string.network_config),
                resources.getString(R.string.network_config_info),
                resources.getString(R.string.lesson_count_network_config),
                R.drawable.network_configuration
            )
        )
        listContent3.add(
            Content(
                resources.getString(R.string.troubleshooting),
                resources.getString(R.string.troubleshooting_info),
                resources.getString(R.string.lesson_count_troubleshooting),
                R.drawable.network_troubleshooting
            )
        )
        listContent3.add(
            Content(
                resources.getString(R.string.dns),
                resources.getString(R.string.dns_info),
                resources.getString(R.string.lesson_count_dns),
                R.drawable.dns
            )
        )

        listModule.add(Modul("Grasshopper", listContent1))
        listModule.add(Modul("Journeyman", listContent2))
        listModule.add(Modul("Networking Nomad", listContent3))

    }

    private fun loadAdapter() {
        subjectAdapter = SubjectAdapter(
            binding.root.context,
            list,
            object : SubjectAdapter.OnSubjectClickListener {
                override fun onCLick(subject: Subject, position: Int) {

                    if (position >= 0 && position <= 7) {
                        Cache.modulePoition = 0
                        Cache.contentPosition = position
                        findNavController().navigate(R.id.subjectsFragment)
                    }
                    if (position >= 8 && position <= 14) {
                        Cache.modulePoition = 1
                        when (position) {
                            8 -> {
                                Cache.contentPosition = 0
                            }
                            9 -> {
                                Cache.contentPosition = 1
                            }
                            10 -> {
                                Cache.contentPosition = 2
                            }
                            11 -> {
                                Cache.contentPosition = 3
                            }
                            12 -> {
                                Cache.contentPosition = 4
                            }
                            13 -> {
                                Cache.contentPosition = 5
                            }
                            14 -> {
                                Cache.contentPosition = 6
                            }
                        }
                        findNavController().navigate(R.id.subjectsFragment)
                    }
                    if (position >= 15 && position <= 21) {
                        Cache.modulePoition = 2
                        when (position) {
                            15 -> {
                                Cache.contentPosition = 0
                            }
                            16 -> {
                                Cache.contentPosition = 1
                            }
                            17 -> {
                                Cache.contentPosition = 2
                            }
                            18 -> {
                                Cache.contentPosition = 3
                            }
                            19 -> {
                                Cache.contentPosition = 4
                            }
                            20 -> {
                                Cache.contentPosition = 5
                            }
                            21 -> {
                                Cache.contentPosition = 6
                            }
                        }
                        findNavController().navigate(R.id.subjectsFragment)
                    }


                }
            })
        binding.rvSubject.adapter = subjectAdapter
    }

    private fun loadSubjects() {
        list = ArrayList()
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(Subject(resources.getString(R.string.command_line), R.drawable.command_line))
        list.add(Subject(resources.getString(R.string.text_fu), R.drawable.text_fu))
        list.add(
            Subject(
                resources.getString(R.string.text_fu_advanced),
                R.drawable.text_fu_advanced
            )
        )
        list.add(Subject(resources.getString(R.string.user_management), R.drawable.user_management))
        list.add(Subject(resources.getString(R.string.permissions), R.drawable.access))
        list.add(Subject(resources.getString(R.string.processes), R.drawable.processes))
        list.add(Subject(resources.getString(R.string.packages), R.drawable.package_management))
        list.add(Subject(resources.getString(R.string.devices), R.drawable.devices))
        list.add(Subject(resources.getString(R.string.the_filesystem), R.drawable.filesystem))
        list.add(Subject(resources.getString(R.string.boot_the_system), R.drawable.booting))
        list.add(Subject(resources.getString(R.string.kernel), R.drawable.kernel))
        list.add(Subject(resources.getString(R.string.init), R.drawable.init))
        list.add(
            Subject(
                resources.getString(R.string.process_utilization),
                R.drawable.process_utilization
            )
        )
        list.add(Subject(resources.getString(R.string.logging), R.drawable.logging))
        list.add(Subject(resources.getString(R.string.network_sharing), R.drawable.network_sharing))
        list.add(
            Subject(
                resources.getString(R.string.network_basic),
                R.drawable.network_fundamentals
            )
        )
        list.add(Subject(resources.getString(R.string.subnetting), R.drawable.subnetting))
        list.add(Subject(resources.getString(R.string.routing), R.drawable.routing))
        list.add(
            Subject(
                resources.getString(R.string.network_config),
                R.drawable.network_configuration
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.troubleshooting),
                R.drawable.network_troubleshooting
            )
        )
        list.add(Subject(resources.getString(R.string.dns), R.drawable.dns))

    }


}