$(function() {
	
	switch(menu) {
	
	case 'Sign Up':
		$('#signup').addClass('active'); break;
		
	case 'login': $('#login').addClass('active'); break;
	
	case 'All Products': $('#productList').addClass('active'); break;
	
	case 'Admins Products': $('#adminsProducts').addClass('active'); break;
	
	case 'About Us': $('#aboutUs').addClass('active'); break;
	
	case 'Contact Us': $('#contactUs').addClass('active'); break;
	
	case 'My Cart': $('#myCart').addClass('active'); break;
	
	case 'Home': $('#Home').addClass('active'); break;
	
	case 'Add Product': $('#addProduct').addClass('active'); break;
	case 'Add New Brand': $('#addCategory').addClass('active'); break;
	case 'Add supplier': $('#addSupplier').addClass('active'); break;
	
	case 'My Account': $('#myAccount').addClass('active'); break;
	case 'Order Details': $('#orderDetails').addClass('active'); break;
	case 'Wish List': $('#wishList').addClass('active'); break;
	case 'Personal Information': $('#personalInfo').addClass('active'); break;
	case 'Change Password': $('#changePW').addClass('active'); break;
	case 'Billing Address': $('#billingAddress').addClass('active'); break;
	case 'Manage Addresses': $('#manageAddress').addClass('active'); break;
	case 'Change Mobile Number': $('#changeMobNo').addClass('active'); break;
	
	
	default: $('#productList').addClass('active'); 
			$('#a_'+menu).addClass('active');
			break;
	
	
	
	}
	
	
	
	
});