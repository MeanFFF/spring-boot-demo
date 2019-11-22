package com.springboot.demo.transactional.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Component
public class MyTransactional {
    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

    public MyTransactional(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    public TransactionStatus begin() {
        System.out.println("begin transactional");
        return dataSourceTransactionManager.getTransaction(transactionDefinition);
    }

    public void commit(TransactionStatus transactionStatus) {
        System.out.println("commit transactional");
        dataSourceTransactionManager.commit(transactionStatus);
    }

    public void rollback(TransactionStatus transactionStatus) {
        System.out.println("rollback transactional");
        dataSourceTransactionManager.rollback(transactionStatus);
    }
}
