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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private VehiculoONRemote vehRemote;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(179, 48, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 85, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(179, 135, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 177, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				datosProducto();
			}
		});
		btnNewButton.setBounds(299, 109, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Vehiculo");
		lblNewLabel.setBounds(179, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(44, 138, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(44, 180, 46, 14);
		panel.add(lblAo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Modelo");
		lblNewLabel_1_1.setBounds(44, 88, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Placa");
		lblNewLabel_1_2.setBounds(44, 51, 46, 14);
		panel.add(lblNewLabel_1_2);
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
		
		    
		
	}

public void actualizarProducto() {
	
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
	
	    
	
}
}
