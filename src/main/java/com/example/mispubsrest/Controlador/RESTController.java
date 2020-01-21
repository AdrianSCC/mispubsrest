package com.example.mispubsrest.Controlador;


import com.example.mispubsrest.Dao.PubDao;
import com.example.mispubsrest.Modelos.Pub;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RESTController {

    @Autowired
    private PubDao daoPub;

    @RequestMapping(value = "hola", method = RequestMethod.GET)
    public String hola(){
        return "Hola, todo ok";
    }

    /**
     *              CRUD PARA LOS PUBS
     * ========================================
     */


    /**
     * Método para insertar un pub
     */
    @RequestMapping(value="pubs",method=RequestMethod.POST)
    public ResponseEntity<Pub> insertarPub(@RequestBody Pub pub){
        Pub p = daoPub.save(pub);
        return ResponseEntity.ok(p);
    }

}
