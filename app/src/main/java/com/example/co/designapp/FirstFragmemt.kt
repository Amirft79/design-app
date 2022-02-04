package com.example.co.designapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.co.designapp.databinding.FragmentFirstFragmemtBinding


class FirstFragmemt : Fragment() {


    private var _binding: FragmentFirstFragmemtBinding? =null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentFirstFragmemtBinding.inflate(layoutInflater,container,false)
        val view=binding.root
        binding.btnFirstFragment.setOnClickListener {
            val action=FirstFragmemtDirections.actionFirstFragmemtToBlankFragment()
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

    companion object {
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}