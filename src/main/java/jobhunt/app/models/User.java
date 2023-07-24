package jobhunt.app.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    private Set<Current_Applications> currentApplications = new HashSet<>();

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    private Set<Archived_Applications> archivedApplications = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;


}


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(  name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
