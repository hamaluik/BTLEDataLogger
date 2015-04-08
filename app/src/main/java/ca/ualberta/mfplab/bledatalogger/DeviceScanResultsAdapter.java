package ca.ualberta.mfplab.bledatalogger;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mfplab on 08/04/2015.
 */
public class DeviceScanResultsAdapter extends BaseAdapter {
    private DeviceScanActivity hostActivity;

    public DeviceScanResultsAdapter(DeviceScanActivity hostActivity) {
        this.hostActivity = hostActivity;
    }

    @Override
    public int getCount() {
        return hostActivity.bluetoothDevices.size();
    }

    @Override
    public Object getItem(int i) {
        return hostActivity.bluetoothDevices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int row, View view, ViewGroup group) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)hostActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_scan_result, group, false);
        }

        TextView rssiIndicator = (TextView)view.findViewById(R.id.rssiIndicator);
        TextView deviceName = (TextView)view.findViewById(R.id.deviceName);
        TextView deviceDescription = (TextView)view.findViewById(R.id.deviceDescription);
        Button connectButton = (Button)view.findViewById(R.id.connectToDevice);

        BluetoothDevice device = hostActivity.bluetoothDevices.get(row);
        rssiIndicator.setText(hostActivity.deviceRSSIs.get(device).toString());
        deviceName.setText(device.getName());
        deviceDescription.setText(device.getAddress());

        return view;
    }


}
