package com.mitocode.service.impl;

import com.mitocode.model.Clientes;
import com.mitocode.repo.IClientesRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServiceImpl extends CRUDImpl<Clientes, Integer> implements IClientesService {
    @Autowired
    private IClientesRepo repo;

    @Override
    protected IGenericRepo<Clientes, Integer> getRepo(){return repo;}
}
