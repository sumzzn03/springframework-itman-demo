package org.liyong.dataaccess.service.listener;

import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className MyTransactionListener
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-08-27 23:15    
 *
 *
**/
public class MyTransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void hanldeOrderCreatedEvent(MyTransactionEvent event) {

        LOGGER.info("第一种事件监听 start");
        // do transaction event
        LOGGER.info("event : " + event.getName());
    }

}
