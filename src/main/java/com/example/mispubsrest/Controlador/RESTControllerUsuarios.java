package com.example.mispubsrest.Controlador;

import com.example.mispubsrest.Dao.UsuarioDao;
import com.example.mispubsrest.Modelos.Pub;
import com.example.mispubsrest.Modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RESTControllerUsuarios {

    //Inyección de dependencias para los usuarios
    @Autowired
    private UsuarioDao daoUsuario;

    /**
     *              CRUD PARA LOS USUARIOS
     * ========================================
     */

    /**
     * Método para insertar un pub Primero el servicio se asegura de
     * que no exita un usuario con el mismo correo almacenado en la base
     * de datos
     */

    @RequestMapping(value="usuarios",method = RequestMethod.POST)
    public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario){
        Optional<Usuario> optionalUsuario = daoUsuario.findByCorreo(usuario.getCorreo());
        if(optionalUsuario.isPresent()){
            return ResponseEntity.noContent().build();
        }else{
            Usuario u = daoUsuario.save(usuario);
            return ResponseEntity.ok(u);
        }
    }

    /**
     * Método para buscar un usuario por correo y contraseña. Lo utilizaremos para el login
     * https://stackoverflow.com/questions/32796419/crudrepository-findby-method-signature-with-multiple-in-operators
     * //List<Course> findByCourseIdAndModuleId(Long courseId, List<Long> moduleIds);
     */
    @RequestMapping(value="usuarios/{correo}/{password}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> buscarPorCorreoPass(@PathVariable("correo") String correo, @PathVariable("password") String password){
        Optional<Usuario> optionalUsuario = daoUsuario.findByCorreoAndPassword(correo,password);
        if (optionalUsuario.isPresent()){
            System.out.println("correcto");
            return ResponseEntity.ok(optionalUsuario.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Método para buscar un usuario por su nombre de usuario. Lo utilizaremos
     * para que en el momento de registro no se deje insertar a un usuario cuyo
     * nombre de usuario ya exista en nuestra BBDD
     */

    @RequestMapping (value="usuarios/registro/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> buscarPorNombreUsuario(@PathVariable("nombre") String nombre){
        Optional<Usuario> optionalUsuario = daoUsuario.findByNombre(nombre);
        if (optionalUsuario.isPresent()){
            optionalUsuario.get().setPassword(null);
            return ResponseEntity.ok(optionalUsuario.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Método para listar todos los usuarios
     * @return
     */
    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAllUsuarios() {
        List<Usuario> listaUsuario = daoUsuario.findAll();
        System.out.println("correcto");
        return ResponseEntity.ok(listaUsuario);
    }

    /**
     * Método para buscar un usuario por ID
     * @param id
     * @return
     */
    @RequestMapping(value = "usuarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByIdUsuarios(@PathVariable("id") Integer id) {
        Optional<Usuario> optionalUsuario = daoUsuario.findById(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Metodo para borrar un usuario recibiendo su id
     * @param id
     * @return
     */
    @RequestMapping(value = "usuarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> borrarUsuario(@PathVariable("id") Integer id) {
        //Buscamos por id
        Optional<Usuario> optionalUsuario = daoUsuario.findById(id);
        //Si lo encontramos, lo borramos y lo devolvemos
        if (optionalUsuario.isPresent()) {
            //Guardamos en un objeto auxiliar
            Usuario u = optionalUsuario.get();
            //Borramos de la BBDD
            daoUsuario.deleteById(id);
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Método para modificar un usuario
     */
    @RequestMapping(value="usuarios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario, @PathVariable("nombre") String nombre){
        Optional<Usuario> optionalUsuario = daoUsuario.findById(id);
        Optional<Usuario> optionalUsuarioNombre = daoUsuario.findByNombre(nombre);
        if (optionalUsuario.isPresent()){
            if (!optionalUsuarioNombre.isPresent()){
                Usuario u = optionalUsuario.get();
                u.setId(id);
                u.setNombre(usuario.getNombre());
                u.setCorreo(usuario.getCorreo());
                u.setPassword(usuario.getPassword());
                u.setImagen(usuario.getImagen());
                daoUsuario.save(u);
                return ResponseEntity.ok(u);
            }else{
                return ResponseEntity.noContent().build();
            }
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
