package com.client.theloop.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.client.theloop.databinding.ListItemsBinding
import com.client.theloop.model.MyList
import javax.inject.Inject

class ListAdapter @Inject constructor(private val motList: ArrayList<MyList>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ListItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myList: MyList) {
            binding.myList = myList
            binding.executePendingBindings()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(motList[position])
    }

    override fun getItemCount(): Int = motList.size

}

