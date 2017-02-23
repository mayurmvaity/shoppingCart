$(function() {
	
	switch(menu) {
	
	case 'Sign Up':
		$('#signup').addClass('active'); break;
		
	case 'login': $('#login').addClass('active'); break;
	
	case 'Product list': $('#productList').addClass('active'); break;
	
	case 'Admins Products': $('#adminsProducts').addClass('active'); break;
	
	case 'About Us': $('#aboutUs').addClass('active'); break;
	
	case 'Contact Us': $('#contactUs').addClass('active'); break;
	
	case 'My Cart': $('#myCart').addClass('active'); break;
	
	case 'Home': $('#Home').addClass('active'); break;
	
	case 'Add Product': $('#addProduct').addClass('active'); break;
	case 'Add New Brand': $('#addCategory').addClass('active'); break;
	
	case 'My Account': $('#myAccount').addClass('active'); break;
	case 'Order Details': $('#orderDetails').addClass('active'); break;
	case 'Wish List': $('#wishList').addClass('active'); break;
	case 'Personal Information': $('#personalInfo').addClass('active'); break;
	case 'Change Password': $('#changePW').addClass('active'); break;
	case 'Manage Addresses': $('#manageAddress').addClass('active'); break;
	case 'Change Mobile Number': $('#changeMobNo').addClass('active'); break;
	
	
	default: System.out.println("default active");
	
	
	
	}
	
	
	
	
});