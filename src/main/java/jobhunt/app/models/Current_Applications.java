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
@Table(name="current_applications")
public class Current_Applications {
    @Id
    @GeneratedValue
    private Long id;

    private String company;

    private String position;

    private String location;

    private String pay;

    private String JobType;

    public Long getId() {
        return id;
    }

    private String jobDescriptionLink;

    private boolean Active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;
}
