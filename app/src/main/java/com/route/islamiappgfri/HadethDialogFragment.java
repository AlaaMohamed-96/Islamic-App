package com.route.islamiappgfri;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.route.islamiappgfri.Model.Hadeth;


public class HadethDialogFragment  extends DialogFragment {

    public HadethDialogFragment(){

    }

    Hadeth hadeth;

    public void setHadeth(Hadeth hadeth) {
        this.hadeth = hadeth;
    }

    TextView title,content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.hadeth_dialog,container,false);
        title=view.findViewById(R.id.title);
        content=view.findViewById(R.id.content);

        title.setText(hadeth.getTitle());
        content.setText(hadeth.getContent());
        return view;
    }
}
