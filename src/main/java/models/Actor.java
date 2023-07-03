package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Actor extends EntityModel {

    String name,
            height,
            mass,
            hair_color,
            skin_color,
            eye_color,
            birth_year,
            gender,
            homeworld;
    List<String> films,
            species,
            vehicles,
            starships;

}
