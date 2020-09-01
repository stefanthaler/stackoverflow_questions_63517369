package net.thalerit.myapplication.ui.slideshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import net.thalerit.myapplication.R


class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val other: Button = root.findViewById(R.id.gotoother)
        other.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val action =
                    SlideshowFragmentDirections.actionNavSlideshowToNavOther()
                v?.findNavController()?.navigate(action)
            }

        })

        val other2: Button = root.findViewById(R.id.gotoother2)
        other2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val action = SlideshowFragmentDirections.actionNavSlideshowToNavOther2()
                v?.findNavController()?.navigate(action)
            }

        })



        return root
    }
}