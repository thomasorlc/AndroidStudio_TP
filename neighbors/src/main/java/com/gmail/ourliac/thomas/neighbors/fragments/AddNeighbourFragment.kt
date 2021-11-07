package com.gmail.ourliac.thomas.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.ourliac.thomas.neighbors.R
import com.gmail.ourliac.thomas.neighbors.data.NeighborRepository
import com.gmail.ourliac.thomas.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_neighbor, container, false)
    }

    override fun onSaveButton() {
    }
}
