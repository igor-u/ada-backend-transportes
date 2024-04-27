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

//        Usuario usuario1 = new Usuario();
//        usuario1.setLogin("joao@gmail.com");
//        usuario1.setSenha("$2a$12$0LCdUN/b6EwIntBps6fVAeT/cprU3RfUrEajZ9mx5KRlGEbyvnP6K");

        usuarioRepository.save(usuario);
//        usuarioRepository.save(usuario1);
    }
}
