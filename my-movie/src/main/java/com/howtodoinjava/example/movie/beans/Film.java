package com.howtodoinjava.example.movie.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Film {
    @ApiModelProperty(notes = "Title of the movie",name="name",required=true,value="test titre")
    private String titre;
    @ApiModelProperty(notes = "Director of the movie",name="name",required=true,value="test realisateur")
    private String realisateur;
    @ApiModelProperty(notes = "Release date of the movie.",name="name",required=true,value="test dateDeSortie")
    private Date dateDeSortie;
    @ApiModelProperty(notes = "Principal actor of the movie",name="name",required=true,value="test acteurPrincipale")
    private Acteur acteurPrincipale;
    public Film(String titre, String realisateur, Date datesortie, Acteur acteurprincipal) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateDeSortie = datesortie;
        this.acteurPrincipale = acteurprincipal;
    }

}

