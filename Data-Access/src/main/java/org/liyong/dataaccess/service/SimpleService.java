package org.liyong.dataaccess.service;

import org.liyong.dataaccess.entity.Foo;
import org.liyong.dataaccess.service.listener.MyTransactionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SimpleService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-27 21:52    
 *
 *
**/
public class SimpleService implements Service, ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;


    private final TransactionTemplate transactionTemplate;

    private JdbcTemplate jdbcTemplate;

    public SimpleService(PlatformTransactionManager transactionManager,JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        this.transactionTemplate = new TransactionTemplate(transactionManager);

        // the transaction settings can be set here explicitly if so desired
        this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        this.transactionTemplate.setTimeout(30); // 30 seconds
        // and so forth...

    }


    @Override
    public Object someServiceMethod(Foo foo) {
        return transactionTemplate.execute(new TransactionCallback() {
            //以下代码运行在事物上下文中
            @Override
            public Object doInTransaction(TransactionStatus status) {

                //第一种：发布事件
                applicationEventPublisher.publishEvent(new MyTransactionEvent("someServiceMethod",this));
                //第二种：注册事物处理器
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        System.out.println("第二种事件监听");
                    }
                });

                updateOperation1(foo);
                return query(foo);
            }
        });
    }

    @Override
    public void updateOperation1(Foo foo) {

        jdbcTemplate.update("insert into stock(name,age) values (?, ?)",foo.getFooName(),foo.getAge());

    }

    @Override
    public Foo query(Foo foo) {
       return jdbcTemplate.queryForObject("select * from stock where name = '" + foo.getFooName() + "'", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new Foo(foo.getBarName(),rs.getString(2),rs.getInt(1));

            }
        });

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
