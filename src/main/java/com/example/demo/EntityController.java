package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EntityController {
    private final PictureService pictureService;

    public EntityController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/{userId}")
    public Picture getPictureById(@PathVariable Long pictureId) {
        return pictureService.getPictureById(pictureId);
    }
    @GetMapping
    public List<Picture> getAllPictures() {
        return pictureService.getAllPictures();
    }
    @PostMapping("/user")
    public Picture addPicture(@RequestBody NewPictureDto newPictureDto) {
        return pictureService.addPicture(newPictureDto);
    }
    @PatchMapping("/{userId}")
    public Picture updatePictureById (@RequestBody NewPictureDto newPictureDto, @PathVariable Long pictureId) {
        return pictureService.updatePictureById(pictureId, newPictureDto);
    }
    @DeleteMapping("/{userId}")
    public void deletePictureById (@PathVariable Long pictureId) {
        pictureService.deletePictureById(pictureId);
    }
}
