package com.example.riadhfarhati.footbyriadh;

/**
 * Created by i on 06/08/2017.
 */

public class score {
    String titre, contenu;

    public String getTitre() {
        return titre;
    }

    public score(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
