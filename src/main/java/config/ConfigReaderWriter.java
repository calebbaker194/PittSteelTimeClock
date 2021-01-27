package config;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigReaderWriter {
	/**
	 * This function writes all of the previously used servers to a file in "%APPDATA%/PSTC/servers.config
	 * @param Servers - A list of all the Servers that this computer knows about. 
	 * @return - True on success and False on failure
	 */
	public static boolean writeAllServerConfig(ServerConfig[] Servers)
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("%APPDATA%/PSTC/servers.config"), Servers);
			return true;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Reads all of the previously used servers from the default file into an array and returns the array
	 * @return - ServerConfig[] of the previous servers.
	 */
	public static ServerConfig[] readAllServerConfig()
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File("%APPDATA%/PSTC/servers.config"), ServerConfig[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Writes the configuration of the current server into "%APPDATA%/PSTC/server.config" to be loaded on the next launch
	 * @param server the server that is currently being used. 
	 * @return True if the write was successful and false if it was not
	 */
	public static boolean writeServerConfig(ServerConfig server)
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("%APPDATA%/PSTC/server.config"), server);
			return true;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * reads the last server used from the default file. in an attempt to log in automatically
	 * @return - ServerConfig of the last used server.
	 */
	public static ServerConfig readServerConfig()
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File("%APPDATA%/PSTC/server.config"), ServerConfig.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
