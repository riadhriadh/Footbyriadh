package com.example.riadhfarhati.footbyriadh;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main2Activity extends AppCompatActivity {



    private ArrayList<score> scores;
    private ListView mListView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mListView=(ListView)findViewById(R.id.listv);
        new   Rest1().execute();
    }





    private class Rest1 extends AsyncTask<Void, Void, Boolean> {
        String ress = "";



        //   Toast.makeText(getApplicationContext(), ress, Toast.LENGTH_LONG).show();


        // http://boitedenuit.coolpage.biz/listeven.php

        private ProgressDialog mProgressDialog;
        private JSONArray jsonObjectResult1 = null;





        public Rest1() {



        }
        protected void onPreExecute() {
            super.onPreExecute();
            ConnectionDb con = new ConnectionDb();


            String[] params = {"imei",  "nom"};
            //Http Get Method
            try {
                ress = con.Post("http://riadhfarhati.com/foot/index.php", params);
                Log.e("res1",ress);
            } catch (ExecutionException e1) {
                Log.e("erreur", e1.toString());
                e1.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("erreur", e.toString());
            }
            scores=new ArrayList<score>();
            //  mProgressDialog = ProgressDialog.show(MainActivity.this, "Chargement", "en cours ...", false, false);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            JSONObject jsonObj;


            //  JSONObject jsonbject = new JSONObject(ress);
            //  Log.e("res2s","mode traville");
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(ress);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //  JSONArray jsonArray = jsonbject.getJSONArray(ress);
            Log.e("res1s",jsonArray.toString());
            // Log.e("res1ss",jsonbject.toString());

            try {

                if (jsonArray !=null) {
                    for(int i=0;i<jsonArray.length();i++){
                        jsonObj = jsonArray.getJSONObject(i);
                        //  Log.e("res2s", jsonObj.getString("idEvenement").toString());
                        JSONObject jsonObj2;
                        JSONObject jsonObj3;
                        jsonObj2=  new JSONObject (jsonObj.getString("pubDate").toString());
                        jsonObj3=  new JSONObject (jsonObj.getString("title").toString());
                        score score=new score(


                                jsonObj2.getString("0").toString(),

                                jsonObj3.getString("0").toString()


                        );
                        scores.add(score);



                    }
                    return true;
                }if(jsonArray ==null){
                    return  false;

                }
                else{
                    return  false;

                }

            }catch (Exception ex){
                ex.printStackTrace();


            }


            return true;
        }
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            //   mProgressDialog.dismiss();


            if (aBoolean) {

                remplireScore replire=new remplireScore(Main2Activity.this,scores);
                mListView.setAdapter(replire);








            }
            else{

            }
        }


    }

}
