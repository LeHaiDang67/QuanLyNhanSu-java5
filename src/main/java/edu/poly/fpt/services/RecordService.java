package edu.poly.fpt.services;

import java.util.List;
import java.util.Optional;

import edu.poly.fpt.models.Record;
import edu.poly.fpt.models.Staff;

public interface RecordService {


	void deleteAll();

	void deleteAll(List<Record> entities);

	void delete(Record entity);

	void deleteById(Integer id);

	long count();

	Iterable<Record> findAllById(Iterable<Integer> ids);

	Iterable<Record> findAll();

	boolean existsById(Integer id);

	Optional<Record> findById(Integer id);

	List<Record> saveAll(Iterable<Record> entities);

	Record save(Record entity);

	List<Record> findByReasonLikeOrderByReason(String reason);

	List<Staff> findAllStaffs();



}
