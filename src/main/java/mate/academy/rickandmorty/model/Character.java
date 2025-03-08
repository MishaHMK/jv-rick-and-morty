package mate.academy.rickandmorty.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long externalId;

    @Column(nullable = false)
    private String name;

    private String status;

    private String species;

    private String gender;

    private String image;

    @Column(unique = true)
    private String url;

    @Override
    public String toString() {
        return "Character{"
                + "id=" + id
                + ", externalId=" + externalId
                + ", name='" + name + '\''
                + ", status='" + status + '\''
                + ", gender='" + gender + '\''
                + '}';
    }
}
