/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.liyong.test.annotation.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.liyong.test.annotation.test.spring.TransactionTestUtils.assertInTransaction;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className 使用@Sql
 *@description 
 *@JunitTest: {@link  }
 *@date 10:26 PM 2020/8/6
 *       
**/

@RunWith(SpringRunner.class)
@ContextConfiguration
@DirtiesContext
public class InferredDataSourceTransactionalSqlScriptsTests {

	@Autowired
	private DataSource dataSource1;

	@Autowired
	private DataSource dataSource2;


	@Test
	@Transactional("txMgr1")
	//开始方法前执行sql
	@Sql(scripts = "classpath:/META-INF/jdbc/data-add-dogbert.sql", config = @SqlConfig(transactionManager = "txMgr1"))
	public void database1() {
		assertInTransaction(true);
		assertUsers(new JdbcTemplate(dataSource1), "Dilbert", "Dogbert");
	}

	@Test
	@Transactional("txMgr2")
	//开始方法前执行sql
	@Sql(scripts = "classpath:/META-INF/jdbc/data-add-catbert.sql", config = @SqlConfig(transactionManager = "txMgr2"))
	public void database2() {
		assertInTransaction(true);
		assertUsers(new JdbcTemplate(dataSource2), "Dilbert", "Catbert");
	}

	private void assertUsers(JdbcTemplate jdbcTemplate, String... users) {
		List<String> expected = Arrays.asList(users);
		Collections.sort(expected);
		List<String> actual = jdbcTemplate.queryForList("select name from user", String.class);
		Collections.sort(actual);
		assertEquals("Users in database;", expected, actual);
	}


	@Configuration
	static class Config {

		@Bean
		public PlatformTransactionManager txMgr1() {
			return new DataSourceTransactionManager(dataSource1());
		}

		@Bean
		public PlatformTransactionManager txMgr2() {
			return new DataSourceTransactionManager(dataSource2());
		}

		@Bean
		public DataSource dataSource1() {
			return new EmbeddedDatabaseBuilder()
			.setName("database1")
			.addScript("classpath:/META-INF/jdbc/schema.sql")
			.addScript("classpath:/META-INF/jdbc/data.sql")
			.build();
		}

		@Bean
		public DataSource dataSource2() {
			return new EmbeddedDatabaseBuilder()
			.setName("database2")
			.addScript("classpath:/META-INF/jdbc/schema.sql")
			.addScript("classpath:/META-INF/jdbc/data.sql")
			.build();
		}
	}

}
