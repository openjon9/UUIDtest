package com.shoelives.uuidtest;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private TextView textview, textview2, textview3, textview4;
    private String uuid;
    List<Integer> Sizelist;
    private int rodom, rodom2;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.textview);
        textview2 = (TextView) findViewById(R.id.textview2);
        textview3 = (TextView) findViewById(R.id.textview3);
        textview4 = (TextView) findViewById(R.id.textview4);
        permission();
        uuid = UUID.randomUUID().toString();
        Sizelist = new ArrayList<>();

    }

    private void permission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 100);
            return;
        }

    }

    public void ANDROID_ID(View view) {
        textview.setText(ANDROID_ID());
    }

    public void getSim_Serial_Number(View view) {
        textview.setText(getSimSerialNumber());
    }

    public void get_DeviceId(View view) {
        textview.setText(getDeviceId());
    }

    public void getserial(View view) {
        textview.setText(serial());
    }

    public void getUUID(View view) {
        textview.setText(uuid);
    }

    private String ANDROID_ID() {
        String ANDROID_ID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        return ANDROID_ID;
    }

    private String getDeviceId() {
        TelephonyManager thManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        String imei = thManager.getDeviceId();
        return imei;
    }

    private String getSimSerialNumber() {
        TelephonyManager thManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        String sim = thManager.getSimSerialNumber();
        return sim;
    }

    private String serial() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            String serial = Build.SERIAL;
            return serial;
        }
        String btMac = BluetoothAdapter.getDefaultAdapter().getAddress(); //藍芽
        return null;
    }

    private String UUID() {
        //WIFI
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String wifiMac = wm.getConnectionInfo().getMacAddress();

        return wifiMac;
    }


    public void test(View view) {
//        if (Sizelist.size() >= 10) {
//            Sizelist.clear();
//            textview.setText("");
//        }
//        textview.append(String.valueOf(fun()));
        textview.setText("");
        textview2.setText("");
        textview3.setText("");
        textview4.setText("");
        fun4();
    }

    private int fun3() {
        list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            for (int k = 1; k <= 13; k++) {
                switch (i) {
                    case 1:
                        list.add("A" + k);
                        break;
                    case 2:
                        list.add("B" + k);
                        break;
                    case 3:
                        list.add("C" + k);
                        break;
                    case 4:
                        list.add("D" + k);
                        break;
                }
            }
        }
        return list.size();
    }
    private void fun4() {

        for (int i=0;i<=12;i++){
            rodom = (int) (Math.random() * fun3());
            textview.append(list.get(rodom)+"\t\t");
            list.remove(rodom);

            rodom = (int) (Math.random() * fun3());
            textview2.append(list.get(rodom)+"\t\t");
            list.remove(rodom);

            rodom = (int) (Math.random() * fun3());
            textview3.append(list.get(rodom)+"\t\t");
            list.remove(rodom);

            rodom = (int) (Math.random() * fun3());
            textview4.append(list.get(rodom)+"\t\t");
            list.remove(rodom);

        }
    }

    private int fun() {
        rodom = (int) (Math.random() * 10);
        if (Sizelist.size() < 1) {
            Sizelist.add(rodom);
        } else {
            while (fun2()) {
            }
            Sizelist.add(rodom);
        }
        return rodom;
    }

    private boolean fun2() {
        if (Sizelist.contains(rodom)) {
            rodom2 = (int) (Math.random() * 10);
            rodom = rodom2;
            return true;
        } else {
            return false;
        }

    }
}
