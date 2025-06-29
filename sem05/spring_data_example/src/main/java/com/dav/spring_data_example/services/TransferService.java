package com.dav.spring_data_example.services;

import com.dav.spring_data_example.exception.AccountNotFoundException;
import com.dav.spring_data_example.model.Account;
import com.dav.spring_data_example.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(()-> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(()-> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiveNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiveNewAmount);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
