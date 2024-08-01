package ltts.com.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ltts.com.dao.UserDAO;
import ltts.com.model.Excel;


@Service
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserDAO userDao;

	@Override
	public boolean uploadExcel(Excel excel) {
		return userDao.UploadExcel(excel);
	}

	@Override
	public List<Excel> showAllExcel() {
		return userDao.showAllExcel();
	}

	@Override
	public boolean deleteById(int id) {
		
		return userDao.deleteById(id);
	
	}

	public boolean uploadExcel(List<Excel> excelList) {
		return userDao.UploadExcel(excelList);
	}

	@Override
	public boolean saveExcelList(List<Excel> excelList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateExcel(int id, String name, long mobileno, String emailid) {
		return userDao.updateExcel(id, name, mobileno, emailid);
	}

	public Excel showEmp(int id) {
		return userDao.showEmp(id);
	}


	
		
	}

	


	
	
	

