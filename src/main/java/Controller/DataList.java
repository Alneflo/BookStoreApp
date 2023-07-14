package Controller;

import java.util.ArrayList;

public class DataList<T> {
	private String columnName;
	
	private ArrayList<T> list;
	
	public DataList(String column){
		this.columnName = column;
		list = new ArrayList<>();
	}
	
	public void addValue(T value) {
		list.add(value);
	}
	
	public ArrayList<T> getValues() {
		return list;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
}
