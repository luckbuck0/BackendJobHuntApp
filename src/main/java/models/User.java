package models;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users",
    uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
    })
public class User {
    @Id
    @GeneratedValue
    private Long id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "current_applications",
    joinColumns = @JoinColumn( name= "id"),
    inverseJoinColumns = @JoinColumn(name = "user_current_applications"))
    private Set<Current_Applications> currentApplications = new HashSet<>();

    public Set<Current_Applications> getCurrentApplications() {
        return currentApplications;
    }

    public void setCurrentApplications(Set<Current_Applications> currentApplications) {
        this.currentApplications = currentApplications;
    }

    public Set<Archived_Applications> getArchivedApplications() {
        return archivedApplications;
    }

    public void setArchivedApplications(Set<Archived_Applications> archivedApplications) {
        this.archivedApplications = archivedApplications;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "archived_applications",
    joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_archived_applications"))
    private Set<Archived_Applications> archivedApplications = new HashSet<>();

    @NotBlank
    @Email
    private String email;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotBlank
    private String username;
    @NotBlank
    private String password;


}
