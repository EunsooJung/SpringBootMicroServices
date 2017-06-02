/**
 * 
 */
package com.ej.microservices;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Component
public class SampleDataCLR implements CommandLineRunner {
	
	private final AccountRepository accountRepository;
	
	@Autowired
	public SampleDataCLR(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		Stream.of("pwebb,boot", "dsyer,cloud", "jlong,spring", "rod,atomist")
        .map(x -> x.split(","))
        .forEach(tuple -> accountRepository.save(new Account(tuple[0], tuple[1], true)));

	}

}