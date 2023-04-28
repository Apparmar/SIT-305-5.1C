package com.example.sit_305_51c;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements NewsAdaptor.ItemClickListener, NewsTopAdaptor.ItemClickListener {

    String[] newsHeader = {"Header 1","Header 2","Header 3","Header 4","Header 5","Header 6","Header 7","Header 8","Header 9","Header 10"};
    String[] newsDetails = {"Aewfadsatg sdfadsfef fasfkl ladsjflkjlk jkdslf 345twre ","glgm 4eretk jjekrjaklf jaf  lfksd  fajsdf ","j4kadsfka fdkgl. efkjsad aewfasklfh  4tio dfad dasf.","Aewfadsatg sdfadsfef fasfkl ladsjflkjlk jkdslf 345twre ","glgm 4eretk jjekrjaklf jaf  lfksd  fajsdf ","j4kadsfka fdkgl. efkjsad aewfasklfh  4tio dfad dasf.","Aewfadsatg sdfadsfef fasfkl ladsjflkjlk jkdslf 345twre ","glgm 4eretk jjekrjaklf jaf  lfksd  fajsdf ","j4kadsfka fdkgl. efkjsad aewfasklfh  4tio dfad dasf.","j4kadsfka fdkgl. efkjsad aewfasklfh  4tio dfad dasf."};
    Boolean[] topStoryList = {true,false,true,true,false,true,true,false,true,false};
    Integer[] groupIDs = {1,1,1,1,2,2,2,2,3,3};

    List<News> newsList = new ArrayList<>();
    List<News> newsTopList = new ArrayList<>();

    RecyclerView recyclerview, recyclerviewA;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < newsHeader.length; i++)
        {
            News news = new News(newsHeader[i], newsDetails[i],topStoryList[i],groupIDs[i]);
            newsList.add(news);
            if (news.GetIsTopStory())
                newsTopList.add(news);
        }

        recyclerview = view.findViewById(R.id.homeRec);
        recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        NewsTopAdaptor newsTopAdaptor = new NewsTopAdaptor(newsTopList, getContext(), this);
        recyclerview.setAdapter(newsTopAdaptor);
        newsTopAdaptor.notifyDataSetChanged();

        recyclerviewA = view.findViewById(R.id.newsRec);
        recyclerviewA.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NewsAdaptor newsAdaptor = new NewsAdaptor(newsList, view.getContext(), this);
        recyclerviewA.setAdapter(newsAdaptor);
        newsAdaptor.notifyDataSetChanged();


    }

    @Override
    public void onItemClick(News news) {
        Fragment fragment = onclickdetail.newInstance(news.GetHeading(), news.GetNewsDetail(),newsList);
//        Bundle arg = new Bundle();
 //       arg.putSerializable("newsList",newsList.toArray());


   //     fragment.setArguments();
        FragmentManager fgm = getActivity().getSupportFragmentManager();
        FragmentTransaction fgt = fgm.beginTransaction();
        fgt.replace(R.id.mainFrame,fragment);
        fgt.addToBackStack(null);
        fgt.commit();
    }
}