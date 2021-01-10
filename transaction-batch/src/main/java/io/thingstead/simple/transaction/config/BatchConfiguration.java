package io.thingstead.simple.transaction.config;

import io.thingstead.simple.transaction.dao.Transaction;
import io.thingstead.simple.transaction.repository.TransactionRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private TransactionRepository repository;

  // tag::readerwriterprocessor[]
  @Bean
  public FlatFileItemReader<Transaction> reader() {
    return new FlatFileItemReaderBuilder<Transaction>()
        .linesToSkip(1)
        .name("transactionItemReader")
        .resource(new ClassPathResource("exported_transactions.csv"))
        .delimited()
        .names(new String[]{"date", "recordedAt", "scheduledFor", "amount", "activity", "pending",
            "rawDescription", "description", "categoryFolder", "category", "streetAddress", "city",
            "state", "zip", "latitude", "longitude", "memo"})
        .fieldSetMapper(new BeanWrapperFieldSetMapper<Transaction>() {{
          setTargetType(Transaction.class);
        }})
        .build();
  }

  @Bean
  public RepositoryItemWriter<Transaction> writer() {
    return new RepositoryItemWriterBuilder<Transaction>()
        .repository(repository)
        .methodName("save")
        .build();
  }
  // end::readerwriterprocessor[]

  // tag::jobstep[]
  @Bean
  public Job importTransactionJob(Step step1) {
    return jobBuilderFactory.get("importTransactionJob")
        .incrementer(new RunIdIncrementer())
        .flow(step1)
        .end()
        .build();
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1")
        .<Transaction, Transaction>chunk(10)
        .reader(reader())
        .writer(writer())
        .build();
  }
  // end::jobstep[]
}
