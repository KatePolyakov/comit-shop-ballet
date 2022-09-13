package org.comit.course.dao;

import java.util.ArrayList;
import java.util.List;

import org.comit.course.bean.Shop;
import org.comit.course.dao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDao {
	
	public List<Shop> shops;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	ShopDao() {
//		this.shops = new ArrayList<>();
//		
//		this.shops.add(new Shop(1, "balletshoes1.jpg", "Ballet Shoes", "90.0", "Color: Light Pink | Size: 12, 13", "ModernModern", "A"));
//		this.shops.add(new Shop(2, "balletshoes1.jpg", "Ballet Shoes", "90.0", "Color: Light Pink | Size: 12, 13", "ModernModern", "A"));
//		this.shops.add(new Shop(3, "balletshoes1.jpg", "Ballet Shoes", "90.0", "Color: Light Pink | Size: 12, 13", "ModernModern", "A"));
//		this.shops.add(new Shop(4, "balletshoes1.jpg", "Ballet Shoes", "90.0", "Color: Light Pink | Size: 12, 13", "ModernModern", "A"));
//		this.shops.add(new Shop(5, "balletshoes1.jpg", "Ballet Shoes", "90.0", "Color: Light Pink | Size: 12, 13", "ModernModern", "A"));
//		
//		
//	}
	
	public List<Shop> listShops() {
		
		String sql = "SELECT * FROM SHOP";
		
		 return jdbcTemplate.query(sql, new ShopMapper());
	}
	
	public Shop findShop(int idProduct) {
		
		Shop shop = new Shop();
		shop.setIdProduct(idProduct);
		//this.shops.indexOf(shop);
		
		int index = this.shops.indexOf(shop);
		
		if (index >=0) {
			shop = this.shops.get(index);
		}
		
		return shop;
	}
	
	public synchronized void createShop(Shop shop) {
		
		int max = 0;
		for (Shop s: shops) {
			if (s.getIdProduct()>max) {
				max= s.getIdProduct();
			}
		}
		
		shop.setIdProduct(++max);
		shop.setStatus("A");
		
		this.shops.add(shop);
	}
	
/////////////// MODIFY USERS METHOD (FOR SYNCRONISED) /////////////////////
	
	public void modifyShop(Shop shop) {
		
		//first we need to find shop
		Shop s = this.findShop(shop.getIdProduct());
		
		if (s != null) {
			s.setPhotoName(shop.getPhotoName());
			s.setName(shop.getName());
			s.setPrice(shop.getPrice());
			s.setDescription(shop.getDescription());
			s.setCompany(shop.getCompany());
		}
	}
	
	public void deleteShop(int idProduct) {
		
		Shop shop = new Shop();
		shop.setIdProduct(idProduct);
		//this.shops.indexOf(shop);
		
		int index = this.shops.indexOf(shop);
		this.shops.remove(index);
	}

}
