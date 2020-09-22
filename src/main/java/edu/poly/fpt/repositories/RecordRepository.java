package edu.poly.fpt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.fpt.models.Record;
@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
	List<Record> findByReasonLikeOrderByReason(String reason);
	
}
