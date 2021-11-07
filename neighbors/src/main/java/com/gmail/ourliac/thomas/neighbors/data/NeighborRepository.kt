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

    fun getNeighbor(position: Int): Neighbor = apiService.showNeighbor(position)

    fun removeNeighborFromList(neighbor: Neighbor) = apiService.deleteNeighbor(neighbor)

    fun createNeighbor(neighbor: Neighbor) = apiService.createNeighbor(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
