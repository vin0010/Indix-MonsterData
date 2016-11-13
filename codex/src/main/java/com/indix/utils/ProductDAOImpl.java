package com.indix.utils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indix.Model.Product;

/**
 * An implementation of the ContactDAO interface.
 * 
 * @author www.codejava.net
 *
 */
public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	public ProductDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Product get(int pid) {
		// implementation
		String sql = "SELECT * FROM contact where pid=" + pid;
		List<Product> listContact = jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product contact = new Product();

				contact.setpId(rs.getString("pid"));
				contact.setCategoryld(Integer.parseInt(rs.getString("categoryld")));
				contact.setDate(new Date(Long.parseLong(rs.getString("timestamp"))));
				contact.setpId(rs.getString("address"));
				contact.setSeller(rs.getString("seller"));

				return contact;
			}

		});
		return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
