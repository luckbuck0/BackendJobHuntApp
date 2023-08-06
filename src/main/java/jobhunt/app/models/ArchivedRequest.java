package jobhunt.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArchivedRequest {

    private Long id;

    private String company;

    private String position;

    private String location;

    private String pay;

    private String JobType;

    private String jobDescriptionLink;

    private boolean Active;
}
