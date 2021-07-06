package com.example.myapplication

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            binding.root.findViewById<View>(R.id.main_view2).
            setRenderEffect(RenderEffect.createBlurEffect(10f, 10f, Shader.TileMode.CLAMP))
            Thread(Runnable {
                Thread.sleep(4000);
                requireActivity().runOnUiThread {
                    binding.root.findViewById<View>(R.id.main_view2).setRenderEffect(null);
                }
            }).start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}