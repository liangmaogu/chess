package com.maogu.chess;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	boolean isSound = false;		// 是否播放音乐
	MediaPlayer startSound;		// 开始和菜单时的音乐
	MediaPlayer gamesound;		// 游戏声音
	
	private ImageButton startGameBtn;
	private ImageButton helpBtn;
	private ImageButton exitBtn;
	private ImageButton backBtn;
	
	private Button settingBtn;

	private CheckBox soundCb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		startSound = MediaPlayer.create(this, R.raw.startsound);
		startSound.setLooping(true);
		
		gamesound = MediaPlayer.create(this, R.raw.gamesound);
		gamesound.setLooping(true);
		initWelcomeView();
	}
	
	private void initWelcomeView() {
		setContentView(R.layout.activity_main);
		if (isSound) {
			startSound.start();
		}
		initBtn();
	}
	
	private void initGameView() {
		if (startSound != null) {
			startSound.stop();
			startSound = null;
		}
		
		if (isSound) {
			gamesound.start();
		}
		setContentView(new GameView(this, this));
	}

	private void initBtn() {
		startGameBtn = (ImageButton)findViewById(R.id.startGameBtn);
		startGameBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				initGameView();
			}
		});
		
		helpBtn = (ImageButton)findViewById(R.id.helpBtn);
		helpBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				setContentView(R.layout.chess_help);
				backBtn = (ImageButton)findViewById(R.id.backBtn);
				backBtn.setOnClickListener(new Button.OnClickListener() {
					@Override
					public void onClick(View v) {
						initWelcomeView();
					}
				});
			}
		});
		
		exitBtn = (ImageButton)findViewById(R.id.exitBtn);
		exitBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.exit(0);
			}
		});
		
		settingBtn = (Button)findViewById(R.id.settingBtn);
		settingBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				setContentView(R.layout.chess_setting);
				backBtn = (ImageButton)findViewById(R.id.backBtn);
				backBtn.setOnClickListener(new Button.OnClickListener() {
					@Override
					public void onClick(View v) {
						initWelcomeView();
					}
				});
				
				soundCb = (CheckBox)findViewById(R.id.soundCb);
				soundCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						System.out.println(isChecked);
					}
				});
			}
		});
	}
	
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				initWelcomeView();
			} else if (msg.what == 2) {
				
			} else if (msg.what == 3) {
				
			}
		}

	};
}
