package com.ingenieriaSoftware2.Service.Implementations;

import com.ingenieriaSoftware2.Repository.ReseniaRepository;
import com.ingenieriaSoftware2.Service.Interfaces.ReseniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReseniaServiceImpl implements ReseniaService {
    @Autowired
    private ReseniaRepository reseniaRepository;
}
