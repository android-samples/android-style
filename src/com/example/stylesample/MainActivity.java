package com.example.stylesample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buttonMethod(View button){
		String text = ((Button)button).getText().toString();
		Toast.makeText(this, text + " pushed.", Toast.LENGTH_SHORT).show();
		
		
		
		// -- -- 以下、アニメーションテスト。一旦保留。 -- -- //
		if(true){
			return;
		}
		// クリッピング設定
		
		// 手前に持ってくる
		button.bringToFront();
		
		// アニメーション
		Animation a = AnimationUtils.loadAnimation(this, R.anim.test_translate);
		Animation a2 = AnimationUtils.loadAnimation(this, R.anim.test_scale);
		Animation a3 = AnimationUtils.loadAnimation(this, R.anim.test_rotate);
		button.startAnimation(a3);
		
		// ソース上で生成する場合
		RotateAnimation a4 = new RotateAnimation(0,  359,  button.getWidth()  /2,  button.getHeight()  /2);
		a4.setDuration(5000);
		button.startAnimation(a4);
		if(true)return;
		/*
		button.startAnimation(a);
		button.startAnimation(a2);
		*/
		// 複合
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(a);
		set.addAnimation(a2);
		button.startAnimation(set);
	}
}
