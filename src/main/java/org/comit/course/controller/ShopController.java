package org.comit.course.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.course.bean.Shop;
import org.comit.course.service.ShopService;
import org.comit.course.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	
	///// CREATE INDEX
	
	@GetMapping({"/", "/index"})
	public String index() {
		System.out.println("Show Index Page");
		
		return "index";
	}

	//// CREATE LIST
	@GetMapping("/list")
	public ModelAndView listShops() {
		System.out.println("List Shops");
		
		List<Shop> shops = this.shopService.listShops();
		return new ModelAndView("list", "shops", shops);
	}
	
	////CREATE 
	
	
	@GetMapping("/create")
	public String showCreate() {
		System.out.println("Show create");
		
		return "create";
	}
	
////CREATE new shop
	@PostMapping("/create")
	public String createShop(HttpServletRequest request) {
		System.out.println("Create Shop");
		

		String photoName = request.getParameter("photoName");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String company = request.getParameter("company");
	
		Shop shop = this.createShop(null, photoName, name, price, description, company);
		
		this.shopService.createShop(shop);
		
		return "redirect:/list";
	}
	
	///UPDATE
	@GetMapping("/update/{id}")
	public ModelAndView showUpdate(@PathVariable("id") int id) {
		System.out.println("Show Update");
		
		Shop shop = this.shopService.findShop(id);
		
		return new ModelAndView("update", "shop", shop);
	}
	
	@PostMapping("/update")
	public String updateShop(HttpServletRequest request) {
		System.out.println("Update Shop");
		
		String id = request.getParameter("id");
		String photoName = request.getParameter("photoName");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String company = request.getParameter("company");


		System.out.println("id " + id + " photoName " + photoName + " price " + price);
		
		Shop shop = this.createShop(id, photoName, name, price, description, company);
		
		this.shopService.modifyShop(shop);
		
		return "redirect:/list";
	}
	
	//DELETE shop
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		System.out.println("Delete User");
		this.shopService.deleteShop(id);
		
		return "redirect:/list";
	}
	
	
	//create a method for collecting all strings in one bin
	private Shop createShop(String id, String photoName, String name, String price, String description, String company) {
		Shop shop = new Shop(Util.parseId(id), photoName.trim(), name.trim(), price.trim(), description.trim(), company.trim(), "");
		
		return shop;
	}
}
