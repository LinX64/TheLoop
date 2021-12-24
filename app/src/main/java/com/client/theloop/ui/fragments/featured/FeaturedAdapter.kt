package com.client.theloop.ui.fragments.featured

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.client.theloop.databinding.FeaturedItemBinding
import com.client.theloop.model.Course
import com.client.theloop.model.CourseDiff
import com.client.theloop.model.CourseId
import javax.inject.Inject

class FeaturedAdapter @Inject constructor(
    private val onClick: CourseViewClick
) : ListAdapter<Course, FeaturedViewHolder>(CourseDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        return FeaturedViewHolder(
            FeaturedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}

interface CourseViewClick {
    fun onClick(view: View, courseId: CourseId)
}

class FeaturedViewHolder(
    private val binding: FeaturedItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(course: Course, onClick: CourseViewClick) {
        binding.run {
            this.course = course
            clickHandler = onClick
            executePendingBindings()
        }
    }
}