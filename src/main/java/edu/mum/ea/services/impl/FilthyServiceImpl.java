package edu.mum.ea.services.impl;

import edu.mum.ea.models.*;
import edu.mum.ea.repos.AdvertRepository;
import edu.mum.ea.repos.FilthyRepository;
import edu.mum.ea.services.AdvertService;
import edu.mum.ea.services.FilthyService;
import edu.mum.ea.util.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilthyServiceImpl implements FilthyService {

    @Autowired
    private FilthyRepository filthyRepository;

    @Override
    public FilthyWord save(FilthyWord filthyWord) {
        return filthyRepository.save(filthyWord);
    }

    @Override
    public FilthyWord update(FilthyWord filthyWord) {
        return null;
    }

    @Override
    public boolean delete(FilthyWord filthyWord) {
        filthyRepository.delete(filthyWord);
        return true;
    }

    @Override
    public FilthyWord findById(Long id) {
        Optional<FilthyWord> optionalFilthyWord = filthyRepository.findById(id);
        return optionalFilthyWord.orElse(null);
    }

    @Override
    public List<FilthyWord> findAll() {
        return (List<FilthyWord>) filthyRepository.findAll();
    }

}
