package io.thingstead.simple.transaction.repository;

import io.thingstead.simple.transaction.dao.Transaction;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

  Iterable<Transaction> findAllByCategoryOrDescriptionOrRawDescriptionContainingIgnoreCase(
      String category, String description, String rawDescription);
}
