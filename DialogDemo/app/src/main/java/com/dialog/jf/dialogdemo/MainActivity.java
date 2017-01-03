package com.dialog.jf.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dialog.jf.dialogdemo.activity.EditNameDialogFragment;
import com.dialog.jf.dialogdemo.activity.LoginDialogFragment;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showEditDialog(View view) {
        EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
        editNameDialogFragment.show(getFragmentManager(), "editNameDialog");
    }

    public void showLoginDialog(View view) {
        LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
        loginDialogFragment.show(getFragmentManager(), "loginDialog");
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "账号：" + username + ", 密码：" + password,
                Toast.LENGTH_SHORT).show();
    }

    public void showDialogInDifferentScreen(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        EditNameDialogFragment newFragment = new EditNameDialogFragment();

        boolean mIsLargeLayout = getResources().getBoolean(R.bool.large_layout);
        Log.e("TAG", mIsLargeLayout + "");
        if (mIsLargeLayout) {
            newFragment.show(fragmentManager, "dialog");
        } else {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
            transaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.replace(R.id.id_ly, newFragment)
                    .commit();
        }
    }

    public void showLoginDialogWithoutFragment(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.fragement_login_dialog, null))
                // Add action buttons
                .setPositiveButton("Sign in",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                            }
                        }).setNegativeButton("Cancel", null).create().show();

    }
}
