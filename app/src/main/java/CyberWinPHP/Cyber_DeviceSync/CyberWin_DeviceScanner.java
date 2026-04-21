package CyberWinPHP.Cyber_DeviceSync;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.ynwlzc.framework.cyberwinosand_ScreenDisplay.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import CyberWinPHP.Cyber_CPU.Cyber_Public_Var;
import CyberWinPHP.Cyber_Plus.LogToFile;
import david.demos.SimpleLogger;
import david.support.ext.net.IpScanner;

public class CyberWin_DeviceScanner extends Activity implements IpScanner.ScanCallback {


    private ProgressDialog mProgressDialog = null;
    private IpScanner mIpScanner = null;
    private TextView mTitle =null;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private DismissAction mDismissAction = new DismissAction();
    private List<String> mIps = new ArrayList<>(5);
    private String mHostIp;
    private ListView mListView = null;
    private ListAdapter mListAdapter = new ListAdapter();

    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mIps.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView tv = new TextView(CyberWin_DeviceScanner.this);
            tv.setText("设备:"+ mIps.get(i));
            tv.setGravity(Gravity.LEFT);
            return tv;
        }
    }

    private class DismissAction implements Runnable {

        @Override
        public void run() {
            mProgressDialog.dismiss();
            mTitle.setText("本机地址:"+mHostIp+" | 数量 :"+mIps.size());
            if (mIps.size() <= 0) {
                toast("Devices not found!");
            } else {
                mListAdapter.notifyDataSetChanged();
            }
        }
    }

    private void toast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cyberwin_devicescanner);
       // mListView = (ListView) this.findViewById(R.id.result);
        mListView.setAdapter(mListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String book = mIps.get(i);
               // Toast.makeText(ListViewActivity.this,book.toString(),Toast.LENGTH_LONG).show();
                Toast.makeText(CyberWin_DeviceScanner.this,"book"+book, Toast.LENGTH_SHORT).show();
               String title="设备分发";
                String url="https://51.onelink.ynwlzc.cn/o2o/wap.php?g=Wap&c=CyberWin_LocalApp&a=deviceSetting&clien_ip="+book;

                Intent login = new Intent();//Cyber_Public_Var.cyber_main_instance, CWPDBrowserSignal.class);
                //	mContext.st
                login.putExtra("cyber_param_weburl", url);
                login.putExtra("cyber_param_webtitle", title);
                login.putExtra("cyber_param_scrren_orientation", 100);
                Cyber_Public_Var.cyber_main_instance.startActivity(login);
            }
        });


        mTitle = (TextView)this.findViewById(R.id.title);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("未来之窗智能设备");//2.设置标题

        mProgressDialog.setMessage("正在搜索附近设备，请稍等......");//3.设置显示内容


        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
        mIpScanner = new IpScanner(19875,this)
                .setScannerLogger(new SimpleLogger());
        mIpScanner.startScan();
    }

    @Override
    public void onFound(Set<String> ip, String hostIp, int port) {
        LogToFile.d_windows("设备管理","发现", ""+hostIp);
        mIps.addAll(ip);
        mHostIp = hostIp;
        mUiHandler.post(mDismissAction);
    }

    @Override
    public void onNotFound(String hostIp, int port) {
        mIps.clear();
        mHostIp = hostIp;
      //  Log.v("cdw","onNotFound "+hostIp);
        LogToFile.d_windows("设备管理","没有发现", ""+hostIp);
        mUiHandler.post(mDismissAction);
    }
}
