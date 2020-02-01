package com.example.mispubsrest.Controlador;

import com.example.mispubsrest.Dao.SesionDao;
import com.example.mispubsrest.Modelos.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class RESTControllerSesiones {

    //Inyección de dependencias para las sesiones
    @Autowired
    private SesionDao daoSesion;

    /**
     *              CRUD PARA LAS SESIONES
     * =======================================================
     */

    /**
     * Método para buscar una sesión por la id de usuario
     */
    @RequestMapping(value="sesiones/{id_usuario}", method = RequestMethod.GET)
    public ResponseEntity<Sesion> findByIdUsuario(@PathVariable("id_usuario") Integer id){
        Optional<Sesion> optionalSesion = daoSesion.findById_usuario(id);
        if (optionalSesion.isPresent()){
            return ResponseEntity.ok(optionalSesion.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Método para insertar una nueva sesión
     */
    @RequestMapping(value="sesiones/nueva", method = RequestMethod.POST)
    public ResponseEntity<Sesion> insertarSesion(@RequestBody Sesion sesion){
        Sesion s = daoSesion.save(sesion);
        return ResponseEntity.ok(s);
    }

    /**
     * Método para eliminar una sesión
     * @param id
     * @return
     */
    @RequestMapping(value="sesiones/cerrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Sesion> borrarSesion(@PathVariable("id") Integer id){
        //Buscamos por id primero
        Optional<Sesion> op = daoSesion.findById(id);
        if(op.isPresent()){
            Sesion s = op.get();
            daoSesion.deleteById(id);
            return ResponseEntity.ok(s);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
