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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txtXCircle;
	private JTextField txtYCircle;
	private JTextField txtRadiusCircle;
	boolean isOk;
	private int xMove, yMove, rMove;
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
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setBounds(100, 100, 300, 300);
		setTitle("Circle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblXCenter = new JLabel("X center:");
		txtXCircle = new JTextField();
		txtXCircle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCircle.setColumns(10);
		JLabel lblYCenter = new JLabel("Y center:");
		txtYCircle = new JTextField();
		txtYCircle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYCircle.setColumns(10);
		JLabel lblRadius = new JLabel("Radius:");
		txtRadiusCircle = new JTextField();
		txtRadiusCircle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); //key event preuzima sta si otkucao pa smesta u c
				if (!((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtRadiusCircle.setColumns(10);
		JButton btnFrameColor = new JButton("Frame color");
		btnFrameColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", randomColor);
				outlineBool = true;
			}
		});
		btnFrameColor.setBackground(Color.BLUE);
		btnFrameColor.setForeground(Color.WHITE);
		JButton btnFillColor = new JButton("Fill color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose a color", randomColor);
				fillBool = true;
			}
		});
		btnFillColor.setBackground(Color.BLUE);
		btnFillColor.setForeground(Color.WHITE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFrameColor, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblYCenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblXCenter, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
								.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtYCircle)
								.addComponent(txtXCircle, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(txtRadiusCircle))))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCenter)
						.addComponent(txtXCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCenter)
						.addComponent(txtYCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadiusCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addComponent(btnFrameColor)
					.addGap(6)
					.addComponent(btnFillColor)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCircle.getText().trim().isEmpty() || txtYCircle.getText().trim().isEmpty() || txtRadiusCircle.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Enter in all the values!", "Error", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							xMove = Integer.parseInt(txtXCircle.getText());
							yMove = Integer.parseInt(txtYCircle.getText());
							rMove = Integer.parseInt(txtRadiusCircle.getText());
							for (Shapes shapes : PnlDrawing.shapesArrList) {
								if(shapes.isSelected()) {
									if(shapes instanceof Circle) {
										((Circle)shapes).setCenter(new Point(xMove, yMove));
										((Circle)shapes).setRadius(rMove);
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
						.addGap(93)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXCircle() {
		return txtXCircle;
	}

	public void setTxtXCircle(JTextField txtXCircle) {
		this.txtXCircle = txtXCircle;
	}

	public JTextField getTxtYCircle() {
		return txtYCircle;
	}

	public void setTxtYCircle(JTextField txtYCircle) {
		this.txtYCircle = txtYCircle;
	}

	public JTextField getTxtRadiusCircle() {
		return txtRadiusCircle;
	}

	public void setTxtRadiusCircle(JTextField txtRadiusCircle) {
		this.txtRadiusCircle = txtRadiusCircle;
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
