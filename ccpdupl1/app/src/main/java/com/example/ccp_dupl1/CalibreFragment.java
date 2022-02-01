package com.example.ccp_dupl1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalibreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalibreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView viewStyle1;
    private RecyclerView viewStyle2;
    private RecyclerView viewStyle3;

    private ImageButton btnStyle1;
    private ImageButton btnStyle2;
    private ImageButton btnStyle3;

    private MainActivity mainActivity;

    public CalibreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calibreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalibreFragment newInstance(String param1, String param2) {
        CalibreFragment fragment = new CalibreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
        View rootView = inflater.inflate(R.layout.fragment_calibre, container, false);
        viewStyle1 = (RecyclerView) rootView.findViewById(R.id.grid_style_1);
        ArrayList<String> style1_images = new ArrayList<String>();
        style1_images.add("/storage/emulated/0/DCIM/test1.jpg");
        style1_images.add("/storage/emulated/0/DCIM/test2.jpg");
        style1_images.add("/storage/emulated/0/DCIM/test3.jpg");
        calibreViewAdapter style1Adapter = new calibreViewAdapter(getActivity(), style1_images);
        viewStyle1.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        viewStyle1.setAdapter(style1Adapter);

        ArrayList<String> style2_images = new ArrayList<String>();
        style2_images.add("/storage/emulated/0/DCIM/test4.jpg");
        style2_images.add("/storage/emulated/0/DCIM/test5.jpg");
        style2_images.add("/storage/emulated/0/DCIM/test6.jpg");
        viewStyle1 = (RecyclerView) rootView.findViewById(R.id.grid_style_2);
        calibreViewAdapter style2Adapter = new calibreViewAdapter(getActivity(), style2_images);
        viewStyle1.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        viewStyle1.setAdapter(style2Adapter);

        ArrayList<String> style3_images = new ArrayList<String>();
        style3_images.add("/storage/emulated/0/DCIM/test7.jpg");
        style3_images.add("/storage/emulated/0/DCIM/test8.jpg");
        style3_images.add("/storage/emulated/0/DCIM/test9.jpg");
        viewStyle1 = (RecyclerView) rootView.findViewById(R.id.grid_style_3);
        calibreViewAdapter style3Adapter = new calibreViewAdapter(getActivity(), style3_images);
        viewStyle1.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        viewStyle1.setAdapter(style3Adapter);

        btnStyle1 = (ImageButton) rootView.findViewById(R.id.button_style_1);
        btnStyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(1, 1);
            }
        });

        btnStyle2 = (ImageButton) rootView.findViewById(R.id.button_style_2);
        btnStyle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(1, 2);
            }
        });

        btnStyle3 = (ImageButton) rootView.findViewById(R.id.button_style_3);
        btnStyle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(1, 3);
            }
        });

        return rootView;
    }
}

class calibreViewAdapter extends RecyclerView.Adapter<calibreViewAdapter.Holder> {

    private Context context;
    private List<String> list = new ArrayList<String>();

    public calibreViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_image, parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        Bitmap bm = BitmapFactory.decodeFile(list.get(position));
        holder.imageView.setImageBitmap(bm);
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public Holder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}