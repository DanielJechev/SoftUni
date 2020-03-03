package entities.gringotts.hospital;

import entities.gringotts.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "gps")
public class Gp extends BaseEntity {
    private Set<Patient> patients;

    public Gp() {
    }

    @OneToMany(mappedBy = "gp")
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
