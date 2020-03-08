package com.kl.usersystem.serrvices;

import com.kl.usersystem.domain.entities.Picture;
import com.kl.usersystem.repositories.PictureRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }


    @Override
    public void persistPicture(Picture picture) {
        this.pictureRepository.saveAndFlush(picture);
    }
}
