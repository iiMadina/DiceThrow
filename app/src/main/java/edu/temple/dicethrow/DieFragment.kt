package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

const val DIESIDE = "sidenumber"
const val KEY = "diceThrow"

class DieFragment : Fragment() {
    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var diceThrow : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.run {
            diceThrow = getInt(KEY)
        }
        if (diceThrow == 0)
            throwDie()
        else
            dieTextView.text = diceThrow.toString()
        /*view.setOnClickListener{
            throwDie()
        }*/
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, diceThrow)
    }

    fun throwDie() {
        diceThrow = Random.nextInt(dieSides) + 1
        dieTextView.text = diceThrow.toString()
    }

    companion object {
        fun newInstance(sides: Int) = DieFragment().apply {
            arguments = Bundle().apply { putInt(DIESIDE, sides) }
        }
    }
}