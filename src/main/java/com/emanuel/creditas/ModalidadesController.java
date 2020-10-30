package com.emanuel.creditas;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ModalidadesController {

    @PostMapping(value = "/api/modalidades")
    public void search(@RequestBody @Valid NewCustomer request){

    }

}
