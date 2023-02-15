package com.example.test;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.Random;


public class CustomScannerActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener {


    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private Button btn_FlashlightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scanner);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String codeScanned = getIntent().getExtras().getString("cosa", "");

        toolbar.setTitleTextColor(Color.rgb(200,200,200));
        setTitle(codeScanned);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(Color.rgb(45,45,45));


        barcodeScannerView = findViewById(R.id.zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);

        btn_FlashlightButton = findViewById(R.id.btn_flashlight);

        // ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);

        Drawable img = ContextCompat.getDrawable(this, R.drawable.ic_flash);
        img.setBounds( 0, 0, 60, 60 );
        btn_FlashlightButton.setCompoundDrawables( img, null, null, null );

        // if the device does not have flashlight in its camera,
        // then remove the switch flashlight button...
        if (!hasFlash()) {
            btn_FlashlightButton.setVisibility(View.GONE);
        }

        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();

        changeMaskColor(null);

        btn_FlashlightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFlashlight(view);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    /**
     * Check if the device's camera has a Flashlight.
     * @return true if there is Flashlight, otherwise false.
     */
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void switchFlashlight(View view) {
        if (getString(R.string.turn_on_flashlight).contentEquals(btn_FlashlightButton.getText())) {
            barcodeScannerView.setTorchOn();
        } else {
            barcodeScannerView.setTorchOff();
        }
    }

    public void changeMaskColor(View view) {
        Random rnd = new Random();
        int color = Color.argb(100, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
       // viewfinderView.setMaskColor(color);
    }

    @Override
    public void onTorchOn() {
        btn_FlashlightButton.setText(R.string.turn_off_flashlight);
      //  switchFlashlightButton.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_flash_off));
        Drawable img = ContextCompat.getDrawable(this, R.drawable.ic_flash_off);
        //Drawable img = this.getResources().getDrawable( R.drawable.ic_flash_off );
        img.setBounds( 0, 0, 60, 60 );
        btn_FlashlightButton.setCompoundDrawables( img, null, null, null );

    }

    @Override
    public void onTorchOff() {
        btn_FlashlightButton.setText(R.string.turn_on_flashlight);

       // switchFlashlightButton.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_flash));
        Drawable img = ContextCompat.getDrawable(this, R.drawable.ic_flash);
       // Drawable img = this.getResources().getDrawable( R.drawable.ic_flash );
        img.setBounds( 0, 0, 60, 60 );
        btn_FlashlightButton.setCompoundDrawables( img, null, null, null );
    }

}