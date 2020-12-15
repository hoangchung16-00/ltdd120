package com.example.appcaronline1.home.tabhome;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;
import com.example.appcaronline1.standard.Standard;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout standard = (LinearLayout) root.findViewById(R.id.li_home_311);
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), Standard.class);
                getActivity().startActivity(myIntent);
            }
        });
        LinearLayout standard1 = (LinearLayout) root.findViewById(R.id.li_home_312);
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), Standard.class);
                getActivity().startActivity(myIntent);
            }
        });
        ArrayList<ActiveEvent> eventArrayList = createData();
        GridView gvHome = root.findViewById(R.id.gv_home_1);
        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < eventArrayList.size(); i++) {
                    if(i==position) {
                        Intent intent = new Intent(getContext(), GridItem.class);
                        intent.putExtra("title",eventArrayList.get(i).getEventTitle());
                        intent.putExtra("image",getMipmapResIdByName(eventArrayList.get(i).getEventImage()));
                        intent.putExtra("content",eventArrayList.get(i).getContent());
                        intent.putExtra("date",eventArrayList.get(i).getDate());
                        startActivity(intent);
                    }
                }
            }
        });
        gvHome.setAdapter(new EventAdapter(getContext(),eventArrayList));
        return root;
    }
    public ArrayList<ActiveEvent> createData(){
        ArrayList<ActiveEvent> list = new ArrayList<ActiveEvent>();
        ActiveEvent event1 = new ActiveEvent("xin chào chào","li1","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event2 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event3 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event4 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event5 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event6 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event7 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");
        ActiveEvent event8 = new ActiveEvent("xin chào xin chào","li2","Phasellus auctor dolor vel neque sollicitudin pharetra. Integer ultrices mi eu elit pretium egestas. Fusce sed nibh sit amet dolor consectetur ultrices. Nunc vulputate feugiat justo sodales pretium. Aenean auctor, dui non efficitur condimentum, odio erat porttitor velit, a accumsan diam nibh vel velit. Vivamus laoreet neque blandit tortor congue, in scelerisque lectus mattis. Vivamus sollicitudin lorem sed arcu consectetur iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris porttitor magna elit, vitae pharetra velit venenatis sit amet. Sed condimentum, lacus ac scelerisque hendrerit, sapien leo finibus ligula, vel consequat ex lacus sit amet magna. Aenean metus lacus, egestas eu pellentesque vitae, rutrum ac neque. In maximus vehicula velit nec faucibus. Fusce facilisis enim lorem, id luctus augue tincidunt vitae. Nunc a commodo lorem.","20/2/2020");

        list.add(event1);
        list.add(event2);
        list.add(event3);
        list.add(event4);
        list.add(event5);
        list.add(event6);
        list.add(event7);
        list.add(event8);
        return list;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = getContext().getPackageName();
        // Return 0 if not found.
        int resID = getContext().getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }



}