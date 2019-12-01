package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BuyerUserDao;
import com.dao.OrderDao;
import com.dao.RequestDao;
import com.dao.ServiceDao;
import com.dao.UserDao;
import com.model.OrderModel;
import com.model.RequestModel;
import com.model.ServiceModel;
import com.model.ServiceProvider;
import com.model.UserBuyer;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class UserController {

	@Autowired
	private UserDao userService;

	@Autowired
	private BuyerUserDao buyerService;

	@Autowired
	private ServiceDao svcDao;

	@Autowired
	private RequestDao rqstDao;

	@Autowired
	private OrderDao ordrDao;

	@PostMapping("/ServiceProviders")
	public ResponseEntity<ServiceProvider> addUserSP(@RequestBody ServiceProvider user) {
		if (userService.isUserExistsById(user.getUserID())) {
			return new ResponseEntity<ServiceProvider>(HttpStatus.CONFLICT);
		} else {
			userService.addUser(user);
			return new ResponseEntity<ServiceProvider>(HttpStatus.CREATED);
		}

	}

	@PutMapping("/ServiceProviders/username/rqstName/addRequest/{rqstName}/{username}")
	public ServiceProvider addRequesttoServiceProvider(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		ServiceProvider user = userService.findUserByName(username);
		System.out.println(user);
		user.getRqsts().add(rqstName);
		System.out.println(user.getRqsts());
		userService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/ServiceProviders/username/rqstName/removeRequest/{rqstName}/{username}")
	public ServiceProvider removeRequestFromServiceProvider(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		ServiceProvider user = userService.findUserByName(username);
		System.out.println(user);
		user.getRqsts().remove(rqstName);
		System.out.println(user.getRqsts());
		userService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/ServiceProviders/username/rqstName/addAcceptedRequest/{rqstName}/{username}")
	public ServiceProvider addAcceptedRequesttoServiceProvider(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		ServiceProvider user = userService.findUserByName(username);
		System.out.println(user);
		user.getAcceptedRqsts().add(rqstName);
		System.out.println(user.getAcceptedRqsts());
		userService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/ServiceProviders/username/rqstName/removeAcceptedRequest/{rqstName}/{username}")
	public ServiceProvider removeAcceptedRequesttoServiceProvider(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		ServiceProvider user = userService.findUserByName(username);
		System.out.println(user);
		user.getAcceptedRqsts().remove(rqstName);
		System.out.println(user.getAcceptedRqsts());
		userService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/ServiceProviders/username/orderName/addOrder/{orderName}/{username}")
	public ServiceProvider addOrdertoServiceProvider(@PathVariable("orderName") String orderName,
			@PathVariable("username") String username) {
		ServiceProvider user = userService.findUserByName(username);
		System.out.println(user);
		user.getOrders().add(orderName);
		System.out.println(user.getOrders());
		userService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/BuyerUsers/username/rqstName/addRequest/{rqstName}/{username}")
	public UserBuyer addRequesttoUserBuyer(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		UserBuyer user = buyerService.findUserByName(username);
		System.out.println(user);
		user.getRqsts().add(rqstName);
		System.out.println(user.getRqsts());
		buyerService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/BuyerUsers/username/rqstName/removeRequest/{rqstName}/{username}")
	public UserBuyer removeRequestFromUserBuyer(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		UserBuyer user = buyerService.findUserByName(username);
		System.out.println(user);
		user.getRqsts().remove(rqstName);
		System.out.println(user.getRqsts());
		buyerService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/BuyerUsers/username/rqstName/addAcceptedRequest/{rqstName}/{username}")
	public UserBuyer addAcceptedRequesttoUserBuyer(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		UserBuyer user = buyerService.findUserByName(username);
		System.out.println(user);
		user.getAcceptedRqsts().add(rqstName);

		System.out.println(user.getAcceptedRqsts());
		buyerService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/BuyerUsers/username/rqstName/removeAcceptedRequest/{rqstName}/{username}")
	public UserBuyer removeAcceptedRequestfromUserBuyer(@PathVariable("rqstName") String rqstName,
			@PathVariable("username") String username) {
		UserBuyer user = buyerService.findUserByName(username);
		System.out.println(user);
		user.getAcceptedRqsts().remove(rqstName);

		System.out.println(user.getAcceptedRqsts());
		buyerService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/BuyerUsers/username/orderName/addOrder/{orderName}/{username}")
	public UserBuyer addOrdertoUserBuyer(@PathVariable("orderName") String orderName,
			@PathVariable("username") String username) {
		UserBuyer user = buyerService.findUserByName(username);
		System.out.println(user);
		user.getOrders().add(orderName);

		System.out.println(user.getOrders());
		buyerService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PutMapping("/ServiceProviders/username/svcName/{svcName}/{username}")
	public ServiceProvider addServicetoServiceProvider(@PathVariable("svcName") String svcName,
			@PathVariable("username") String username) {
		ServiceProvider user = userService.findUserByName(username);
		System.out.println(user);
		user.getSvcs().add(svcName);
		userService.addUser(user);
		System.out.println(user);
		return user;

	}

	@PostMapping("/BuyerUsers")
	public UserBuyer addUserBuyer(@RequestBody UserBuyer user) {
		if (buyerService.isUserExistsById(user.getUserID())) {
			return null;
		} else {
			buyerService.addUser(user);
			return user;
		}

	}

	@PostMapping("/Services")
	public ServiceModel addService(@RequestBody ServiceModel svc) {

		svcDao.addService(svc);
		return svc;

	}

	@PostMapping("/Requests")
	public RequestModel addRequest(@RequestBody RequestModel rqst) {

		rqstDao.addRequest(rqst);

		return rqst;

	}

	@PostMapping("/Orders")
	public ResponseEntity<OrderModel> addOrder(@RequestBody OrderModel ordr) {
		if (ordrDao.isOrderExists(ordr.getoId())) {
			return new ResponseEntity<OrderModel>(HttpStatus.CONFLICT);
		} else {
			ordrDao.addOrder(ordr);
			return new ResponseEntity<OrderModel>(HttpStatus.CREATED);
		}

	}

	@GetMapping("/ServiceProviders")
	public ResponseEntity<List<ServiceProvider>> getAllUsersSP() {
		List<ServiceProvider> users = userService.getAllUsers();
		return new ResponseEntity<List<ServiceProvider>>(users, HttpStatus.OK);
	}

	@GetMapping("/BuyerUsers")
	public ResponseEntity<List<UserBuyer>> getAllUsersBuyer() {
		List<UserBuyer> users = buyerService.getAllUsers();
		return new ResponseEntity<List<UserBuyer>>(users, HttpStatus.OK);
	}

	@GetMapping("/Services")
	public ResponseEntity<List<ServiceModel>> getAllServices() {
		List<ServiceModel> users = svcDao.getAllServices();
		return new ResponseEntity<List<ServiceModel>>(users, HttpStatus.OK);
	}

	@GetMapping("/Requests")
	public ResponseEntity<List<RequestModel>> getAllRequests() {
		List<RequestModel> rqsts = rqstDao.getAllRequests();
		return new ResponseEntity<List<RequestModel>>(rqsts, HttpStatus.OK);
	}

	@GetMapping("/Orders")
	public ResponseEntity<List<OrderModel>> getAllOrders() {
		List<OrderModel> orders = ordrDao.getAllOrders();
		return new ResponseEntity<List<OrderModel>>(orders, HttpStatus.OK);
	}

	@GetMapping("/ServiceProviders/username/{username}")
	public ResponseEntity<ServiceProvider> findUserSPByName(@PathVariable("username") String username) {
		ServiceProvider user = new ServiceProvider();
		if (userService.isUserExistsByName(username)) {
			user = userService.findUserByName(username);
			return new ResponseEntity<ServiceProvider>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<ServiceProvider>(user, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/ServiceProviders/id/{id}")
	public ResponseEntity<ServiceProvider> findUserSPById(@PathVariable("id") String id) {
		ServiceProvider user = new ServiceProvider();
		if (userService.isUserExistsById(id)) {
			user = userService.findUserById(id);
			return new ResponseEntity<ServiceProvider>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<ServiceProvider>(user, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/ServiceProviders/email/{email}")
	public ResponseEntity<ServiceProvider> findUserSPByMailId(@PathVariable("email") String email) {
		ServiceProvider user = new ServiceProvider();
		if (userService.isUserExistsByMailId(email)) {
			user = userService.findUserByMailId(email);

			return new ResponseEntity<ServiceProvider>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<ServiceProvider>(user, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/BuyerUsers/username/{username}")
	public ResponseEntity<UserBuyer> findUserBuyerByName(@PathVariable("username") String username) {
		UserBuyer user = new UserBuyer();
		if (buyerService.isUserExistsByName(username)) {
			user = buyerService.findUserByName(username);
			return new ResponseEntity<UserBuyer>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserBuyer>(user, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/BuyerUsers/id/{id}")
	public ResponseEntity<UserBuyer> findUserBuyerById(@PathVariable("id") String id) {
		UserBuyer user = new UserBuyer();
		if (buyerService.isUserExistsById(id)) {
			user = buyerService.findUserById(id);
			return new ResponseEntity<UserBuyer>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserBuyer>(user, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/BuyerUsers/email/{email}")
	public UserBuyer findUserBuyerByEmail(@PathVariable("email") String email) {
		UserBuyer user = new UserBuyer();
		
			user = buyerService.findUserByEmailId(email);
			return user;
		
			
	}

	@GetMapping("/Services/svcName/{svcName}")
	public ResponseEntity<ServiceModel> findService(@PathVariable("svcName") String svcName) {
		if (svcDao.isServiceExists(svcName)) {
			ServiceModel svc = svcDao.findService(svcName);
			return new ResponseEntity<ServiceModel>(svc, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<ServiceModel>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/Requests/rqstName/{rqstName}")
	public ResponseEntity<RequestModel> findRequestByName(@PathVariable("rqstName") String rqstName) {
		if (rqstDao.isRequestExistsByName(rqstName)) {
			RequestModel rqst = rqstDao.findRequestByName(rqstName);
			return new ResponseEntity<RequestModel>(rqst, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<RequestModel>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/Requests/id/{id}")
	public ResponseEntity<RequestModel> findRequestById(@PathVariable("id") String id) {
		if (rqstDao.isRequestExistsById(id)) {
			RequestModel rqst = rqstDao.findRequestById(id);
			return new ResponseEntity<RequestModel>(rqst, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<RequestModel>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/Orders/id/{id}")
	public ResponseEntity<OrderModel> findOrder(@PathVariable("id") String id) {
		if (ordrDao.isOrderExists(id)) {
			OrderModel order = ordrDao.findOrder(id);
			return new ResponseEntity<OrderModel>(order, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<OrderModel>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/ServiceProviders/{username}/{password}")
	public ResponseEntity<ServiceProvider> validateUserSP(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		if (userService.validateUser(username, password)) {
			ServiceProvider user = userService.findUserByName(username);
			return new ResponseEntity<ServiceProvider>(user, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<ServiceProvider>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/BuyerUsers/{username}/{password}")
	public ResponseEntity<UserBuyer> validateUserBuyer(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		if (buyerService.validateUser(username, password)) {
			UserBuyer user = buyerService.findUserByName(username);
			return new ResponseEntity<UserBuyer>(user, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<UserBuyer>(HttpStatus.NOT_FOUND);
		}

	}

}
