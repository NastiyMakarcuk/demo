package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }
    public Picture addPicture(NewPictureDto newPictureDto) {
        Picture user = new Picture(newPictureDto.getName(), newPictureDto.getDescription());
        return pictureRepository.save(user);
    }
    public Picture getPictureById(Long id) {
        return pictureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Picture not found"));
    }
    public Picture updatePictureById(Long id, NewPictureDto newUserDto) {

        Picture pictureFromDb = pictureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Picture not found"));

        Optional.ofNullable(newUserDto.getName()).ifPresent(pictureFromDb::setName);
        Optional.ofNullable(newUserDto.getDescription()).ifPresent(pictureFromDb::setDescription);

        return pictureRepository.save(pictureFromDb);
    }
    public void deletePictureById(Long id) {
        pictureRepository.deleteById(id);
    }
}
