package com.example.mss1.controllers;

import com.example.mss1.domain.Pedido;
import com.example.mss1.services.PedidoQueryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoQueryController {


    private final PedidoQueryService service;

    public PedidoQueryController(PedidoQueryService service) {
        this.service = service;
    }

    @Operation(description = "Buscar pedidos")
    @GetMapping("/{id}/pedidos")
    public List<Object> listEvents(@PathVariable(value = "id") String id){
        return service.listEvents(id);
    }

    @Operation(description = "Buscar pedidos por ID")
    @GetMapping("/{id}")
    public Pedido getById(@PathVariable(value = "id") String id){
        return service.getById(id).get();
    }



}
