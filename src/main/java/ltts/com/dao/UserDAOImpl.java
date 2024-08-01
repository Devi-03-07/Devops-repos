package ltts.com.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import ltts.com.jpa.MyJPARepository;

import ltts.com.model.Excel;

@Repository
public class UserDAOImpl implements UserDAO  {
	@Autowired
	private MyJPARepository myRepo;

	@Override
	public boolean UploadExcel(Excel excel) {
		if(myRepo.save(excel)!=null)
			return true;
		return false;
	}
	public List<Excel> showAllExcel(){
		return (List<Excel>)myRepo.findAll();
	}
	@Override
	@Transactional
	public boolean deleteById(int id) {
		
		return (myRepo.deleteById(id)>0) ;
	}
	public boolean UploadExcel(List<Excel> excelList) {
		if((myRepo.saveAll(excelList))!=null){
			return true;
		}
		return false;
	}

	public Excel showEmp(int id) {
		return myRepo.findById(id);
	}
	@Override
	@Transactional
	public boolean updateExcel(int id, String name, long mobileno,String emailid) {
		
		if(myRepo.updateDataById(id, name, mobileno, emailid)>0)
			return true;
		return false;
	}
	

	

   
	

}
