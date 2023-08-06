package jobhunt.app.services;


import jobhunt.app.models.*;
import jobhunt.app.config.JwtService;
import jobhunt.app.repository.Archived_Applications_Repository;
import jobhunt.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserRepository repository;
    private final Archived_Applications_Repository archrepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getFirstname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
                var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse archivedauth(ArchivedRequest request, String header) {

        String token = jwtService.extractTokenFromAuthorizationHeader(header);
        var app= jwtService.extractToken(token);
        var username= jwtService.extractUsername(token);
        var user = repository.findByEmail(username)
                .orElseThrow();

        // Save the archived application
        if(user!=null){
        var archivedApp = Archived_Applications.builder()
                .company(request.getCompany())
                .position(request.getPosition())
                .location(request.getLocation())
                .pay(request.getPay())
                .jobDescriptionLink(request.getJobDescriptionLink())
                .jobType(request.getJobType())
                .build();
        archrepository.save(archivedApp);}

        // Return the response with token
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public String userId( String header){
                var token= jwtService.extractTokenFromAuthorizationHeader(header);
        var isTokenValid= jwtService.isTokenRight(token);
        var username= jwtService.extractUsername(token);
        var user = repository.findByEmail(username)
                .orElseThrow();
    if(user!=null) {
        var id = jwtService.extractId(token);
        return id;
    } else
        return "The userId was not sent right";
    }

}
