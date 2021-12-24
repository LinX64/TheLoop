package com.client.theloop.ui.fragments.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.client.theloop.R
import com.client.theloop.databinding.FragmentLearnBinding
import com.client.theloop.model.CourseRepo
import com.client.theloop.util.loadListener
import com.client.theloop.util.transition.MaterialContainerTransition
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class LearnFragment : Fragment() {

    private val args: LearnFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val course = CourseRepo.getCourse(args.courseId)
        val binding = FragmentLearnBinding.inflate(inflater, container, false).apply {

            this.course = course
            imageLoadListener = loadListener {
                startPostponedEnterTransition()
            }
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }

        }

        postponeEnterTransition(1000L, TimeUnit.MILLISECONDS)
        val interp = AnimationUtils.loadInterpolator(
            context,
            android.R.interpolator.fast_out_slow_in
        )
        sharedElementEnterTransition = MaterialContainerTransition(R.id.scroll).apply {
            duration = 400L
            interpolator = interp
        }

        sharedElementReturnTransition = MaterialContainerTransition().apply {
            duration = 300L
            interpolator = interp
        }

        return binding.root
    }
}
