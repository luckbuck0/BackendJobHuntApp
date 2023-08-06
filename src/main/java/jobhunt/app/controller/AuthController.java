package jobhunt.app.controller;

import jobhunt.app.config.JwtService;
import jobhunt.app.models.*;
import jobhunt.app.repository.Archived_Applications_Repository;
import jobhunt.app.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
private final AuthenticationService service;
private final JwtService jwtService;
private Archived_Applications_Repository archivedApplicationsRepository;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/archived")
    public  ResponseEntity<AuthenticationResponse> archived(
            @RequestBody ArchivedRequest request,
            @RequestHeader("Authorization") String header
            )
    {
        return ResponseEntity.ok(service.archivedauth(request,header));
    }

    @GetMapping("/userid")
    public ResponseEntity<String> getUserId(
            @RequestHeader("Authorization") String header
            )
    {

        return ResponseEntity.ok(service.userId(header));

    }



}
