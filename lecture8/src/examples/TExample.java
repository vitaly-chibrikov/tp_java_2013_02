package examples;

import handlers.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import executor.SimpleExecutor;
import executor.TExecutor;

public class TExample {
	public static void connect(){
		try {
			Connection connection = SimpleExample.getConnection();
			SimpleExecutor exec = new SimpleExecutor();
			
			exec.execUpdate(connection, "create table users (id bigint auto_increment, user_name varchar(256), primary key (id))");
			System.out.append("Table created\n");
			exec.execUpdate(connection, "insert into users (user_name) values ('tully')");
			System.out.append("User added\n");
			
			TExecutor execT = new TExecutor();
			
			Integer name = execT.execQuery(connection, "select * from users where id=1", new TResultHandler<Integer>(){
				public Integer handle(ResultSet result) throws SQLException {
					result.next();
					return result.getInt(1);				
				}				
			});
			
			System.out.append("Read user: " + name + '\n');
			
			exec.execUpdate(connection, "drop table users");
			System.out.append("Done!\n");
					
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
