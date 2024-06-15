package deus.pet.onboarding.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import deus.pet.data.local.Pref
import deus.pet.onboarding.R
import deus.pet.onboarding.databinding.FragmentOnBoardingBinding
import deus.pet.onboarding.ui.onboarding.adapter.OnBoardingAdapter
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    // Создайте переменную для хранения binding
    private var _binding: FragmentOnBoardingBinding? = null

    // Это свойство используется для доступа к binding и предотвращения утечек памяти
    private val binding get() = _binding!!

    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.wormDotsIndicator.attachTo(binding.viewPager)
    }

    private fun onClick() {
        pref.onBoardingShow()
        findNavController().navigate(R.id.homeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Обнуляем _binding чтобы предотвратить утечки памяти
        _binding = null
    }
}