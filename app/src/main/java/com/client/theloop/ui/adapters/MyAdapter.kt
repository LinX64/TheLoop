package com.client.theloop.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.client.theloop.R
import com.client.theloop.databinding.ListItemsBinding
import com.client.theloop.model.MyList
import javax.inject.Inject

class MyAdapter @Inject constructor(private val businessList: ArrayList<MyList>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ListItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myList: MyList) {
            binding.myList = myList
            binding.executePendingBindings()

            itemView.setOnClickListener {
                when (adapterPosition) {
                    0 -> {
                       // Navigation.findNavController(it).navigate(R.id.motionFragment)
                    }
                    1 -> {
                        Navigation.findNavController(it).navigate(R.id.featured)
                    }

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(businessList[position])
    }

    override fun getItemCount(): Int = businessList.size

}

