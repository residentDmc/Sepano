package com.example.sampleapplication.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.FragmentCalculatorBinding
import com.example.sampleapplication.utils.application.AppService
import com.example.sampleapplication.utils.process_calculator.StringCalculator
import com.example.sampleapplication.utils.tools.HandleErrorTools
import org.koin.android.ext.android.inject

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var navController: NavController
    private val handleErrorTools: HandleErrorTools by inject()
    private val operationList: MutableList<String> = arrayListOf()
    private val numberCache: MutableList<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            initAction()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initAction() {
        initNavController()
        initTitleToolbar()
        initOnClick()
    }

    private fun initTitleToolbar() {
        binding.included.toolbarTitle.text = resources.getString(R.string.calculate)
    }

    private fun makeString(list: List<String>, joiner: String = ""): String {
        if (list.isEmpty()) return ""
        return list.reduce { r, s -> r + joiner + s }
    }

    private fun clearCache() {
        numberCache.clear()
        operationList.clear()
    }

    private fun updateDisplay(mainDisplayString: String) {
        val fullCalculationString = makeString(operationList, " ")
        binding.fullCalculationText.text = fullCalculationString
        binding.txtResult.text = mainDisplayString

    }

    private fun clearClick() {
        clearCache()
        updateDisplay("")
    }

    private fun equalsClick() {
        operationList.add(makeString(numberCache))
        numberCache.clear()

        val calculator = StringCalculator()
        val answer = calculator.calculate(operationList)

        updateDisplay("=$answer")
        clearCache()
    }

    private fun negateNumber() {
        if (numberCache.isNotEmpty()) {
            if (numberCache.first().equals("-")) {
                numberCache.removeAt(0)
            } else numberCache.add(0, "-")
        } else numberCache.add("-")

        val numberString = makeString(numberCache)
        updateDisplay(numberString)
    }

    private fun buttonClick(view: View) {
        val button = view as Button
        if (numberCache.isEmpty()) return
        operationList.add(makeString(numberCache))
        numberCache.clear()
        operationList.add(button.text.toString())

        updateDisplay(button.text.toString())
    }

    private fun numberClick(view: View) {
        val button = view as Button
        val numberString = button.text
        numberCache.add(numberString.toString())
        val text = makeString(numberCache)
        updateDisplay(text)
    }

    private fun initOnClick() {
        binding.included.imgBtnBack.setOnClickListener { navController.popBackStack() }
        binding.clearClick.setOnClickListener { clearClick() }
        binding.equalsClick.setOnClickListener { equalsClick() }
        binding.negateNumber.setOnClickListener { negateNumber() }
        binding.divButtonClick.setOnClickListener { buttonClick(it) }
        binding.plusButtonClick.setOnClickListener { buttonClick(it) }
        binding.multiplicationButtonClick.setOnClickListener { buttonClick(it) }
        binding.subtractButton.setOnClickListener { buttonClick(it) }
        binding.zeroButton.setOnClickListener { numberClick(it) }
        binding.oneButton.setOnClickListener { numberClick(it) }
        binding.twoButton.setOnClickListener { numberClick(it) }
        binding.threeButton.setOnClickListener { numberClick(it) }
        binding.fourButton.setOnClickListener { numberClick(it) }
        binding.fiveButton.setOnClickListener { numberClick(it) }
        binding.sixButton.setOnClickListener { numberClick(it) }
        binding.sevenButton.setOnClickListener { numberClick(it) }
        binding.eightButton.setOnClickListener { numberClick(it) }
        binding.nineButton.setOnClickListener { numberClick(it) }
    }

    private fun initNavController() {
        navController = Navigation.findNavController(AppService.activity, R.id.my_nav_fragment)
    }

}