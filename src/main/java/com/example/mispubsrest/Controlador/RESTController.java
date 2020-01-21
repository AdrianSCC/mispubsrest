package com.example.mispubsrest.Controlador;


import com.example.mispubsrest.Dao.PubDao;
import com.example.mispubsrest.Modelos.Pub;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RESTController {

    @Autowired
    private PubDao daoPub;

    @RequestMapping(value = "hola", method = RequestMethod.GET)
    public String hola() {
        return "Hola, todo ok";
    }

    /**
     *              CRUD PARA LOS PUBS
     * ========================================
     */


    /**
     * Método para insertar un pub
     */
    @RequestMapping(value = "pubs", method = RequestMethod.POST)
    public ResponseEntity<Pub> insertarPub(@RequestBody Pub pub) {
        Pub p = daoPub.save(pub);
        System.out.println("p");
        return ResponseEntity.ok(p);
    }

    /**
     * Método para devolver todos los pubs
     * @return
     */
    @RequestMapping(value = "pubs", method = RequestMethod.GET)
    public ResponseEntity<List<Pub>> findAll() {
        List<Pub> lista = daoPub.findAll();
        return ResponseEntity.ok(lista);
    }

    /**
     * Metodo para modificar un pub
     * @param id
     * @param pub
     * @return
     */
    @RequestMapping(value = "pubs", method = RequestMethod.PUT)
    public ResponseEntity<Pub> update(@PathVariable("id") Integer id, @RequestBody Pub pub){
        Optional<Pub> optionalPub = daoPub.findById(id);
        if (optionalPub.isPresent()){
            Pub p = optionalPub.get();
            p.setNombre(pub.getNombre());
            p.setLatitud(pub.getLatitud());
            p.setLongitud(pub.getLongitud());
            p.setEstilo(pub.getEstilo());
            p.setVisitas(pub.getVisitas());
            p.setWeb(pub.getWeb());
            daoPub.save(p);
            return ResponseEntity.ok(p);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
}
