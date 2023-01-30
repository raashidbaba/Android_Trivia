package com.example.androidtrivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
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
            // it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment2)
            it.findNavController()
                .navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment2())
        }
      /*  val args = GameWonFragmentArgs.fromBundle(arguments)
        Toast.makeText(
            context,
            "Num correct: ${args.numCorrect},Num Questions : ${args.numQuestions}",
            Toast.LENGTH_LONG
        ).show()*/
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    // Creating our Share Intent
    private fun getShareIntent(): Intent {
        var args = GameWonFragmentArgs.fromBundle(requireArguments())
      //  val args: GameWonFragmentArgs by navArgs<>()
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_success_text, args.numCorrect, args.numQuestions)
            )
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}