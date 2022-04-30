package uz.hamroev.linuxgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.hamroev.linuxgo.R
import uz.hamroev.linuxgo.adapters.ModulAdapter
import uz.hamroev.linuxgo.adapters.SubjectAdapter
import uz.hamroev.linuxgo.databinding.FragmentHomeBinding
import uz.hamroev.linuxgo.models.Content
import uz.hamroev.linuxgo.models.Modul
import uz.hamroev.linuxgo.models.Subject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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


        loadSubjects()
        loadAdapter()

        loadModul()
        loadModulAdapter()





        return binding.root
    }

    private fun loadModulAdapter() {
        modulAdapter = ModulAdapter(
            binding.root.context,
            listModule,
            object : ModulAdapter.OnModuleItemCLickListener {
                override fun onCLick(modul: Modul, position: Int, contentPosition: Int) {

                }
            })
        binding.rvModule.adapter = modulAdapter
    }

    private fun loadModul() {
        listModule = ArrayList()

        val listContent1 = ArrayList<Content>()
        listContent1.add(Content("", "", "8 Lesson", R.drawable.ic_getting_started))
        listContent1.add(Content("", "", "8 Lesson", R.drawable.ic_getting_started))
        listContent1.add(Content("", "", "8 Lesson", R.drawable.ic_getting_started))
        listContent1.add(Content("", "", "8 Lesson", R.drawable.ic_getting_started))

        val listContent2 = ArrayList<Content>()
        listContent2.add(Content("", "", "6 Lesson", R.drawable.ic_getting_started))
        listContent2.add(Content("", "", "6 Lesson", R.drawable.ic_getting_started))
        listContent2.add(Content("", "", "6 Lesson", R.drawable.ic_getting_started))
        listContent2.add(Content("", "", "6 Lesson", R.drawable.ic_getting_started))

        val listContent3 = ArrayList<Content>()
        listContent3.add(Content("", "", "4 Lesson", R.drawable.ic_getting_started))
        listContent3.add(Content("", "", "4 Lesson", R.drawable.ic_getting_started))
        listContent3.add(Content("", "", "4 Lesson", R.drawable.ic_getting_started))
        listContent3.add(Content("", "", "4 Lesson", R.drawable.ic_getting_started))

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
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
        list.add(
            Subject(
                resources.getString(R.string.getting_started),
                R.drawable.ic_getting_started
            )
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}