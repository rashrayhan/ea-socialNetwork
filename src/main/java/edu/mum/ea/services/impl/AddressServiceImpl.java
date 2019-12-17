package edu.mum.ea.services.impl;

import edu.mum.ea.models.Address;
import edu.mum.ea.models.User;
import edu.mum.ea.repos.AddressRepository;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(Address address) {
         return false;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(new Address());
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepository.findAll();
    }
}
