package com.mitocode.controller;

import com.mitocode.dto.ClientesDTO;
import com.mitocode.dto.PostTransaccionDTO;
import com.mitocode.dto.TransaccionDTO;
import com.mitocode.model.Clientes;
import com.mitocode.model.Transaccion;
import com.mitocode.repo.IClientesRepo;
import com.mitocode.repo.ITransaccionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TransaccionController {
    @Autowired
    private ITransaccionRepo transaccionRepository;

    @Autowired
    private IClientesRepo clientesRepository;

    @Autowired
    private ModelMapper mapper;


    @GetMapping("/VisualizarTransacciones")
    public ResponseEntity<List<TransaccionDTO>> findAll() {
        List<Transaccion> transacciones = transaccionRepository.findAll();
        List<TransaccionDTO> list = transacciones.stream().map(transaccion -> {
            TransaccionDTO dto = mapper.map(transaccion, TransaccionDTO.class);
            if (transaccion.getClientes() != null) {
                ClientesDTO clienteDto = mapper.map(transaccion.getClientes(), ClientesDTO.class);
                dto.setCliente(clienteDto);
            }
            return dto;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    /*
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TransaccionDTO dto) {
        Transaccion transaccion = transaccionRepository.save(mapper.map(dto, Transaccion.class));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    */
    @PostMapping("/Reserva")
    public ResponseEntity<String> createTransaccion(@RequestBody PostTransaccionDTO dto) {
        if (dto.getClienteId() == null) {
            // Retorna un error o maneja el caso donde clienteId es null
            return ResponseEntity.badRequest().body("Cliente ID is null");
        }

        Clientes cliente = clientesRepository.findById(dto.getClienteId()).orElse(null);
        if (cliente == null) {
            // Retorna un error o maneja el caso donde el cliente no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }

        Transaccion transaccion = mapper.map(dto, Transaccion.class);
        transaccion.setClientes(cliente);
        transaccion.setTransaccionRealizada(false);
        transaccionRepository.save(transaccion);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/transaccion/{id}/completar")
    public ResponseEntity<Void> completarTransaccion(@PathVariable Integer id) {
        Optional<Transaccion> transaccionOptional = transaccionRepository.findById(id);

        if (transaccionOptional.isPresent()) {
            Transaccion transaccion = transaccionOptional.get();
            transaccion.setTransaccionRealizada(true);
            transaccionRepository.save(transaccion);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
}}
