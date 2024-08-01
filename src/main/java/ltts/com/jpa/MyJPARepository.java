package ltts.com.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ltts.com.model.Registration;

@Repository
public interface MyJPARepository extends CrudRepository<Registration,String>{
	
	@Modifying
	@Query("update Registration r set r.mobile_no=:mobile_no,r.password=:password where r.email=:email")
	int updateDataByEmail(@Param("email") String email,@Param("mobile_no") long mobile_no,@Param("password") String password);



}
