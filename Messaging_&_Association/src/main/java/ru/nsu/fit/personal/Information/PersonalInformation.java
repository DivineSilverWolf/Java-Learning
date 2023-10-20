package ru.nsu.fit.personal.Information;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PROTECTED) @AllArgsConstructor @Getter @Setter
public abstract class PersonalInformation {
    @NonNull String firstName;
    @NonNull String lastName;
    @NonNull String dateOfBirth;

}
