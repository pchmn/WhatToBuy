package com.pchmn.whattobuy.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    protected OnFragmentActionListener mListener;
    // activity
    protected BaseActivity mActivity;
    // title
    protected String mTitle;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentActionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
