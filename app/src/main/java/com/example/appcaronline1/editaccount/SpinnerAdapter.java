package com.example.appcaronline1.editaccount;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.AreaCode;

import java.util.ArrayList;
import java.util.List;


public class SpinnerAdapter extends ArrayAdapter<AreaCode> {
    Context context;

    public SpinnerAdapter(Context context,
                            List<AreaCode> areaCodes)
    {

        super(context, 0, areaCodes);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent)
    {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.text_view);
        ImageView imageView = convertView.findViewById(R.id.image_view);
        AreaCode currentItem = getItem(position);

        // It is used the name to the TextView when the
        // current item is not null.
        if (currentItem != null) {
            textViewName.setText(currentItem.getCode());
            imageView.setImageResource(getMipmapResIdByName(currentItem.getCountryName()));
        }
        return convertView;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
}
