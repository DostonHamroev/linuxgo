package uz.hamroev.linuxgo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import uz.hamroev.linuxgo.R
import uz.hamroev.linuxgo.adapters.DataAdapter
import uz.hamroev.linuxgo.cache.Cache
import uz.hamroev.linuxgo.databinding.FragmentDataBinding
import uz.hamroev.linuxgo.models.Data


class DataFragment : Fragment() {


    lateinit var binding: FragmentDataBinding
    lateinit var dataList: ArrayList<Data>
    lateinit var dataAdapter: DataAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(layoutInflater, container, false)

        binding.title.text = Cache.title_data
        loadData()
        dataAdapter = DataAdapter(binding.root.context, dataList)
        binding.rvData.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvData.adapter = dataAdapter


        return binding.root
    }

    private fun loadData() {
        dataList = ArrayList()
        dataList.clear()
        when (Cache.modulePoition) {
            0 -> {
                when (Cache.contentPosition) {
                    0 -> {
                        when (Cache.dataPosition) {
                            0 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_1_data1)}"))
                            }
                            1 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_2_data1)}"))
                            }
                            2 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_3_data1)}"))
                            }
                            3 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_4_data)}"))
                            }
                            4 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_5_data)}"))
                            }
                            5 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_6_data)}"))
                            }
                            6 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_7_data)}"))
                            }
                            7 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_8_data)}"))
                            }
                            8 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_9_data)}"))
                            }
                            9 -> {
                                dataList.add(Data(DataAdapter.VIEW_TYPE_ONE, "${activity?.resources!!.getString(R.string.getting_10_data)}"))
                            }
                        }
                    }
                    1 -> {
                    }
                    2 -> {
                    }
                    3 -> {
                    }
                    4 -> {
                    }
                    5 -> {
                    }
                    6 -> {
                    }
                    7 -> {
                    }
                }

            }
            1 -> {
                when (Cache.contentPosition) {
                    0 -> {
                    }
                    1 -> {
                    }
                    2 -> {
                    }
                    3 -> {
                    }
                    4 -> {
                    }
                    5 -> {
                    }
                    6 -> {
                    }
                }
            }
            2 -> {
                when (Cache.contentPosition) {
                    0 -> {
                    }
                    1 -> {
                    }
                    2 -> {
                    }
                    3 -> {
                    }
                    4 -> {
                    }
                    5 -> {
                    }
                    6 -> {
                    }
                }
            }
        }


    }


}