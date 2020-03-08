package com.kl.usersystem.serrvices;

import com.kl.usersystem.domain.entities.Album;
import com.kl.usersystem.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void persistAlbum(Album album) {
        this.albumRepository.saveAndFlush(album);
    }
}
