package com.example.appcaronline1.home.tabnoti;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;
import com.example.appcaronline1.notificationdetail.NotificationDetail;

import java.util.ArrayList;


public class NotificationFragment extends Fragment{


    public NotificationFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_notification, container, false);
        ArrayList<Message> messageArrayList = createData();
        ListView lvNoti = root.findViewById(R.id.lv_noti);
        lvNoti.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                Intent intent = new Intent(getActivity(), NotificationDetail.class);
                intent.putExtra("login","Login");
                startActivity(intent);


            }
        });
        lvNoti.setAdapter(new NotiAdapter(getContext(),messageArrayList));
        return root;
    }
    public ArrayList<Message> createData(){
        ArrayList<Message> list = new ArrayList<Message>();
        Message mess1 = new Message("Thông báo tạm ngưng dịch vụ trong khu vực bão","imgmsg");
        Message mess2 = new Message("Tìm 'Điểm vàng, hoàn điểm lên tới 70%'","imgmsg");
        Message mess3 = new Message("Thông báo dịch vụ mở rộng sau bão","imgmsg");
        Message mess4 = new Message("Cảm ơn người bạn đồng hành...","imgmsg");
        Message mess5 = new Message("Thông báo diễn ra sự kiện 'Đồng hành cùng CaOn'","imgmsg");
        Message mess6 = new Message("Bạn đã đăng ký thành công dịch vụ tháng...","imgmsg");

        list.add(mess1);
        list.add(mess2);
        list.add(mess3);
        list.add(mess4);
        list.add(mess5);
        list.add(mess6);

        return list;
    }



}