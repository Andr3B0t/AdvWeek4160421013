package com.ubaya.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.myapplication.R
import com.ubaya.myapplication.databinding.FragmentStudentDetailBinding
import com.ubaya.myapplication.databinding.FragmentStudentListBinding
import com.ubaya.myapplication.viewmodel.DetailViewModel
import com.ubaya.myapplication.viewmodel.ListViewModel


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer{
            binding.txtID.setText(it.id)
            binding.txtName.setText(it.name)
            binding.txtDoB.setText(it.dob)
            binding.txtPhone.setText(it.phone)
        })

    }

}