package com.cscoach.SpringDemo;

import com.cscoach.SpringDemo.dao.PersonDAO;
import com.cscoach.SpringDemo.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonDAO pdao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      logger.info("data for id = 100 is {}",pdao.findById(100));
      logger.info("insert data :: {}",pdao.insertData(new Person("justin","italy",new Date())));
      Person p = new Person("jenny","texas",new Date());
      p.setId(100);
      logger.info("update data :: {}",pdao.updateData(p));
      logger.info("find all :; {}",pdao.findAllPersons());
      pdao.deleteData(100);
      logger.info("after delete id = 100 :: currerntRecords = {}",pdao.findAllPersons().size());
      logger.info("insert data using persist");
      pdao.insertOrUpdateDataUSingPersistOrMerge(new Person("jeff","russia",new Date()));
      logger.info("update using merge");
      Person person = pdao.findById(1);
      person.setName("rohan");
      pdao.insertOrUpdateDataUSingPersistOrMerge(person);
      logger.info("entity manager internal working : ");
      pdao.entityManagerWorking();
      logger.info("native query select => {}",pdao.nativeQueryForSelect(1));
      logger.info("native query update => {}",pdao.nativeQueryForUpdate());
	}
}
