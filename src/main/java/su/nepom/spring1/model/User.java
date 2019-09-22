package su.nepom.spring1.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Builder.Default
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = -1;
    @NonNull
    @Column(name = "name")
    private String name;

    public boolean isNew() {
        return id == -1;
    }
}
