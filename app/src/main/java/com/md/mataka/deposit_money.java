package com.md.mataka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lib.kingja.switchbutton.SwitchMultiButton;

public class deposit_money extends AppCompatActivity {


    ViewDialog progressDialog;
    String url;
    ArrayList<String> gateways = new ArrayList<>();
    String gateway = "";
    SwitchMultiButton mSwitchMultiButton;
    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_money);

        url = constant.prefix + getString(R.string.get_gateway);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        amount = findViewById(R.id.amount);
        mSwitchMultiButton = findViewById(R.id.switchmultibutton);
        findViewById(R.id.whatsapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = constant.whatsapplink;

                Uri uri = Uri.parse(url);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });

        //apicall();

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount.getText().toString().isEmpty() || amount.getText().toString().equals("0")) {
                    amount.setError("Enter valid amount");
                } else {

                    if (mSwitchMultiButton.getVisibility() == View.VISIBLE) {
                        gateway = gateways.get(mSwitchMultiButton.getSelectedTab());
                    }

//                    startActivity(new Intent(deposit_money.this,webview.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("amount",amount.getText().toString()).putExtra("gateway",gateway));
                    Uri uri = Uri.parse("upi://pay?pa=bharatpe09891517390@yesbankltd&pn=md matka&tr=md123&cu=INR&am=" + amount.getText().toString());

                    //BHARATPE09891517390@yesbankltd

                    Log.e("TAG", "onClick: " + uri.toString());


                    Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
                    upiPayIntent.setData(uri);
                    Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

                    startActivityForResult(chooser, 1, null);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (data != null) {
            String response = data.getStringExtra("response");
            Map<String, String> map = new HashMap<>();
            String[] pairs = response.split("&");
            for (String pair : pairs) {
                String[] vals = pair.split("=");
                if (vals.length == 2)
                    map.put(vals[0].toLowerCase(), vals[1].toLowerCase());
            }

            if (Objects.equals(map.get("status"), "success")) {
                updatePayment();
            } else {
                Toast.makeText(deposit_money.this, "Payment Failed", Toast.LENGTH_LONG).show();
            }
        }

    }

    private void apicall() {

        progressDialog = new ViewDialog(deposit_money.this);
        progressDialog.showDialog();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("edsa", "efsdc" + response);
                        progressDialog.hideDialog();
                        try {
                            JSONObject jsonObject1 = new JSONObject(response);

                            JSONArray jsonArray = jsonObject1.getJSONArray("data");
                            for (int a = 0; jsonArray.length() > a; a++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(a);
                                gateways.add(jsonObject.getString("name").toLowerCase());
                            }

                            if (gateways.contains("paytm") && gateways.contains("razorpay")) {
                                mSwitchMultiButton.setText("Paytm", "Razorpay");
                                mSwitchMultiButton.setVisibility(View.VISIBLE);
                            } else if (gateways.contains("paytm") && !gateways.contains("razorpay")) {
                                gateway = "paytm";
                            } else if (!gateways.contains("paytm") && gateways.contains("razorpay")) {
                                gateway = "razorpay";
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.hideDialog();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                        progressDialog.hideDialog();
                        Toast.makeText(deposit_money.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("mobile", getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("mobile", null));


                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }


    void updatePayment() {
        url = constant.prefix + "deposite.php";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    Intent in = new Intent(deposit_money.this, MainActivity.class);

                    startActivity(in);
                },
                error -> {
                    Intent in = new Intent(deposit_money.this, MainActivity.class);

                    startActivity(in);
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("mobile", getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("mobile", null));
                params.put("amount", amount.getText().toString());


                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }

}