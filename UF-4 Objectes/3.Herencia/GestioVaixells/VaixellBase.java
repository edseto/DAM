public interface VaixellBase {
    public abstract int prioritat();
    public String getMatricula();
    public double getEslora();
    public double getManega();
    public double solicitarPreu(Embarcadors gestio);
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception;
}