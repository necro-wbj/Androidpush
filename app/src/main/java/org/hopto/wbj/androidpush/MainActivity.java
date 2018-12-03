package org.hopto.wbj.androidpush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

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

        //連線 請求 回應處理 物件
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req = new StringRequest(
                Request.Method.GET,
                "http:10.184.12.54/test.txt",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG,response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG,error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> p = new HashMap<String, String>();
                p.put("t","之前的Token");
                p.put("n","名字");
                return p;
            }
        };
        queue.add(req);

    }
}
