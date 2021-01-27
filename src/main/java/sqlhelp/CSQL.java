package sqlhelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSQL {
	
	private PreparedStatement s;
	
	public CSQL(String sql)
	{
		try {
			s = SqlConnectionHandler.getInstance().getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			System.err.println("Cannot create statement.");
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getSQL()
	{
		return s;
	}
	
	public ResultList executeQuery()
	{
		ResultSet results;
		try 
		{
			results = s.executeQuery();
	
			ResultSetMetaData meta= results.getMetaData();
			List<HashMap<String,Object>> resultArray = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> row;
			int columns = meta.getColumnCount();
			while(results.next())
			{
				row = new HashMap<String,Object>(columns);
				for(int i=1;i<=columns;i++)
				{
					row.put(meta.getColumnName(i), results.getObject(i));
				}
				resultArray.add(row);
			}
			results.close();
			Connection c = s.getConnection();
			c.commit();
			s.close();
			c.close();
			return new ResultList(resultArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
