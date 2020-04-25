package com.crowdfunding.dp.backend.service;

import com.crowdfunding.dp.backend.dao.ProjectRepository;
import com.crowdfunding.dp.backend.dao.TransactionRepository;
import com.crowdfunding.dp.backend.dao.UserRepository;
import com.crowdfunding.dp.backend.model.Project;
import com.crowdfunding.dp.backend.model.Transaction;
import com.crowdfunding.dp.backend.rest.dto.ContributionData;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {

    private TransactionRepository transactionRepository;

    private UserRepository userRepository;

    private ProjectRepository projectRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              UserRepository userRepository,
                              ProjectRepository projectRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList =  transactionRepository.findAll();
        transactionList.sort(Comparator.comparing(Transaction::getTransactiondate));
        return transactionList;
    }

    public List<Transaction> getTransactionsForProject(Long projectId) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        List<Transaction> transactionList = transactionRepository.findByProject(projectOpt.get());
        transactionList.sort(Comparator.comparing(Transaction::getTransactiondate));
        return transactionList;
    }

    public List<Transaction> contributeToProject(Long projectId, ContributionData contributionData) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isPresent()) {
            Transaction transaction = new Transaction();
            transaction.setProject(projectOpt.get());
            transaction.setSum(contributionData.getSum());
            transaction.setTransactiondate(LocalDateTime.now());
            if (contributionData.getUserLogin() != null) {
                transaction.setDoneBy(userRepository.findUserByLoginEquals(contributionData.getUserLogin()));
            }
            transactionRepository.save(transaction);
            return transactionRepository.findByProject(projectOpt.get());
        }
        return null;
    }
}
