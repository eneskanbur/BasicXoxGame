package com.knbrgns.basicxoxgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.knbrgns.basicxoxgame.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnStartGame.setOnClickListener {
            btnStartClick()
        }
    }

    private fun btnStartClick() {
        val name1 = binding.etName1.text.toString()
        val name2 = binding.etName2.text.toString()
        val action = StartFragmentDirections.actionStartFragmentToGameFragment(name1 = name1, name2 = name2)
        findNavController().navigate(action)
    }
}