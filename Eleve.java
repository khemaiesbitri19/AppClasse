public class Eleve {
    private String nom;
    private String prenom;
    private int age;

    public Eleve(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + age + " ans)";
    }
}
