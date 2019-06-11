package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class SortFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel dlm = new DefaultListModel();
	ArrayList<Rectangle> arrayRect = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortFrm() {
		setResizable(false);
		setTitle("Sort - IM 91-2015 Bolesnikov Stefan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList lstMain = new JList();
		scrollPane.setViewportView(lstMain);
		pnlCenter.setLayout(gl_pnlCenter);
		
		lstMain.setModel(dlm); //lista koja nije vidljiva
		
		
		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortDlg sortdlg = new SortDlg();
				sortdlg.setVisible(true);
				if(sortdlg.carryOn==true) {
					
				Rectangle rec = new Rectangle(new Point(Integer.parseInt(sortdlg.getTxtXCoord().getText()),
											 (Integer.parseInt(sortdlg.getTxtYCoord().getText()))),
											 (Integer.parseInt(sortdlg.getTxtWidth().getText())),
											 (Integer.parseInt(sortdlg.getTxtHeight().getText())));
				
				arrayRect.add(rec);
				Collections.sort(arrayRect); //sortira
				
				dlm.add(arrayRect.indexOf(rec), "X: " + rec.getUlp().getX() + " , Y: " + rec.getUlp().getY() + " , Width: " + rec.getWidth() 
						+ " , Height: " + rec.getHeight());
			}}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.GREEN);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()){
					JOptionPane.showMessageDialog(null, "Nothing to delete", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					SortDlg sortdlgdelete = new SortDlg();
					String[] split = dlm.firstElement().toString().split(" "); //splituje niz stringova uzima prvi e
																			  //lement podeli po razmaku svaki put je prvi
					sortdlgdelete.getTxtXCoord().setText(split[1]);
					sortdlgdelete.getTxtYCoord().setText(split[4]);
					sortdlgdelete.getTxtWidth().setText(split[7]);
					sortdlgdelete.getTxtHeight().setText(split[10]);
					sortdlgdelete.getTxtXCoord().setEditable(false); //da ne moze da se menja vrednost
					sortdlgdelete.getTxtYCoord().setEditable(false);
					sortdlgdelete.getTxtWidth().setEditable(false);
					sortdlgdelete.getTxtHeight().setEditable(false);
					sortdlgdelete.setVisible(true);
					if(sortdlgdelete.isDelete()==true) {
						arrayRect.remove(0); //brise se nulti objekat iz niza
						dlm.removeElementAt(0);
					}
					
				}
				
			}
		});
		btnDelete.setBackground(Color.RED);
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlDown.createSequentialGroup()
					.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		);
		pnlDown.setLayout(gl_pnlDown);
	}
}
