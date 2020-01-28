package com.example.mispubsrest.Controlador;

import com.example.mispubsrest.Dao.ValoracionDao;
import com.example.mispubsrest.Modelos.Valoracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RESTControllerValoraciones {

    //Inyección de dependencias para las valoraciones
    @Autowired
    private ValoracionDao daoValoracion;

    /**
     * CRUD PARA LAS VALORACIONES
     */

    /**
     * Método para listar todas las valoraciones de un pub
     */
    @RequestMapping(value="valoraciones/{idpub}", method = RequestMethod.GET)
    public ResponseEntity <List<Valoracion>> findValoracionesPub(@PathVariable("idpub") Integer idpub){
        List<Valoracion> listaValoraciones = daoValoracion.findByIdpub(idpub);
        if (listaValoraciones.size() == 0){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listaValoraciones);
        }
    }

    /**
     * Método para insertar una valoración
     */
    @RequestMapping(value="valoraciones", method = RequestMethod.POST)
    public ResponseEntity<Valoracion> insertarValoracion(@RequestBody Valoracion valoracion){
        Valoracion v = daoValoracion.save(valoracion);
        return ResponseEntity.ok(v);
    }
}
