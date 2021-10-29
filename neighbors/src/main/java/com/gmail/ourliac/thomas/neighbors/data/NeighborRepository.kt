package com.gmail.ourliac.thomas.neighbors.data

import com.gmail.ourliac.thomas.neighbors.data.service.DummyNeighborApiService
import com.gmail.ourliac.thomas.neighbors.data.service.NeighborApiService
import com.gmail.ourliac.thomas.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbors(): List<Neighbor> = apiService.neighbors

    fun deleteNeighbor(neighbor: Neighbor) = apiService.deleteNeighbor(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
