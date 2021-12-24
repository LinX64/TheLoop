package com.client.theloop.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.client.theloop.databinding.FragmentMainBinding
import com.client.theloop.model.MyList
import com.client.theloop.ui.adapters.MyAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        val myLst = arrayListOf(MyList("MotionLayout Example"), MyList("RecyclerView Animation"))
        myAdapter = MyAdapter(myLst)

        binding.recyclerView.adapter = myAdapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}