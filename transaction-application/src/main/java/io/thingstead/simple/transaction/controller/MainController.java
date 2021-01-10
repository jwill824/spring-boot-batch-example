package io.thingstead.simple.transaction.controller;

import io.thingstead.simple.transaction.dao.Transaction;
import io.thingstead.simple.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/transactions")
@RestController
public class MainController {

  @Autowired
  private TransactionRepository repository;

  @RequestMapping
  public @ResponseBody
  Iterable<Transaction> getAllTransactions() {
    return repository.findAll();
  }

  @RequestMapping(path = "/search")
  public @ResponseBody
  Iterable<Transaction> getAllTransactionsByCategoryOrDescription(
      @RequestParam(value = "category", required = false) String category,
      @RequestParam(value = "description") String description) {
    return repository
        .findAllByCategoryOrDescriptionOrRawDescriptionContainingIgnoreCase(category, description,
            description);
  }
}