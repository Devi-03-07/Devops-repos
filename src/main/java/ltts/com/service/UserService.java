package ltts.com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ltts.com.model.Excel;

public interface UserService {



	public boolean uploadExcel(Excel excel);
	public List<Excel> showAllExcel();
	public boolean deleteById(int id);
	public boolean saveExcelList(List<Excel> excelList);
	public boolean uploadExcel(List<Excel> excelList);
	public boolean updateExcel(int id, String name, long mobileno,String emailid);
	public Excel showEmp(int id);
	
	


}
