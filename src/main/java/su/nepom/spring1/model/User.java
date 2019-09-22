package su.nepom.spring1.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int id = -1;
    @NonNull
    private String name;

    public boolean isNew() {
        return id == -1;
    }
}
