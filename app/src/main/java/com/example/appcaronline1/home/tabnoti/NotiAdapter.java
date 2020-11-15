package com.example.appcaronline1.home.tabnoti;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcaronline1.R;

import java.util.List;

public class NotiAdapter extends BaseAdapter {

    private List<Message> messageList;
    private LayoutInflater InflaterCatalogListItems;
    private Context context;
    public NotiAdapter(Context context, List<Message> messageList) {
        this.messageList = messageList;
        this.context = context;
        InflaterCatalogListItems =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NotiAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = InflaterCatalogListItems.inflate(R.layout.message, null);
            holder = new NotiAdapter.ViewHolder();
            holder.messImage = (ImageView) convertView.findViewById(R.id.image_mess);
            holder.messTitle = (TextView) convertView.findViewById(R.id.title_mess);

            convertView.setTag(holder);
        } else {
            holder = (NotiAdapter.ViewHolder) convertView.getTag();
        }

        Message messenger = this.messageList.get(position);
        holder.messTitle.setText(messenger.getMesTitle());

        int imageId = this.getMipmapResIdByName(messenger.getMesImage());

        holder.messImage.setImageResource(imageId);

        return convertView;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
    static class ViewHolder {
        TextView messTitle;
        ImageView messImage;
    }

}
