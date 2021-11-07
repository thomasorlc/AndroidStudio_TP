package com.gmail.ourliac.thomas.neighbors.adapters

import com.gmail.ourliac.thomas.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeighbor(neighbor: Neighbor)
    fun onCreateNeighbor(neighbor: Neighbor)
}
