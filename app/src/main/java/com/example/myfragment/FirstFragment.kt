package com.example.myfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

private const val ARG_KEY = "key"

class FirstFragment : Fragment() {

    private var text:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_KEY,"初期値")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView:TextView = view.findViewById(R.id.frag_text)
        textView.setText(text)

        var button:Button = view.findViewById(R.id.second_to_button)

        button.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.main_frame, SecondFragment())
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object{
        @JvmStatic
        fun newInstance(text:String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_KEY,text)
                }
            }
    }
}