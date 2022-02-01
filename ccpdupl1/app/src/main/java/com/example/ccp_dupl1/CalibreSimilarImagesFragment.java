package com.example.ccp_dupl1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalibreSimilarImagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalibreSimilarImagesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton btnBack;
    private RecyclerView gridStyle;
    private GridView gridRelatedImages;

    private MainActivity mainActivity;
    private int CalibreIndex;


    public CalibreSimilarImagesFragment() {}

    public CalibreSimilarImagesFragment(int CalibreIndex) {
        // Required empty public constructor
        this.CalibreIndex = CalibreIndex;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalibreSimilarImagesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalibreSimilarImagesFragment newInstance(String param1, String param2) {
        CalibreSimilarImagesFragment fragment = new CalibreSimilarImagesFragment();
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calibre_similar_images, container, false);

        TextView textStyleIndex = rootView.findViewById(R.id.text_similar_index);
        textStyleIndex.setText("Style "+CalibreIndex);

        btnBack = (ImageButton)rootView.findViewById(R.id.button_to_calibre);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(0, 0);
            }
        });

        List<String> selelctedStyleImages = new ArrayList<String>();

        selelctedStyleImages.add("/storage/emulated/0/DCIM/test1.jpg");
        selelctedStyleImages.add("/storage/emulated/0/DCIM/test2.jpg");
        selelctedStyleImages.add("/storage/emulated/0/DCIM/test3.jpg");

        gridStyle = (RecyclerView) rootView.findViewById(R.id.grid_style);
        StyleViewAdapter style1Adapter = new StyleViewAdapter(getActivity(), selelctedStyleImages);
        gridStyle.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        gridStyle.setAdapter(style1Adapter);


        List<String> relatedStyleImages = new ArrayList<String>();

        relatedStyleImages.add("/storage/emulated/0/DCIM/test1.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test2.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test3.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test4.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test5.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test6.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test7.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test8.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test9.jpg");

        relatedStyleImages.add("/storage/emulated/0/DCIM/test7.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test8.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test9.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test7.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test8.jpg");
        relatedStyleImages.add("/storage/emulated/0/DCIM/test9.jpg");

        gridRelatedImages = (GridView) rootView.findViewById(R.id.grid_related_images);
        RelatedViewAdapter relatedViewAdapter = new RelatedViewAdapter(relatedStyleImages, mainActivity, getContext());
        gridRelatedImages.setAdapter(relatedViewAdapter);
        gridRelatedImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bitmap bm = BitmapFactory.decodeFile(relatedStyleImages.get(i));
                mainActivity.onFragmentChange(AppConstants.CALIBRE_RELATED_IMAGE_CLICKED, bm);
            }
        });
        return rootView;
    }
}

class RelatedViewAdapter extends BaseAdapter{

    List<String> relatedStyleImages = null;
    Context context;
    MainActivity mainActivity;

    public RelatedViewAdapter(List relatedStyleImages, MainActivity mainActivity, Context context){
        this.relatedStyleImages = relatedStyleImages;
        this.context = context;
        this.mainActivity = mainActivity;
    }
    public RelatedViewAdapter(){}

    @Override
    public int getCount() {
        return relatedStyleImages.size();
    }

    @Override
    public Object getItem(int i) {
        return relatedStyleImages.get(i);
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
        Bitmap bm = BitmapFactory.decodeFile(relatedStyleImages.get(position));
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

class StyleViewAdapter extends RecyclerView.Adapter<StyleViewAdapter.Holder> {

    private Context context;
    private List<String> list = new ArrayList<String>();

    public StyleViewAdapter(Context context, List<String> list) {
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