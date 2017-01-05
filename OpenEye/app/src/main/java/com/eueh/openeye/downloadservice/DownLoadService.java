package com.eueh.openeye.downloadservice;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Even on 16/12/28.
 */

public class DownLoadService extends Service {

    private DownloadManager downloadManager;
    private GetDataBR getDataBR;
    private static String test="";
    private static String url="";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        getDataBR = new GetDataBR();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("MYBR");
        registerReceiver(getDataBR,intentFilter);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initDownManager();
        return super.onStartCommand(intent, flags, startId);
    }

    private void initDownManager() {

        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        if (url.equals("")){
        }else {
            DownloadManager.Request down = new DownloadManager.Request(Uri.parse(url));
            down.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            down.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            down.setVisibleInDownloadsUi(true);
            if (test.equals("")) {
                down.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "test.mp4");
            } else {
                down.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, test + ".mp4");
            }

            downloadManager.enqueue(down);
        }


    }

    class GetDataBR extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            test = intent.getStringExtra("name");
            url = intent.getStringExtra("url");
            initDownManager();

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(getDataBR);
    }
}
