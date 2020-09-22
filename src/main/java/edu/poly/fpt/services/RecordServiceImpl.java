package edu.poly.fpt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.poly.fpt.models.Record;
import edu.poly.fpt.models.Staff;
import edu.poly.fpt.repositories.RecordRepository;
import edu.poly.fpt.repositories.StaffRepository;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private StaffRepository staffRepository;


	@Override
	public List<Record> findByReasonLikeOrderByReason(String reason) {
		return recordRepository.findByReasonLikeOrderByReason(reason);
	}

	
	@Override
	public Record save(Record entity) {
		return recordRepository.save(entity);
	}

	@Override
	public List<Record> saveAll(Iterable<Record> entities) {
		return (List<Record>)recordRepository.saveAll(entities);
	}

	
	@Override
	public Optional<Record> findById(Integer id) {
		return recordRepository.findById(id);
	}

	
	@Override
	public boolean existsById(Integer id) {
		return recordRepository.existsById(id);
	}


	@Override
	public Iterable<Record> findAll() {
		return recordRepository.findAll();
	}


	@Override
	public Iterable<Record> findAllById(Iterable<Integer> ids) {
		return recordRepository.findAllById(ids);
	}


	@Override
	public long count() {
		return recordRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		recordRepository.deleteById(id);
	}

	
	@Override
	public void delete(Record entity) {
		recordRepository.delete(entity);
	}

	
	@Override
	public void deleteAll(List<Record> entities) {
		recordRepository.deleteAll(entities);
	}


	@Override
	public void deleteAll() {
		recordRepository.deleteAll();
	}



	@Override
	public List<Staff> findAllStaffs() {
		return (List<Staff>)staffRepository.findAll();
	}

}
