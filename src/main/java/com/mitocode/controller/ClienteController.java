package com.mitocode.controller;

import com.mitocode.dto.ClientesDTO;
import com.mitocode.model.Clientes;
import com.mitocode.repo.IClientesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mantenimiento/clientes")
public class ClienteController {
    @Autowired
    private IClientesRepo clienteRepository;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> findAll() {
        List<ClientesDTO> list = clienteRepository.findAll().stream().map(p -> mapper.map(p, ClientesDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientesDTO dto) {
        Clientes cliente = clienteRepository.save(mapper.map(dto, Clientes.class));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
