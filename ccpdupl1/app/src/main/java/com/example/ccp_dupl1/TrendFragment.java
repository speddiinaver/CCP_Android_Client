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
 * Use the {@link TrendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GridView gridStyleImages;
    private List<String> styleImageList = new ArrayList<String>();
    private MainActivity mainActivity;

    public TrendFragment() {
        // Required empty public constructor
        styleImageList.add("/storage/emulated/0/DCIM/test1.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test2.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test3.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test4.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test5.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test6.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test1.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test2.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test3.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test4.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test5.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test6.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test9.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test7.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test8.jpg");
        styleImageList.add("/storage/emulated/0/DCIM/test9.jpg");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalibreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrendFragment newInstance(String param1, String param2) {
        TrendFragment fragment = new TrendFragment();
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_trend, container, false);

        gridStyleImages = (GridView) rootView.findViewById(R.id.grid_trend_images);
        TrendViewAdapter trendViewAdapter = new TrendViewAdapter(styleImageList, getContext());
        gridStyleImages.setAdapter(trendViewAdapter);
        return rootView;
    }
}

class TrendViewAdapter extends BaseAdapter {

    List<String> trendStyleImages = null;
    Context context;
    MainActivity mainActivity;

    public TrendViewAdapter(List trendStyleImages, Context context){
        this.trendStyleImages = trendStyleImages;
        this.context = context;
    }
    public TrendViewAdapter(){}

    @Override
    public int getCount() {
        return trendStyleImages.size();
    }

    @Override
    public Object getItem(int i) {
        return trendStyleImages.get(i);
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
        Bitmap bm = BitmapFactory.decodeFile(trendStyleImages.get(position));
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