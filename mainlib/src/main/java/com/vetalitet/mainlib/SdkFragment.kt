package com.vetalitet.mainlib

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SdkFragment: Fragment(R.layout.fragment_sdk) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + Job())
    private val viewModel by lazy {
        ViewModelProvider(this)[TestViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.testFlow.collect {
                    view.findViewById<TextView>(R.id.tv3).text = it
                }
            }
        }
    }

}
