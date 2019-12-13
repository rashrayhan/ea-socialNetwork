package edu.mum.ea.services.impl;

import edu.mum.ea.models.Advert;
import edu.mum.ea.repos.AdvertRepository;
import edu.mum.ea.services.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdvertServiceImpl implements AdvertService {

    private AdvertRepository advertRepository;

    @Autowired
    public AdvertServiceImpl(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @Override
    public Advert save(Advert advert) {
        return advertRepository.save(advert);
    }

    @Override
    public Advert update(Advert advert) {
        return null;
    }

    @Override
    public boolean delete(Advert advert) {
        return false;
    }

    @Override
    public Advert findById(Long id) {
        return null;
    }

    @Override
    public List<Advert> findAll() {
        return null;
    }
}
