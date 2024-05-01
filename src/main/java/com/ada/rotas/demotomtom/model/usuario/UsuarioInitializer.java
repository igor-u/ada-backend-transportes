package com.ada.rotas.demotomtom.model.usuario;

import com.ada.rotas.demotomtom.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInitializer implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) {
        Usuario usuario = new Usuario();
        usuario.setLogin("igor@gmail.com");
        usuario.setSenha("$2a$12$Jbd2.lDyDSkXbj/VPyjmu.Kubsn1oGdV2KCFQaQhxiSi7efVMNXAW");

        usuarioRepository.save(usuario);

    }
}
