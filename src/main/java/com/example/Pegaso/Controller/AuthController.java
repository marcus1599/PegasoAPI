package com.example.Pegaso.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.Pegaso.domain.Service.auth.AuthenticationService;
import com.example.Pegaso.domain.VO.V1.UsuarioVO;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");
    
        Optional<String> token = authenticationService.login(email, senha);
    
        if (token.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("token", token.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
    
    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody UsuarioVO usuarioVO) {
    try {
        authenticationService.register(usuarioVO);
        return ResponseEntity.ok().body(Map.of("message", "Usuário registrado com sucesso!"));
    } catch (Exception e) {
        return ResponseEntity.status(400).body("Erro no registro: " + e.getMessage());
    }
}
  @GetMapping("/userinfo")
    public ResponseEntity<?> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        
        Optional<UsuarioVO> usuarioVO = authenticationService.getUserInfo(email);
        if (usuarioVO.isPresent()) {
            return ResponseEntity.ok(usuarioVO.get());
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }
    }

}
