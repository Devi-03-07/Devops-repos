package ltts.com.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ltts.com.model.Event;

@Repository
public interface MyJPAEventRepository extends CrudRepository<Event,Integer> {
	
	@Modifying
	@Query("update Event e set e.details=:details,e.location=:location,e.price=:price where e.eid=:eid")
	int updateDataById(@Param("eid") int eid,@Param("details") String details,@Param("location") String location,@Param("price") double price);
	
	List<Event> findByLocation(String location);

	List<Event> findByCategoryContaining(String category);

	List<Event> findByTitleContaining(String title);
	
	int deleteByEid(int eid);

}
