package com.hache.mystoreapp.util;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.hache.mystoreapp.MainActivity;
import com.hache.mystoreapp.service.VolleyS;

public abstract class BaseFragment extends Fragment {

    private VolleyS volley;
    protected RequestQueue fRequestQueue;

    /* Member Variables. */
    private ActivityBuffer mActivityBuffer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volley = VolleyS.getInstance(getActivity().getApplicationContext());
        fRequestQueue = volley.getRequestQueue();
    }

    public void addToQueue(Request request) {
        if (request != null) {
            request.setTag(this);
            if (fRequestQueue == null)
                fRequestQueue = volley.getRequestQueue();
            request.setRetryPolicy(new DefaultRetryPolicy(
                    60000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            ));
            onPreStartConnection();
            fRequestQueue.add(request);
        }
    }

    public void onPreStartConnection() {
        getActivity().setProgressBarIndeterminateVisibility(true);
    }

    public void onConnectionFinished() {
        getActivity().setProgressBarIndeterminateVisibility(false);
    }

    public void onConnectionFailed(String error) {
        getActivity().setProgressBarIndeterminateVisibility(false);
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }


    public BaseFragment() {
        // Implement the Parent.
        super();
        // Allocate the ActivityBuffer.
        this.mActivityBuffer = new ActivityBuffer();
    }

    @Override
    public final void onAttach(final Context pContext) {
        // Handle as usual.
        super.onAttach(pContext);
        // Is the Context an Activity?
        if(pContext instanceof Activity) {
            // Cast Accordingly.
            final Activity lActivity = (Activity)pContext;
            // Inform the ActivityBuffer.
            this.getActivityBuffer().onContextGained(lActivity);
        }
    }

    @Override
    public final void onDetach() {
        // Handle as usual.
        super.onDetach();
        // Inform the ActivityBuffer.
        this.getActivityBuffer().onContextLost();
    }

    /* Getters. */
    public final ActivityBuffer getActivityBuffer() {
        return this.mActivityBuffer;
    }


}
