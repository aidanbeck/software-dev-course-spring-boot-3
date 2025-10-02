package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping
    public List<Album> getAllItems() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Album getItem( @PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Album addItem( @RequestBody Album album ) {
        return albumRepository.save(album);
    }

    @PutMapping("/{id}")
    public Album updateItem( @PathVariable int id, @RequestBody Album album) {
        album.setId(id);
        return albumRepository.save(album);
    }

    @DeleteMapping("/{id}")
    public Album deleteItem( @PathVariable int id ) {
        Album reportAlbum = albumRepository.findById(id).orElse(null);
        albumRepository.deleteById(id);
        return reportAlbum;
    }

}
