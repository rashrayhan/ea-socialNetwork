package edu.mum.ea.services.imp;

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
    public Follow save(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public Follow update(Follow follow) {
        return null;
    }

    @Override
    public boolean delete(Follow follow) {
        return false;
    }

    @Override
    public Follow findById(Long id) {
        return null;
    }

    @Override
    public List<Follow> findAll() {
        return null;
    }
}
