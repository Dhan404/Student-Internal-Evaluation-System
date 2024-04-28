package np.edu.nast.sies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.edu.nast.sies.entity.NatureOfCourse;
@Repository
public interface NatureOfCourseRepository extends JpaRepository<NatureOfCourse, Long>{

}
