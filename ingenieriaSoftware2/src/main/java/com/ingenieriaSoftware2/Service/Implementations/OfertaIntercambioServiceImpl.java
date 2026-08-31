package com.ingenieriaSoftware2.Service.Implementations;

import com.ingenieriaSoftware2.Repository.OfertaIntercambioRepository;
import com.ingenieriaSoftware2.Service.Interfaces.OfertaIntercambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaIntercambioServiceImpl implements OfertaIntercambioService {
    @Autowired
    private OfertaIntercambioRepository ofertaIntercambioRepository;
}
