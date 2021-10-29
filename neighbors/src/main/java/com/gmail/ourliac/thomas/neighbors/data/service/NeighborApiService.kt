package com.gmail.ourliac.thomas.neighbors.data.service

import com.gmail.ourliac.thomas.neighbors.models.Neighbor

interface NeighborApiService {
    /**
     * Get all my Neighbors
     * @return [List]
     */
    val neighbors: List<Neighbor>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbor(neighbor: Neighbor)

    /**
     * Create a neighbor
     * @param neighbor: Neighbor
     */
    fun createNeighbor(neighbor: Neighbor)

    /**
     * Update "Favorite status" of an existing Neighbor"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbor"
     * @param neighbor: Neighbor
     */
    fun updateDataNeighbor(neighbor: Neighbor)
}
