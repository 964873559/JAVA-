package com.littlewhite.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener {

	private GameControl gameControl;

	/*
	 * 获得GameControl的控制
	 */
	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.keyRight();
			break;
		case KeyEvent.VK_Z:
			this.gameControl.keyZ();
			break;
		case KeyEvent.VK_X:
			this.gameControl.keyX();
			break;
		case KeyEvent.VK_SPACE:
			this.gameControl.keySPACE();
			break;
		case KeyEvent.VK_ENTER:
			this.gameControl.keyENTER();
			break;
		}
	}
	
	/*
	 * 无用
	 */

	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
