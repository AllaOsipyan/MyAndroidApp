package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

        public static int age =0;
        private NumberPicker.OnValueChangeListener valueChangeListener;

        public int getAge(){
            return age;
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final NumberPicker numberPicker = new NumberPicker(getActivity());

            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(100);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Укажите свой возраст: ");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    valueChangeListener.onValueChange(numberPicker,
                            numberPicker.getValue(), numberPicker.getValue());

                }
            });

            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    valueChangeListener.onValueChange(numberPicker,
                            numberPicker.getValue(), numberPicker.getValue());
                }
            });

            builder.setView(numberPicker);
            return builder.create();
        }

        public NumberPicker.OnValueChangeListener getValueChangeListener() {
            return valueChangeListener;
        }

        public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
            this.valueChangeListener = valueChangeListener;
        }



}
