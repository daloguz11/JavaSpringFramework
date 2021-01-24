package com.myproject.api;

import com.myproject.entitiy.Kullanici;
import com.myproject.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init(){
        HashMap<String , String> hmap = new HashMap<String, String>();
        hmap.put("City","İstanbul");
        hmap.put("boy","190");
        Kullanici kullanici=new Kullanici();
        kullanici.setName("oğuzhan");
        kullanici.setLastName("dal");
        kullanici.setProperties(hmap);
        kullaniciRepository.save(kullanici);
    }
    //POST metodu ise URL’de görüntülenmesi istemediğimiz istekler için kullanılır.
    // Gönderilen bilgiler URL’de görünmediği için daha güvenlidir ancak GET methoduna göre daha yavaştır.
    @PostMapping
    public ResponseEntity<Kullanici> Add(@RequestBody Kullanici kullanici) {
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    //GET methodu kullanıldığında istekler URL kısmında gönderilir.
    // Gönderilen bilgiler URL’de görüntülendiği için güvenlik riski yüksektir
    @GetMapping
    public ResponseEntity<List<Kullanici>> ShowAll() {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }
}
