package com.dialog.jf.dialogdemo.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.dialog.jf.dialogdemo.R;

/**
 * Created by admin on 2017/1/3.
 */

public class LoginDialogFragment extends DialogFragment {

    private EditText mUsername;
    private EditText mPassword;

    public interface LoginInputListener{
        void onLoginInputComplete(String username,String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragement_login_dialog,null);
        mUsername = (EditText) view.findViewById(R.id.id_txt_username);
        mPassword = (EditText) view.findViewById(R.id.id_txt_password);
        // Inflate and set the layout for the dialog
        //Pass null as the parent view because its going in the dialog layout
        AlertDialog.Builder builder1 = builder.setView(view)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                   @Override
                    public void onClick(DialogInterface dialog,int id){
                       LoginInputListener loginInputListener = (LoginInputListener) getActivity();
                       loginInputListener.onLoginInputComplete(mUsername
                       .getText().toString(),mPassword
                       .getText().toString());
                   }
                }).setNegativeButton("Cancel",null);
        return builder.create();
    }
}
