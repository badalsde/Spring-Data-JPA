package com.jpql.repository;

public interface AccountRepository {
    public Double getAverageBalance() ;
    public Long getTotalBalance();
    public Long getNumberOfAccounts() ;
    public Integer getMinimumBalance() ;
    public Integer getMaximumBalance() ;
}
