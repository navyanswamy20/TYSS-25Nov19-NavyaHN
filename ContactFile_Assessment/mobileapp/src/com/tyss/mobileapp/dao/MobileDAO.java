package com.tyss.mobileapp.dao;

import java.util.List;

import com.tyss.mobileapp.dto.MobileBean;

public interface MobileDAO {
	public List<MobileBean> getAllContacts();

	public MobileBean showOneDetail(String name);

	//public void operateContact();
}



















