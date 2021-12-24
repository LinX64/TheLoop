package com.client.theloop.ui.fragments.featured

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.client.theloop.databinding.FragmentFeaturedBinding
import com.client.theloop.model.CourseId
import com.client.theloop.model.courses
import com.client.theloop.util.SpringAddItemAnimator
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class FeaturedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeaturedBinding.inflate(inflater, container, false).apply {
            val onClick: CourseViewClick = object : CourseViewClick {
                override fun onClick(view: View, courseId: CourseId) {
                    val extras = FragmentNavigatorExtras(
                        view to "shared_element"
                    )
                    val action = FeaturedFragmentDirections.actionFeaturedToLearn(courseId)
                    view.findNavController().navigate(action, extras)
                }
            }
            featuredGrid.apply {
                itemAnimator = SpringAddItemAnimator()
                adapter = FeaturedAdapter(onClick).apply {
                    doOnNextLayout {
                        submitList(courses)
                        doOnNextLayout {
                            startPostponedEnterTransition()
                        }
                    }
                }
            }
        }
        postponeEnterTransition(1000L, TimeUnit.MILLISECONDS)

        return binding.root
    }


}
