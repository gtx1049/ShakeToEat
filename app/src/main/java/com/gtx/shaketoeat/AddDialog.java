package com.gtx.shaketoeat;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2015/7/7.
 */
public class AddDialog extends Dialog
{
    private EditText editText;
    private RadioGroup radioGroup;
    private Button positiveButton, negativeButton;

    public AddDialog(Context context)
    {
        super(context);
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.add_dialog, null);
        editText = (EditText)mView.findViewById(R.id.inputname);
        radioGroup = (RadioGroup)mView.findViewById(R.id.radiogroup);
        positiveButton = (Button)mView.findViewById(R.id.dialog_ok);
        negativeButton = (Button)mView.findViewById(R.id.dialog_cancel);
        super.setContentView(mView);
    }

    public void setOnPositiveListener(View.OnClickListener listener)
    {
        positiveButton.setOnClickListener(listener);
    }

    public void setOnNegativeListener(View.OnClickListener listener)
    {
        negativeButton.setOnClickListener(listener);
    }

    public EditText getEditText()
    {
        return editText;
    }

    public RadioGroup getRadioGroup()
    {
        return radioGroup;
    }
}
