package ltts.com.controller;
import ltts.com.model.Excel;
import ltts.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
 
@RestController

@CrossOrigin(origins="http://localhost:5173", allowedHeaders="*")
public class AppController {
 
    @Autowired
    private UserService service;
 
   @PostMapping(value="/upload",consumes="application/json")
    public String UploadExcel(@RequestBody Map<String,List<Excel>> payload) {
    	List<Excel> excelList=payload.get("data");
    	if(service.uploadExcel(excelList)) {
    		return "uploaded successfully";
    	}
    	return "not uploaded";
   		
   	
    	
   }

   @GetMapping("/get/{id}")
   public Excel showEmp(@PathVariable("id")int id){
   	return service.showEmp(id);
   	
   }
               

    @GetMapping("/show")
    public List<Excel> showAllExcel(){
    	return service.showAllExcel();
    	
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
		if(service.deleteById(id))
			return "deleted successfully" ;
		return "failed to delete";
    	
    }

    @PutMapping("/excel/update")
	 public String updateData(@RequestBody Excel excel) {
		 System.out.println(excel);
		 if(service.updateExcel(excel.getId(), excel.getName(), excel.getMobileno(), excel.getEmailid()))
			 return "Updated Successfully";
		 return "NO data exist to fetch";
	 }

  
}