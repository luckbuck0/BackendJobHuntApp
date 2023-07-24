package jobhunt.app.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    private String job_description_link;

    private boolean Active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;
}
