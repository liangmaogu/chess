package com.maogu.chess;

public class TimeThread extends Thread {
	private boolean flag = true;
	private GameView gameView;

	public TimeThread(GameView gameView) {
		this.gameView = gameView;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		while (flag) {
			if (gameView.caiPan == false) {			// 当前为黑方走棋、思考
				gameView.blackTime++;
			} else if (gameView.caiPan == true) {	// 当前为红方走棋、思考
				gameView.redTime++;
			}
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
