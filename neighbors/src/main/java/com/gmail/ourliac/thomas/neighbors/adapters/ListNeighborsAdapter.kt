package com.mbds.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.ourliac.thomas.neighbors.R
import com.gmail.ourliac.thomas.neighbors.adapters.ListNeighborHandler
import com.gmail.ourliac.thomas.neighbors.models.Neighbor

class ListNeighborsAdapter(
    items: List<Neighbor>,
    private var listNeighborsHandler: ListNeighborHandler
    ) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {
    private val mNeighbors: List<Neighbor> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.neighbor_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbor: Neighbor = mNeighbors[position]
        // Display Neighbor Name
        holder.mNeighborName.text = neighbor.name
        val context = holder.mNeighborAvatar
// Display Neighbor Avatar
        Glide.with(context)
            .load(neighbor.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_baseline_person_outline_24)
            .error(R.drawable.ic_baseline_person_outline_24)
            .skipMemoryCache(false)
            .into(holder.mNeighborAvatar)

        holder.mDeleteButton.setOnClickListener() {
            listNeighborsHandler.onDeleteNeighbor(neighbor)
        }
    }

    override fun getItemCount(): Int {
        return mNeighbors.size
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val mNeighborAvatar: ImageView
        val mNeighborName: TextView
        val mDeleteButton: ImageButton

        init {
            // Enable click on item
            mNeighborAvatar = view.findViewById(R.id.item_list_avatar)
            mNeighborName = view.findViewById(R.id.item_list_name)
            mDeleteButton = view.findViewById(R.id.item_list_delete_button)
        }
    }
}
