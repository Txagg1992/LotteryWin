package com.curiousca.lotterywin.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.curiousca.lotterywin.R;
import com.curiousca.lotterywin.data.MegaAdapter;
import com.curiousca.lotterywin.data.PowerAdapter;
import com.curiousca.lotterywin.model.MegaItem;
import com.curiousca.lotterywin.model.PowerItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PastNumberActivity extends AppCompatActivity {

    private static final String URL_MEGA = "https://data.ny.gov/resource/5xaw-6ayf.json";
    private static final String URL_POWER = "https://data.ny.gov/resource/d6yy-54nr.json";

    private RecyclerView mRecyclerView;
    private RecyclerView pRecyclerView;
    private MegaAdapter mMegaAdapter;
    private PowerAdapter mPowerAdapter;
    private ArrayList<MegaItem> mMegaItems;
    private ArrayList<PowerItem> mPowerItems;
    private RequestQueue mRequestQueue;
    private RequestQueue pRequestQueue;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_number);

        progressDialog = new ProgressDialog(this);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMegaItems = new ArrayList<>();
        mPowerItems = new ArrayList<>();

        buildRecyclerView();
        buildPowerRecyclerView();
        parseMegaJSon();
        parsePowerJSon();
    }

    private void parsePowerJSon() {

        pRequestQueue = Volley.newRequestQueue(this);

        progressDialog.setMax(100);
        progressDialog.setTitle("Retrieving Lottery Numbers");
        progressDialog.setMessage("Loading");
        progressDialog.show();

        JsonArrayRequest pRequest = new JsonArrayRequest(Request.Method.GET, URL_POWER, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int j = 0; j < response.length(); j++) {
                                JSONObject pNumber = response.getJSONObject(j);

                                String winningNumbers = pNumber.getString("winning_numbers");
                                String drawDate = pNumber.getString("draw_date");

                                mPowerItems.add(new PowerItem(winningNumbers, drawDate));

                                //Log.d("PastNumberActivity", pNumber.getString("draw_date"));
                                //Log.d("PastNumberActivity", winningNumbers);
                            }
                            mPowerAdapter = new PowerAdapter(PastNumberActivity.this, mPowerItems);
                            pRecyclerView.setAdapter(mPowerAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        pRequestQueue.add(pRequest);

    }

    private void parseMegaJSon() {

        mRequestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL_MEGA, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject number = response.getJSONObject(i);

                                String winningNumbers = number.getString("winning_numbers").toString();
                                String megaBall = number.getString("mega_ball");
                                String drawDate = number.getString("draw_date");

                                mMegaItems.add(new MegaItem(winningNumbers, megaBall, drawDate));
                            }

                            mMegaAdapter = new MegaAdapter(PastNumberActivity.this, mMegaItems);
                            mRecyclerView.setAdapter(mMegaAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);

    }

    private void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerViewMegaBall);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void buildPowerRecyclerView() {
        pRecyclerView = findViewById(R.id.recyclerViewPowerBall);
        pRecyclerView.setHasFixedSize(true);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
