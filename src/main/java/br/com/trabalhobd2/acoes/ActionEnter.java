package br.com.trabalhobd2.acoes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionEnter implements KeyListener {

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    e.getComponent().requestFocus();
  }

  public void keyReleased(KeyEvent e) {
  }
}
