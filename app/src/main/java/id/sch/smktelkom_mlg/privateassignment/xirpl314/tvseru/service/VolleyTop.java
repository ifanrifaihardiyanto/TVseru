package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.service;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page2Fragment;

/**
 * Created by Ifan on 14/05/2017.
 */

public class VolleyTop {
    private static volatile VolleyTop mInstance;
    private static Page2Fragment mCtx;
    private RequestQueue mRequestQueue;

    private VolleyTop(Page2Fragment context)
    {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static VolleyTop getInstance(Page2Fragment context)
    {
        if (mInstance == null)
        {
            synchronized (VolleySingleton.class)
            {
                if (mInstance == null) mInstance = new VolleyTop(context);
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
