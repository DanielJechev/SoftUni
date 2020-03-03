package entities.gringotts.hospital;

import entities.gringotts.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private String picture;
    private PatientInformation information;

    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> medicaments;

    private Gp gp;

    public Patient() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Enumerated(EnumType.STRING)
    public PatientInformation getInformation() {
        return information;
    }

    public void setInformation(PatientInformation information) {
        this.information = information;
    }

    @OneToMany(targetEntity = Visitation.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @OneToMany(targetEntity = Diagnose.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @OneToMany(targetEntity = Medicament.class)
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    @ManyToOne(targetEntity = Gp.class)
    public Gp getGp() {
        return gp;
    }

    public void setGp(Gp gp) {
        this.gp = gp;
    }
}