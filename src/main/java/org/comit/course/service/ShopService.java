package org.comit.course.service;

import java.util.List;

import org.comit.course.bean.Shop;
import org.comit.course.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;
///////////// LIST USERS METHOD ///////////////////////
	
	public List<Shop> listShops(){
		
		List<Shop> shops = shopDao.listShops();
		
		shops.forEach(System.out::println);
		
		shops.removeIf(shop-> !"A".equals(shop.getStatus()));
		
		
		return shops;
	}
	/////////////// FIND USERS METHOD /////////////////////
	public Shop findShop(int idProduct) {
		
		return shopDao.findShop(idProduct);
	}
	
	/////////////// CREATE USERS METHOD /////////////////////
	public void createShop(Shop shop) {
		
		this.validateShop(shop);
		shopDao.createShop(shop);
	}
	
/////////////// MODIFY USERS METHOD (FOR SYNCRONISED) /////////////////////
	public void modifyShop(Shop shop) {
		this.validateShop(shop);
		shopDao.modifyShop(shop);
	}
	
/////////////// DELETE USERS METHOD /////////////////////
	public void deleteShop(int idProduct) {
		
		shopDao.deleteShop(idProduct);
	}
	////////VALIDATION OF USER /////////
	private void validateShop(Shop shop) {
		if(shop.getPhotoName().isEmpty() || shop.getName().isEmpty() || shop.getPrice().isEmpty() || shop.getDescription().isEmpty() || shop.getCompany().isEmpty()) {
			throw new RuntimeException("Invalid Data" + shop);
		}
	}

}
