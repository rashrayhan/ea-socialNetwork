package edu.mum.ea.services.impl;

import edu.mum.ea.models.Follow;
import edu.mum.ea.repos.FollowRepository;
import edu.mum.ea.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FollowServiceImpl implements FollowService {

    private FollowRepository followRepository;

    @Autowired
    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public Object save(Object object) {
        Follow follow = (Follow) object;
        return followRepository.save(follow);
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
