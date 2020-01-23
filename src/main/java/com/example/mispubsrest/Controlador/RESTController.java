package com.example.mispubsrest.Controlador;


import com.example.mispubsrest.Dao.PubDao;
import com.example.mispubsrest.Modelos.Pub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RESTController {

    //Inyección de dependencias para los pub
    @Autowired
    private PubDao daoPub;



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
    public ResponseEntity<List<Pub>> findAllPubs() {
        List<Pub> lista = daoPub.findAll();
        return ResponseEntity.ok(lista);
    }

    /**
     * Método para seleccionar un pub buscando por su id
     * @param id
     * @return
     */
    @RequestMapping(value ="pubs/{id}",method = RequestMethod.GET)
    public ResponseEntity<Pub> findById(@PathVariable("id") Integer id){
        Optional<Pub> optionalPub = daoPub.findById(id);
        if (optionalPub.isPresent()){
            return ResponseEntity.ok(optionalPub.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

     /**
     * Metodo para modificar un pub
     * @param id
     * @param pub
     * @return
     */
    @RequestMapping(value = "pubs/{id}", method = RequestMethod.PUT)
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
            p.setImagen(pub.getImagen());
            daoPub.save(p);
            return ResponseEntity.ok(p);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Metodo para borrar un pub
     * @param id
     * @return
     */
    @RequestMapping(value = "pubs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pub> borrar(@PathVariable("id") Integer id) {
        //Buscamos por id
        Optional<Pub> op = daoPub.findById(id);
        //Si lo encontramos, lo borramos y lo devolvemos
        if (op.isPresent()) {
            //Guardamos en un objeto auxiliar
            Pub p = op.get();
            //Borramos de la BBDD
            daoPub.deleteById(id);
            return ResponseEntity.ok(p);
        } else {
            //El pub no está en la BBDD
            return ResponseEntity.noContent().build();
        }
    }
}
