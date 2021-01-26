package com.myproject.Api;

import com.myproject.entity.Kisi;
import com.myproject.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

//hangi field gerekliyse onun constructionu eklesin
@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {
    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setAd("mustafa");
        kisi.setSoyad("dal");
        kisi.setAdres("Istanbul");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("T001");
        kisiRepository.save(kisi);

    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search, search);
        return ResponseEntity.ok(kisiler);
    }

}
