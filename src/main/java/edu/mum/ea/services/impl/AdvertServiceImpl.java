package edu.mum.ea.services.impl;

import edu.mum.ea.Application;
import edu.mum.ea.models.Activity;
import edu.mum.ea.models.Advert;
import edu.mum.ea.models.Media;
import edu.mum.ea.models.MediaType;
import edu.mum.ea.repos.AdvertRepository;
import edu.mum.ea.services.AdvertService;
import edu.mum.ea.util.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@PreAuthorize("isAuthenticated()")
public class AdvertServiceImpl implements AdvertService {

    private AdvertRepository advertRepository;
    private ServletContext context;
    AppProperties appProperties;

    @Autowired
    public AdvertServiceImpl(AdvertRepository advertRepository, ServletContext context, AppProperties appProperties) {
        this.advertRepository = advertRepository;
        this.context = context;
        this.appProperties = appProperties;
    }

    @Secured("ROLE_ADVERTISE_PRIVILEGE")
    @Override
    public Advert save(Advert advert) {

        String picturePath = context.getRealPath("/") + appProperties.getPicture();
        String videoPath = context.getRealPath("/") + appProperties.getVideo();

        StringBuilder fileNames = new StringBuilder();

        try {
            advert.setActivityTime(LocalDateTime.now());
            advert = advertRepository.save(advert);

            //for pictures
            for (MultipartFile file: advert.getPictures()) {
                fileUploadHelper(advert, fileNames, file, new File(picturePath), MediaType.Image);
            }

            //for videos
            for (MultipartFile file: advert.getVideos()) {
                fileUploadHelper(advert, fileNames, file, new File(videoPath), MediaType.Video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advert;
    }


    @Secured("ROLE_ADVERTISE_PRIVILEGE")
    @Override
    public Advert update(Advert advert) {
        return null;
    }

    @Secured("ROLE_ADVERTISE_PRIVILEGE")
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
        return (List<Advert>) advertRepository.findAll();
    }

    public void fileUploadHelper(@ModelAttribute("advert") @Valid Advert advert, StringBuilder fileNames, MultipartFile file, File pictureUploadDirectory, MediaType image) {
        Media media = new Media();

        Path fileNamePath = Paths.get(pictureUploadDirectory.getPath(), file.getOriginalFilename());
        media.setFilePath(file.getOriginalFilename());
        media.setMediaType(image);
        media.setAdvert(advert);
        advert.getMediaList().add(media);

        fileNames.append(file.getOriginalFilename());

        try{
            Files.write(fileNamePath, file.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
