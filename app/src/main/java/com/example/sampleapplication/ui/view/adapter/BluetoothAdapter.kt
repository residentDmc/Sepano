package com.example.sampleapplication.ui.view.adapter

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapplication.databinding.ItemBluetoothBinding

class BluetoothAdapter(
    private val context: Context
) : RecyclerView.Adapter<BluetoothAdapter.BluetoothViewHolder>() {

    private var list: ArrayList<BluetoothDevice> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BluetoothAdapter.BluetoothViewHolder {
        val itemAddressBinding =
            ItemBluetoothBinding.inflate(LayoutInflater.from(context), parent, false)
        return BluetoothViewHolder(itemAddressBinding)
    }

    override fun onBindViewHolder(holder: BluetoothAdapter.BluetoothViewHolder, position: Int) {
        holder.bind(list[position])
    }


    override fun getItemCount(): Int = list.size

    fun updateList(listBluetoothDevice: BluetoothDevice?) {
        listBluetoothDevice?.let { it ->
            val resultItem=list.find { it.address==listBluetoothDevice.address }
            if (resultItem==null){
                list.add(it)
                notifyDataSetChanged()
            }
        }
    }

    fun clearList() {
        if (list.isNotEmpty()){
            list.clear()
            notifyDataSetChanged()
        }
    }

    inner class BluetoothViewHolder(private val binding: ItemBluetoothBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BluetoothDevice) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) return
            item.name.let {
                if (it==null){
                    binding.txtDevice.visibility= View.GONE
                }else{
                    binding.txtDevice.visibility= View.VISIBLE
                    binding.txtDevice.text = it
                }
            }
            binding.txtAddress.text = item.address

        }
    }
}