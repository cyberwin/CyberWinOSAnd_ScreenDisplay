package CyberWinPHP.device;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;

import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.R;

import java.util.List;
import java.util.Random;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.Cyber_JsPrinterStandard;

public class MyScanV2024Activity    extends Activity implements
        DecoratedBarcodeView.TorchListener {

private CaptureManager capture;
private DecoratedBarcodeView barcodeScannerView;
private Button switchFlashlightButton;
private ViewfinderView viewfinderView;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scanner);

        barcodeScannerView = findViewById(R.id.zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);

        switchFlashlightButton = findViewById(R.id.switch_flashlight);

        viewfinderView = findViewById(R.id.zxing_viewfinder_view);

        // if the device does not have flashlight in its camera,
        // then remove the switch flashlight button...
        if (!hasFlash()) {
        switchFlashlightButton.setVisibility(View.GONE);
        }

       // barcodeScannerView.decodeSingle(未来之窗扫码callback);
        beepManager = new BeepManager(this);

        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.setShowMissingCameraPermissionDialog(false);
      //2024-6-12 废弃  capture.decode();
        capture.未来之窗扫码_解码(未来之窗扫码callback);


        changeMaskColor(null);
        changeLaserVisibility(true);
        }
        private BeepManager beepManager;
        private BarcodeCallback 未来之窗扫码callback = new BarcodeCallback() {
                @Override
                public void barcodeResult(final BarcodeResult result) {
                     //   barcodeView.pause();
                      //  beepManager.playBeepSoundAndVibrate();
                        barcodeScannerView.pause();
                        beepManager.playBeepSoundAndVibrate();

                      //  handler.post(() -> returnResult(result));

                        // cyber_scan_result = result.getText();
                        String 未来之窗扫码结果= result.getText();
                        if(未来之窗扫码结果.length()<1){
                                未来之窗扫码结果="cyber_error";
                        }
                        Cyber_JsPrinterStandard.cyber_scan_result=未来之窗扫码结果;
                        Toast.makeText(Cyber_Public_Var.cyber_main_instance, "扫码："+未来之窗扫码结果, Toast.LENGTH_SHORT).show();

                        finish(); //结束当前的activity的生命周期
                }

                @Override
                public void possibleResultPoints(List<ResultPoint> resultPoints) {

                }
        };


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
//2024-6-7
        if (keyCode== android.view.KeyEvent.KEYCODE_BACK ){
                //cwpd_Web.goBack();
                Cyber_JsPrinterStandard.cyber_scan_result="cyber_error";
                finish();
                return super.onKeyDown(keyCode, event);
                //  return true;
        }
      //  return super.onKeyDown(keyCode, event);
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
        if (getString(R.string.turn_on_flashlight).equals(switchFlashlightButton.getText())) {
        barcodeScannerView.setTorchOn();
        } else {
        barcodeScannerView.setTorchOff();
        }
        }

public void changeMaskColor(View view) {
        Random rnd = new Random();
        int color = Color.argb(100, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        viewfinderView.setMaskColor(color);
        }

public void changeLaserVisibility(boolean visible) {
        viewfinderView.setLaserVisibility(visible);
        }

@Override
public void onTorchOn() {
        switchFlashlightButton.setText(R.string.turn_off_flashlight);
        }

@Override
public void onTorchOff() {
        switchFlashlightButton.setText(R.string.turn_on_flashlight);
        }

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        capture.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        }
