package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = DieFragment.newInstance(100)
        /*findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).throwDie()
        }*/

        if (supportFragmentManager.findFragmentById(R.id.dieContainer) !is DieFragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.dieContainer, fragment)
            .commit()
        }
    }

    override fun buttonClicked() {
        TODO("Not yet implemented")
    }
}