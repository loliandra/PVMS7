package com.example.myapplicationtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;


import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class CustomDialogFragment extends DialogFragment {


    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog alert = builder.create();
        int tryNumber = MainActivity.progress;
        return builder
                .setTitle("Точно в цель!")
                .setView(R.layout.dialog)
                .setMessage("Попытки: " + String.valueOf(tryNumber))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.progress = 0;
                    }
                }).create();
    }
}