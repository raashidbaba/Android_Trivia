package com.example.androidtrivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidtrivia.databinding.GameWonFragmentBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GameWonFragmentBinding>(
            inflater,
            R.layout.game_won_fragment,
            container,
            false
        )
        binding.nextMatchButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment2)
        }
        return binding.root
    }
}