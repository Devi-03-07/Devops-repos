package ltts.com.jpa;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ltts.com.model.Excel;

@Repository
public interface MyJPARepository extends CrudRepository<Excel,Integer>  {

@Modifying
@Query( "delete Excel e  where e.id=:id" )
int deleteById(@Param("id")int id);

@Modifying
@Query("update Excel e set e.name=:name,e.mobileno=:mobileno,e.emailid=:emailid where e.id=:id")
int updateDataById(@Param("id") int id,@Param("name") String name,@Param("mobileno") long mobileno,@Param("emailid") String emailid);

Excel findById(int id);




	
}
