package launch;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.springframework.boot.SpringApplication;

import config.ConfigReaderWriter;
import config.ServerConfig;
import sqlhelp.SqlConnectionHandler;

public class Main {
	
	
	public Main(String args[])
	{
		ServerConfig svr = ConfigReaderWriter.readServerConfig();
		
		SqlConnectionHandler ch = SqlConnectionHandler.getInstance();
		
		if(svr != null)
		{
			ch.setHost(svr.getHost());
			ch.setPort(svr.getPort());
			ch.setDatabase(svr.getDatabase());
			ch.setUsername(svr.getUsername());
			ch.setPassword(svr.getPassword());
		
			//Attempt login
			if(ch.canLogin())
			{
				launchWebsite(args);
				openMainGUI();
			}
			else 
			{
				openCfgGUI();
			}
		}
		else
		{
			openCfgGUI();
		}
	}
	
	public void launchWebsite(String args[])
	{
		SpringApplication.run(Main.class, args);
	}
	
	public void openCfgGUI()
	{
		
	}
	
	public void openMainGUI()
	{
		
	}
	
	public static void main(String args[]) throws Exception
	{
		new Main(args);
	}
}
