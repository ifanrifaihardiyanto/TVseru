package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page1Fragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page2Fragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page3Fragment;


public class VolleySingleton
{
    private static volatile VolleySingleton mInstance;
    private static Page1Fragment mCtx;
    private static Page2Fragment mCtx2;
    private static Page3Fragment mCtx3;
    private RequestQueue mRequestQueue;
    
    private VolleySingleton(Page1Fragment context)
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


    //Page2Fragment
    private VolleySingleton(Page2Fragment context2)
    {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx2 = context2;
        mRequestQueue = getRequestQueue();
    }

    public static VolleySingleton getInstance(Page2Fragment context2)
    {
        if (mInstance == null)
        {
            synchronized (VolleySingleton.class)
            {
                if (mInstance == null) mInstance = new VolleySingleton(context2);
            }
        }
        return mInstance;
    }

    //Page3Frament
    private VolleySingleton(Page3Fragment context3)
    {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx3 = context3;
        mRequestQueue = getRequestQueue();
    }

    public static VolleySingleton getInstance(Page3Fragment context3)
    {
        if (mInstance == null)
        {
            synchronized (VolleySingleton.class)
            {
                if (mInstance == null) mInstance = new VolleySingleton(context3);
            }
        }
        return mInstance;
    }
}
