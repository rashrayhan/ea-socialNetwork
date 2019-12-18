package edu.mum.ea.services.impl;

import edu.mum.ea.models.Claim;
import edu.mum.ea.models.FilthyWord;
import edu.mum.ea.models.User;
import edu.mum.ea.repos.ClaimRepository;
import edu.mum.ea.repos.FilthyRepository;
import edu.mum.ea.services.ClaimService;
import edu.mum.ea.services.FilthyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public Claim save(Claim claim) {
        return null;
    }

    @Override
    public Claim update(Claim claim) {
        return null;
    }

    @Override
    public boolean delete(Claim claim) {
        claimRepository.delete(claim);
        return true;
    }
    @Override
    public Claim findById(Long id) {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        return optionalClaim.orElse(null);
    }

    @Override
    public List<Claim> findAll() {
        return (List<Claim>) claimRepository.findAll();
    }
}
