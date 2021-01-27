package ui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import config.ConfigReaderWriter;
import config.ServerConfig;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CfgGUI extends JFrame{
	
	/** 
	 * This is the main class for CfgGUI designed to set up the graphics.
	 * After that the the parent class should create an action listener for the connect button. 
	 * The connect button will let the user know that it can now read a ServerConfig object out of 
	 * getConnCfg();
	 */
	private static final long serialVersionUID = 4665367555601221762L;
	private JTable _servers;
	private JTextField _host;
	private JTextField _port;
	private JTextField _db;
	private JTextField _password;
	private JTextField _username;
	private JButton _connect;
	
	public CfgGUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.75);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		_servers = new JTable();
		panel.add(_servers);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel hostLbl = new JLabel("Host:");
		GridBagConstraints gbc_hostLbl = new GridBagConstraints();
		gbc_hostLbl.insets = new Insets(0, 0, 5, 5);
		gbc_hostLbl.anchor = GridBagConstraints.EAST;
		gbc_hostLbl.gridx = 0;
		gbc_hostLbl.gridy = 0;
		panel_1.add(hostLbl, gbc_hostLbl);
		
		_host = new JTextField();
		GridBagConstraints gbc__host = new GridBagConstraints();
		gbc__host.gridwidth = 2;
		gbc__host.insets = new Insets(0, 0, 5, 5);
		gbc__host.fill = GridBagConstraints.HORIZONTAL;
		gbc__host.gridx = 1;
		gbc__host.gridy = 0;
		panel_1.add(_host, gbc__host);
		_host.setColumns(10);
		
		JLabel portLbl = new JLabel("Port:");
		GridBagConstraints gbc_portLbl = new GridBagConstraints();
		gbc_portLbl.anchor = GridBagConstraints.EAST;
		gbc_portLbl.insets = new Insets(0, 0, 5, 5);
		gbc_portLbl.gridx = 0;
		gbc_portLbl.gridy = 1;
		panel_1.add(portLbl, gbc_portLbl);
		
		_port = new JTextField();
		GridBagConstraints gbc__port = new GridBagConstraints();
		gbc__port.gridwidth = 2;
		gbc__port.insets = new Insets(0, 0, 5, 5);
		gbc__port.fill = GridBagConstraints.HORIZONTAL;
		gbc__port.gridx = 1;
		gbc__port.gridy = 1;
		panel_1.add(_port, gbc__port);
		_port.setColumns(10);
		
		JLabel dbLbl = new JLabel("Database:");
		GridBagConstraints gbc_dbLbl = new GridBagConstraints();
		gbc_dbLbl.anchor = GridBagConstraints.EAST;
		gbc_dbLbl.insets = new Insets(0, 0, 5, 5);
		gbc_dbLbl.gridx = 0;
		gbc_dbLbl.gridy = 2;
		panel_1.add(dbLbl, gbc_dbLbl);
		
		_db = new JTextField();
		GridBagConstraints gbc__db = new GridBagConstraints();
		gbc__db.gridwidth = 2;
		gbc__db.insets = new Insets(0, 0, 5, 5);
		gbc__db.fill = GridBagConstraints.HORIZONTAL;
		gbc__db.gridx = 1;
		gbc__db.gridy = 2;
		panel_1.add(_db, gbc__db);
		_db.setColumns(10);
		
		JLabel unameLbl = new JLabel("Username:");
		GridBagConstraints gbc_unameLbl = new GridBagConstraints();
		gbc_unameLbl.anchor = GridBagConstraints.EAST;
		gbc_unameLbl.insets = new Insets(0, 0, 5, 5);
		gbc_unameLbl.gridx = 0;
		gbc_unameLbl.gridy = 4;
		panel_1.add(unameLbl, gbc_unameLbl);
		
		_username = new JTextField();
		GridBagConstraints gbc__username = new GridBagConstraints();
		gbc__username.insets = new Insets(0, 0, 5, 5);
		gbc__username.fill = GridBagConstraints.HORIZONTAL;
		gbc__username.gridx = 1;
		gbc__username.gridy = 4;
		panel_1.add(_username, gbc__username);
		_username.setColumns(10);
		
		JLabel passwdLbl = new JLabel("Password:");
		GridBagConstraints gbc_passwdLbl = new GridBagConstraints();
		gbc_passwdLbl.insets = new Insets(0, 0, 5, 5);
		gbc_passwdLbl.anchor = GridBagConstraints.EAST;
		gbc_passwdLbl.gridx = 2;
		gbc_passwdLbl.gridy = 4;
		panel_1.add(passwdLbl, gbc_passwdLbl);
		
		_password = new JTextField();
		GridBagConstraints gbc__password = new GridBagConstraints();
		gbc__password.insets = new Insets(0, 0, 5, 0);
		gbc__password.fill = GridBagConstraints.HORIZONTAL;
		gbc__password.gridx = 3;
		gbc__password.gridy = 4;
		panel_1.add(_password, gbc__password);
		_password.setColumns(10);
		
		_connect = new JButton("Connect");
		GridBagConstraints gbc__connect = new GridBagConstraints();
		gbc__connect.gridwidth = 4;
		gbc__connect.gridx = 0;
		gbc__connect.gridy = 5;
		panel_1.add(_connect, gbc__connect);
	}
	
	public JButton getConnect()
	{
		return _connect;
	}
	
	public void loadPrevious()
	{
		ServerConfig[] servers = ConfigReaderWriter.readAllServerConfig();
	}
	
	public void loadAvailable()
	{
		
	}
	
	public ServerConfig getConnCfg()
	{
		ServerConfig s = new ServerConfig();
		s.setHost(getName());
		s.setPort(ABORT);
		s.setDatabase(getName());
		s.setUsername(getName());
		s.setPassword(getName());		
		
		return s;
	}
	
}
