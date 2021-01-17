package youn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class window {
    private JFrame frame;
    boolean[][] data = new boolean[26][26];
    ArrayList<int[]> path = new ArrayList<int[]>();
    map mapC = new map();
    int[] startPos = new int[2];
    int[] endPos = new int[2];
    int isStartPos = 0;
    int isEndPos = 0;
    int isWallPos = 0;

    public window() {
	//Sets the fundamentals of the frame
	frame = new JFrame("Pathfinding");
	frame.setLayout(null);
	frame.setVisible(true);

	this.initialValues();
	mapC.setData(data);
	mapC.setStartPos(startPos);
	mapC.setEndPos(endPos);

	mapC.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + "," + e.getY());
		if(isWallPos==1) {
		    data[e.getY() / 22][e.getX() / 22] = true;
		    mapC.repaint();
		}else if(isStartPos == 1){
		    startPos[0] = e.getX();
		    startPos[1] = e.getY();
		    mapC.setStartPos(startPos);
		    mapC.repaint();
		}else if(isEndPos == 1){
		    endPos[0] = e.getX();
		    endPos[1] = e.getY();
		    mapC.setEndPos(endPos);
		    mapC.repaint();
		}
	    }
	});

	mapC.setBounds(5,5,575,575);

	JButton start = new JButton("Find Path");
	start.setBounds(650,20, 100,50);
	start.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		// display/center the jdialog when the button is pressed
		mapC.setDrawPath(true);
		mapC.setPath(path);
		mapC.repaint();
	    }
	});

	JCheckBox startPosisiton = new JCheckBox("StartPos");
	startPosisiton.setBounds(600,100, 100,50);

	startPosisiton.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent e) {
		isStartPos = e.getStateChange();
	    }
	});

	JCheckBox endPosisiton = new JCheckBox("EndPos");
	endPosisiton.setBounds(600,150, 100,50);

	endPosisiton.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent e) {
		isEndPos = e.getStateChange();
	    }
	});

	JCheckBox wallPosisiton = new JCheckBox("WallPos");
	wallPosisiton.setBounds(600,200, 100,50);

	wallPosisiton.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent e) {
		isWallPos = e.getStateChange();
	    }
	});


	frame.add(mapC);
	frame.add(start);
	frame.add(startPosisiton);
	frame.add(endPosisiton);
	frame.add(wallPosisiton);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.setPreferredSize(new Dimension(800, 610));

	//Add new components to the frame
	frame.pack();
	frame.setLocationRelativeTo(null);
    }

    private void initialValues(){
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data.length; j++) {
		data[i][j] = false;
	    }
	}
	startPos[0] = -1;
	startPos[1] = -1;
	endPos[0] = -1;
	endPos[1] = -1;

	int []temp = {0,0};
	path.add(temp);
	int []temp2 = {1,1};
	path.add(temp2);
	int []temp3 = {2,2};
	path.add(temp3);
	int []temp4 = {3,3};
	path.add(temp4);
    }
}
