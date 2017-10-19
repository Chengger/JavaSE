package gui.panel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel{
		static{
			GUIUtil.useLNF();
		}
		
		public static BackupPanel instance = new BackupPanel();
		
		JButton bBackup = new JButton("±¸·Ý");
		
		public BackupPanel(){
			GUIUtil.setColor(ColorUtil.blueColor, bBackup);
			this.add(bBackup);
			addListener();
		}
		public static void main(String[] args) {
			GUIUtil.showPanel(BackupPanel.instance);
		}
		  @Override
		    public void updateData() {
		 
		    }
		 
		    @Override
		    public void addListener() {
		        BackupListener listener = new BackupListener();
		        bBackup.addActionListener(listener);
		    }
}

