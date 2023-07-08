package com.andififian.resto2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivityMaPembuka extends AppCompatActivity implements MakananUtamaInterface{
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    List<ListModelMaPembuka> mListItem;
    private final String BASE_URL = "https://menu-makanan-andi.herokuapp.com/menumakananpembuka";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ma_pembuka);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerlist);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItem = new ArrayList<>();

        request();
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterListMaPembuka(mListItem,MainActivityMaPembuka.this, this);
        mRecyclerview.setAdapter(mAdapter);

    }
    private void request(){
        JsonObjectRequest requestImage = new JsonObjectRequest(Request.Method.GET, BASE_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("JSONResponse", response.toString());

                try {


                    JSONArray data = response.getJSONArray("menu_makanan");
                    for(int i=0; i<data.length(); i++)
                    {
                        ListModelMaPembuka model = new ListModelMaPembuka();
                        model.setMenu_makanan(data.getJSONObject(i).getString("menu_makanan"));
                        model.setDesc_makanan(data.getJSONObject(i).getString("desc_makanan"));
                        model.setHarga(data.getJSONObject(i).getString("harga"));
                        model.setGambar_makanan(data.getJSONObject(i).getString("gambar_makanan"));


                        mListItem.add(model);
                    }



                }catch (JSONException e){
                    e.printStackTrace();
                }


                mAdapter.notifyDataSetChanged();


                /*for(int i=0; i < response.length(); i++){
                    try {
                        JSONObject data = response.getJSONObject(i);
                        ListModel model = new ListModel();
                        model.setId(data.getString("id"));
                        model.setHarga(data.getString("id"));
                        model.setMenu_makanan(data.getString("title"));
                        model.setGambar_makanan(data.getString("id"));

                        mListItem.add(model);


                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                    mAdapter.notifyDataSetChanged();
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERRORRequest", "Error: " + error.getMessage());
            }
        });
        mRequest.add(requestImage);
    }

    @Override
    public void onItemClick(int position) {

    }
}