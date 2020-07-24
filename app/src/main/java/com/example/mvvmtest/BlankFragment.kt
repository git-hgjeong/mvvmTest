package com.example.mvvmtest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.room.BlankEntity

class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel
    private lateinit var txt1 : TextView
    private lateinit var txt2 : TextView
    private lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        var view = inflater.inflate(R.layout.blank_fragment, container, false)
        txt1 = view.findViewById(R.id.editTextTextPersonName)
        txt2 = view.findViewById(R.id.editTextTextPersonName2)
        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            viewModel.insert(BlankEntity("1",txt1.text.toString(),txt2.text.toString()))
        }


/*
        txt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s : Editable?){
                val txt = txt1.text.toString()
                Log.d("debug-txt",txt)
                viewModel.setField1("1", txt)
            }
        })
*/
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

        viewModel.blank.observe(requireActivity(), Observer {
            if(it == null){
                Log.d("debug", "BlankEntity is null")
                //viewModel.insert(BlankEntity("1","1111","2222"))
            }else {
                Log.d("debug-field1", it.filed1)
                Log.d("debug-field2", it.filed2)
                txt1.text = it.filed1
                txt2.text = it.filed2
            }
        })


    }

}