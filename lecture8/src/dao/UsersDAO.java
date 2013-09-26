package dao;

import handlers.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataSets.UsersDataSet;
import executor.TExecutor;

public class UsersDAO {
	
	private Connection con;
	
	public UsersDAO(Connection con){
		this.con = con;
	}
	
	public UsersDataSet get(long id) throws SQLException{
		TExecutor ecec = new TExecutor();
		return ecec.execQuery(con, "select * from users where id=" + id, new TResultHandler<UsersDataSet>(){

			public UsersDataSet handle(ResultSet result) throws SQLException {
				result.next();
				UsersDataSet dataSet = new UsersDataSet(result.getLong(1), result.getString(2));
				return dataSet;				
			}
			
		});
	}
}
