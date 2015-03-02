package com.migh.poster.Fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.migh.poster.Adapters.*;
import com.migh.poster.DataModels.*;
import com.migh.poster.R;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;

import java.util.ArrayList;

public class NoticeListFragment extends Fragment {
	ArrayList<NoticeModel> notices;
	FeedNoticeListAdapter noticeListAdapter;
	ListView noticeListView;
	String TAG = "NoticeListFragment";
    String caller ;
    String feedID;
	SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedEditor;
    Menu menu;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		return inflater.inflate(R.layout.feed_notice_list_page,container , false );
	}
	
	public NoticeListFragment newInstance (String feedID, String caller){
		NoticeListFragment nFrag = new NoticeListFragment();
		Bundle args = new Bundle();
		args.putString("FeedID", feedID);
        args.putString("Caller",caller);
		Log.v(TAG, "NoticeListFragment started for feed " + feedID);
		nFrag.setArguments(args);
		return nFrag;
	}


    /*
     * TODO
     * populate the notices array list from the internet, searching by the posterID, then
     * display it. Each onclick leads to a display for the notice
     *
     */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {	
		super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        init();

        notices = null;
        if(!notices.isEmpty()){
            //display the list
            noticeListAdapter = new FeedNoticeListAdapter(getActivity().getApplicationContext(), notices);
            AnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(noticeListAdapter);
            animationAdapter.setAbsListView(noticeListView);

        }
        else{
           noticeListView.setBackgroundResource(R.drawable.img_nothing_screen);

        }

	}

    private void init() {
        noticeListView = (ListView) getActivity().findViewById(R.id.NoticeListPageList);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notice_list_menu, menu);


    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }



	@Override
    public void onResume(){
        super.onResume();

    }
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	

}
