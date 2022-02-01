package com.example.ccp_dupl1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClosetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClosetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GridView gridClosetImages;
    private List<String> closetImageList = new ArrayList<String>();

    public ClosetFragment() {
        // Required empty public constructor
        closetImageList.add("/storage/emulated/0/DCIM/test1.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test2.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test3.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test4.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test5.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test6.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test1.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test2.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test3.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test4.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test5.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test6.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        closetImageList.add("/storage/emulated/0/DCIM/test9.jpg");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClosetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClosetFragment newInstance(String param1, String param2) {
        ClosetFragment fragment = new ClosetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_closet, container, false);

        gridClosetImages = (GridView) rootView.findViewById(R.id.grid_closet_images);
        ClosetiewAdapter closetiewAdapter = new ClosetiewAdapter(closetImageList, getContext());
        gridClosetImages.setAdapter(closetiewAdapter);

        return rootView;
    }
}

class ClosetiewAdapter extends BaseAdapter {

    List<String> closetStyleImages = null;
    Context context;
    MainActivity mainActivity;

    public ClosetiewAdapter(List trendStyleImages, Context context){
        this.closetStyleImages = trendStyleImages;
        this.context = context;
    }
    public ClosetiewAdapter(){}

    @Override
    public int getCount() {
        return closetStyleImages.size();
    }

    @Override
    public Object getItem(int i) {
        return closetStyleImages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        ImageView simpleImage;
        final ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.simple_image, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.imageViwe = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.position = position;
            convertView.setTag(viewHolder);

//            simpleImage = (ImageView) convertView.findViewById(R.id.imageView);
//            simpleImage.setImageBitmap(bm);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Bitmap bm = BitmapFactory.decodeFile(closetStyleImages.get(position));
        viewHolder.imageViwe.setImageBitmap(bm);
        viewHolder.position = position;
        return convertView;  //뷰 객체 반환
    }

    static class ViewHolder
    {
        ImageView imageViwe;
        int position;
    }
}