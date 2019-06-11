package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXLine;
	private JTextField txtYLine;
	private JTextField txtXLineEND;
	private JTextField txtYLineEND;
	private JButton btnColorLine;
	private JButton okButton;
	private JButton cancelButton;
	private int xMove, yMove, xMoveEnd, yMoveEnd;
	private Color outline = Color.black;
	private Color fill = Color.black;
	private boolean fillBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setTitle("Line");
		setResizable(false);
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtYLine = new JTextField();
			txtYLine.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
					if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			txtYLine.setColumns(10);
		}
		{
			txtXLine = new JTextField();
			txtXLine.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
					if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			txtXLine.setColumns(10);
		}
		
		txtXLineEND = new JTextField();
		txtXLineEND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXLineEND.setColumns(10);
		
		txtYLineEND = new JTextField();
		txtYLineEND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYLineEND.setColumns(10);
		
		JLabel lblXs = new JLabel("X start:");
		
		JLabel lblYs = new JLabel("Y start:");
		
		JLabel lblXEnd = new JLabel("X end:");
		
		JLabel lblYEnd = new JLabel("Y end:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXs)
						.addComponent(lblYs)
						.addComponent(lblXEnd, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYEnd, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtXLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXLineEND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYLineEND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(112))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXs)
						.addComponent(txtXLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYs)
						.addComponent(txtYLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtXLineEND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXEnd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtYLineEND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYEnd))
					.addGap(44))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnColorLine = new JButton("Color");
				btnColorLine.setForeground(Color.WHITE);
				btnColorLine.setBackground(Color.BLUE);
				btnColorLine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						outline = JColorChooser.showDialog(null, "Choose a color", fill);
						fillBool = true;
					}
				});
			}
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXLine.getText().trim().isEmpty() || txtYLine.getText().trim().isEmpty() || txtXLineEND.getText().trim().isEmpty() || txtYLineEND.getText().trim().isEmpty() ) {
							JOptionPane.showMessageDialog(null, "Enter in all the values!", "Error", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							xMove = Integer.parseInt(txtXLine.getText());
							yMove = Integer.parseInt(txtYLine.getText());
							xMoveEnd = Integer.parseInt(txtXLineEND.getText());
							yMoveEnd = Integer.parseInt(txtYLineEND.getText());
							for (Shapes shapes : PnlDrawing.shapesArrList) {
								if(shapes.isSelected()) {
									if(shapes instanceof Line) {
										((Line)shapes).setStart(new Point(xMove, yMove));
										((Line)shapes).setEnd(new Point(xMoveEnd, yMoveEnd));
									}
									if(fillBool == true) {
										shapes.setOutline(outline);
										fillBool = false;
									}
								}
							}
							dispose();
							return;
						}
					}
				});
				okButton.setBackground(Color.GREEN);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.RED);
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnColorLine, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(46))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnColorLine)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXLine() {
		return txtXLine;
	}

	public void setTxtXLine(JTextField txtXLine) {
		this.txtXLine = txtXLine;
	}

	public JTextField getTxtYLine() {
		return txtYLine;
	}

	public void setTxtYLine(JTextField txtYLine) {
		this.txtYLine = txtYLine;
	}

	public JTextField getTxtXLineEND() {
		return txtXLineEND;
	}

	public void setTxtXLineEND(JTextField txtXLineEND) {
		this.txtXLineEND = txtXLineEND;
	}

	public JTextField getTxtYLineEND() {
		return txtYLineEND;
	}

	public void setTxtYLineEND(JTextField txtYLineEND) {
		this.txtYLineEND = txtYLineEND;
	}

	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public int getxMoveEnd() {
		return xMoveEnd;
	}

	public void setxMoveEnd(int xMoveEnd) {
		this.xMoveEnd = xMoveEnd;
	}

	public int getyMoveEnd() {
		return yMoveEnd;
	}

	public void setyMoveEnd(int yMoveEnd) {
		this.yMoveEnd = yMoveEnd;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}
}
