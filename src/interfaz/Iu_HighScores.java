package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.LinkedListJ;
import codigo.Puntuacion;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import codigo.Node;

public class Iu_HighScores extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNombre;
	private JLabel lblPuntuacin;
	private JLabel lblTiempo;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel[][] matriz;
	private LinkedListJ<String> facil;
	private LinkedListJ<String> medio;
	private LinkedListJ<String> dificil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_HighScores frame = new Iu_HighScores();
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
	public Iu_HighScores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		matriz = new JLabel[10][3];
		tablero();
		facil = Puntuacion.getPuntuacion().getFacil();
		medio = Puntuacion.getPuntuacion().getMedio();
		dificil = Puntuacion.getPuntuacion().getDificil();
		cargarDatos(facil);

	}

	private void tablero() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				JLabel l = new JLabel("");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				getPanel_2().add(l);
				matriz[i][j] = l;

			}
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 3, 0, 0));
			panel.add(getLblNombre());
			panel.add(getLblPuntuacin());
			panel.add(getLblTiempo());
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 4, 0, 0));
			panel_1.add(getPanel_3());
			panel_1.add(getPanel_4());
			panel_1.add(getPanel_5());
			panel_1.add(getPanel_6());
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(0, 3, 0, 0));
			LinkedListJ<String> listaF = Puntuacion.getPuntuacion().getFacil();
		}
		return panel_2;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNombre;
	}

	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuaci\u00F3n");
			lblPuntuacin.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPuntuacin;
	}

	private JLabel getLblTiempo() {
		if (lblTiempo == null) {
			lblTiempo = new JLabel("Tiempo");
			lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTiempo;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getBtnNewButton());
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.add(getBtnNewButton_1());
		}
		return panel_4;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.add(getBtnNewButton_2());
		}
		return panel_5;
	}

	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.add(getBtnNewButton_3());
		}
		return panel_6;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("F\u00E1cil");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarDatos(facil);
				}
			});
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Medio");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarDatos(medio);
				}
			});
		}
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Did\u00EDcil");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarDatos(dificil);
				}
			});
		}
		return btnNewButton_2;
	}

	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Volver");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnNewButton_3;
	}

	private void cargarDatos(LinkedListJ<String> lista) {

		Node<String> primero = lista.getFirst();
		int fila = 0;
		
		limpiarJLabels();

		while (primero != null) {
			String[] line = primero.data.split("\\s+--->\\s++");
			matriz[fila][0].setText(line[1]);
			matriz[fila][1].setText(line[2]);
			matriz[fila][2].setText(line[3]);
			fila++;
			primero = primero.next;

		}
	}

	private void limpiarJLabels() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				
				matriz[i][j].setText("");

			}
		}
	}
}