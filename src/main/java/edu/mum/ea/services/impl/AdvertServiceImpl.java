package edu.mum.ea.services.impl;

import edu.mum.ea.models.Advert;
import edu.mum.ea.repos.AdvertRepository;
import edu.mum.ea.services.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
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
    public Object save(Object object) {
        Advert advert = (Advert) object;
        try {
            advert.setActivityTime(LocalDateTime.now());
            advert = advertRepository.save(advert);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advert;
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
