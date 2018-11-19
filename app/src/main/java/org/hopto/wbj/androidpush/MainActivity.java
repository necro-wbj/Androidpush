package org.hopto.wbj.androidpush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="necro-wbj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bd =getIntent().getExtras();
        //測試用
        if(bd != null){
            for (String k : bd.keySet()){ //類似於python的for k in bd.keySet(): 寫法
                Object v= bd.get(k);
                Log.d(TAG,"收到EXTRA中的: "+"key = "+k + "\tvalue = "+v);
            }
        }
        //通常直接\取值
        // bd.get("某個KEY")
    }
}
