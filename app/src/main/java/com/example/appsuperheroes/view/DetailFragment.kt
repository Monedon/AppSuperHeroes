package com.example.appsuperheroes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.appsuperheroes.R
import com.example.appsuperheroes.databinding.FragmentDetailBinding

import com.example.appsuperheroes.viewmodel.HeroesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var  binding: FragmentDetailBinding
    private val viewModel:HeroesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentDetailBinding.inflate(layoutInflater)
        viewModel.getDetail().observe(viewLifecycleOwner, {
            it?.let {
                binding.tvRealName.text = it.biography.fullName
                binding.tvName.text = it.name
                // binding.tvPublisher.text=it.biography.alignment
                binding.ivDetail.load(it.images.lg)
                binding.tvIntel.text = it.powerstats.intelligence.toString()
                binding.tvCombat.text = it.powerstats.combat.toString()
                binding.tvDurability.text = it.powerstats.durability.toString()
                binding.tvPower.text = it.powerstats.power.toString()
                binding.tvSpeed.text = it.powerstats.speed.toString()
                binding.tvStrength.text = it.powerstats.strength.toString()
                binding.tvHeight.text = it.appearance.height.toString()
            }
        })



        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}