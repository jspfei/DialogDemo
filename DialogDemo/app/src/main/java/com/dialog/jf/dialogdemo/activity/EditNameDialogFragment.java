package com.dialog.jf.dialogdemo.activity;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.dialog.jf.dialogdemo.R;

/**
 * Created by admin on 2017/1/3.
 */

public class EditNameDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState){
      //  getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragement_edit_name,container);
        return view;
    }

}
