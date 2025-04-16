package me.dio.service;

import java.util.List;

import me.dio.domain.model.Account;

public interface AccountService {
    List<Account> findAll();
    Account findById(Long id);
    Account create(Account account);
    Account update(Long id, Account account);
    void delete(Long id);
} 