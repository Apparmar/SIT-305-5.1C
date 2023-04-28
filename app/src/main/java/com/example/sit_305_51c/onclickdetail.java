package com.example.sit_305_51c;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link onclickdetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class onclickdetail extends Fragment {

    RecyclerView recyclerview;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String mParam3;
    private News[] newsList;
    private List<News> relatedNews = new ArrayList<>();
    public onclickdetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment onclickdetail.
     */
    // TODO: Rename and change types and number of parameters
    public static onclickdetail newInstance(String param1, String param2, List<News> newsList) {
        onclickdetail fragment = new onclickdetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        Gson gson = new Gson();
        String newsListJSON = gson.toJson(newsList);
        args.putString(ARG_PARAM3,newsListJSON);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_onclickdetail, container, false);
        TextView header = view.findViewById(R.id.newsHeaderDet2);
        header.setText(mParam1);

        TextView detail = view.findViewById(R.id.nd2);
        detail.setText(mParam2);

        Gson gson = new Gson();
        newsList = gson.fromJson(mParam3, News[].class);
        Log.d("***************",newsList[0].GetHeading());

        for (int i = 0; i < newsList.length; i++)
        {
            if (newsList[i].GetIsTopStory())
                relatedNews.add(newsList[i]);
        }
        recyclerview = view.findViewById(R.id.relatedNewsRC);
        recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NewsRelatedAdaptor newsrelatedadaptor = new NewsRelatedAdaptor(relatedNews, getContext());
        recyclerview.setAdapter(newsrelatedadaptor);
        newsrelatedadaptor.notifyDataSetChanged();


        return view;
    }
}