package com.example.co.designapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.co.designapp.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? =null
    private val binding get() = _binding!!
    private val arg:BlankFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentBlankBinding.inflate(layoutInflater,container,false)
        val view =binding.root
        binding.textViewBlank.text="the args :${arg.buttonname}"
        binding.btnBlankToFirst.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_firstFragmemt)
        }
        return view

    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }


}