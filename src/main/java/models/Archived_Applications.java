package models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private String job_description_link;

    private boolean Active;

    private int user_id;
}
