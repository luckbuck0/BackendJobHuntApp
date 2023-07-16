package models;


import jakarta.persistence.*;


@Entity
@Table( name ="archived_applications")
public class Archived_Applications {
    @Id
    @GeneratedValue
    private Long id;
    private String company;
    private String position;

    private String linkedin_contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLinkedin_contact() {
        return linkedin_contact;
    }

    public void setLinkedin_contact(String linkedin_contact) {
        this.linkedin_contact = linkedin_contact;
    }

    public String getJob_description_link() {
        return job_description_link;
    }

    public void setJob_description_link(String job_description_link) {
        this.job_description_link = job_description_link;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }



    private String job_description_link;

    private boolean Active;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
