package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblX;
	private JTextField txtXRectangle;
	private JTextField txtYRectangle;
	private JLabel lblY;
	private JLabel lblWidth;
	private JTextField txtWidthRectangle;
	private JTextField txtHeightRectangle;
	private JLabel lblHeight;
	private JButton btnColorOfThe;
	private JButton btnColorOfThe_1;
	boolean isOk;
	private int xMove, yMove, wMove, hMove;
	private Color outline = Color.black;
	private Color fill = Color.white;
	private boolean fillBool;
	private boolean outlineBool;
	private Color randomColor = Color.black;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRect dialog = new DlgRect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRect() {
		setModal(true);
		setBounds(100, 100, 300, 300);
		setTitle("Rectangle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		lblX = new JLabel("X:");
		txtXRectangle = new JTextField();
		txtXRectangle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXRectangle.setColumns(10);
		txtYRectangle = new JTextField();
		txtYRectangle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYRectangle.setColumns(10);
		lblY = new JLabel("Y:");
		lblWidth = new JLabel("W:");
		txtWidthRectangle = new JTextField();
		txtWidthRectangle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtWidthRectangle.setColumns(10);
		txtHeightRectangle = new JTextField();
		txtHeightRectangle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtHeightRectangle.setColumns(10);
		lblHeight = new JLabel("H:");
		btnColorOfThe = new JButton("Frame color");
		btnColorOfThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", randomColor);
				outlineBool = true;
			}
		});
		btnColorOfThe.setBackground(Color.BLUE);
		btnColorOfThe.setForeground(Color.WHITE);
		btnColorOfThe_1 = new JButton("Fill color");
		btnColorOfThe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", randomColor);
				fillBool = true;
			}
		});
		btnColorOfThe_1.setBackground(Color.BLUE);
		btnColorOfThe_1.setForeground(Color.WHITE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtXRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtYRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtWidthRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtHeightRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnColorOfThe_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnColorOfThe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGap(1)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblX))
						.addComponent(txtXRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblY))
						.addComponent(txtYRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblWidth))
						.addComponent(txtWidthRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblHeight))
						.addComponent(txtHeightRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnColorOfThe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnColorOfThe_1)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXRectangle.getText().trim().isEmpty() || txtYRectangle.getText().trim().isEmpty() || txtWidthRectangle.getText().trim().isEmpty() || txtHeightRectangle.getText().trim().isEmpty()) {
							//trim brise spejsove
							isOk = false;
							JOptionPane.showMessageDialog(null, "Enter in all the values!", "Error", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						}
						else {
							xMove = Integer.parseInt(txtXRectangle.getText());
							yMove = Integer.parseInt(txtYRectangle.getText());
							wMove = Integer.parseInt(txtWidthRectangle.getText());
							hMove = Integer.parseInt(txtHeightRectangle.getText());
							for (Shapes shapes : PnlDrawing.shapesArrList) {
								if(shapes.isSelected()) {
									if(shapes instanceof Rectangle) {
										((Rectangle)shapes).setUlp(new Point(xMove, yMove));
										((Rectangle)shapes).setWidth(wMove);
										((Rectangle)shapes).setHeight(hMove);
									}
									if(isOutlineBool() == true) {
										shapes.setOutline(outline);
										setOutlineBool(false);
									}
									if(isFillBool() == true) {
										shapes.setFill(fill);
										setFillBool(false);
									}
								}
							}
							isOk = true;
							dispose();
						}
					}
				});
				okButton.setBackground(Color.GREEN);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(Color.RED);
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(100)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(cancelButton)
							.addComponent(okButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXRectangle() {
		return txtXRectangle;
	}

	public void setTxtXRectangle(JTextField txtXRectangle) {
		this.txtXRectangle = txtXRectangle;
	}

	public JTextField getTxtYRectangle() {
		return txtYRectangle;
	}

	public void setTxtYRectangle(JTextField txtYRectangle) {
		this.txtYRectangle = txtYRectangle;
	}

	public JTextField getTxtWidthRectangle() {
		return txtWidthRectangle;
	}

	public void setTxtWidthRectangle(JTextField txtWidthRectangle) {
		this.txtWidthRectangle = txtWidthRectangle;
	}

	public JTextField getTxtHeightRectangle() {
		return txtHeightRectangle;
	}

	public void setTxtHeightRectangle(JTextField txtHeightRectangle) {
		this.txtHeightRectangle = txtHeightRectangle;
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

	public int getwMove() {
		return wMove;
	}

	public void setwMove(int wMove) {
		this.wMove = wMove;
	}

	public int gethMove() {
		return hMove;
	}

	public void sethMove(int hMove) {
		this.hMove = hMove;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public boolean isFillBool() {
		return fillBool;
	}

	public void setFillBool(boolean fillBool) {
		this.fillBool = fillBool;
	}

	public boolean isOutlineBool() {
		return outlineBool;
	}

	public void setOutlineBool(boolean outlineBool) {
		this.outlineBool = outlineBool;
	}

}
