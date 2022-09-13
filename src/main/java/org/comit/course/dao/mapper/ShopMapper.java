package org.comit.course.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.course.bean.Shop;
import org.springframework.jdbc.core.RowMapper;

public class ShopMapper implements RowMapper<Shop> {

	@Override
	public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Shop shop = new Shop();
		
		shop.setIdProduct(rs.getInt("ID_PRODUCT"));
		shop.setPhotoName(rs.getString("PHOTO_NAME"));
		shop.setName(rs.getString("NAME"));
		shop.setPrice(rs.getString("PRICE"));
		shop.setDescription(rs.getString("DESCRIPTION"));
		shop.setCompany(rs.getString("COMPANY"));
		shop.setStatus(rs.getString("STATUS"));
		return null;
	}

}
