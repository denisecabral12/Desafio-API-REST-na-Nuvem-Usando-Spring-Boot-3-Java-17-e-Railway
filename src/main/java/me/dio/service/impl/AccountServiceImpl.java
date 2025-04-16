package me.dio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Account;
import me.dio.domain.repository.AccountRepository;
import me.dio.service.AccountService;
import me.dio.service.exception.NotFoundException;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Account not found with ID: " + id));
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, Account account) {
        if (!accountRepository.existsById(id)) {
            throw new NotFoundException("Account not found with ID: " + id);
        }
        account.setId(id);
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new NotFoundException("Account not found with ID: " + id);
        }
        accountRepository.deleteById(id);
    }
} 