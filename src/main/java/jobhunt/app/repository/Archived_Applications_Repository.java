package jobhunt.app.repository;


import jobhunt.app.models.Archived_Applications;
import jobhunt.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Archived_Applications_Repository extends JpaRepository<Archived_Applications,Long> {


}
