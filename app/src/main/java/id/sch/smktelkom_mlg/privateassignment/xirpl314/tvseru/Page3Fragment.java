package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.adapter.PopularMovieAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.adapter.TopMovieAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.model.Result;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.model.ResultResponse;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Page3Fragment extends Fragment {
    ArrayList<Result> list= new ArrayList<>();
    View inflate;
    RecyclerView recyclerView;
    PopularMovieAdapter popularMovieAdapter;

    public Page3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_page3, container, false);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        popularMovieAdapter = new PopularMovieAdapter(this,list,getContext());
        recyclerView.setAdapter(popularMovieAdapter);

        LinearLayoutManager grid = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(grid);

        downloadDataSource();
        return inflate;
    }

    private void downloadDataSource() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=c96c586178c4f8a9b5a9f7cb0d0ab3f0&language=en-US&page=1";

        GsonGetRequest<ResultResponse> myRequest = new GsonGetRequest<ResultResponse>
                (url, ResultResponse.class, null, new Response.Listener<ResultResponse>() {
                    @Override
                    public void onResponse(ResultResponse response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));

                        list.addAll(response.results);
                        popularMovieAdapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }
}
