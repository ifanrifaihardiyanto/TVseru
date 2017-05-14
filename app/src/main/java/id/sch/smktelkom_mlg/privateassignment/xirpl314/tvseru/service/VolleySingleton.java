package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page1Fragment;

/**
 * Created by hyuam on 18/04/2017.
 */

public class VolleySingleton
{
    private static volatile VolleySingleton mInstance;
    private static Page1Fragment mCtx;
    private RequestQueue mRequestQueue;
    
    public VolleySingleton(Page1Fragment context)
    {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }
    
    public static VolleySingleton getInstance(Page1Fragment context)
    {
        if (mInstance == null)
        {
            synchronized (VolleySingleton.class)
            {
                if (mInstance == null) mInstance = new VolleySingleton(context);
            }
        }
        return mInstance;
    }
    
    public RequestQueue getRequestQueue()
    {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(mCtx.getActivity());
        }
        return mRequestQueue;
    }
    
    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }
}
