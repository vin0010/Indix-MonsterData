package com.indix.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.indix.Model.Product;

public class MergerDAO {
	public MergerDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void write(List<Product> products) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = SingletonDBConnection.getInstance().getConnInst().getConnection();
		PreparedStatement preparedStatement = null;
		for (Product product : products) {
			String updateTableSQL = "UPDATE Product SET pid=?, upcs=?, categoryId=?, storeId=?, seller=?, timestamp = ? and price=? where timestamp<?";
			preparedStatement = connection.prepareStatement(updateTableSQL);
			preparedStatement.setString(0, product.getpId());
			preparedStatement.setLong(1, product.getUpcs());
			preparedStatement.setInt(2, product.getCategoryld());
			preparedStatement.setInt(3, product.getStoreld());
			preparedStatement.setString(4, product.getSeller());
			preparedStatement.setDate(5, product.getDate());
			preparedStatement.setFloat(6, product.getPrice());
			// execute update SQL stetement
			preparedStatement.executeUpdate();
		}
	}

}
