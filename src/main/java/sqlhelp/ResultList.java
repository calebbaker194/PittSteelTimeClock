package sqlhelp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class ResultList extends ArrayList<HashMap<String,Object>>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5821956676968273233L;
	private int lastRow;
	private int currentRow = 0;
	
	public ResultList(java.util.List<HashMap<String, Object>> list)
	{
		addAll(list);
	}

	/**
	 * Creates an empty result list. that we can build up
	 * Mainly used for json
	 */
	public ResultList()
	{
		
	}

	public int addRow()
	{
		add(new HashMap<String,Object>());
		lastRow = size()-1;
		return size()-1;
	}
	
	/**
	 * gets the value of the field specified by prop in the first elemet of the result set
	 * @param field the column that you want the value from.
	 */
	public Object get(String field)
	{
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return null;
			return get(currentRow).get(field);
		}
		else 
			return null;
	}
	
	
	public HashMap<String,Object> getRow()
	{
		return get(currentRow);
	}
	
	public Integer getInt(String field)
	{
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return -1;
			return (Integer) get(currentRow).get(field);
		}
		else 
			return null;
	}
	
	public Double getDouble(String field)
	{
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return -1.0;
			if(get(currentRow).get(field) instanceof BigDecimal)	
			{
				return ((BigDecimal) get(currentRow).get(field)).doubleValue();
			}
			else
			{
				return (Double) get(currentRow).get(field);
			}
		}
		else 
			return null;
	}
	
	public String getString(String field)
	{
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return "";
			return (String) get(currentRow).get(field);
		}
		else 
			return null;
	}
	
	public char getChar(String field)
	{
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return ' ';
			return ((String) get(currentRow).get(field)).charAt(0);
		}
		else 
			return 0;
	}
	
	public Boolean getBoolean(String field)
	{
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return false;
			return (Boolean) get(currentRow).get(field);
		}
		else 
			return null;
	}
	
	public Timestamp getTimeStamp(String field)
	{
		
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return null;
			return (Timestamp) get(currentRow).get(field);
		}
		else 
			return null;
	}
	
	public ArrayList<String> getColumnNames() {
		Object[] it =  get(0).keySet().toArray();
		ArrayList<String> rt = new ArrayList<String>();
		for(Object o : it)
			rt.add(o.toString());
		return rt;
	}

	public boolean first(){
		return size()>0;
	}

	public void put(String string, Object value)
	{
		get(lastRow).put(string, value);
	}

	public boolean next()
	{
		currentRow++;
		if(currentRow >= size())
			return false;
		return true;
	}
	
	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public Date getDate(String field) {
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return null;
			return (Date) get(currentRow).get(field);
		}
		else 
			return null;
	}

	public Long getLong(String field) {
		if(size()>0)
		{
			if(get(currentRow).get(field) == null)
				return -1l;
			return (Long) get(currentRow).get(field);
		}
		else 
			return null;
	}
}