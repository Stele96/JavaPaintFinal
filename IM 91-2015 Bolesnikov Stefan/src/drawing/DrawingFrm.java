package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrm extends JFrame {

	private JPanel contentPane;
	static Color fill = Color.white;
	static Color out = Color.BLACK;
	private Color randomColor = Color.black;

	/**
	 * Launch the application.
	 */
	
	private PnlDrawing pnld = new PnlDrawing(); //za crtanje
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
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
	public DrawingFrm() {
		setResizable(false);
		setTitle("Drawing - IM 91-2015 Bolesnikov Stefan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pnld.setBackground(Color.WHITE);
		pnld.setBorder(null);
		contentPane.add(pnld,BorderLayout.CENTER);
		
		JPanel pnlRight = new JPanel();
		contentPane.add(pnlRight, BorderLayout.EAST);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 1;
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 2;
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 3;
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 4;
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnDoughnut = new JButton("Doughnut");
		btnDoughnut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 5;
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to select!", "Information", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					PnlDrawing.obj = 6;
				}
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to edit!", "Error", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					if(shapes.isSelected()) {
						shapes.DialogEdit();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "You must select an object first!", "Error", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to delete!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Shapes shapes : PnlDrawing.shapesArrList) {
					if(shapes.isSelected()) {
						int anws = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected object?","Warning",JOptionPane.YES_NO_OPTION);
						if(anws == 0) {
							PnlDrawing.shapesArrList.remove(shapes);
						}
							return;
							
						}
					}
					
				JOptionPane.showMessageDialog(null, "Please select an object", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnShapeColor = new JButton("Fill Color");
		btnShapeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", randomColor);
			}
		});
		
		JButton btnOutlineColor = new JButton("Frame Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out = JColorChooser.showDialog(null, "Choose a color", randomColor);
			}
		});
		GroupLayout gl_pnlRight = new GroupLayout(pnlRight);
		gl_pnlRight.setHorizontalGroup(
			gl_pnlRight.createParallelGroup(Alignment.LEADING)
				.addComponent(btnOutlineColor, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnShapeColor, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnDoughnut, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnCircle, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnRectangle, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnLine, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnPoint, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
		);
		gl_pnlRight.setVerticalGroup(
			gl_pnlRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRight.createSequentialGroup()
					.addComponent(btnPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCircle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDoughnut)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelect)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnShapeColor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOutlineColor)
					.addContainerGap(277, Short.MAX_VALUE))
		);
		pnlRight.setLayout(gl_pnlRight);
	}
}
