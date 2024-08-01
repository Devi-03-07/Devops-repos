package ltts.com.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ltts.com.model.Booking;

@Repository
public interface MyJPABookingRepository extends CrudRepository<Booking,Integer>{

	@Modifying
	@Query("update Booking b set b.status=:status where b.bid=:bid")
	int updateDataById(@Param("bid") int bid,@Param("status") String status);

}
