import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String nomClasse;
    private List<Eleve> eleves;

    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
        this.eleves = new ArrayList<>();
    }

    public void ajouterEleve(Eleve eleve) {
        eleves.add(eleve);
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public String getNomClasse() {
        return nomClasse;
    }
}