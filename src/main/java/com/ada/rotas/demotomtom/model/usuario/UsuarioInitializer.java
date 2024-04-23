package com.ada.rotas.demotomtom.model.usuario;

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
        Usuario usuario1 = new Usuario();
        usuario1.setLogin("igor.ribeiro@tomtom.com");
        usuario1.setSenha("$2a$12$Jbd2.lDyDSkXbj/VPyjmu.Kubsn1oGdV2KCFQaQhxiSi7efVMNXAW");

        Usuario usuario2 = new Usuario();
        usuario2.setLogin("maria.silva@tomtom.com");
        usuario2.setSenha("$2a$12$0LCdUN/b6EwIntBps6fVAeT/cprU3RfUrEajZ9mx5KRlGEbyvnP6K");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }
}
