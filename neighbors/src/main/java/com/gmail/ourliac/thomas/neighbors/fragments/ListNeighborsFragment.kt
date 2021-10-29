package com.gmail.ourliac.thomas.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.ourliac.thomas.neighbors.R
import com.gmail.ourliac.thomas.neighbors.adapters.ListNeighborHandler
import com.gmail.ourliac.thomas.neighbors.data.NeighborRepository
import com.gmail.ourliac.thomas.neighbors.models.Neighbor
import com.mbds.myapplication.adapters.ListNeighborsAdapter

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbors()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Voulez-vous supprimer ce voisin ?")
                .setCancelable(false)
                .setPositiveButton("Oui") { dialog, id ->
                    NeighborRepository.getInstance().deleteNeighbor(neighbor)
                    dialog.dismiss()
                    refreshViewNeighbors()
                }
                .setNegativeButton("Non") { dialog, id ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

    private fun refreshViewNeighbors() {
        val neighbors = NeighborRepository.getInstance().getNeighbors()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
