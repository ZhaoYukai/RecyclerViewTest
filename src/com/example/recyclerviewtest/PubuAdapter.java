package com.example.recyclerviewtest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PubuAdapter extends RecyclerView.Adapter<PubuAdapter.MyViewHolder> {
	
	private LayoutInflater mInflater = null;
	private Context mContext = null;
	private List<String> mDatas = null;
	
	
	//瀑布流就是用一个动态的数去改变高度
	private List<Integer> mHeights = null;
	
	
	
	public PubuAdapter(Context context , List<String> datas) {
		mInflater = LayoutInflater.from(context);
		mContext = context;
		mDatas = datas;
		
		mHeights = new ArrayList<Integer>();
		for(int i = 0 ; i < getItemCount() ; i++) {
			mHeights.add((int) (100 + Math.random() * 300));
		}
	}
	
	
	
	
	/**
	 * 返回的是数据的总量
	 */
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
	
	
	/**
	 * 绑定一个ViewHolder
	 */
	@Override
	public void onBindViewHolder(PubuAdapter.MyViewHolder myViewHolder, int position) {
		//瀑布流：给每个item设置不同的随机高度
		ViewGroup.LayoutParams layoutParams = myViewHolder.itemView.getLayoutParams();
		layoutParams.height = mHeights.get(position);
		myViewHolder.itemView.setLayoutParams(layoutParams);
		
		myViewHolder.tv.setText(mDatas.get(position));
	}

	
	
	/**
	 * 创建一个ViewHolder
	 */
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup root, int arg1) {
		
		View itemView = mInflater.inflate(R.layout.item_pubu_textview , root , false);
		MyViewHolder myViewHolder = new MyViewHolder(itemView);
		
		return myViewHolder;
	}

	
	

	class MyViewHolder extends ViewHolder {
		
		public TextView tv = null;

		public MyViewHolder(View itemView) {
			super(itemView);
			
			tv = (TextView) itemView.findViewById(R.id.id_pubu_textView);
		}
		
	}
	

}