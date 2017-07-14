package com.example.ominext.exampleasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.renderscript.Sampler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ominext on 7/14/2017.
 */

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    Activity activity;

    public MyAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(activity, "onPreExecute", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(100);
            //sau khi thực hiện lệnh publishProgress thì hàm onProgressUpdate sẽ được thực thi
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.progressbar);
        int value = values[0];
        progressBar.setProgress(value);
        TextView textNumber = (TextView) activity.findViewById(R.id.text_number);
        textNumber.setText(value + "%");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(activity, "Update done!", Toast.LENGTH_SHORT).show();
    }
}
