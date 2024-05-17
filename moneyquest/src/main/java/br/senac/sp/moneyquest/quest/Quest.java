package br.senac.sp.moneyquest.quest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Entity
@Data
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    @Size(min = 10, max = 255)

    private String description;

    @Pattern(regexp = "ESTUDOS|LAZER|TRABALHO")
    private String category;

    @Pattern(regexp = "PEQUENA|MÉDIA|GRANDE")
    private String priority;

}
