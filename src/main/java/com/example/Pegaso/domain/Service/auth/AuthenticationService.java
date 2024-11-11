package com.example.Pegaso.domain.Service.auth;

import com.example.Pegaso.Data.Models.Usuario;
import com.example.Pegaso.Data.Repository.UsuarioRepository;
import com.example.Pegaso.Security.JwtTokenProvider;
import com.example.Pegaso.domain.VO.V1.UsuarioVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public Optional<String> login(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        
        if (usuarioOpt.isPresent() && passwordEncoder.matches(senha, usuarioOpt.get().getSenha())) {
            return Optional.of(jwtTokenProvider.generateToken(email));
        }
        
        return Optional.empty();
    }
    public void register(UsuarioVO usuarioVO) throws Exception {
        // Verifique se o e-mail já está registrado
        if (usuarioRepository.findByEmail(usuarioVO.getEmail()).isPresent()) {
            throw new Exception("E-mail já registrado");
        }

        // Criptografe a senha
        String senhaCriptografada = passwordEncoder.encode(usuarioVO.getSenha());

        // Cria o objeto de usuário e salve no banco de dados
        Usuario usuario = new Usuario();
        usuario.setUserName(usuarioVO.getUsername());
        usuario.setEmail(usuarioVO.getEmail());
        usuario.setSenha(senhaCriptografada); 

        usuarioRepository.save(usuario);
    }
}
