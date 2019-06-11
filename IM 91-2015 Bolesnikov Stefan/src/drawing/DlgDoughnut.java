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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDoughnut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txtXDoughnut;
	private JTextField txtYDoughnut;
	private JTextField txtOuterRadiusDoughnut;
	private JTextField txtInnerRadiusDoughnut;
	boolean isOk;
	private int xMove, yMove, irMove, orMove;
	private Color outline = Color.black;
	private Color randomColor = Color.black;
	private Color fill = Color.white;
	private boolean fillBool;
	private boolean outlineBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDoughnut dialog = new DlgDoughnut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDoughnut() {
		setModal(true);
		setBounds(100, 100, 300, 300);
		setTitle("Doughnut");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblXCenter = new JLabel("X center:");
		txtXDoughnut = new JTextField();
		txtXDoughnut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXDoughnut.setColumns(10);
		JLabel lblYCenter = new JLabel("Y center:");
		txtYDoughnut = new JTextField();
		txtYDoughnut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYDoughnut.setColumns(10);
		JLabel lblOuterRadius = new JLabel("Outer radius:");
		txtOuterRadiusDoughnut = new JTextField();
		txtOuterRadiusDoughnut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtOuterRadiusDoughnut.setColumns(10);
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		txtInnerRadiusDoughnut = new JTextField();
		txtInnerRadiusDoughnut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtInnerRadiusDoughnut.setColumns(10);
		JButton btnFrameColor = new JButton("Frame color");
		btnFrameColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", randomColor);
				outlineBool = true;
			}
		});
		btnFrameColor.setForeground(Color.WHITE);
		btnFrameColor.setBackground(Color.BLUE);
		JButton btnFillColor = new JButton("Fill color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", randomColor);
				fillBool = true;
			}
		});
		btnFillColor.setForeground(Color.WHITE);
		btnFillColor.setBackground(Color.BLUE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFrameColor, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblXCenter, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
								.addComponent(lblYCenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblOuterRadius, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInnerRadius, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtXDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOuterRadiusDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInnerRadiusDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXCenter)
							.addGap(12)
							.addComponent(lblYCenter)
							.addGap(12)
							.addComponent(lblOuterRadius)
							.addGap(12)
							.addComponent(lblInnerRadius))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtXDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtYDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtOuterRadiusDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtInnerRadiusDoughnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addComponent(btnFrameColor)
					.addGap(6)
					.addComponent(btnFillColor)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXDoughnut.getText().trim().isEmpty() || txtYDoughnut.getText().trim().isEmpty() || txtInnerRadiusDoughnut.getText().trim().isEmpty() || txtOuterRadiusDoughnut.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Enter in all the values!", "Error", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							if(Integer.parseInt(txtOuterRadiusDoughnut.getText()) > Integer.parseInt(txtInnerRadiusDoughnut.getText())) {
								
							
							xMove = Integer.parseInt(txtXDoughnut.getText());
							yMove = Integer.parseInt(txtYDoughnut.getText());
							orMove = Integer.parseInt(txtOuterRadiusDoughnut.getText());
							irMove = Integer.parseInt(txtInnerRadiusDoughnut.getText());
							for (Shapes shapes : PnlDrawing.shapesArrList) {
								if(shapes.isSelected()) {
									if(shapes instanceof Doughnut) {
										((Doughnut)shapes).setCenter(new Point(xMove, yMove));
										((Doughnut)shapes).setRadius(orMove);
										((Doughnut)shapes).setInnerRadius(irMove);
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
							else {
								isOk = false;
								JOptionPane.showMessageDialog(null, "The inner radius must be smaller than the outer radius!", "Error", JOptionPane.ERROR_MESSAGE);
							}
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
						.addGap(94)
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

	public JTextField getTxtXDoughnut() {
		return txtXDoughnut;
	}

	public void setTxtXDoughnut(JTextField txtXDoughnut) {
		this.txtXDoughnut = txtXDoughnut;
	}

	public JTextField getTxtYDoughnut() {
		return txtYDoughnut;
	}

	public void setTxtYDoughnut(JTextField txtYDoughnut) {
		this.txtYDoughnut = txtYDoughnut;
	}

	public JTextField getTxtOuterRadiusDoughnut() {
		return txtOuterRadiusDoughnut;
	}

	public void setTxtOuterRadiusDoughnut(JTextField txtOuterRadiusDoughnut) {
		this.txtOuterRadiusDoughnut = txtOuterRadiusDoughnut;
	}

	public JTextField getTxtInnerRadiusDoughnut() {
		return txtInnerRadiusDoughnut;
	}

	public void setTxtInnerRadiusDoughnut(JTextField txtInnerRadiusDoughnut) {
		this.txtInnerRadiusDoughnut = txtInnerRadiusDoughnut;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getRandomColor() {
		return randomColor;
	}

	public void setRandomColor(Color randomColor) {
		this.randomColor = randomColor;
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
