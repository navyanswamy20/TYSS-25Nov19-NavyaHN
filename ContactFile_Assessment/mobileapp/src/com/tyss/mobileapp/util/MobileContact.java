package com.tyss.mobileapp.util;

import com.tyss.mobileapp.dao.MobileDAO;
import com.tyss.mobileapp.dao.MobileDAOImpl;

public class MobileContact {
	private MobileContact() {

	}

	public static MobileDAO getMobileDAO() {
		return new MobileDAOImpl();
	}

}
