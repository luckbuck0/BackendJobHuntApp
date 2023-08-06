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

    private String location;

    private String pay;

    private String jobType;



    public Long getId() {
        return id;
    }

    private String jobDescriptionLink;

    private boolean Active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;
}
