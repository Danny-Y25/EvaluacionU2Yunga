package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import ec.edu.ups.bussines.VehiculoONRemote;

import ec.edu.ups.model.Vehiculo;

import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private VehiculoONRemote vehRemote;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.conectar();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(145, 48, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 85, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 135, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 177, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				datosProducto();
			}
		});
		btnNewButton.setBounds(110, 221, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ingresar Vehiculo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(79, 17, 151, 20);
		panel.add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 138, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(10, 180, 46, 14);
		panel.add(lblAo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Modelo");
		lblNewLabel_1_1.setBounds(10, 88, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Placa");
		lblNewLabel_1_2.setBounds(10, 51, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Editar Vehiculo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(369, 17, 113, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Placa");
		lblNewLabel_2.setBounds(369, 51, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarCliente();
				
			}
		});
		textField_4.setBounds(414, 48, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarProducto();
				
			}
		});
		btnNewButton_1.setBounds(390, 221, 113, 23);
		panel.add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(331, 101, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(502, 101, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(414, 148, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Modelo");
		lblNewLabel_1_1_1.setBounds(275, 104, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setBounds(446, 107, 46, 14);
		panel.add(lblTipo_1);
		
		JLabel lblAo_1 = new JLabel("A\u00F1o");
		lblAo_1.setBounds(358, 151, 46, 14);
		panel.add(lblAo_1);
	}
	
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/Prueba-Web/VehiculoON!ec.edu.ups.bussines.VehiculoONRemote";  
              
            this.vehRemote = (VehiculoONRemote) context.lookup(lookupName);  
            
           
            System.out.println("conectado");
        	
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	
	}
public void datosProducto() {
		
		String placa=textField.getText();
		String modelo=textField_1.getText();
		String tipo=textField_2.getText();
		String anio =textField_3.getText();
		
		Vehiculo veh=new Vehiculo();
		veh.setPlaca(placa);
		veh.setModelo(modelo);
		veh.setTipo(tipo);
		veh.setAnio(anio);
		
		
		
		try {
			this.vehRemote.insertar(veh);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Vehiculo Agregado");   
		Limpiar1();
	}

protected void consultarCliente() {
	// TODO Auto-generated method stub
	String placa=textField_4.getText();
	Vehiculo p = this.vehRemote.getDatos(placa);
	
	if (p==null) {
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		JOptionPane.showMessageDialog(null, "Vehiculo no registrado");
		
		
	}else {
		textField_5.setText(p.getModelo());
		textField_6.setText(p.getTipo());
		textField_7.setText(p.getAnio());
	}
	
	
}


public void actualizarProducto() {
	
	String placa=textField_4.getText();
	String modelo=textField_5.getText();
	String tipo=textField_6.getText();
	String anio =textField_7.getText();
	
	Vehiculo veh=new Vehiculo();
	veh.setPlaca(placa);
	veh.setModelo(modelo);
	veh.setTipo(tipo);
	veh.setAnio(anio);
	
	
	
	try {
		this.vehRemote.actualizar(veh);;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JOptionPane.showMessageDialog(null, "Vehiculo Actualizado");
	Limpiar();
	  
	
}

public void Limpiar(){
	textField_4.setText("");
	textField_5.setText("");
	textField_6.setText("");
	textField_7.setText("");
}

public void Limpiar1(){
	textField.setText("");
	textField_1.setText("");
	textField_2.setText("");
	textField_3.setText("");
}
}
