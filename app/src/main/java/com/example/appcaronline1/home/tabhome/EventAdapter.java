package com.example.appcaronline1.home.tabhome;

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

public class EventAdapter extends BaseAdapter {

    private List<ActiveEvent> eventLists;
    private LayoutInflater InflaterCatalogListItems;
    private Context context;
    public EventAdapter(Context context, List<ActiveEvent> eventLists) {
        this.eventLists = eventLists;
        this.context = context;
        InflaterCatalogListItems =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return eventLists.size();
    }

    @Override
    public Object getItem(int position) {
        return eventLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = InflaterCatalogListItems.inflate(R.layout.active_event, null);
            holder = new ViewHolder();
            holder.eventImage = (ImageView) convertView.findViewById(R.id.imageEvent);
            holder.eventTitle = (TextView) convertView.findViewById(R.id.titleEvent);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ActiveEvent event = this.eventLists.get(position);
        holder.eventTitle.setText(event.getEventTitle());

        int imageId = this.getMipmapResIdByName(event.getEventImage());

        holder.eventImage.setImageResource(imageId);

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
        TextView eventTitle;
        ImageView eventImage;
    }
}
