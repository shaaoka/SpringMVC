package tw.team6.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.team6.model.Delivery;
import tw.team6.model.DeliveryService;


@Controller
public class DeliveryController {

	@Autowired
	private DeliveryService service;

	
	
	//查詢全部 測試網址http://localhost:8080/team6/home
	@GetMapping("/home")
	public String Home(Model model) {
		List<Delivery> delivery = service.findAll();
		model.addAttribute("delivery",delivery);  	
		return "GetAll";
	}
	//測試網址http://localhost:8080/team6/add
	@GetMapping("/add")
	public String Add() {
		return "insert";			
	}
	
	//新增   
	@PostMapping("/insert")
	public String Insert(
						 @RequestParam("cname") String cname,
						 @RequestParam("phone") String phone,
						 @RequestParam("product") String product,
						 @RequestParam("num") int num,
						 @RequestParam("ename") String ename,
						 @RequestParam("price") int price,
						 @RequestParam("address") String address,
						 @RequestParam("time") int time){
		Delivery result = new Delivery(cname,phone,product,num,price,ename,address,time);
		service.insert(result);
		return "redirect:/home";
	}
	
	

	//查詢單筆
	@GetMapping("/update/{id}")
	public String Update(@PathVariable("id") int id ,Model m){
		Delivery delivery = service.findById(id);
		m.addAttribute("delivery",delivery);
		return "DoUpdate";
	}
	//修改
	@PostMapping("/upd")
	public String Upd(@ModelAttribute("delivery")Delivery delivery) {
		service.update(delivery);
		return "redirect:/home";		
	}
	
	
	//刪除
	@GetMapping("/del/{id}")
	public String processDeleteAction(@PathVariable("id") int id) {
		service.Del(id);
		return "redirect:/home";

	}
}
	



