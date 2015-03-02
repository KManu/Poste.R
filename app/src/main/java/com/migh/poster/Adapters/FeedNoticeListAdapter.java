package com.migh.poster.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.migh.poster.DataModels.NoticeModel;
import com.migh.poster.R;
import com.nhaarman.listviewanimations.ArrayAdapter;

import java.util.ArrayList;

/*
 * List adapter used for showing lists of info.
 * Used in all pages that show lists of notice feeds
 * SRC
 * Halls Feed pages
 * Department feed pages
 */

public class FeedNoticeListAdapter extends ArrayAdapter<NoticeModel> {
	private LayoutInflater inflater=null;
	Context context;
	ArrayList<NoticeModel> notices;
	public FeedNoticeListAdapter( Context context,ArrayList<NoticeModel> Notices) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.notices = Notices;

	}

	@Override
	public int getCount(){
		return this.notices.size();
	}
	
	@Override
	public NoticeModel getItem(int position){
		
		return notices.get(position);
	}
	
	@Override
	public long getItemId(int position){
		return position;
	}	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v ;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(convertView== null){
			v= new View(context);
			v=inflater.inflate(R.layout.feed_notice_list_item, parent, false);
			TextView PostcardSubject = (TextView) v.findViewById(R.id.PostCard_Subject);
			TextView PostcardPoster= (TextView) v.findViewById(R.id.PostCard_Poster);
			TextView PostcardPostTime=(TextView) v.findViewById(R.id.PostCard_PostTime);
			ImageView PostcardPostType = (ImageView) v.findViewById(R.id.PostCard_TypeImage);
			
			NoticeModel compToDisp= notices.get(position);
			
			//Use the database adapter to get the poster title. Same for the poster name
            //TODO
            //Fix the retrieval of  the string below
            /*
			String PosterTitle = (dbAdapter.getFeedPoster(compToDisp.getPosterID())).getPosterTitle();
			String PosterID = (dbAdapter.getFeedPoster(compToDisp.getPosterID())).getPosterID();
			*/

			String PosterTitle = "Tijuana Rohan";
			PostcardSubject.setText(compToDisp.getNoticeSubject()); 
			PostcardPoster.setText(PosterTitle);
			PostcardPostTime.setText(compToDisp.getPostTime());
			
			//There would be a fixed number of drawables that the image would be set to depending on what the post type is.
			PostcardPostType.setImageResource(R.drawable.img_super_meat);
		}
		else{
			v = (View) convertView;
		}
		
		
		return v;
	}

}
