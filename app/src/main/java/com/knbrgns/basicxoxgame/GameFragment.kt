package com.knbrgns.basicxoxgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.knbrgns.basicxoxgame.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private val args: GameFragmentArgs by navArgs()
    private var player: Int = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNewGame.visibility = View.GONE

        binding.tvGameTurn.text = "Sıra sende ${args.name1}"

        binding.imageView1.setOnClickListener {
            imageClick(binding.imageView1)
        }

        binding.imageView2.setOnClickListener {
            imageClick(binding.imageView2)
        }

        binding.imageView3.setOnClickListener {
            imageClick(binding.imageView3)
        }

        binding.imageView4.setOnClickListener {
            imageClick(binding.imageView4)
        }

        binding.imageView5.setOnClickListener {
            imageClick(binding.imageView5)
        }

        binding.imageView6.setOnClickListener {
            imageClick(binding.imageView6)
        }

        binding.imageView7.setOnClickListener {
            imageClick(binding.imageView7)
        }

        binding.imageView8.setOnClickListener {
            imageClick(binding.imageView8)
        }

        binding.imageView9.setOnClickListener {
            imageClick(binding.imageView9)
        }
    }

    private fun imageClick(imageView: ImageView) {
        if (player == 1) {
            imageView.setImageResource(R.drawable.x_vector)
            imageView.tag = "X"
            player = 2
            binding.tvGameTurn.text = "Sıra sende ${args.name2}"
            checkWin()
        } else {
            imageView.setImageResource(R.drawable.o_vector)
            imageView.tag = "O"
            player = 1
            binding.tvGameTurn.text = "Sıra sende ${args.name1}"
            checkWin()
        }
    }

    private fun checkWin() {
        if (checkLine(binding.imageView1, binding.imageView2, binding.imageView3) ||
            checkLine(binding.imageView4, binding.imageView5, binding.imageView6) ||
            checkLine(binding.imageView7, binding.imageView8, binding.imageView9) ||
            checkLine(binding.imageView1, binding.imageView4, binding.imageView7) ||
            checkLine(binding.imageView2, binding.imageView5, binding.imageView8) ||
            checkLine(binding.imageView3, binding.imageView6, binding.imageView9) ||
            checkLine(binding.imageView1, binding.imageView5, binding.imageView9) ||
            checkLine(binding.imageView3, binding.imageView5, binding.imageView7)) {

            binding.tvGameTurn.text = if (player == 1) "Kazanan ${args.name2}" else "Kazanan ${args.name1}"
            binding.btnNewGame.visibility = View.VISIBLE
        }
    }

    private fun checkLine(view1: ImageView, view2: ImageView, view3: ImageView): Boolean {
        val tag1 = view1.tag
        return tag1 != null && tag1 == view2.tag && tag1 == view3.tag
    }
}