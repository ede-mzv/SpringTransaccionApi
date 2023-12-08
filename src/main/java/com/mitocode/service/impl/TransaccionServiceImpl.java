package com.mitocode.service.impl;

import com.mitocode.model.Transaccion;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ITransaccionRepo;
import com.mitocode.service.ITransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImpl extends CRUDImpl<Transaccion, Integer> implements ITransaccionService {
    @Autowired
    private ITransaccionRepo repo;

    @Override
    protected IGenericRepo<Transaccion, Integer> getRepo(){return repo;}
}
