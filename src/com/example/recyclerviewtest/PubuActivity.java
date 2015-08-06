package com.example.recyclerviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class PubuActivity extends Activity{
	
	private Context mContext = null;
	private RecyclerView mRecyclerView = null;
	private List<String> mDatas = null;
	private PubuAdapter mAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContext = PubuActivity.this;
		initDatas();
		initViews();
		
		mAdapter = new PubuAdapter(mContext , mDatas);
		mRecyclerView.setAdapter(mAdapter);
		
		//设置RecyclerView的布局管理，瀑布流
		mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
		
		//设置RecyclerView的Item间的分隔线
		//mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext , DividerItemDecoration.VERTICAL_LIST));
		
	}
	
	

	private void initViews() {
		mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
	}

	
	
	
	private void initDatas() {
		mDatas = new ArrayList<String>();
		for(int i = 'A' ; i <= 'z' ; i++) {
			mDatas.add("" + (char)i);
		}
	}

}
