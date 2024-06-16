package com.fullProjectOverview.fullProjectOverview.configure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseService {

	@Autowired
	DataSource datasource;

	public boolean performDatabaseOperation() throws SQLException {
		try (Connection connecion = datasource.getConnection();) {
			String query = "Select * from users";
			try (PreparedStatement preparedStatement = connecion.prepareStatement(query);) {
				try (ResultSet resultSet = preparedStatement.executeQuery();) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String name = resultSet.getString("name");
						System.err.println("id" + id + " : name " + name);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}