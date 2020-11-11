package pl.morg.pracadomowatydzien5.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.morg.pracadomowatydzien5.model.Animes;
import pl.morg.pracadomowatydzien5.model.Picture;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Controller
public class AnimeController {

    @EventListener(ApplicationReadyEvent.class)
    private List<String> getAnimeImages() {
        RestTemplate restTemplate = new RestTemplate();
        String path = "https://api.jikan.moe/v3/anime/" + generateRandomInt() + "/pictures";
        Animes animes = restTemplate.getForObject(path, Animes.class);
        List<Picture> animePictures = Objects.requireNonNull(animes).getPictures();
        return animePictures.stream()
                .map(Picture::getSmall)
                .collect(Collectors.toList());
    }

    @GetMapping("/anime-images")
    public String get(Model model) {
        model.addAttribute("animeImages", getAnimeImages());
        return "animeView";
    }

    private int generateRandomInt() {
        return ThreadLocalRandom.current().nextInt(5, 8);
    }
}
