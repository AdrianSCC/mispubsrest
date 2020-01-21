package com.example.mispubsrest.Controlador;


import com.example.mispubsrest.Dao.PubDao;
import org.springframework.beans.factory.annotation.Autowired;
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

}
