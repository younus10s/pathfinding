package youn;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class map extends JComponent {
    boolean [][] data = new boolean[26][26];
    ArrayList<int[]> path = new ArrayList<int[]>();
    int[] startPos= new int[2];
    int[] endPos = new int[2];

    int isStartPos = 0;
    int isEndPos = 0;

    boolean drawPath = false;

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	int dist = 22;
	int squareSize = 20;
	for (int row = 0; row < data.length; row++){
	    for (int col = 0; col < data.length; col++){
		if(data[row][col])
		    g2d.fillRect(col*dist, row*dist, squareSize, squareSize);
		else
		    g2d.drawRect(col*dist, row*dist, squareSize, squareSize);
	    }
	}

	if(startPos[0] != -1 || startPos[1] != -1) {
	    int realX = startPos[0]/22;
	    int realY = startPos[1]/22;
	    g2d.setColor(Color.BLUE);
	    g2d.fillRect(realX * 22, realY * 22, 20, 20);
	}
    	if(endPos[0] != -1 || endPos[1] != -1) {
	    int realX = endPos[0]/22;
	    int realY = endPos[1]/22;

	    g2d.setColor(Color.RED);
	    g2d.fillRect(realX * 22, realY * 22, 20, 20);
	}

    	if(drawPath){
	    g2d.setColor(Color.YELLOW);
	    for (int i= 0; i<path.size(); i++) {
		System.out.println(path.get(i)[0]);
		int realX = path.get(i)[0];
		int realY = path.get(i)[1];
		g2d.fillRect(realX * 22, realY * 22, 20, 20);
	    }
	    drawPath = false;
	}

    }


    public void setData(boolean [][] d){
        data = d;
    }
    public void setStartPos(int []pos){
	startPos = pos;
    }
    public void setEndPos(int []pos){
	endPos = pos;
    }

    public void setDrawPath(boolean b){
	drawPath = b;
    }

    public void setPath(ArrayList<int[]> p){
	path = p;
    }
}
