package com.example.shipper.service;

import com.example.shipper.repository.VoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VoteService {
    @Autowired
    VoteRepository voteRepository;
}
