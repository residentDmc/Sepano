package com.example.sampleapplication

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.tlgbltcn.library.BluetoothHelper
import c.tlgbltcn.library.BluetoothHelperListener
import com.example.sampleapplication.databinding.FragmentHomeBinding
import com.example.sampleapplication.ui.view.activity.MainActivity
import com.example.sampleapplication.ui.view.adapter.BluetoothAdapter
import com.example.sampleapplication.utils.application.AppService
import com.example.sampleapplication.utils.build_config.BuildConfig.Companion.INTERVAL
import com.example.sampleapplication.utils.extention.setSystemBarColor
import com.example.sampleapplication.utils.tools.HandleErrorTools
import com.example.sampleapplication.utils.tools.ToastTools
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private lateinit var bluetoothHelper: BluetoothHelper
    private val bluetoothAdapter: BluetoothAdapter by inject()
    private val handleErrorTools: HandleErrorTools by inject()
    private val toastTools: ToastTools by inject()
    private var doubleBackToExitPressedOnce = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
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

    override fun onResume() {
        super.onResume()
        bluetoothHelper.registerBluetoothStateChanged()
    }

    override fun onPause() {
        super.onPause()
        bluetoothHelper.unregisterBluetoothStateChanged()
    }

    private fun initAction() {
        initNavController()
        initToolbar()
        initNavigationMenu()
        initOnClick()
        initAdapter()
        initBluetooth()
        initOnBackPress()
    }

    private fun initOnClick() {
        binding.included.imgBtnRefresh.setOnClickListener { initRefreshList() }
    }

    private fun initAdapter() {
        val linearLayoutManager =
            LinearLayoutManager(AppService.context, RecyclerView.VERTICAL, false)
        binding.includeDrawerContent.recyclerView.layoutManager = linearLayoutManager
        binding.includeDrawerContent.recyclerView.setHasFixedSize(true)
        binding.includeDrawerContent.recyclerView.adapter = bluetoothAdapter
    }

    private fun initBluetooth() {
        bluetoothHelper = BluetoothHelper(requireContext(), object : BluetoothHelperListener {
            override fun getBluetoothDeviceList(device: BluetoothDevice?) {
                bluetoothAdapter.updateList(device)
            }

            override fun onDisabledBluetooh() {

            }

            override fun onEnabledBluetooth() {

            }

            override fun onFinishDiscovery() {

            }

            override fun onStartDiscovery() {

            }
        })
            .setPermissionRequired(true)
            .create()
    }

    private fun initToolbar() {
        val currentActivity = (requireActivity() as MainActivity)
        currentActivity.setSupportActionBar(binding.included.toolbar)
        val actionBar = currentActivity.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)
        requireActivity().setSystemBarColor()
        actionBar?.title = null
    }


    private fun initNavigationMenu() {
        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            requireActivity(),
            binding.drawerLayout,
            binding.included.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun setDrawerIndicatorEnabled(enabled: Boolean) {
                super.setDrawerIndicatorEnabled(false) // Disable the default navigation drawer icon
            }
        }
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_bluetooth -> {
                    initRefreshList()
                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_calculate -> {
                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_memory -> {
                    binding.drawerLayout.closeDrawers()
                }

                R.id.nav_exit -> {
                    binding.drawerLayout.closeDrawers()
                    initFinishAffinity()
                }
            }
            true
        }
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun initRefreshList() {
        if (!bluetoothHelper.isBluetoothScanning())
            bluetoothHelper.startDiscovery()
        bluetoothAdapter.clearList()
    }


    private fun initFinishAffinity() {
        requireActivity().finishAffinity()
    }

    private fun initNavController() {
        navController = Navigation.findNavController(AppService.activity, R.id.my_nav_fragment)
    }

    private fun initOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() = initFinish()
            })
    }

    private fun initFinish() {
        if (doubleBackToExitPressedOnce) {
            initFinishAffinity()
        } else toastTools.toast(resources.getString(R.string.exit_app))
        doubleBackToExitPressedOnce = true
        Handler().postDelayed({
            doubleBackToExitPressedOnce = false
        }, INTERVAL)
    }
}