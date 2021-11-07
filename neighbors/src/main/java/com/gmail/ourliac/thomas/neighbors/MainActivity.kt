package com.gmail.ourliac.thomas.neighbors

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gmail.ourliac.thomas.neighbors.fragments.AddNeighborFragment
import com.gmail.ourliac.thomas.neighbors.fragments.ListNeighborsFragment
import com.gmail.ourliac.thomas.neighbors.fragments.ShowNeighborFragment

class MainActivity : AppCompatActivity(), NavigationListener {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        showFragment(ListNeighborsFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun updateTitle(title: Int) {
        toolbar.setTitle(title)
    }

    override fun getString(string: String) {
        val bundle = Bundle()
        bundle.putString("string", string)

        val transaction = this.supportFragmentManager.beginTransaction()
        val showNeighborFragment = ShowNeighborFragment()
        showNeighborFragment.arguments = bundle

        transaction.replace(R.id.fragment_container, showNeighborFragment)
        transaction.commit()
    }
}
}
