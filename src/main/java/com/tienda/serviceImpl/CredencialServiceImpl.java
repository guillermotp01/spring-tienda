package com.tienda.serviceImpl;

import com.tienda.model.Credencial;
import com.tienda.records.usuarios.CrearCredencial;
import com.tienda.repositoris.CredencialRepository;
import com.tienda.service.CredencialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredencialServiceImpl implements CredencialService {
    private final CredencialRepository credencialRepository;
    @Autowired
    public CredencialServiceImpl(CredencialRepository credencialRepository){
        this.credencialRepository = credencialRepository;
    }
    @Override
    public void registrarUsuarioYCredencial(CrearCredencial datos) {
        this.credencialRepository.save(new Credencial(datos));
    }
}
