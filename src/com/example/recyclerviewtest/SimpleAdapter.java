package com.example.recyclerviewtest;

import java.util.List;

import android.content.Context;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> implements OnItemClickListener {
	
	private LayoutInflater mInflater = null;
	private Context mContext = null;
	private List<String> mDatas = null;

	private OnItemClickListener mOnItemClickListener = null; 
	
	
	
	
	
	public SimpleAdapter(Context context , List<String> datas) {
		mInflater = LayoutInflater.from(context);
		mContext = context;
		mDatas = datas;
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
	public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {
		myViewHolder.tv.setText(mDatas.get(position));
		
		//分别对单击事件和长按事件注册监听器
		if(mOnItemClickListener != null) {
			myViewHolder.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					int layoutPosition = myViewHolder.getPosition();
					mOnItemClickListener.onItemClick(myViewHolder.itemView, layoutPosition);
				}
			});
			
			myViewHolder.itemView.setOnLongClickListener(new OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					int layoutPosition = myViewHolder.getPosition();
					mOnItemClickListener.onItemLongClick(myViewHolder.itemView , layoutPosition);
					return true;
				}
			});
		}
	}

	
	
	/**
	 * 创建一个ViewHolder
	 */
	@Override
	public SimpleAdapter.MyViewHolder onCreateViewHolder(ViewGroup root, int arg1) {
		
		View itemView = mInflater.inflate(R.layout.item_simple_textview , root , false);
		MyViewHolder myViewHolder = new MyViewHolder(itemView);
		
		return myViewHolder;
	}




	@Override
	public void onItemClick(AdapterViewCompat<?> arg0, View arg1, int position, long arg3) {
		Toast.makeText(mContext , mDatas.get(position) , Toast.LENGTH_SHORT).show();
	}
	
	
	
	class MyViewHolder extends ViewHolder {
		
		public TextView tv = null;

		public MyViewHolder(View itemView) {
			super(itemView);
			
			tv = (TextView) itemView.findViewById(R.id.id_item_textView);
		}
		
	}
	
	
	
	/**
	 * 自定义的接口
	 */
	public interface OnItemClickListener {
		void onItemClick(View view , int position);
		void onItemLongClick(View view , int position);
	}
	
	/**
	 * 针对接口的自定义的方法
	 */
	public void setOnItemClickListener(OnItemClickListener listener) {
		
		mOnItemClickListener = listener;
		
	}

}





