package com.example.recyclerviewtest;

import java.util.ArrayList;
import java.util.List;

import com.example.recyclerviewtest.SimpleAdapter.OnItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Context mContext = null;
	private RecyclerView mRecyclerView = null;
	private List<String> mDatas = null;
	private SimpleAdapter mAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContext = MainActivity.this;
		initDatas();
		initViews();
		
		mAdapter = new SimpleAdapter(mContext , mDatas);
		mRecyclerView.setAdapter(mAdapter);
		
		//设置RecyclerView的布局管理
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
				mContext ,
				LinearLayoutManager.VERTICAL , 
				false);
		mRecyclerView.setLayoutManager(linearLayoutManager);
		
		//设置RecyclerView的Item间的分隔线
		//mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext , DividerItemDecoration.VERTICAL_LIST));
		
		mAdapter.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemLongClick(View view, int position) {
				Toast.makeText(mContext, mDatas.get(position) , Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(mContext, mDatas.get(position) , Toast.LENGTH_SHORT).show();
			}
		});
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
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		switch (id) {
		case R.id.action_listview:
			mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
			break;
		case R.id.action_gridview:
			mRecyclerView.setLayoutManager(new GridLayoutManager(mContext , 2)); //设置为3列
			break;
		case R.id.action_hor_gridview:
			mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
			break;
		case R.id.action_pubu:
			Intent intent = new Intent(mContext , PubuActivity.class);
			startActivity(intent);
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
