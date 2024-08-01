package ltts.com.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ltts.com.model.Excel;

public interface UserDAO {

	public boolean UploadExcel(Excel excel);
	public List<Excel> showAllExcel();
	public boolean deleteById(int id );
	public boolean UploadExcel(List<Excel> excelList);
	public boolean updateExcel(int id, String name, long mobileno,String emailid);
	public Excel showEmp(int id);
	

}
