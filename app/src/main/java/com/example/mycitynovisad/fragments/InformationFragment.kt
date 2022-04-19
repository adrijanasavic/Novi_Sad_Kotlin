package com.example.mycitynovisad.fragments

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mycitynovisad.R


class InformationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_info, container, false)
        requireActivity().title = getString(R.string.app_name)
        val textView = rootView.findViewById<TextView>(R.id.ns_des)
        val span: Spannable = SpannableString(textView.text)
        span.setSpan(RelativeSizeSpan(1.8f), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = span
        return rootView
    }
}