/**
 * 
 */
package com.ej.microservices.car_with_mysql;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author eunsoojung
 *
 */
@Repository
public class CarModelWithMySQLRepository {
	
	private final JdbcTemplate jdbc;
	
	public CarModelWithMySQLRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<CarModelWithMySQL> findByMakeIgnoringCase(String make) {
		return this.jdbc.query(
				"select * from car " + "where UPPER(car.make) = UPPER(?) order by id",
				(rs, i) -> new CarModelWithMySQL(rs.getInt("id"), rs.getString("make"),
						rs.getString("model"), rs.getInt("year")),
				make);		
	}

}
