package com.example.tenantmanagementsystem

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // The Fragment OBJECT is created (no view yet)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onCreate")
    }

    // Build the VIEW from fragment_dashboard.xml
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onCreateView")
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    // The view exists: fill in the metrics and set click listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onViewCreated")

        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()

        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)

        binding.addTenantButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment()
            findNavController().navigate(action)
        }

        binding.viewTenantsButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onStop")
    }

    // The VIEW is destroyed: clear the binding so the old view can be freed
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onDestroyView")
        _binding = null
    }

    // The Fragment OBJECT is destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onDestroy")
    }
}